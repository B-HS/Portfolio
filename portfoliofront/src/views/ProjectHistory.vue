<template>
    <div class="contentarea-context">
        <ProjectPreview v-for="info in 3" :key="info" @click="router.push('./read')"></ProjectPreview>
        <div class="contentarea-context__writebtn">
            <i class="bi bi-pencil-square" @click="showModal('visible')"></i>
        </div>
        <div ref="writeModal" class="writecheck" v-on:keyup.esc="showModal('hidden')">
            <div class="writecheckmodal"></div>
            <div class="writecheckmodal__body">
                <div class="writecheckmodal__body__title"> 비밀번호 </div>
                <input type="password" v-model="state.passwd" required>
                <div class="writecheckmodal__body__btnsection">
                    <button @click="showModal('hidden')">Close</button>
                    <button @click="write">Submit</button>
                </div>
                
            </div>
        </div>
    </div>
</template>
<script setup>
    import { reactive, ref } from 'vue'
    import ProjectPreview from "@/components/ProjectPreview.vue";
    import router from "@/router";
    import axios from "axios";

    const header = {
        "Content-Type": "application/json; charset=utf-8"
    }

    let state = reactive({
        passwd : null
    })

    let writeModal = ref(null)

    function write() {
        axios.post("./api/projects/writecheck", state.passwd, {header}).then(function(res){
            if (res.data==true) {
                router.push("/write")
            }
        })
    }

    function showModal(status){
        writeModal.value.style.visibility=`${status}`
    }

    document.addEventListener("keydown", (e)=>{
        if(e.key == "Escape"){
            showModal('hidden')
        }
    })

</script>
<style scoped lang="sass">
    .contentarea-context
        display: grid
        grid-template-columns: repeat(auto-fit, minmax(400px, 1fr))
        justify-content: center
        gap: 1rem
        width: 75%
    .contentarea-context__writebtn
        position: absolute
        font-size: 3rem
        right: 2rem
        bottom: 2rem
    .writecheck
        visibility: hidden
        position: absolute
        left: 0
        top: 0
        width: 100vw
        height: 100vh
    .writecheckmodal
        position: absolute
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
        position: absolute
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
                
</style>
