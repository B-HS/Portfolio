import { createRouter, createWebHistory } from 'vue-router'
import HomeIntro from "@/views/HomeIntro.vue"
import ProjectList from "@/views/ProjectHistory.vue"
import GuestBoard from "@/views/GuestBook.vue"
import ProjectDetail from "@/views/ReadProject.vue"
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
    path: '/read',
    name: 'read',
    component: ProjectDetail
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
