import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/pages/Home.vue'
import About from '@/pages/About.vue'
import Member from '@/pages/Member.vue'
import Videos from '@/pages/Videos.vue'
import Idols from '@/pages/Idols.vue'

//라우터 정보를 가지고 있는 객체
const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: Home
    },{
      path: '/about',
      component: About
    },{
      path: '/member',
      component: Member
    },{
      path: '/videos',
      component: Videos
    },{
      path: '/idols',
      component: Idols
    }]
})

export default router
