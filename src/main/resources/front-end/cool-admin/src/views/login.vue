<template>
  <div class="container wrapper">
    <Row class="z-10  cool-container code-row-bg" type="flex" justify="center" align="middle" >
        
        <Col :xs="20" :sm="16" :md="12" :lg="8">
          <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
            <FormItem label="Name" prop="name">
                    <Input v-model="formValidate.name" placeholder="Enter your name" autocomplete="off"></Input>
            </FormItem>
            <br>
            <FormItem label="Password" prop="password">
                <Input v-model="formValidate.password"  type='password' placeholder="Enter your password" autocomplete="off"></Input>
            </FormItem>
            <FormItem>
            <Button type="primary" @click="handleSubmit('formValidate')">Submit</Button>
        </FormItem>
          </Form>
         
        </Col>
         
    </Row>
    <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
    </ul>
  </div>
</template>
<script>
export default {
  data () {
    return {
      formValidate: {
        name: '',
        password: ''
      },
      ruleValidate: {
        name: [
          {
            required: true,
            message: ' The name cannot be empty ',
            trigger: 'blur'
          }
        ],
        password: [
          {
            required: true,
            message: 'Please fill in the password,cannot be empty',
            trigger: 'blur'
          },
          {
            type: 'string',
            min: 6,
            message: 'The password length cannot be less than 6 bits',
            trigger: 'blur'
          }
        ]
      }
    }
  },
  methods: {
    handleSubmit (name) {
      this.$refs[name].validate(valid => {
        if (valid) {
          this.$Message.success('Success!')
          console.log(this.formValidate)
          let userinfo = this.formValidate
          this.$axios
            .get('http://127.0.0.1:8088/ajaxLogin', { userinfo })
            .then(function (response) {
              console.log(response)
            })
            .catch(function (error) {
              console.log(error)
            })
        } else {
          this.$Message.error('Fail!')
        }
      })
    },
    handleReset (name) {
      this.$refs[name].resetFields()
    }
  }
}
</script>
<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  font-weight: 300;
}
.cool-container {
  position: relative;
  height: 400px;
  z-index: 10;
  top: 20%;
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
}
.cool-center {
  text-align: center;
}
.wrapper {
  background: #50a3a2;
  background: -webkit-linear-gradient(top left, #50a3a2 0%, #53e3a6 100%);
  background: linear-gradient(to bottom right, #50a3a2 0%, #53e3a6 100%);
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
  z-index: 998;
}
.z-10 {
  z-index: 10;
}
.clearfix:after {
  clear: both;
}
.wrapper.form-success .container h1 {
  -webkit-transform: translateY(85px);
  transform: translateY(85px);
}
.container h1 {
  font-size: 40px;
  -webkit-transition-duration: 1s;
  transition-duration: 1s;
  -webkit-transition-timing-function: ease-in-put;
  transition-timing-function: ease-in-put;
  font-weight: 200;
}
.bg-bubbles {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
  background: url(/images/bg.jpg);
}
.bg-bubbles li {
  position: absolute;
  list-style: none;
  display: block;
  width: 40px;
  height: 40px;
  background-color: rgba(255, 255, 255, 0.15);
  bottom: -160px;
  -webkit-animation: square 35s infinite;
  animation: square 35s infinite;
  -webkit-transition-timing-function: linear;
  transition-timing-function: linear;
}
.bg-bubbles li:nth-child(1) {
  left: 10%;
  background: rgba(135, 208, 104, 0.53);
}
.bg-bubbles li:nth-child(2) {
  left: 20%;
  width: 80px;
  height: 80px;
  animation-duration: 15s;
  background: rgba(91, 192, 222, 0.5);
}
.bg-bubbles li:nth-child(3) {
  left: 25%;
  background: rgba(238, 238, 238, 0.81);
}

.bg-bubbles li:nth-child(4) {
  left: 40%;
  width: 60px;
  height: 60px;
  animation-duration: 20s;
  background: rgba(255, 170, 0, 0.7);
}

.bg-bubbles li:nth-child(7) {
  left: 32%;
  width: 160px;
  height: 160px;
  animation-delay: 3s;
  background: #afdddf;
}

.bg-bubbles li:nth-child(9) {
  left: 25%;
  width: 20px;
  height: 20px;
  animation-delay: 1s;
  animation-duration: 10s;
  background: rgba(239, 22, 15, 0.67);
}

.bg-bubbles li:nth-child(11) {
  left: 22%;
  width: 60px;
  height: 60px;
  animation-delay: 3s;
  background: rgba(239, 22, 15, 0.5);
}

.bg-bubbles li:nth-child(12) {
  left: 5%;
  width: 20px;
  height: 20px;
  animation-delay: 3s;
  animation-duration: 10s;
  background: rgba(245, 183, 59, 0.76);
}

.bg-bubbles li:nth-child(5) {
  left: 70%;
  background: rgba(255, 170, 0, 0.8);
}

.bg-bubbles li:nth-child(6) {
  left: 80%;
  width: 120px;
  height: 120px;
  background: rgba(245, 183, 59, 0.76);
}

.bg-bubbles li:nth-child(8) {
  left: 55%;
  width: 20px;
  height: 20px;
  animation-delay: 2s;
  animation-duration: 10s;
  background: rgba(135, 208, 104, 0.7);
}

.bg-bubbles li:nth-child(10) {
  left: 90%;
  width: 160px;
  height: 160px;
  animation-delay: 3s;
  background: rgba(238, 238, 238, 0.5);
}

.bg-bubbles li:nth-child(13) {
  left: 85%;
  width: 50px;
  height: 50px;
  animation-delay: 5s;
  animation-duration: 10s;
  background: rgba(239, 22, 15, 0.6);
}
.bg-bubbles li:nth-child(14) {
  left: 70%;
  width: 30px;
  height: 30px;
  animation-delay: 6s;
  background: #afdddf;
}
@-webkit-keyframes square {
  0% {
    -webkit-transform: translateY(0);
    transform: translateY(0);
  }
  100% {
    /*-1080px代表从下向上移动多少   600deg代表从下向上移动过程中旋转600度*/
    -webkit-transform: translateY(-1080px) rotate(600deg);
    transform: translateY(-1080px) rotate(600deg);
  }
}
@keyframes square {
  0% {
    -webkit-transform: translateY(0);
    transform: translateY(0);
  }
  100% {
    -webkit-transform: translateY(-1080px) rotate(600deg);
    transform: translateY(-1080px) rotate(600deg);
  }
}
</style>
