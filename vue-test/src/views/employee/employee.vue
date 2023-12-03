<template>
  <div>
    <div style="padding: 10px 0">
      <el-input
        placeholder="职工姓名"
        suffix-icon="el-icon-search"
        style="width: 200px"
        type="text"
        v-model="empName"
      ></el-input>

      <el-select
      style="margin-left:10px"
            v-model="deptName"
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

          <el-select
          style="margin-left:10px"
            v-model="empDegreeName"
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

      <el-button :disabled="upLimit" @click="getTableData" style="margin-left: 5px" type="primary"
        >搜索</el-button
      >
      <el-button :disabled="upLimit" @click="reset" style="margin-left: 5px" type="primary"
        >重置</el-button
      >
    </div>

    <div style="margin: 10px 0">
      <el-button @click="edit('')" type="primary" :disabled="limit"
        >新增 <i class="el-icon-circle-plus-outline"></i>
      </el-button>
      <el-button type="danger" @click="removeByIds" :disabled="limit"
        >批量删除 <i class="el-icon-remove-outline"></i>
      </el-button>
  

      <el-button :disabled="limit" @click="exportExcel" type="primary">导出<i class="el-icon-upload2"></i></el-button>
    </div>

    <el-table
      :data="tableData"
      border
      stripe
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection"></el-table-column>
      <el-table-column prop="empName" label="姓名" width="120">
      </el-table-column>
      <el-table-column prop="sex" label="性别">
        <template slot-scope="scope">
            <span>{{scope.row.sex ? dictTransform(scope.row.sex,sexArr) : '' }}</span>
          </template>   
      </el-table-column>
      <el-table-column prop="age" label="年龄"> </el-table-column>
      <el-table-column prop="deptName" label="部门名称">
        <template slot-scope="scope">
            <span>{{scope.row.deptName ? dictTransform(scope.row.deptName,deptNameArr) : '' }}</span>
          </template>
      </el-table-column>
      <el-table-column prop="empDegreeName" label="学历">
        <template slot-scope="scope">
            <span>{{scope.row.empDegreeName ? dictTransform(scope.row.empDegreeName,empDegreeNameArr) : '' }}</span>
          </template>
      </el-table-column>
      <el-table-column label="操作" width="300">
        <template slot-scope="scope">
          <el-button :disabled="limit" @click="edit(scope.row.id)" type="success">编辑</el-button>
          <el-button :disabled="limit" type="danger" @click="remove(scope.row.id)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <div style="padding: 10px 0">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="10"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      >
      </el-pagination>
    </div>
    <Dialog
      @reflash="getTableData"
      :formData="formData"
      :dialogVisible="dialogVisible"
      @closeDialog="closeDialog"
      @save="save($event)"
    ></Dialog>
  </div>
</template>

<script>
import Dialog from "@/views/employee/Dialog.vue";
export default {
  name: "employee",
  components: { Dialog },
  data() {
    return {
      tableData: [],
      pageSize: 10,
      pageNum: 1,
      total: 10,
      dialogVisible: false,
      formData: {},
      removeIds: [],
      empName: "",
      empDegreeName:'',
      deptName:'',
      limit:false,
      upLimit:false,
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
  mounted() {
    let user = JSON.parse(localStorage.getItem("user"))
    if(!user){
      // this.$message.error("无token，重新登录")
      // this.$router.push('/Login')
      return false;
    }
    
    this.getTableData();
  },
  methods: {
    test23(scope) {
      console.log(scope);
    },
    dictTransform(value, dict) {
      // 遍历字典数组，查找匹配的值
      for (let item of dict) {
        // 如果找到匹配的值，返回对应的label
        if (item.value === value) {
          return item.label;
        }
      }
      // 如果没有找到匹配的值，返回空字符串
      return "";
    },
    reset(){
      this.empName = ''
      this.empDegreeName = ''
      this.deptName = ''
      this.getTableData()
    },

    exportExcel(){
      window.open("http://localhost:9091/employee/export")
    },
    save(formData) {
      this.request.post("/employee/saveOrUpdate", formData).then((res) => {
        if (res.code === 200) {
          this.$message.success("保存成功");
          this.dialogVisible = false;
          this.formData = {};
        } else {
          this.$message.error(res.msg);
        }
      });
    },
    edit(id) {
      if (!id) {
        this.dialogVisible = true;
      } else {
        this.request.get("/employee/getById/" + id).then((res) => {
          if (res.code === 200) {
            this.formData = res.data;
          }
        });
        this.dialogVisible = true;
      }
    },
    remove(id) {
      this.$confirm("确认删除？", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.request.delete("/employee/removeById/" + id).then((res) => {
            if (res.code === 200) {
              this.$message.success(res.msg);
              this.getTableData();
            } else {
              this.$message.error(res.msg);
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    removeByIds() {
      this.$confirm("确认删除？", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.request
            .post("/employee/removeByIds/", this.removeIds)
            .then((res) => {
              if (res.code === 200) {
                this.$message.success(res.msg);
                this.getTableData();
              } else {
                this.$message.error(res.msg);
              }
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    closeDialog() {
      this.dialogVisible = false;
      this.formData = {};
    },
    handleSizeChange(val) {
      this.pageSize = val;
      console.log(`每页 ${val} 条`);
      this.getTableData();
    },
    handleCurrentChange(val) {
      this.pageNum = val;
      console.log(`当前页: ${val}`);
      this.getTableData();
    },
    getTableData() {
      let data = { pageNum: this.pageNum, pageSize: this.pageSize };
     
      if (this.empName) {
        data.empName = this.empName;
      }
      if(this.deptName){
        data.deptName = this.deptName
      }
      if(this.empDegreeName){
        data.empDegreeName = this.empDegreeName
      }
     
      this.request.post("/employee/findPage", data).then((res) => {
        this.tableData = res.data.records;
        this.total = res.data.total;
      });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
      this.removeIds = val.map((item) => {
        return item.id;
      });
      console.log(this.removeIds);
    },
  },
};
</script>

<style>
</style>