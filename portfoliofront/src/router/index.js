import { createRouter, createWebHistory } from 'vue-router'
import HomeIntro from "@/views/HomeIntro.vue"
// import ProjectList from "@/views/ProjectHistory.vue"
const ProjectList = () => import(/* webpackChunkName: "ProjectHistory" */ '@/views/ProjectHistory.vue');
// import GuestBoard from "@/views/GuestBook.vue"
const GuestBoard = () => import(/* webpackChunkName: "GuestBook" */ '@/views/GuestBook.vue');
// import WriteProject from "@/views/WriteProject.vue"
const WriteProject = () => import(/* webpackChunkName: "WriteProject" */ '@/views/WriteProject.vue');
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeIntro
  },
  {
    path: '/projects',
    name: 'project',
    component: ProjectList
  },
  {
    path: '/board',
    name: 'board',
    component: GuestBoard
  },
  {
    path: '/write',
    name: 'write',
    component: WriteProject
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
