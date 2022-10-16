<template>
    <div class="contentarea-context">
        <ProjectPreview v-for="info in 3" :key="info" @click="router.push('./read')"></ProjectPreview>
        <CheckModal :which="false"></CheckModal>
    </div>
</template>
<script setup>
    import router from '@/router';
    import ProjectPreview from "@/components/ProjectPreview.vue";
    import CheckModal from "@/components/CheckModal.vue";
</script>
<style scoped lang="sass">
    .contentarea-context
        display: grid
        grid-template-columns: repeat(auto-fit, minmax(400px, 1fr))
        justify-content: center
        gap: 1rem
        width: 75%                
</style>
