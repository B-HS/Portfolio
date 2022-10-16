<template>
    <div class="contentarea-context">
        <div class="contentarea-context__btns">
            <span @click="router.push('./projects')"><i class="bi bi-arrow-left"></i> 목록으로 돌아가기</span>
        </div>
        <div class="contentarea-context__innerline">
            <div class="contentarea-context__section">
                <label class="contentarea-context__section__label" for="title">프로젝트명</label>
                <input type="text" v-model="state.title" />
            </div>
            <div class="contentarea-context__section">
                <label class="contentarea-context__section__label" for="title">제작소요 기간</label>
                <input type="text" v-model="state.duration" />
            </div>
            <div class="contentarea-context__section">
                <label class="contentarea-context__section__label" for="title">사용된 기술</label>
                <input type="text" v-model="state.stack" />
            </div>
            <div class="contentarea-context__section">
                <label class="contentarea-context__section__label" for="title">프로젝트 프리뷰</label>
                <input @change="imgSet" type="file" ref="img">
                <img ref="prev" alt="preview" src="@/assets/prev.png" >
            </div>
            <div class="contentarea-context__section">
                <label class="contentarea-context__section__label" for="title">느낀점</label>
                <textarea v-model="state.context"></textarea>
            </div>
        </div>
        <CheckModal :which="true" :articleInfo="state"></CheckModal>
    </div>
</template>
<script setup>
    import router from "@/router";
    import { reactive, ref } from "vue";
    import CheckModal from "@/components/CheckModal.vue";
    let formData = new FormData()
    let writeModal = ref(null);
    let state = reactive({
        title: "",
        duration: "",
        stack: "",
        context: "",
        img:""
    });
    let img = ref(null)
    let prev = ref(null)
    
    function imgSet(){
        let reader = new FileReader()
        formData.append("upload", img.value.files[0])
        state.img = img.value.files[0]
        reader.readAsDataURL(img.value.files[0])
        reader.onload=(e)=>{
            prev.value.src = e.target.result
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
    .contentarea-context
        display: block
        width: 80%
        box-sizing: border-box
        span
            text-align: left
            cursor: pointer
        .contentarea-context__btns
            display: flex
            justify-content: space-between

        .contentarea-context__innerline
            width: 100%
            margin-top: 5rem
            .contentarea-context__section
                margin-top: 5rem
                width: 100%
                display: flex
                text-align: center
                justify-content: space-between
                align-items: center
                height: 3rem
                gap: 2rem
                &:nth-last-of-type(1)
                    height: 15rem
                    textarea
                        height: 15rem
                        width: 100%
                        resize: none
                        border: none
                        border-radius: none
                        padding: 0.25rem
                        &:focus
                           outline: none
                           

                .contentarea-context__section__label
                    width: 10%
                input
                    width: 100%
                    height: 1.5rem
</style>
