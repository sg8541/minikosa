// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/Login.vue'
import Signup from '../views/Signup.vue'
import Intro from '../views/Intro.vue'
import Suggestion from '../views/Suggestion.vue'
import FindEmail from '../views/FindEmail.vue'
import ResetPassword from '../views/ResetPassword.vue'
import EditProfile from '../views/EditProfile.vue'
import AdminSuggestionList from '../views/admin/AdminSuggestionList.vue'
import AdminSuggestionView from '../views/admin/AdminSuggestionView.vue'
import RegisterOwner from '../views/admin/RegisterOwner.vue'

import StoreView from '../views/stores/StoreView.vue'

// 다른 뷰를 추가로 임포트

import { useAuthStore } from '../stores/auth'

const routes = [
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/signup',
    name: 'Signup',
    component: Signup
  },
  {
    path: '/intro',
    name: 'Intro',
    component: Intro,
    meta: { requiresAuth: true }
  },
  {
    path: '/findemail',
    name: 'FindEmail',
    component: FindEmail
  },
  {
    path: '/reset/password',
    name: 'ResetPassword',
    component: ResetPassword
  },
  {
    path: '/suggestion',
    name: 'Suggestion',
    component: Suggestion,
    meta: { requiresAuth: true }
  },
  {
    path: '/editprofile',
    name: 'EditProfile',
    component: EditProfile,
    meta: { requiresAuth: true }
  },
  // Admin Routes
  {
    path: '/admin/suggestion/list',
    name: 'AdminSuggestionList',
    component: AdminSuggestionList,
    meta: { requiresAuth: true, requiresAdmin: true }
  },
  {
    path: '/admin/suggestion/:id',
    name: 'AdminSuggestionView',
    component: AdminSuggestionView,
    meta: { requiresAuth: true, requiresAdmin: true },
  },
  {
    path: '/admin/register/owner',
    name: 'RegisterOwner',
    component: RegisterOwner,
    meta: { requiresAuth: true, requiresAdmin: true },
  },
  // 기타 라우트
  {
    path: '/',
    name: 'Home',
    redirect: '/login'
  },
  // store
  {
    path: '/store/:id',
    name: 'StoreView',
    component: StoreView
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

// 라우터 가드 설정
router.beforeEach((to, from, next) => {
  const authStore = useAuthStore()
  if (to.matched.some(record => record.meta.requiresAuth)) {
    if (!authStore.accessToken) {
      next({ name: 'Login' })
    } else if (to.matched.some(record => record.meta.requiresAdmin) && authStore.user.roleId !== 2) {
      // 관리자 권한 확인 (예: roleId === 2이 ADMIN)
      next({ name: 'Intro' })
    } else {
      next()
    }
  } else {
    next()
  }
})

export default router
