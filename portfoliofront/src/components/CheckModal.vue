<template>
    <div ref="writeModal" class="writecheck">
        <div class="writecheckmodal"></div>
        <div class="writecheckmodal__body">
            <div class="writecheckmodal__body__title">비밀번호</div>
            <input type="password" v-model="state.passwd" required />
            <div class="writecheckmodal__body__btnsection">
                <button @click="showModal('hidden')">Close</button>
                <button @click="write">Submit</button>
            </div>
        </div>
    </div>
    <div class="contentarea-context__writebtn" v-if="!props.articleInfo">
        <i class="bi bi-pencil-square" @click="showModal('visible')"></i>
    </div>
    <div class="contentarea-context__write" v-if="props.articleInfo"> 
        <span @click="showModal('visible')">저장하기</span>
    </div>
</template>
<script setup>
    import router from "@/router";
    import axios from "axios";
    import { reactive, ref, defineProps } from "vue";

    const props = defineProps(["which", "articleInfo"])

    const header = {
        "Content-Type": "application/json;",
    };
    
    const headerForMulti= {
        "Content-Type": "multipart/form-data;charset=UTF-8"
    };

    let state = reactive({
        passwd: null,
    });

    let writeModal = ref(null);
    function write() {
        if(props.which){
            axios.post("./api/projects/writecheck", state.passwd, { header }).then(function (res) {
                let form = new FormData()
                for (const key in props.articleInfo) {
                    if (Object.hasOwnProperty.call(props.articleInfo, key)) {
                        const element = props.articleInfo[key];
                        form.set(`${key}`, element)
                    }
                }  
                console.log(form);
            if (res.data == true) {
                axios.post("./api/projects/write", form, { headerForMulti }).then(function(res){
                    res.data>0?router.push("./projects"):alert("글쓰기 실패")
                })
            }
        });
        }else{
            axios.post("./api/projects/writecheck", state.passwd, { header }).then(function (res) {
                if (res.data == true) {
                    router.push("/write");
                }
            });
        }
    }

    function showModal(status) {
        writeModal.value.style.visibility = `${status}`;
    }

    document.addEventListener("keydown", (e) => {
        if (e.key == "Escape") {
            showModal("hidden");
        }
    });
</script>
<style lang="sass" scoped>
    .writecheck
        visibility: hidden
        position: absolute
        left: 0
        top: 0
        width: 99%
        height: 100%
    .writecheckmodal
        position: fixed
        display: flex
        justify-content: center
        align-items: center
        background-color: white
        transform: translate(-50%, -50%)
        top: 50%
        left: 50%
        width: 100vw
        height: 100vh
        opacity: 0.2

    .writecheckmodal__body
        position: fixed
        display: flex
        gap: 1rem
        padding: 2rem
        box-sizing: border-box
        flex-direction: column
        align-content: center
        top: 50%
        left: 50%
        width: 25vw
        height: fit-content
        opacity: 100%
        transform: translate(-50%, -50%)
        background-color: black
        z-index: 10
        opacity: 1
        .writecheckmodal__body__title
            text-align: center
        .writecheckmodal__body__btnsection
            display: flex
            justify-content: flex-end
            gap: 1rem
            height: 2rem
            button
                width: 15%

    .contentarea-context__writebtn
        position: fixed
        font-size: 3rem
        right: 3rem
        top: 5rem
        cursor: pointer
        color: black
        transition: all ease-in-out 0.3s
        &:hover
            color: white
    .contentarea-context__write
        cursor: pointer
        margin-top: 3rem
        width: 100%
        display: flex
        justify-content: flex-end
</style>
