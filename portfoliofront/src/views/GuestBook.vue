<template>
    <div class="guestbooksection">
        <div class="guestbook-inputsection">
            <div class="guestbook-inputsection__guestinfo"><span>작성자</span><input type="text" v-model="body.username" /> <span>비밀번호</span><input type="password" v-model="body.password" /></div>
            <div class="guestbook-inputsection__context">
                <textarea v-model="body.context"></textarea>
                <button @click="addBook()">입력</button>
            </div>
        </div>
        <hr />
        <table>
            <thead>
                <tr>
                    <td>작성자</td>
                    <td style="width: 70%; text-align: left">내용</td>
                    <td>등록일</td>
                </tr>
            </thead>
            <tbody>
                <tr v-for="info in tableState.info" :key="info">
                    <td>{{info.username}}</td>
                    <td style="width: 70%; text-align: left">{{info.context}}</td>
                    <td>{{getTimeFromJavaDate(info.regdate)}}</td>
                    <td style="width:1%" >
                        <i class="bi bi-x-lg"> 
                            <input type="text" placeholder="비밀번호 입력 후 엔터" @mouseout="deleteState.password=''" @keyup.enter="remove(info.gid, deleteState.password)" v-model="deleteState.password">
                        </i>
                    </td>
                </tr>
            </tbody>
        </table>
        <ul class="paging" >
            <li v-for="num in tableState.size[0]" @click="getBookList(num)" :key="num">{{num}}</li>
        </ul>
    </div>
</template>
<script setup>
    import { reactive } from "vue";
    import axios from "axios";
    const headers = {
        "Content-Type": "application/json; charset=utf-8",
    };
    let body = reactive({
        username: null,
        password: null,
        context: null,
    });

    let tableState = reactive({
        info:[],
        size:[],
        currentPage:""
    })

    let deleteState = reactive({
        gid : null,
        password : null
    })

    
    
    function addBook() {
        axios.post("./api/add", body, { headers }).then(function (res) {
            body.username=""
            body.password=""
            body.context=""
            getBookList()
        });
    }

    function getBookList(num){
        axios.post("./api/list", num!=null?num:1 , { headers }).then(function(res){
            tableState.info = []
            tableState.info.push(...[...res.data.dtoList])
            tableState.size.push(JSON.parse(res.data.totalSize))
            tableState.currentPage = num
        })
    }

    function getTimeFromJavaDate(s) {
                const cont = new Date(s)
                let date = new Date()
                let calculated = (new Date(date.getTime()) - cont) / 1000
                if (calculated < 60) {
                    return "방금 전"
                } else if (calculated < 60 * 60) {
                    return `${Math.round(calculated / 60)}분 전`
                } else if (calculated < 60 * 60 * 24) {
                    return `${Math.round(calculated / (60 * 60))}시간 전`
                } else if (calculated < 60 * 60 * 24 * 7) {
                    return `${Math.round(calculated / (60 * 60 * 24))}일 전`
                } else if (calculated < 60 * 60 * 24 * 7 * 5) {
                    return `${Math.round(calculated / (60 * 60 * 24 * 7))}주 전`
                } else if (calculated > 31536000) {
                    return `${Math.round(calculated / 31536000)}년 전`
                }
            }
    function remove(userid, password){
        deleteState.gid=userid
        console.log(password);
        axios.post("./api/delete", deleteState, { headers }).then(function(res){
            if (res.data == false) {
                alert("삭제에 실패하였습니다")
            }else{
                getBookList(tableState.currentPage)
            }
        })
    }

    getBookList()
</script>
<style lang="sass" scoped>

    .guestbooksection
        display: flex
        flex-direction: column
        gap: 3rem
        width: 60%

        table
            border: 1px white solid
            box-sizing: border-box
            padding: 2rem 0rem
            width: 100%
            border-spacing: 0 0.5rem
            thead, tbody
                text-align: center
            tr, td
                vertical-align: middle
            td
                padding: 0 1rem
                i
                    position: relative
                    &:hover input
                        width: 10rem             
                    input
                        position: absolute
                        background: white
                        padding: 0
                        border: none
                        width: 0rem
                        height: 1.1rem
                        left: 1.15rem
                        top: -2px
                        transition: 0.2s ease-in-out all
                        outline: none
                        &:focus
                            outline: none


        
        .paging
            display: flex
            gap: 1rem
        .guestbook-inputsection
            display: flex
            flex-direction: column
            gap: 1rem
            width: 100%
            padding: 1rem
            box-sizing: border-box
            border: 1px solid white

            .guestbook-inputsection__guestinfo
                display: flex
                align-items: center
                gap: 1rem
                input
                    width: 20%
                    height: 2rem
            .guestbook-inputsection__context
                display: flex
                gap: 1rem
                button
                    width: 5%
                    border-radius: 0
                    background: white
                    border: none
                textarea
                    resize: none
                    width: 95%
                    height: 3rem
                    padding: 1rem
                    &:focus
                        outline: none
</style>
