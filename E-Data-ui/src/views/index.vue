<template>
  <div class="app-container home">

    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>欢迎登录数据电子化管理系统</h2>
        <h2>{{user.nickName}}</h2>
        <h2>{{user.userName}}</h2>
        <p>
          这是首页
        </p>
        <p>
          <b>当前版本:</b> <span>v{{ version }}</span>
        </p>

        <p>

        </p>
      </el-col>


    </el-row>
    <el-divider/>
    <el-row :gutter="20">



    </el-row>
  </div>
</template>

<script>


import { getUserProfile } from "@/api/system/user";

export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "1.0.0",
      username:"",

      user: {},

    };
  },

  created() {
    this.getUser();
  },

  methods: {
    getUser() {
      getUserProfile().then(response => {
        this.user = response.data;
        const username = response.data.userName

        console.log("123456",username)
      });
    },

    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }

  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }

  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

<!--<template>-->
<!--  <div>-->
<!--    <el-input v-model='password' style="width:300px;" @focus="showDialog"></el-input>-->
<!--    <el-input v-model='password2' style="width:300px;" @focus="showDialog2"></el-input>-->
<!--    <simpleKeyboard v-show="isShowFirst"-->
<!--                    :layout="layout"-->
<!--                    @onChange="onChange"-->
<!--                    @onKeyPress="onKeyPress"-->
<!--                    keyboardClass="myBaseClass" />-->
<!--    <simpleKeyboard-->
<!--      v-show="!isShowFirst"-->
<!--      @onChange="onChange2"-->
<!--      @onKeyPress="onKeyPress2"-->
<!--      keyboardClass="myBaseClass2" />-->
<!--  </div>-->
<!--</template>-->
<!--<script>-->
<!--import simpleKeyboard  from "@/components/keyboard/keyboard"-->
<!--export default {-->
<!--  components: {-->
<!--    simpleKeyboard-->
<!--  },-->
<!--  data() {-->
<!--    return {-->
<!--      password:undefined,-->
<!--      password2:undefined,-->
<!--      isShowFirst:true,-->
<!--      layout:{-->
<!--        'default': [-->
<!--          "1 2 3 4",-->
<!--          "5 6 7 8",-->
<!--          '{bksp} 9 0 {enter}',-->
<!--        ],-->
<!--      },-->
<!--    }-->
<!--  },-->
<!--  methods: {-->
<!--    showDialog(){-->
<!--      this.isShowFirst = true;-->
<!--    },-->
<!--    showDialog2(){-->
<!--      this.isShowFirst = false;-->
<!--    },-->
<!--    onChange2(input) {-->
<!--      // input 是当前点击按钮的值-->
<!--      console.log(input)-->
<!--      this.password2 = input-->
<!--    },-->

<!--    onKeyPress2(button) {-->
<!--      if (button == "{enter}") {-->
<!--        // 如果按确认键的相应操作-->
<!--        console.log(111)-->
<!--      }-->
<!--      if (button == "{bksp}") {-->
<!--        // 删除键的相应操作-->
<!--        console.log(222)-->
<!--      }-->
<!--    },-->
<!--    onChange(input) {-->
<!--      // input 是当前点击按钮的值-->
<!--      console.log(input)-->
<!--      this.password = input-->
<!--    },-->

<!--    onKeyPress(button) {-->
<!--      if (button == "{enter}") {-->
<!--        // 如果按确认键的相应操作-->
<!--        console.log(111)-->
<!--      }-->
<!--      if (button == "{bksp}") {-->
<!--        // 删除键的相应操作-->
<!--        console.log(222)-->
<!--      }-->
<!--    },-->
<!--  }-->
<!--}-->
<!--</script>-->
