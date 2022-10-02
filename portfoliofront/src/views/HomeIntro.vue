<template>
    <div class="contentarea-context">
        <div class="contentarea-context__img">
                <img src="@/assets/selfieeee.jpeg" alt="profile" />
            </div>

            <div class="contentarea-context__text">
                <h1 class="contentarea-context__text__name">Hyunseok Byun</h1>
                <div class="contentarea-context__text__etc">
                    <h5 class="contentarea-context__text__etc__birthday">95.07.01</h5>
                    <div class="contentarea-context__text__etc__icon">
                        <a href="https://github.com/B-HS"><h5 class="contentarea-context__text__etc__icon__github bi bi-github"></h5></a>
                        <a href="https://mail:gumyoincirno@gmail.com/"><h5 class="contentarea-context__text__etc__icon__mail bi bi-envelope-fill"></h5></a>
                        <a href="tel:010-7538-2613"><h5 class="bi bi-telephone-fill"></h5></a>
                        <a href="https://hbyun.tistory.com/"><h5 class="bi bi-arrow-up-right-square"></h5></a>
                    </div>
                </div>
            </div>
        <section class="contentarea-context__box">
            <h1 class="bi bi-person-fill"> Introduce</h1>
            <hr>
            <p>
                코딩, 무언가 하나 해결 될 때의 그 짜릿함을 끊을 수가 없습니다 <br>
                언제나 발전하는 코딩을 지향합니다
            </p>
        </section>
        <section class="contentarea-context__box">
            <h1 class="bi bi-stack"> SKILL</h1>
            <hr>
            <div class="contentarea-context__box__list">
                <div ref="java" class="contentarea-context__collapse" @click="collapse(0)">
                    <div class="contentarea-context__collapse-title">
                        <span> - JAVA <h6> ㄴ Spring boot</h6></span>
                        <i ref="javaBtn" class="bi bi-caret-down-square-fill"></i>
                    </div>
                    <br>
                    <span class="contentarea-context__collapse-context">
                        Spring boot를 이용하여 하기의 프로젝트의 백엔드를 완성하였습니다<br>
                        <a href="https://github.com/DS-Pirate/-AIRREVIEW"><i class="bi bi-paperclip"></i> 에어리뷰 세상의 모든 리뷰</a>
                        <a href="https://naver.com"><i class="bi bi-paperclip"></i> 현 포트폴리오 사이트</a>
                    </span>
                </div>
                <div ref="vue" class="contentarea-context__collapse" @click="collapse(1)">
                    <div ref="vue" class="contentarea-context__collapse-title">
                        <span> - Vue <h6> ㄴ Javascript, HTML, CSS(SASS)</h6></span>
                        <i ref="vueBtn" class="bi bi-caret-down-square-fill"></i>
                    </div>
                    <br>
                    <span  class="contentarea-context__collapse-context">
                        Vue.js를 이용하여 하기의 프로젝트의 프론트를 완성하였습니다<br>
                        <a href="https://github.com/DS-Pirate/-AIRREVIEW"><i class="bi bi-paperclip"></i> 에어리뷰 세상의 모든 리뷰</a>
                        <a href="https://naver.com"><i class="bi bi-paperclip"></i> 현 포트폴리오 사이트</a>
                    </span> 
                </div>
                <div ref="python" class="contentarea-context__collapse" @click="collapse(2)">
                    <div class="contentarea-context__collapse-title">
                        <span> - Python</span>
                        <i ref="pythonBtn" class="bi bi-caret-down-square-fill"></i>
                    </div>
                    <br>
                    <span ref="python" class="contentarea-context__collapse-context">
                        Python을 이용하여 기초적인 자료구조, 알고리즘을 습득하였습니다<br>
                        <a href="https://github.com/B-HS/Algorithm-with-python-feat.-Backjoon"><i class="bi bi-paperclip"></i> :: 문제 기록 레포지토리</a>
                        <a href="https://www.acmicpc.net/user/hseoks"><i class="bi bi-paperclip"></i> :: BAEKJOON 프로필</a>
                    </span>
                </div>
            </div>
        </section>

        <section class="contentarea-context__box">
            <h1 class="bi bi-three-dots"> Etc.</h1>
            <hr>
            <div class="contentarea-context__box__list">
                <ul>
                    <li>MySQL</li>
                    <li>Nginx</li>
                    <li>Docker</li>
                    <li>AWS Lightsail</li>
                    <li>Oracle Cloud</li>
                    <li>JIRA</li>
                    <li>Redmine</li>
                </ul>

            </div>
        </section>
    </div>
</template>
<script setup>
    import { ref } from 'vue'

    let java = ref(null)
    let vue = ref(null)
    let python = ref(null)
    let javaBtn = ref(null)
    let vueBtn  = ref(null)
    let pythonBtn  = ref(null)



    function collapse(which){
        
        switch (which) {
            case 0:
                if(java.value.style.maxHeight=="10rem"){
                    java.value.style.height="fit-content"
                    java.value.style.maxHeight="1.5rem"
                    javaBtn.value.style.transform ="rotate(0deg)"
                    
                }else{
                    java.value.style.height="auto"
                    java.value.style.maxHeight="10rem"
                    javaBtn.value.style.transform ="rotate(180deg)"
                }
                break;
        
            case 1:
                if(vue.value.style.maxHeight=="10rem"){
                    vue.value.style.height="fit-content"
                    vue.value.style.maxHeight="1.5rem"
                    vueBtn.value.style.transform ="rotate(0deg)"
                    
                }else{
                    vue.value.style.height="auto"
                    vue.value.style.maxHeight="10rem"
                    vueBtn.value.style.transform ="rotate(180deg)"
                }
                break
            case 2:
                if(python.value.style.maxHeight=="10rem"){
                    python.value.style.height="fit-content"
                    python.value.style.maxHeight="1.5rem"
                    pythonBtn.value.style.transform ="rotate(0deg)"
                    
                }else{
                    python.value.style.height="auto"
                    python.value.style.maxHeight="10rem"
                    pythonBtn.value.style.transform ="rotate(180deg)"
                }
                break
        }
    }
</script>
<style scoped lang="sass">
    .contentarea-context
        display: flex
        flex-direction: column
        gap: 1rem
        width: 75%
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
            display: flex
            flex-direction: column
            gap: 2rem
            box-sizing: border-box
            ul
                display: flex
                justify-content: space-between
            .contentarea-context__collapse
                font-size: 1rem
                height: 1.5rem
                max-height: 1.5rem
                padding: 1rem 0.5rem
                border-bottom: 1px solid #333
                overflow: hidden
                transition: 0.5s ease-in-out all
                .contentarea-context__collapse-title
                    display: flex
                    justify-content: space-between

                .contentarea-context__collapse-context
                    line-height: 2rem
                    i
                        margin-left: 2rem

                        
                    
                    
</style>
