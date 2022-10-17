<template>
    <div class="contentarea-context">
        <ProjectPreview v-for="info in state.projects" :key="info" :detail="info" ></ProjectPreview>
        <CheckModal :which="false"></CheckModal>
        <div class="contentarea-context__infomsg">클릭으로 프로젝트 설명을 여실 수 있습니다</div>
    </div>
</template>
<script setup>
    import ProjectPreview from "@/components/ProjectPreview.vue";
    import CheckModal from "@/components/CheckModal.vue";
    import axios from 'axios';
    import { reactive } from 'vue'

    let state = reactive({
        projects:[],
        page:0,
        totalPage:Number.MAX_SAFE_INTEGER
    })
    

    const headers = {
        "Content-Type": "application/json",
    };
    async function getList(){
        if (state.page>=state.totalPage) {
            return
        }
        await axios.post("./api/projects/list", state.page, {headers}).then(function(res){
            state.projects.push(...res.data.content)
            state.page = JSON.parse(JSON.stringify(res.data.number))+1
            state.totalPage = JSON.parse(JSON.stringify(res.data.totalPages))
        })
    }

    window.addEventListener("scroll",(e)=>{getListsMore(e)})

    function getListsMore(){
        let bottomCheck = window.innerHeight+window.scrollY==document.body.offsetHeight
        if(bottomCheck){
            getList()
        }
    }
    
    getList()
</script>
<style scoped lang="sass">
    .contentarea-context
        position: relative
        display: grid
        grid-template-columns: repeat(auto-fit, minmax(400px, 1fr))
        grid-auto-rows: repeat(auto-fit, minmax(500px, 1fr))
        justify-content: center
        gap: 1rem
        width: 75%
        overflow: hidden !important
        .contentarea-context__infomsg
            position: absolute
            top: 0
            left: 50%
            transform: translateX(-50%)
</style>
