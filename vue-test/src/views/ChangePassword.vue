<template>
  <div>
    <el-dialog
      title="修改密码"
      :before-close="closeDialog"
      :visible.sync="dialogVisible"
      width="400px"
    >
      <el-form :label-position="labelPosition" label-width="100px">
        <el-form-item label="原始密码" prop="original">
          <el-input autocomplete="off" v-model="formData.original"></el-input>
        </el-form-item>

        <el-form-item label="新密码" prop="newPassword">
          <el-input
            show-password
            autocomplete="off"
            v-model="formData.newPassword"
          ></el-input>
        </el-form-item>

        <el-form-item label="重复新密码" prop="reNewPassword">
          <el-input
            show-password
            autocomplete="off"
            v-model="formData.reNewPassword"
          ></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="closeDialog()">取 消</el-button>
        <el-button type="primary" @click="savePassword()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "ChangePassword",
  props: {
    dialogVisible: {
      type: Boolean,
      default: false,
    },
  },
  data() {
    return {
      labelPosition: "left",
      formData: {
        id: "",
      },
    };
  },
  mounted() {
 
  },
  methods: {
    savePassword() {
        let user = JSON.parse(localStorage.getItem("user"));
       this.formData.id = user.id;
      this.$emit("savePassword", this.formData);
      this.reflash();
    },
    closeDialog() {
      this.formData = {};
      this.$emit("closeDialog");
    },
    reflash() {
    this.formData = {};
  },
  },

};
</script>

<style>
</style>