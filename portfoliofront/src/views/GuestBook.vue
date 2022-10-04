<template>
    <div class="guestbooksection">
        <div class="guestbook-inputsection-sticky">
            <div class="guestbook-inputsection" v-if="!body.fixmode">
                <div class="guestbook-inputsection__guestinfo">
                    <span>작성자</span><input type="text" v-model="body.username" />
                    <span>비밀번호</span><input type="password" v-model="body.password" />
                    <h5> 
                        <i class="bi bi-check-circle"></i> 댓글을 클릭하면 수정과 삭제가 가능합니다
                    </h5>
                </div>
                <div class="guestbook-inputsection__context">
                    <textarea v-model="body.context"></textarea>
                    <button @click="addBook()" src="#">입력</button>
                </div>
                <div class="guestbook-inputsection__functions">
                    <input type="checkbox" name="open" v-model="body.open">
                    <span>비밀글</span>
                </div>
            </div>
            <div class="guestbook-inputsection" v-if="body.fixmode">
                <div class="guestbook-inputsection__guestinfo">
                    <span>작성자</span> <input type="text" v-model="body.username" /> <span>비밀번호</span> <input type="password" v-model="body.password" />
                    <div class="guestbook-inputsection__guestinfo__fix">
                        <span @click="reset"><i class="bi bi-arrow-clockwise"></i> 수정 취소</span> &nbsp;
                        <span @click="remove"><i class="bi bi-trash3"></i> 삭제</span>
                    </div>
                </div>
                <div class="guestbook-inputsection__context">
                    <textarea v-model="body.context"></textarea>
                    <button @click="addBook()">수정</button>
                </div>
                <div class="guestbook-inputsection__functions">
                    <input type="checkbox" name="open" v-model="body.open">
                    <span>비밀글</span>
                </div>
            </div>
        </div>
        <div ref="area" class="guestboot-context-area">
            <div class="guestboot-context-area__element" v-for="(info, idx) in tableState.info" :key="(info, idx)" @click="modify(info, idx)" :id="info.gid">
                <div class="guestboot-context-area__element__userinfo">
                    <span>{{(idx+1) + "." + info.username }}</span>
                    <h6>{{ getTimeFromJavaDate(info.regdate) }}</h6>
                </div>
                <span class="guestboot-context-area__element__usercomment" v-if="info.open==true">{{info.context}}</span>
                <span class="guestboot-context-area__element__usercomment" v-if="info.open==false" style="opacity:0.5;">관리자만 볼 수 있는 글입니다</span>
            </div>
        </div>
    </div>
</template>
<script setup>
    import { reactive, ref } from "vue";
    import axios from "axios";
    const headers = {
        "Content-Type": "application/json; charset=utf-8",
    };

    let area = ref(null);

    let tableState = reactive({
        info: [],
        size: [],
        currentPage: [0],
    });
    let body = reactive({
        gid: null,
        username: null,
        password: null,
        context: null,
        open:false,
        fixmode: false,
    });

    let deleteState = reactive({
        gid: null,
        password: null,
    });

    function modify(info, idx) {
        if (info.open==false) {
            body.context = "수정이 불가능한 글입니다"
            return
        }
        body.fixmode = true;
        body.username = info.username;
        body.context = info.open==true?info.context:"";
        body.password = "";
        body.gid = info.gid;
        for (let i = 0; i < tableState.info.length; i++) {
            area.value.children[i].style.backgroundColor = "black";
        }
        area.value.children[idx].style.backgroundColor = "#333";
    }

    function addBook() {
        body.open = !body.open
        axios.post("./api/add", body, { headers }).then(function (res) {
            body.username = "";
            body.password = "";
            body.context = "";
            body.open = "";
            tableState.info = [];
            tableState.currentPage = [0];
            tableState.size = [];
            getBookList();
        });
    }

    function getBookList(num) {
        if (num >= tableState.size[0]) {
            return;
        }
        console.log(num);
        axios.post("./api/list", num != null ? num : 1, { headers }).then(function (res) {
            tableState.info.push(...[...res.data.dtoList]);
            tableState.size = [];
            tableState.size.push(res.data.totalSize / 10);
            tableState.currentPage = [];
            tableState.currentPage.push(num);
        });
    }

    function getTimeFromJavaDate(s) {
        const cont = new Date(s);
        let date = new Date();
        let calculated = (new Date(date.getTime()) - cont) / 1000;
        if (calculated < 60) {
            return "방금 전";
        } else if (calculated < 60 * 60) {
            return `${Math.round(calculated / 60)}분 전`;
        } else if (calculated < 60 * 60 * 24) {
            return `${Math.round(calculated / (60 * 60))}시간 전`;
        } else if (calculated < 60 * 60 * 24 * 7) {
            return `${Math.round(calculated / (60 * 60 * 24))}일 전`;
        } else if (calculated < 60 * 60 * 24 * 7 * 5) {
            return `${Math.round(calculated / (60 * 60 * 24 * 7))}주 전`;
        } else if (calculated > 31536000) {
            return `${Math.round(calculated / 31536000)}년 전`;
        }
    }
    function remove(gid, pwd) {
        axios.post("./api/delete", deleteState, { headers }).then(function (res) {
            if (res.data == false) {
                alert("삭제에 실패하였습니다");
            } else {
                getBookList(tableState.currentPage);
            }
        });
    }

    function reset() {
        body.fixmode = false;
        body.username = "";
        body.context = "";
        body.password = "";
        for (let i = 0; i < tableState.info.length; i++) {
            area.value.children[i].style.backgroundColor = "black";
        }
    }

    function windowSize() {
        if (window.innerHeight + window.scrollY >= document.body.offsetHeight - 100) {
            tableState.currentPage[0] += 1;
            getBookList(tableState.currentPage[0]);
        }
    }

    window.addEventListener("scroll", windowSize);
    getBookList(1);
</script>
<style lang="sass" scoped>
    .guestbook-inputsection-sticky
        display: flex
        justify-content: center
        width: 100%
        height: auto
        top:2.5rem
        position: sticky
        padding: 0rem 0rem 3rem 0rem
        z-index: 10
        box-sizing: border-box        
    .guestbooksection
        display: flex
        flex-direction: column
        gap: 2rem
        width: 60%
        align-items: center
        z-index: 0
        hr
            width: 100%
        .paging
            display: flex
            gap: 1rem
        .guestbook-inputsection
            display: flex
            flex-direction: column
            min-width: 400px
            gap: 1rem
            width: 100%
            padding: 1rem
            box-sizing: border-box
            border: 1px solid white
            background-color: black
            .guestbook-inputsection__functions
                font-size: 0.75rem
                display: flex
                gap: 0.5rem
                align-content: center
            .guestbook-inputsection__guestinfo
                display: flex
                align-items: center
                justify-content: flex-start
                gap: 1rem
                font-size: 0.75rem
                h5
                    font-size: inherit
                input
                    width: 15%
                    height: 1rem
            .guestbook-inputsection__context
                display: flex
                gap: 1rem
                button
                    width: 10%
                    border-radius: 0
                    background: white
                    border: none
                    transition: 0.2s ease-in-out all
                    &:active, &:hover
                        background-color: #333
                textarea
                    resize: none
                    width: 95%
                    height: 2rem
                    padding: 1rem
                    &:focus
                        outline: none
        .guestbook-inputsection__titlesection
            display: flex
            width: 100%
            box-sizing: border-box
            justify-content: space-between
            padding: 0 4.75rem
        .guestboot-context-area
            min-width: 400px
            width: 100%
            display: flex
            flex-direction: column
            align-items: center
            justify-content: center
            box-sizing: border-box
            gap: 2rem
            .guestboot-context-area__element
                padding: 1rem
                box-sizing: border-box
                display: flex
                flex-direction: column
                gap: 1rem
                width: 100%
                border: 1px solid white
                background: black
                transition: 0.2s ease-in-out all
                &:hover
                    background-color: #333
                .guestboot-context-area__element__userinfo
                    display: flex
                    align-items: baseline
                    gap: 0.5rem
                .guestboot-context-area__element__usercomment
                    padding-left: 1rem
</style>
