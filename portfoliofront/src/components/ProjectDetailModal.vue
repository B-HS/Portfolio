<template>
    <div class="contentarea-context">
        <div class="contentarea-context__innerline">
            <div class="contentarea-context__section">
                <label class="contentarea-context__section__label" for="title">프로젝트명</label>
                <span class="contextarea-context__section__input" id="title">{{props.info.title}}</span>
            </div>
            <div class="contentarea-context__section">
                <label class="contentarea-context__section__label" for="title">제작소요 기간</label>
                <span class="contextarea-context__section__input" id="title">{{props.info.duration}}</span>
            </div>
            <div class="contentarea-context__section">
                <label class="contentarea-context__section__label" for="title">사용된 기술</label>
                <span class="contextarea-context__section__input" id="title">{{props.info.stack}}</span>
            </div>
            <div class="contentarea-context__section">
                <label class="contentarea-context__section__label" for="title">느낀점</label>
                <div class="contextarea-context__section__input" id="title" v-html="props.info.context"></div>
            </div>
        </div>
    </div>
</template>
<script setup>
    import { defineProps } from "vue";
    const props = defineProps(["info"])

</script>
<style lang="sass" scoped>
    .contentarea-context
        display: block
        width: 100%
        height: 100%
        box-sizing: border-box
        span
            text-align: left
            cursor: pointer

        .contentarea-context__innerline
            display: flex
            flex-direction: column
            width: 100%
            height: 95%
            justify-content: space-between
            .contentarea-context__section
                width: 100%
                display: flex
                text-align: left
                justify-content: space-between
                align-items: center
                .contentarea-context__section__label
                    width: 20%
                .contextarea-context__section__input
                    text-align: left
                    width: 90%
                &:nth-last-child(0)
                    height: 100%
                    
</style>
