<template>
    <div class="contentarea">
        <NavigationBar></NavigationBar>
        <section class="contentarea-context">
            <transition>
                <router-view></router-view>
            </transition>
        </section>
    </div>
</template>
<script setup>
    import NavigationBar from "./components/NavigationBar.vue";
</script>

<style lang="sass">
    @import url("https://fonts.googleapis.com/css2?family=Gothic+A1:wght@100;300;500&family=Ubuntu:wght@500&display=swap")
    *
        padding: 0
        margin: 0
        font-family: 'Gothic A1', sans-serif
        img
            max-height: 100%
            max-width: 100%
        h5
            font-size: 1.2rem
        h6
            font-weight: 300
            font-family: 'Ubuntu', sans-serif
        hr
            opacity: 0.7
        input
            outline: none
            padding: 0.3rem
            border-radius: 0
    #app
        a, li, ul, ol
            text-decoration: none
            color: inherit
            list-style-type: none
            padding: 0
            margin: 0

    .contentarea
        display: flex
        flex-direction: column
        align-items: center
        min-height: 100vh
        min-width: 450px
        background: black
        .contentarea-context
            max-width: 1920px
            min-width: 450px
            display: flex
            flex-direction: column
            align-items: center
            box-sizing: border-box
            padding: 2rem 1rem
            color: white
            gap: 1rem
            width: 100%
        .contentarea-context__img
            width: 12.5rem
            img
                border-radius: 10rem
        .contentarea-context__text
            .contentarea-context__text__name
                font-size: 2rem
            .contentarea-context__text__etc
                display: flex
                justify-content: space-between
                gap: 3rem
                .contentarea-context__text__etc__icon
                    display: flex
                    gap: 0.5rem
    .v-enter-active, .v-leave-active
        transition: 0.5s ease-in-out all

    .v-enter-from, .v-leave-to
        opacity: 0
</style>
