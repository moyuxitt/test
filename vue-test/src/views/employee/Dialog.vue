<template>
  <div>
    <el-dialog title="编辑" :before-close="closeDialog" :visible.sync="dialogVisible" width="400px">
      <el-form ref="form" :label-position="labelPosition"  label-width="100px" :model="formData">
        <el-form-item label="职工名称:"  prop="empName" :rules="{required:true,message: '必填参数不能为空', trigger: 'blur' }">
            <el-input autocomplete="off"   v-model="formData.empName"></el-input>
        </el-form-item>
        <el-form-item label="性别:"  prop="sex" :rules="{required:true,message: '必填参数不能为空', trigger: 'blur' }">
            <!-- <el-input autocomplete="off"   v-model="formData.sex"></el-input> -->
            <el-select
            v-model="formData.sex"
            placeholder="请选择性别"
          >
            <el-option
              v-for="item in sexArr"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            > 
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="年龄:"  prop="age" :rules="{required:true,message: '必填参数不能为空', trigger: 'blur' }">
            <el-input autocomplete="off"  type="number"  v-model="formData.age"></el-input>
        </el-form-item>
        <el-form-item label="部门名称:"  prop="deptName" :rules="{required:true,message: '必填参数不能为空', trigger: 'blur' }">
            <!-- <el-input autocomplete="off"  v-model="formData.deptName"></el-input> -->
            <el-select
            v-model="formData.deptName"
            placeholder="请选择部门名称"
          >
            <el-option
              v-for="item in deptNameArr"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="学历:"  prop="empDegreeName" :rules="{required:true,message: '必填参数不能为空', trigger: 'blur' }">
            <!-- <el-input autocomplete="off"  v-model="formData.empDegreeName"></el-input> -->
            <el-select
            v-model="formData.empDegreeName"
            placeholder="请选择学历"
          >
            <el-option
              v-for="item in empDegreeNameArr"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="closeDialog()">取 消</el-button>
        <el-button type="primary" @click="save()"
          >确 定</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "Dialog",
  props:{
    dialogVisible:{
        type:Boolean,
        default:false
    },
    formData:{
        type:Object,
        default:{}
    }
  },
  data() {
    return {
        labelPosition:"left",
        sexArr:[
        {
          label:'男',
          value:'0'
        },
        {
          label:'女',
          value:'1'
        },
      ],
      deptNameArr:[
        {
          label:'业务部',
          value:'0'
        },
        {
          label:'后勤部',
          value:'1'
        },
        {
          label:'人事部',
          value:'2'
        },
      ],
      empDegreeNameArr:[
        {
          label:'大专',
          value:'0'
        },
        {
          label:'本科',
          value:'1'
        },
        {
          label:'研究生',
          value:'2'
        },
      ]
    };
  },
  methods: {
    save(){
      this.$refs.form.validate((valid) => {
        if(valid){
          this.$emit("save",this.formData)
           this.$emit("reflash")
        }else{
          this.$message.error("参数错误")
        }
      })
      
    },
    closeDialog(){
        this.$emit("closeDialog")
    },

  },
};
</script>

<style>
</style>