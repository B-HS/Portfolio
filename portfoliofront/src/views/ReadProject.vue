<template>
    <div class="contentarea-context">
        <span @click="router.push('./projects')"><i class="bi bi-arrow-left"></i> 목록으로 돌아가기</span>
        <div class="contentarea-context__innerline">
            <div class="contentarea-context__section">
                <label class="contentarea-context__section__label" for="title">프로젝트명</label>
                <span class="contextarea-context__section__input" id="title">안녕하세요</span>
            </div>
            <div class="contentarea-context__section">
                <label class="contentarea-context__section__label" for="title">제작소요 기간</label>
                <span class="contextarea-context__section__input" id="title">2달</span>
            </div>
            <div class="contentarea-context__section">
                <label class="contentarea-context__section__label" for="title">사용된 기술</label>
                <span class="contextarea-context__section__input" id="title">여러가지</span>
            </div>
            <div class="contentarea-context__section">
                <label class="contentarea-context__section__label" for="title">느낀점</label>
                <span class="contextarea-context__section__input" id="title"></span>
            </div>
        </div>
    </div>
</template>
<script setup>
    import router from "@/router";
</script>
<style lang="sass" scoped>
    .contentarea-context
        display: block
        width: 80%
        box-sizing: border-box
        span
            text-align: left
            cursor: pointer

        .contentarea-context__innerline
            width: 100%
            margin-top: 5rem
            .contentarea-context__section
                margin-top: 3rem
                width: 100%
                display: flex
                text-align: center
                justify-content: space-between
                align-items: center
                height: 3rem
                gap: 2rem
                .contentarea-context__section__label
                    width: 10%
                .contextarea-context__section__input
                    text-align: left
                    width: 90%
</style>
