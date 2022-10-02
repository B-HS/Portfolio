<template>
    <div class="contentarea-context">
        <ProjectPreview v-for="info in 3" :key="info" @click="router.push('./read')"></ProjectPreview>
        <!-- <section class="contentarea-context__box">
            <h1 class="bi bi-layout-sidebar"> 포트폴리오 사이트</h1>
            <hr>
            <div class="contentarea-context__box__img">
                <img src="@/assets/portfolio.png" alt="airreview">
            </div>
        </section> -->
        <!-- 개발시작하면 넣기 -->
        <!-- <section class="contentarea-context__box">
            <h1 class="bi bi-layout-sidebar"> 슷슷 :: Stretching your Stress</h1>
            <hr>
            <div class="contentarea-context__box__img">
                <img src="@/assets/airreview.png" alt="airreview">
            </div>
        </section> -->
        <!-- <section class="contentarea-context__box">
            <h1 class="bi bi-layout-sidebar"> 에어리뷰</h1>
            <hr>
            <div class="contentarea-context__box__img">
                <img src="@/assets/airreview.png" alt="airreview">
            </div>
        </section>
        <section class="contentarea-context__box">
            <h1 class="bi bi-layout-sidebar"> 티스토리 스킨</h1>
            <hr>
            <div class="contentarea-context__box__img">
                <img src="@/assets/tistory.png" alt="airreview">
            </div>
        </section> -->
    </div>
</template>
<script setup>
import ProjectPreview from '@/components/ProjectPreview.vue';
import router from '@/router';
</script>
<style scoped lang="sass">
    .contentarea-context
        display: grid
        grid-template-columns: 1fr 1fr
        flex-direction: column
        gap: 1rem
        width: 75%                    
</style>