<template>
    <div class="navigation">
        <ul class="navigation-ul">
            <router-link @click="menuBackground(1)" to="/"><li ref="home" class="navigation-ul__home"><i class="bi bi-house"></i></li></router-link>
            <router-link @click="menuBackground(2)" to="/projects"><li ref="detail" class="navigation-ul__detail"><i class="bi bi-info-circle"></i></li></router-link>
            <router-link @click="menuBackground(3)" to="/board"><li ref="board" class="navigation-ul__board"><i class="bi bi-card-list"></i></li></router-link>
        </ul>
        <span class="navigation-title"> {{currentSite}}</span>
        <span class="navigation-timer">{{time.hour}}:{{time.minu}}</span>
    </div>
</template>
<script setup>
    import { reactive, ref, onMounted } from 'vue'
    let time = reactive({
        hour : 0,
        minu : 0
    })
    let currentSite = ref("Summary")

    let home = ref(null)
    let detail = ref(null)
    let board = ref(null)

    function getTime(){
        let tmpTime = new Date()
        time.hour = tmpTime.getHours()
        time.minu = tmpTime.getMinutes()
        if (time.minu<10){
            time.minu = "0"+time.minu
        }
    }

    function menuBackground(which){
        
        switch (which) {
            case 1:
                home.value.style.backgroundColor="black"
                home.value.style.color="white"
                detail.value.style.backgroundColor="white"
                detail.value.style.color="black"
                board.value.style.backgroundColor="white"
                board.value.style.color="black"
                currentSite.value = "Summary"
                break
            case 2:
                home.value.style.backgroundColor="white"
                home.value.style.color="black"
                detail.value.style.backgroundColor="black"
                detail.value.style.color="white"
                board.value.style.backgroundColor="white"
                board.value.style.color="black"
                currentSite.value = "Projects"
                break
            case 3:
                home.value.style.backgroundColor="white"
                home.value.style.color="black"
                detail.value.style.backgroundColor="white"
                detail.value.style.color="black"
                board.value.style.backgroundColor="black"
                board.value.style.color="white"
                currentSite.value = "Guest book"
                break
        }
    }
    

    getTime()
    onMounted(()=>{
        switch (window.location.href.split("/")[3]) {
            case "":
                menuBackground(1)
                break;
            case "projects":
                menuBackground(2)
                break
            case "read":
                menuBackground(2)
                break
            case "board":
                menuBackground(3)
                break
        }
        
    })
    setInterval(getTime, 1000)
    
    
</script>
<style scoped lang="sass">
    .navigation
        width: 100%
        position: sticky
        top: 0
        z-index: 1000
        .navigation-title
            position: absolute
            left: 50%
            transform: translateX(-50%)
        .navigation-timer
            padding-right: 0.5rem
        display: flex
        justify-content: space-between
        align-items: center
        box-sizing: border-box
        gap: 1rem
        background: white
        height: auto
        .navigation-ul
            height: 100%
            display: flex     
            li  
                cursor: pointer
                display: flex
                justify-content: center
                align-items: center
                height: 2.5rem
                width: 2.5rem
                box-sizing: border-box
                transition: 0.3s ease-in-out all


                
                                
                
                
</style>