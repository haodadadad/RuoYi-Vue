<template>
  <div class="app-container">
    <el-form ref="$form" :model="model" label-position="left" label-width="100px" size="small">
      <el-form-item :rules="rules.mesId" prop="mesId" label="MES码">
        <el-input v-model="model.mesIdInput" placeholder="请扫描二维码" @keyup.enter.native="submitCode" autofocus clearable
                  ref="input"
                  prefix-icon="el-icon-camera"></el-input>
      </el-form-item>
      <el-row :gutter="20" type="flex" justify="start" align="top" tag="div">
        <el-col :span="12" :offset="0" :push="0" :pull="0" tag="div">

          <el-form-item :rules="rules.orderNumber" prop="orderNumber" label="任务号">
            <el-input v-model="model.orderNumber" placeholder="任务号" readonly clearable></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" :offset="0" :push="0" :pull="0" tag="div">
          <el-form-item :rules="rules.drawingNumber" prop="drawingNumber" label="图号">
            <el-input v-model="model.drawingNumber" placeholder="图号" readonly clearable></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" :offset="0" :push="0" :pull="0" tag="div">
          <el-form-item :rules="rules.boardNumber" prop="boardNumber" label="板号">
            <el-input v-model="model.boardNumber" placeholder="板号" readonly clearable></el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12" :offset="0" :push="0" :pull="0" tag="div">
          <el-form-item :rules="rules.nickName" prop="nickName" label="校试人员">
            <el-input v-model="model.nickName" placeholder="姓名" readonly clearable></el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12" :offset="0" :push="0" :pull="0" tag="div">
          <el-form-item :rules="rules.userName" prop="userName" label="工号">
            <el-input v-model="model.userName" placeholder="工号" readonly clearable></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item :rules="rules.instrumentNumber" prop="instrumentNumber" label="仪表码">
        <el-input v-model="model.instrumentNumber" placeholder="请扫描仪表码" clearable
                  prefix-icon="el-icon-camera"></el-input>
      </el-form-item>
      <el-form-item :rules="rules.result" prop="result" label="测试结果">
        <el-radio-group v-model="model.result" text-color="#ffffff" fill="#409EFF" :class="['111']">
          <el-radio v-for="(item, $index) in result_data" :key="item.value" :label="item.value" :border="!!item.border"
                    :disabled="!!item.disabled" @change="unqualified">{{ item.label }}
          </el-radio>
        </el-radio-group>
      </el-form-item>
      <el-divider></el-divider>
      <el-row :gutter="20" type="flex" justify="start" align="top" tag="div" v-if="model.result==='1'">


        <el-col :span="12" :offset="0" :push="0" :pull="0" tag="div">
          <el-form-item :rules="rules.phenomenon" prop="phenomenon" label="故障现象">
            <el-select v-model="model.phenomenon" placeholder="请选择" :style="{width: '100%'}">
              <el-option
                v-for="item in phenomenonOptions"
                :key="item.phenomenon"
                :label="item.phenomenon"
                :value="item.phenomenon"
                :disabled="!!item.disabled"

              ></el-option>


              <!--              <el-option-group v-for="(group, $groupIndex) in phenomenon_data" :key="group.label" :label="group.label"-->
              <!--                               :disabled="!!group.disabled">-->
              <!--                <el-option v-for="(item, $index) in (group.data || [])" :key="item.value" :label="item.label"-->
              <!--                           :value="item.value" :disabled="!!item.disabled"></el-option>-->
              <!--              </el-option-group>-->
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12" :offset="0" :push="0" :pull="0" tag="div">
          <el-form-item :rules="rules.cause" prop="cause" label="故障原因">
            <el-select v-model="model.cause" placeholder="请选择" :style="{width: '100%'}">
              <el-option v-for="(item, $index) in cause_data" :key="item.value" :label="item.label"
                         :value="item.value" :disabled="!!item.disabled"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="10" :offset="0" :push="0" :pull="0" tag="div">
          <el-form-item :rules="rules.tagNumber" prop="tagNumber" label="故障位号">
            <el-input v-model="model.tagNumber" placeholder="请输入" clearable
                      onkeyup="this.value = this.value.toUpperCase()" @focus="showDialog2">

            </el-input>
          </el-form-item>
        </el-col>

        <div>
          <simpleKeyboard
            v-show="!isShowFirst"
            @onChange="onChange2"
            @onKeyPress="onKeyPress2"
            keyboardClass="myBaseClass2"/>
        </div>

      </el-row>

      <el-row :gutter="20" type="flex" justify="start" align="top" tag="div">
        <el-col :span="12" :offset="0" :push="0" :pull="0" tag="div">
          <el-button size="small" type="primary" icon="el-icon-check" @click="submitForm">提 交</el-button>
        </el-col>

      </el-row>


    </el-form>
  </div>
</template>
<script>
import {getPhenomenonInfo} from "@/api/data/phenomenon";

import {getUserProfile} from "@/api/system/user";
import {listRecord, getRecord, delRecord, addRecord, updateRecord} from "@/api/data/record";
import SimpleKeyboard from "@/components/keyboard/keyboard"

import user from "@/store/modules/user";

export default {
  name: "Input",
  components: {
    // JElSelectTree,
    SimpleKeyboard

  },
  data() {
    return {
      forms: ['$form'],
      model: {
        mesId: '',
        mesIdInput: '',
        nickName: '',
        userName: '',
        instrumentNumber: '',
        result: '0',
        phenomenon: '',
        //故障现象选项
        phenomenonOptions: [],
        cause: '',
        tagNumber: '',
        drawingNumber: '',
        boardNumber: '',
        orderNumber: '',
        remark: null,


        password: undefined,
        password2: undefined,
        isShowFirst: true,
        layout: {
          'default': [
            "1 2 3 4",
            "5 6 7 8",
            '{bksp} 9 0 {enter}',
          ],
        },

      },
      rules: {
        mesId: [],
        mesIdInput: [],
        nickName: [],
        userName: [],
        drawingNumber: [{
          required: true,
          message: '图号不能为空',
          trigger: 'blur'
        }],
        boardNumber: [{
          required: true,
          message: '板号不能为空',
          trigger: 'blur'
        }],
        orderNumber: [{
          required: true,
          message: '任务号不能为空',
          trigger: 'blur'
        }],
        instrumentNumber: [{
          required: true,
          message: '仪表码不能为空',
          trigger: 'blur'
        }],
        result: [{
          required: true,
          message: '测试结果不能为空',
          trigger: 'change'
        }],
        phenomenon: [],
        cause: [],

        tagNumber: []
      },
      result_data: [{
        label: '合格',
        value: '0',
        disabled: false,
        border: false
      }, {
        label: '不合格',
        value: '1',
        disabled: false,
        border: false
      }],

      cause_data: [{
        label: '缺焊',
        value: '缺焊',
        disabled: false
      }, {
        label: '虚焊',
        value: '虚焊',
        disabled: false
      }, {
        label: '连焊',
        value: '连焊',
        disabled: false
      }, {
        label: '错焊',
        value: '错焊',
        disabled: false
      }, {
        label: '器件失效',
        value: '器件失效',
        disabled: false
      }, {
        label: '装配问题',
        value: '装配问题',
        disabled: false
      }, {
        label: '结构件问题',
        value: '结构件问题',
        disabled: false
      }, {
        label: '其它',
        value: '其它',
        disabled: false
      }],


      submit_loading: false
    };
  },
  computed: {},
  methods: {
    reset() {
      this.model.mesId = null
      this.model.mesIdInput = null
      this.model.phenomenon = null
      this.model.cause = ""
      this.model.tagNumber = ""
      this.model.result = "0"
      this.model.drawingNumber = ''
      this.model.boardNumber = ''
      this.model.ordernum = ''
      this.model.orderNumber = ''
      this.add


    },
    sliptmesId() {
      this.model.mesId = this.model.mesIdInput
      let strArr = this.model.mesId
      const arr = strArr.split('|', 6)
      this.model.drawingNumber = arr[1]
      this.model.boardNumber = arr[3]
      this.model.ordernum = arr[0]
      this.model.orderNumber = arr[4]
      this.model.mesIdInput = ''

    }, sliptinstrumentNumber() {

      let strArr = this.model.instrumentNumber
      if (strArr.length >= 20) {
        const arr = strArr.split('|', 6)
        this.model.instrumentNumber = arr[2]
      } else {
        this.model.instrumentNumber = strArr
      }


    },

    submitCode() {
      this.sliptmesId()
      addRecord(this.model).then(res => {
        if (res) {
          // this.model = res.data;
          this.$message.success("MES码扫描成功")

          // console.log(res);
          // console.log(Object.keys(res.data).length);
          if (Object.keys(res.data).length !== 0) {
            this.$set(this.model, 'instrumentNumber', res.data.instrumentNumber,)
            this.$set(this.model, 'result', res.data.result,)
            this.$set(this.model, 'phenomenon', res.data.phenomenon,)
            this.$set(this.model, 'cause', res.data.cause,)
            this.$set(this.model, 'tagNumber', res.data.tagNumber,)

            this.unqualified(1)
            setTimeout(() => {
              this.$message.warning("该MES码已存在记录");
            }, 10);

          }


        } else {
          this.$message.error("扫描失败")
        }
      })

    },

    repair() {
      let strtagNumber = this.model.tagNumber
      let strcause = this.model.cause
      let strphenomenon = this.model.phenomenon

      if (this.model.result === '1') {
        if (Object.keys(strcause).length === 0 || Object.keys(strtagNumber).length === 0 || Object.keys(strphenomenon).length === 0) {
          console.log(Object.keys(strcause).length);
          console.log(Object.keys(strtagNumber).length);
          console.log(Object.keys(strphenomenon).length);
          this.model.result = '1'
        } else {
          this.model.result = '0'
          this.model.remark = '已修复'
        }
      }


    },
    submitForm() {
      Promise.all(this.forms.map(form => this.$refs[form].validate()))
        .then(() => {
          this.submit_loading = true;
          // TODO demo
          this.sliptinstrumentNumber()
          this.repair()
          updateRecord(this.model).then(response => {
            this.$message.success("保存成功")
            //除仪表码其他数据清空
            this.reset()
            //自动聚焦到MES码输入输入框
            this.$refs.input.focus()
          })


          console.log(this.model);
          setTimeout(() => {
            this.submit_loading = false;
          }, 3000);
        });
    },

    getUser() {
      getUserProfile().then(response => {
        this.user = response.data;
        this.model.nickName = this.user.nickName
        this.model.userName = this.user.userName
      });
    },

    unqualified: function (val) {
      if (val == 1) {
        if (Object.keys(this.model.drawingNumber).length !== 0) {
          getPhenomenonInfo(this.model.drawingNumber).then(response => {
            this.phenomenonOptions = response.data;
            this.$forceUpdate()  //强制更新下拉数据

          });
        } else {
          this.$message.error("未获取到图号信息，请扫描MES码")
          this.model.result = '0'
        }

        console.log("点击了不合格", this.model.drawingNumber)
        console.log()

      }
    },


    onChange2(input) {
      // input 是当前点击按钮的值
      console.log(input)
      this.model.tagNumber = input
    },

    onKeyPress2(button) {
      if (button == "{enter}") {
        // 如果按确认键的相应操作
        console.log(111)
      }
      if (button == "{bksp}") {
        // 删除键的相应操作
        console.log(222)
      }
    },
    onChange(input) {
      // input 是当前点击按钮的值
      console.log(input)
      this.password = input
    },

    onKeyPress(button) {
      if (button == "{enter}") {
        // 如果按确认键的相应操作
        console.log(111)
      }
      if (button == "{bksp}") {
        // 删除键的相应操作
        console.log(222)
      }
    },


  },
  created() {
    this.getUser();

  }
}
</script>
<style scoped>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>

