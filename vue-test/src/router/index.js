import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Employee from '@/views/employee/employee.vue'
// import Active from '@/views/Active/index.vue'
// import EmInfo from '@/views/EmInfo/index.vue'
// import EmNotice from '@/views/EmNotice/index.vue'
// import studentInfo from '@/views/studentInfo/index.vue'
// import teacherInfo from '@/views/teacherInfo/index.vue'
// import User from '@/views/User/index.vue'
import Login from '@/views/Login.vue'
import Home from '@/views/Home.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home1',
    component: HomeView,
    children: [
      {
        path: 'employee', name: 'employee', component: Employee,
      },
    //   {
    //     path: 'active', name: 'active', component: Active,
    //   },
    //   {
    //     path: 'emInfo', name: 'emInfo', component: EmInfo,
    //   },
    //   {
    //     path: 'emNotice', name: 'emNotice', component: EmNotice,
    //   },
    //   {
    //     path: 'studentInfo', name: 'studentInfo', component: studentInfo,
    //   },
    //   {
    //     path: 'teacherInfo', name: 'teacherInfo', component: teacherInfo,
    //   },
    //   {
    //     path: 'user', name: 'user', component: User,
    //   },
      {
        path: 'home', name: 'home', component: Home,
      }
    ]
  },
  {
    path: '/Login',
    name: 'Login',
    component: Login
  },
  {
    path: '/home',
    name: 'home',
    component: Home
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
