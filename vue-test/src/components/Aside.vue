<template>
    <el-menu
        :default-openeds="['2']"
        style="min-height: 100%; overflow-x: hidden"
        background-color="rgb(48,65,86)"
        text-color="#fff"
        active-text-color="#ffd04b"
        :collapse-transition="false"
        :collapse="isCollapse"
        router
      >
        <div style="height: 60px; line-height: 60px; text-align: center">
          <img
            src="../assets/logo.png"
            alt=""
            style="width: 20px; position: relative; top: 5px; margin-right: 5px"
          />
          <b style="color: #cccccc" v-show="!isCollapse">VUE</b>
        </div>
        <el-menu-item index="/home"> 
        <i class="el-icon-house"></i>
        <span slot="title">主页</span>
      </el-menu-item>
       
        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span slot="title">职工管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="/employee">职工列表</el-menu-item>
           
          </el-menu-item-group>
        </el-submenu>

      
      </el-menu>
</template>

<script>
export default {
   name:"Aside",
   props:{
    isCollapse:{
        type:Boolean,
        default:false
    },
   },
   data(){
    return{
      studentLimit:true,
      teacherLimit:true,
      limit:true
    }
   },
   mounted(){
    let user = JSON.parse(localStorage.getItem("user"))
    // if(user.type === "3"){
    //   this.limit = true
    //   this.teacherLimit = true
    //   this.studentLimit = true
    // }
    // if(user.type === "1" || user.type === "2"){
    //   this.teacherLimit = true
    // }
    // if(user.type === "0"){
    //   this.studentLimit = true
    // }
   }
}
</script>

<style scoped>

</style>