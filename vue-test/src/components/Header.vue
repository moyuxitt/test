<template>
  <div style="font-size: 12px; display: flex; line-height: 60px">
    <div style="flex: 1; font-size: 18px">
      <span
        :class="collapseBtnClass"
        style="cursor: pointer"
        @click="collapse"
      ></span>
    </div>
    <el-dropdown @command="handleCommand" style="width: 70px; cursor: pointer">
      <span>{{ userName }}</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item command="logout">退出</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>

  </div>
</template>

<script>

export default {
  name: "Header",

  props: {
    collapseBtnClass: {
      type: String,
      default: "",
    },
    collapse: Function,
  },
  data() {
    return {
      userName: "",
      dialogVisible:false,
    };
  },
  mounted() {
    this.getUserName();
  },
  methods: {
    handleCommand(command) {
      if (command === "logout") {
        this.logout();
      } 
    },
    getUserName() {
      let user = JSON.parse(localStorage.getItem("user"));
      if(!user){
        this.$message.error("无token，重新登录")
        this.$router.push('/Login')
        return false
      }
      this.userName = user.userId;
    },
    logout() {
        localStorage.removeItem("user")
      this.$router.push("/Login");
      this.$message.success("退出登录！")
    },
    closeDialog(){
      this.dialogVisible = false

    },
  
  },
};
</script>

<style>
</style>