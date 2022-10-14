<template>
    <div class="contentarea-context">
        <ProjectPreview v-for="info in 3" :key="info" @click="router.push('./read')"></ProjectPreview>
        <div class="contentarea-context__writebtn">
            <i class="bi bi-pencil-square" @click="write"></i>
        </div>
        <div class="writecheck">
            <div class="writecheckmodal"></div>
            <div class="writecheckmodal__body">
                <div class="writecheckmodal__body__title" > 비밀번호 </div>
                <input type="password" v-model="state.passwd">
                <button @click="write">Submit</button>
            </div>
        </div>
    </div>
</template>
<script setup>
    import { reactive } from 'vue'
    import ProjectPreview from "@/components/ProjectPreview.vue";
    import router from "@/router";
    import axios from "axios";

    const header = {
        "Content-Type": "application/json; charset=utf-8"
    }

    let state = reactive({
        passwd : null
    })

    function write() {
        console.log(state.passwd);
        axios.post("./api/projects/writecheck", state.passwd, {header}).then(function(res){
            console.log(res)
        })
    }
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
        transition: 0.2s all ease-in-out
    .writecheckmodal__body
        position: absolute
        top: 50%
        left: 50%
        width: 50vw
        height: 50vh
        opacity: 100%
        transform: translate(-50%, -50%)
        background-color: black
        z-index: 10
        opacity: 1
</style>
