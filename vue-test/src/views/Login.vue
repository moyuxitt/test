<template>
  <div class="wrapper">
    <!-- <h1 style="position: absolute;;color: rgba(115,176,66,0.7);font-size: 50px;text-align: center; padding-top: 5vh;left: 37%">就 业 信 息 管 理 系 统</h1> -->
    <div
      style="
        background-color: #fff;
            width: 358px;
            height: 588px;
            border-radius: 15px;
            padding: 0 50px;
            position: relative;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
      "
    >
      <div style=" font-size: 38px;
            font-weight: bold;
            text-align: center;
            line-height: 200px;">
        <b>Login</b>
      </div>
      <el-form :rules="rules" :model="user" ref="form">
        <el-form-item prop="userId">
          <el-input
            size="medium"
            style="margin: 10px 0"
            prefix-icon="el-icon-user"
            v-model="user.userId"
          ></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            size="medium"
            style="margin: 10px 0"
            prefix-icon="el-icon-lock"
            show-password
            v-model="user.password"
          ></el-input>
        </el-form-item>
        <div style="margin: 10px 0; text-align: right">
          <el-button

            autocomplete="off"
            @click="login"
            style="text-align: center;
            padding: 10px;
            width: 100%;
            margin-top: 0px;
            background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
            color: #fff;"
            >登录</el-button
          >
          <!-- <el-button @click="dialogOpen" type="warning" size="small" autocomplete="off"
            >注册</el-button
          > -->
          <!-- <div class="msg">
                还没有帐号？
                <a  @click="dialogOpen" >注册</a>
            </div> -->
        </div>
      </el-form>
    </div>
    <!-- <Register ref="register" @save="save($event)" :dialogVisible="dialogVisible" @closeDialog="closeDialog"></Register> -->
  </div>
  
</template>

<script>

export default {

  name: "Login",
  data() {
    return {
      user: {
        userId: "",
        password: "",
      },
      dialogVisible:false,
      rules: {
        userId: [{ required: true, message: "请输入用户名", trigger: "blur" }],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
      },
    };
  },
  methods: {
    dialogOpen(){
      this.dialogVisible = true
    },
    closeDialog(){
      this.dialogVisible = false
    },
    save(formData) {
      this.request.post("/user/saveOrUpdate", formData).then((res) => {
        if (res.code === 200) {
          this.$message.success("保存成功");
          this.dialogVisible = false;
          this.userIdBoolean = true;
          this.formData = {};
          this.$refs.register.reflash
        } else {
          this.$message.error(res.msg);
        }
      });
    },
    login() {
      this.$refs.form.validate((valid) => {
        if (valid) {
          this.request.post("/user/Login", this.user).then((res) => {
            if (res.code === 200) {
              this.$message.success("登录成功");
              localStorage.setItem("user",JSON.stringify(res.data))
              this.$router.push('/home')
            } else {
              this.$message.error(res.msg);
            }
          });
        }else{
            this.$message.error("参数错误")
        }
      });
    },
  },
};
</script>

<style>
.wrapper {
  height: 100vh;
  background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);
  overflow: hidden;
}
        .login-wrapper {
            background-color: #fff;
            width: 358px;
            height: 588px;
            border-radius: 15px;
            padding: 0 50px;
            position: relative;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
        }
        .header {
            font-size: 38px;
            font-weight: bold;
            text-align: center;
            line-height: 200px;
        }
        .input-item {
            display: block;
            width: 100%;
            margin-bottom: 20px;
            border: 0;
            padding: 10px;
            border-bottom: 1px solid rgb(128, 125, 125);
            font-size: 15px;
            outline: none;
        }
        .input-item:placeholder {
            text-transform: uppercase;
        }
        .btn {
            text-align: center;
            padding: 10px;
            width: 100%;
            margin-top: 40px;
            background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
            color: #fff;
        }
        .msg {
            text-align: center;
            line-height: 88px;
        }
        a {
            text-decoration-line: none;
            color: #abc1ee;
        }
</style>