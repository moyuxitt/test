<template>
  <el-container style="height: 100vh">
    <el-aside
      :width="sideWith + 'px'"
      style="
        background-color: rgb(238, 241, 246);
        box-shadow: 2px 0 6px rgb(0 21 41 / 35%);
      "
    >
     <Aside :isCollapse="isCollapse"> </Aside>
    </el-aside>

    <el-container>
      <el-header
        style="
      
          border-bottom: 1px solid #ccc;
         
        
        "
      >
       <Header :collapseBtnClass="collapseBtnClass"  :collapse="collapse"></Header>
      </el-header>
       
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
// import  request  from '../utils/request.js'
import Aside from '@/components/Aside.vue'
import Header from '@/components/Header.vue'
export default {
  name: "HomeView",
  components:{Aside,Header},
  data() {
    return {
      tableData: [],
      collapseBtnClass: "el-icon-s-fold",
      isCollapse: false,
      sideWith: 200,
    };
  },
  methods: {
    collapse() {
      this.isCollapse = !this.isCollapse;
      if (this.isCollapse) {
        this.sideWith = 64;
      } else {
        this.sideWith = 200;
      }
    },
   
  },
 
};
</script>
