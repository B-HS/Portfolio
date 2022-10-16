<template>
    <section class="contentarea-context__box" @click="viewDetail">
        <h1 class="bi bi-layout-sidebar">&nbsp;{{props.detail.title}}</h1>
        <hr />
        <div class="contentarea-context__box__img" @click="DetailModal('visible')">
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
        width: 100%
        hr
            margin: 0.75rem 0rem
        p
            line-height: 2rem
        h1
            cursor: pointer
        
    .contentarea-context__box__img
        cursor: pointer
        img
            width: 100%
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
