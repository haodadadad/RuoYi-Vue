<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="任务号" prop="orderNumber">
        <el-input
          v-model="queryParams.orderNumber"
          placeholder="请输入任务号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="图号" prop="drawingNumber">
        <el-input
          v-model="queryParams.drawingNumber"
          placeholder="请输入图号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="板号" prop="boardNumber">
        <el-input
          v-model="queryParams.boardNumber"
          placeholder="请输入板号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户工号" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入用户工号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户姓名" prop="nickName">
        <el-input
          v-model="queryParams.nickName"
          placeholder="请输入用户姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="检测结果" prop="result">

        <!--        <el-input-->
        <!--          v-model="queryParams.result"-->
        <!--          placeholder="请输入检测结果"-->
        <!--          clearable-->
        <!--          @keyup.enter.native="handleQuery"-->
        <!--        />-->

        <el-select v-model="queryParams.result" placeholder="请选择检测结果">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>


      <el-form-item label="故障现象" prop="phenomenon">
        <el-input
          v-model="queryParams.phenomenon"
          placeholder="请输入故障现象"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="故障原因" prop="cause">
        <el-input
          v-model="queryParams.cause"
          placeholder="请输入故障原因"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="位号" prop="tagNumber">
        <el-input
          v-model="queryParams.tagNumber"
          placeholder="请输入位号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="仪表序列号" prop="instrumentNumber" label-width=85px>
        <el-input
          v-model="queryParams.instrumentNumber"
          placeholder="请输入仪表序列号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="MES码" prop="mesId">
        <el-input
          v-model="queryParams.mesId"
          placeholder="请扫描MES码"
          clearable
          @keyup.enter.native="handleQuery"

        />
      </el-form-item>
      <el-form-item label="备注" prop="remark">
        <el-input
          v-model="queryParams.remark"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['data:record:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['data:record:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['data:record:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['data:record:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="recordList" @selection-change="handleSelectionChange" stripe style="width: 100%" border>
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="任务号" align="center" prop="orderNumber" width="125"/>
      <el-table-column label="图号" align="center" prop="drawingNumber" width="125"/>
      <el-table-column label="板号" align="center" prop="boardNumber" width="80"/>
      <el-table-column label="检测结果" align="center" prop="result" width="75">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_test_result" :value="scope.row.result"/>
        </template>
      </el-table-column>

      <el-table-column label="故障现象" align="center" prop="phenomenon"min-width="100"/>
      <el-table-column label="故障原因" align="center" prop="cause" min-width="50"/>
      <el-table-column label="位号" align="center" prop="tagNumber" width="55"/>
      <el-table-column label="仪表序列号" align="center" prop="instrumentNumber" min-width="50"/>
      <el-table-column label="用户姓名" align="center" prop="nickName" width="75"/>
      <el-table-column label="时间" align="center" prop="createTime" width="100">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d} ') }}</span>
        </template>
      </el-table-column>

      <el-table-column label="备注" align="center" prop="remark" width="80"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="100">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['data:record:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['data:record:remove']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改记录查询对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
<!--        <el-form-item label="用户工号" prop="userName">-->
<!--          <el-input v-model="form.userName" placeholder="请输入用户工号"/>-->
<!--        </el-form-item>-->
        <el-form-item label="用户姓名" prop="nickName" aria-readonly="true">
          <el-input v-model="form.nickName" placeholder="请输入用户姓名"/>
        </el-form-item>
<!--        <el-form-item label="仪表序列号" prop="instrumentNumber">-->
<!--          <el-input v-model="form.instrumentNumber" placeholder="请输入仪表序列号"/>-->
<!--        </el-form-item>-->
        <el-form-item label="检测结果" prop="result">
          <!--          <el-input v-model="form.result" placeholder="请输入检测结果" />-->
          <el-select v-model="form.result" placeholder="请选择检测结果" @change="repair">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>
<!--        <el-form-item label="MES码" prop="mesId">-->
<!--          <el-input v-model="form.mesId" placeholder="请输入MES码"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="图号" prop="drawingNumber">-->
<!--          <el-input v-model="form.drawingNumber" placeholder="请输入图号"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="板号" prop="boardNumber">-->
<!--          <el-input v-model="form.boardNumber" placeholder="请输入板号"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="订单号" prop="orderNumber">-->
<!--          <el-input v-model="form.orderNumber" placeholder="请输入订单号"/>-->
<!--        </el-form-item>-->
        <el-form-item label="位号" prop="tagNumber">
          <el-input v-model="form.tagNumber" placeholder="请输入位号"/>
        </el-form-item>
        <el-form-item label="故障现象" prop="phenomenon">
          <el-input v-model="form.phenomenon" placeholder="请输入故障现象"/>
        </el-form-item>
        <el-form-item label="故障原因" prop="cause">
          <el-input v-model="form.cause" placeholder="请输入故障原因"/>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {listRecord, getRecord, delRecord, addRecord, updateRecord} from "@/api/data/record";
import {getPhenomenonInfo} from "@/api/data/phenomenon";

export default {
  name: "Record",
  dicts: ['sys_test_result'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 记录查询表格数据
      recordList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: null,
        nickName: null,
        instrumentNumber: null,
        result: null,
        mesId: null,
        drawingNumber: null,
        boardNumber: null,
        orderNumber: null,
        tagNumber: null,
        phenomenon: null,
        cause: null,
        remark: null,
      },
      // 表单参数
      form: {},
      options: [{
        value: '0',
        label: '合格'
      }, {
        value: '1',
        label: '不合格'
      }],
      // 表单校验
      rules: {}
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询记录查询列表 */
    getList() {
      this.loading = true;
      listRecord(this.queryParams).then(response => {
        this.recordList = response.rows;
        this.total = response.total;
        this.loading = false;
        //  console.log("123321",this.recordList)
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        recordId: null,
        userName: null,
        nickName: null,
        instrumentNumber: null,
        result: null,
        mesId: null,
        drawingNumber: null,
        boardNumber: null,
        orderNumber: null,
        tagNumber: null,
        phenomenon: null,
        cause: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    repair: function (val) {
      if (val == 0) {
        this.form.remark = "已修复"
        // console.log("点击了合格", this.form.result)
      }
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.recordId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加记录查询";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const recordId = row.recordId || this.ids
      getRecord(recordId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改记录查询";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.recordId != null) {
            updateRecord(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRecord(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const recordIds = row.recordId || this.ids;
      this.$modal.confirm('是否确认删除记录查询编号为"' + recordIds + '"的数据项？').then(function () {
        return delRecord(recordIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('data/record/export', {
        ...this.queryParams
      }, `record_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
