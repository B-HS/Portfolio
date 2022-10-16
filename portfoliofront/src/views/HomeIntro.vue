<template>
    <div class="contentarea-context">
        <section class="contextarea-context__profile">
            <div class="contentarea-context__img">
                <img src="@/assets/selfieeee.jpeg" alt="profile" />
            </div>

            <div class="contentarea-context__text">
                <h1 class="contentarea-context__text__name">Hyunseok Byun</h1>
                <div class="contentarea-context__text__etc">
                    <h5 class="contentarea-context__text__etc__birthday">95.07.01</h5>
                    <div class="contentarea-context__text__etc__icon">
                        <a href="https://github.com/B-HS"><h5 class="contentarea-context__text__etc__icon__github bi bi-github"> 깃허브</h5></a>
                        <a href="mailto:gumyoincirno@gmail.com"><h5 class="contentarea-context__text__etc__icon__mail bi bi-envelope -fill"> 메일</h5></a>
                        <a href="tel:010-7538-2613"><h5 class="bi bi-telephone-fill"> 전화</h5></a>
                        <a href="https://hbyun.tistory.com/"><h5 class="bi bi-arrow-up-right-square"> 블로그</h5></a>
                    </div>
                </div>
            </div>
        </section>
        <section class="contentarea-context__box">
            <h1 class="bi bi-person-fill"> 소개</h1>
            <hr />
            <p>
                코딩, 무언가 하나 해결 될 때의 그 짜릿함을 끊을 수가 없습니다 <br />
                언제나 발전하는 코딩을 지향합니다
            </p>
        </section>
        <section class="contentarea-context__box">
            <h1 class="bi bi-stack"> 주요 기술</h1>
            <hr />
            <div class="contentarea-context__box__list">
                <div ref="java" class="contentarea-context__collapse" @click="collapse(0)">
                    <div class="contentarea-context__collapse-title">
                        <span>
                            - JAVA
                            <h6>ㄴ Spring boot</h6>
                        </span>
                        <i ref="javaBtn" class="bi bi-caret-down-square-fill"></i>
                    </div>
                    <br />
                    <span class="contentarea-context__collapse-context">
                        Spring boot를 이용하여 하기의 프로젝트의 백엔드를 완성하였습니다<br />
                        <a href="https://github.com/DS-Pirate/-AIRREVIEW"><i class="bi bi-paperclip"></i> 에어리뷰 :: 세상의 모든 리뷰</a><br />
                        <a href="https://naver.com"><i class="bi bi-paperclip"></i> 현 포트폴리오 사이트</a>
                    </span>
                </div>
                <div ref="vue" class="contentarea-context__collapse" @click="collapse(1)">
                    <div ref="vue" class="contentarea-context__collapse-title">
                        <span>
                            - Vue
                            <h6>ㄴ Javascript, HTML, CSS</h6>
                        </span>
                        <i ref="vueBtn" class="bi bi-caret-down-square-fill"></i>
                    </div>
                    <br />
                    <span class="contentarea-context__collapse-context">
                        Vue.js를 이용하여 하기의 프로젝트의 프론트를 완성하였습니다<br />
                        <a href="https://github.com/DS-Pirate/-AIRREVIEW"><i class="bi bi-paperclip"></i> 에어리뷰 :: 세상의 모든 리뷰</a><br />
                        <a href="https://naver.com"><i class="bi bi-paperclip"></i> 포트폴리오 사이트</a>
                    </span>
                </div>
                <div ref="python" class="contentarea-context__collapse" @click="collapse(2)">
                    <div class="contentarea-context__collapse-title">
                        <span>
                            - Python
                            <h6>ㄴ Algorithm</h6>
                        </span>
                        <i ref="pythonBtn" class="bi bi-caret-down-square-fill"></i>
                    </div>
                    <br />
                    <span ref="python" class="contentarea-context__collapse-context">
                        Python을 이용하여 기초적인 자료구조, 알고리즘을 습득하였습니다<br />
                        <a href="https://github.com/B-HS/Algorithm-with-python-feat.-Backjoon"><i class="bi bi-paperclip"></i> :: 문제 기록 레포지토리</a><br />
                        <a href="https://www.acmicpc.net/user/hseoks"><i class="bi bi-paperclip"></i> :: BAEKJOON 프로필</a>
                    </span>
                </div>
            </div>
        </section>

        <section class="contentarea-context__box">
            <h1 class="bi bi-three-dots"> 기타 경험 기술</h1>
            <hr />
            <div class="contentarea-context__box__list_etc">
                <span>MySQL</span>
                <span>Nginx</span>
                <span>Docker</span>
                <span>AWS Lightsail</span>
                <span>Oracle Cloud</span>
                <span>JIRA</span>
                <span>Redmine</span>
            </div>
        </section>
    </div>
</template>
<script setup>
    import { ref } from "vue";

    let java = ref(null);
    let vue = ref(null);
    let python = ref(null);
    let javaBtn = ref(null);
    let vueBtn = ref(null);
    let pythonBtn = ref(null);

    function collapse(which) {
        switch (which) {
            case 0:
                if (java.value.style.maxHeight == "7rem") {
                    java.value.style.height = "fit-content";
                    java.value.style.maxHeight = "1.25rem";
                    javaBtn.value.style.transform = "rotate(0deg)";
                } else {
                    java.value.style.height = "auto";
                    java.value.style.maxHeight = "7rem";
                    javaBtn.value.style.transform = "rotate(180deg)";
                }
                break;

            case 1:
                if (vue.value.style.maxHeight == "7rem") {
                    vue.value.style.height = "fit-content";
                    vue.value.style.maxHeight = "1.25rem";
                    vueBtn.value.style.transform = "rotate(0deg)";
                } else {
                    vue.value.style.height = "auto";
                    vue.value.style.maxHeight = "7rem";
                    vueBtn.value.style.transform = "rotate(180deg)";
                }
                break;
            case 2:
                if (python.value.style.maxHeight == "7rem") {
                    python.value.style.height = "fit-content";
                    python.value.style.maxHeight = "1.25rem";
                    pythonBtn.value.style.transform = "rotate(0deg)";
                } else {
                    python.value.style.height = "auto";
                    python.value.style.maxHeight = "7rem";
                    pythonBtn.value.style.transform = "rotate(180deg)";
                }
                break;
        }
    }
</script>
<style scoped lang="sass">
    .contentarea-context
        display: flex
        flex-direction: column
        gap: 1rem
        width: 80%
    .contextarea-context__profile
        display: flex
        justify-content: flex-start
        gap: 1.5rem
    .contentarea-context__box
        border: 1px #777 solid
        box-sizing: border-box
        padding: 1rem
        width: 100%
        hr
            margin: 0.75rem 0rem
        p
            line-height: 2rem
        .subp
            margin-left: 1rem
        .subpp
            margin-left: 2rem
        .contentarea-context__box__list
            display: grid
            grid-template-columns: repeat(auto-fit, minmax(400px, 1fr))
            gap: 2rem
            box-sizing: border-box
            overflow: hidden
            .contentarea-context__collapse
                font-size: 0.75rem
                height: 1.25rem
                max-height: 1.5rem
                padding: 1rem 0.5rem
                border-bottom: 1px solid #333
                overflow: hidden
                transition: 0.5s ease-in-out all
                line-height: 0.85rem
                .contentarea-context__collapse-title
                    display: flex
                    justify-content: space-between
                    position: relative
                    i
                        position: absolute
                        right: 1rem

                .contentarea-context__collapse-context
                    line-height: 1.5rem
                    i
                        margin-left: 2rem
        .contentarea-context__box__list_etc
            display: grid
            grid-template-columns: repeat(auto-fit, minmax(380px, 1fr))
            gap: 2rem
            box-sizing: border-box
            padding: 1rem 0.5rem
    .contentarea-context__text__etc
        flex-direction: column
        justify-content: start
        gap: 1rem !important
        .contentarea-context__text__etc__icon
            display: flex
            flex-direction: column
            gap: 0.25rem
            h5
                font-size: 1rem
                
</style>
