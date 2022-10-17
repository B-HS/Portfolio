<template>
    <section class="contentarea-context__box" @click="viewDetail">
        <div class="contentarea-context__box__hoverbox"  @click="DetailModal('visible')">
            <h2> 프로젝트 설명 보기</h2>
        </div>
        <h1 class="bi bi-layout-sidebar">&nbsp;{{props.detail.title}}</h1>
        <hr />
        <div class="contentarea-context__box__img">
            <img :src="'./api/projects/img/'+props.detail.pimage" alt="airreview" />
        </div>
        <div class="contentarea-context__box__modal" ref="detailModal" >
            <div class="contentarea-context__box__modal__background"></div>
            <span @click="DetailModal('hidden')" style="cursor: pointer"><i class="bi bi-arrow-left"></i> 닫기</span>
            <ProjectDetailModal :info="props.detail"></ProjectDetailModal>
        </div>
    </section>
</template>
<script setup>
    import { defineProps, ref } from 'vue'
    import ProjectDetailModal from './ProjectDetailModal.vue';
    const props = defineProps(["detail"])

    let detailModal = ref(null)
    function DetailModal(status){
        detailModal.value.style.visibility=status
    }

    document.addEventListener("keydown", (e) => {
        if (e.key == "Escape") {
            DetailModal("hidden");
        }
    });

</script>
<style lang="sass" scoped>
    .contentarea-context__box
        border: 1px #777 solid
        box-sizing: border-box
        padding: 1rem
        height: 100%
        width: 100%
        position: relative
        hr
            margin: 0.75rem 0rem
        p
            line-height: 2rem
        h1
            cursor: pointer
        .contentarea-context__box__hoverbox
            cursor: pointer
            left: 0
            top: 0
            width: 100%
            height: 100%
            position: absolute
            background-color: white
            opacity: 0
            transition: 0.25s ease-in-out all
            display: flex
            justify-content: center
            align-items: center
            color: black
            &:hover
                opacity: 0.85
    .contentarea-context__box__img
        cursor: pointer
    .contentarea-context__box__modal
        border: white 1px solid
        z-index: 20
        visibility: hidden
        position: fixed
        background-color: black
        box-sizing: border-box
        padding: 2rem
        margin-top: 1.5rem
        top: 50%
        left: 50%
        width: 90%
        height: 90%
        transform: translate(-50%, -50%)
</style>
