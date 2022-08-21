<template>
  <div class="rain">

    <el-row>
      <el-col :span="6" style="padding: 20px">
        <span style="color: white">Author:Tate.Zhao<br>PV:0<br></span>
        <div class="billboardContainer">
          总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>
          总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>
        </div>
      </el-col>
      <el-col :span="12">
        <div>
          <ul style="margin-top: 150px;">
            <li class="flip-container  " ontouchstart="this.classList.toggle('hover');" style="background-color: rgba(0,0,0,0.3)">
              <a class="flipper">
                <div class="front " style="outline:1px solid transparent;background-color: rgba(255,255,255,0.1);color: gold;border: 1px solid #787be8">
                  <div style="border-bottom: 1px dashed gray;background-color: rgba(0,0,0,0.3);color: #008489;">
                    <marquee>公益提示：吸烟有害健康，尽早戒烟有益健康</marquee>
                  </div>
                  <span>
                    <div v-html="sentences.contentHtml" style="margin: 70px 200px"></div>
                    <div style="float: right;margin-right: 200px;margin-bottom: 70px">—— —— <span v-text="sentences.source"></span></div>
                  </span>
                </div>
                <div class="back " style="outline:1px solid transparent;background-color: rgba(255,255,255,0.2);color: silver;border: 1px solid #787be8">
                  <div style="margin: 70px 200px">
                    <table class="author-tb">
                      <tr>
                        <td><b>投稿者：</b></td>
                        <td><span v-text="sentences.author"></span></td>
                      </tr>
                      <tr>
                        <td><b>投稿者Email：</b></td>
                        <td><span v-text="sentences.email"></span></td>
                      </tr>
                      <tr>
                        <td><b>投稿时间：</b></td>
                        <td><span v-text="sentences.createTime"></span></td>
                      </tr>
                      <tr>
                        <td><b>投稿者的话：</b></td>
                        <td><span v-text="sentences.authorTalk"></span></td>
                      </tr>
                    </table>
                  </div>
                </div>
              </a>
            </li>
          </ul>
        </div>
      </el-col>
      <el-col :span="6">
      </el-col>
    </el-row>

    <div
      v-for="(item,index) in rainNumber"
      :key="index"
      class="rain-item"
      ref="rain-item"
      :style="`transform:rotate(${rotateDeg}deg);width:${w}px;height:${h}px;`"
    >
      <div class="line" :style="`animationDelay:${index*100}ms`"></div>
    </div>
  </div>
</template>

<!--
rain特效
-->
<script>
import { randomQueryOne } from "@/api/mars/sentences";

export default {
  data(){
    return {
      playFlip: false,
      sentences:{},
    }
  },
  props: {
    rainNumber: {
      type: Number,
      default: 0,
    },
    rotateDeg: {
      type: Number,
      default: 0,
    },
    w: {
      type: Number,
      default: 0,
    },
    h: {
      type: Number,
      default: 0,
    },
  },
  mounted() {
    this.randomRain();
  },
  methods: {
    play() {
      this.playFlip = !this.playFlip
    },
    randomQueryOne() {
      randomQueryOne().then(response => {
        // console.log("res:"+JSON.stringify(response))
        // console.log("res.code:"+response.code)
        this.sentences = response.data;
      })
    },
    randomRain() {
      let rainArr = this.$refs["rain-item"];
      rainArr.forEach((item) => {
        // console.log(item.children);
        item.style.top = Math.floor(Math.random() * 0 + 1) + "px";
        item.style.left = Math.floor(Math.random() * 2000 + 1) + "px";
      });
    },

  },
  created() {
    this.randomQueryOne();
  },
};
</script>
<style lang='less' scoped>
.rain {
  width: 100%;
  height: cacl(100vh-110px);
  position: relative;
  .rain-item {
    position: absolute;
    width: 2px;
    height: 30px;
    display: inline-block;
    .line {
      animation: raining 2s infinite linear;
      position: absolute;
      content: "";
      top: -30px;
      left: 0;
      width: 100%;
      height: 100%;
      box-shadow: 0px 5px 20px 0px #fcfcfc;
      background: linear-gradient(
        to top,
        rgb(249, 249, 249),
        rgba(11, 36, 66, 0.1)
      );
    }
  }
}
@keyframes raining {
  0% {
    top: -0;
    opacity: 0;
  }
  10% {
    top: 10;
    opacity: 0.5;
  }
  25% {
    top: 200;
    opacity: 0.5;
  }
  50% {
    top: 400px;
    opacity: 1;
  }
  75% {
    top: 600px;
    opacity: 0.5;
  }
  100% {
    top: 800px;
    opacity: 0;
  }
}
</style>


<!--
公告css
-->
<style>
.billboardContainer{
  margin-top: 50px;
  background-image: url('./bgimg3.png');
  background-size: 100%;
  padding: 50px;
  color: #efeef0;
}
</style>


<!--
下边是翻转卡片
-->
<style>
ul,li{ list-style:none; margin:0; padding:0;}

.brandsShow{ width:1200px; height:620px; margin:0 auto;  }
.brandsShow ul{ margin-left:-20px; width:1225px; height:auto;  }
.brandsShow ul li{ float:left; display:inline; width:283px; height:424px;  }

.flip-container {perspective: 1000;
  -webkit-perspective: 1000px;    /*父类容器中  perspective  子类允许透视*/
  -moz-perspective: 1000px;
  -ms-perspective: 1000px;
  -o-perspective: 1000px;
  perspective: 1000px;
  margin:0px auto;
  float:left; margin-left:20px; margin-bottom:20px; border:1px solid #333;
}


.flip-container, .front, .back {width: 100%;min-height: 424px;border-radius: 5px}

.front, .back {
  backface-visibility: hidden;
  overflow:hidden;
  -webkit-transition: .8s ease-out;
  transition: .8s ease-out;
  -webkit-transform-style: preserve-3d;  /* 子类保留3d动画结果*/
  -moz-transform-style: preserve-3d;
  -ms-transform-style: preserve-3d;
  -o-transform-style: preserve-3d;
  transform-style: preserve-3d;
  position: absolute;top: 0;left: 0; /*动画元素最好绝对位置*/
}


.front {z-index: 2; /*起始设置层  hover时候改变*/
  -webkit-transform: rotateY(0deg);
  -moz-transform: rotateY(0deg);
  -ms-transform:  rotateY(0deg);
  -o-transform:  rotateY(0deg);
  transform: rotateY(0deg);
}

.back { z-index:1;/*起始设置层  hover时候改变*/
  -webkit-transform: rotateY(-180deg);
  -moz-transform: rotateY(-180deg);
  -ms-transform:  rotateY(-180deg);
  -o-transform:  rotateY(-180deg);
  transform: rotateY(-180deg);
}



.flipper {
  -webkit-transition: transform .8s ease-in-out;
  -moz-transition: transform .8s ease-in-out;
  -ms-transition: transform .5s ease-in-out;
  -o-transition: transform .5s ease-in-out;
  transition: transform .5s ease-in-out;

  -webkit-transform-style: preserve-3d;  /*使其子类变换后得以保留 3d转换后的位置*/
  -moz-transform-style: preserve-3d;
  -ms-transform-style: preserve-3d;
  -o-transform-style: preserve-3d;
  transform-style: preserve-3d;
  display:block;position: relative;
}


.flip-container:hover .back {
  -webkit-transform: rotateY(0deg);
  -moz-transform:  rotateY(0deg);
  -ms-transform:  rotateY(0deg);
  -o-transform:  rotateY(0deg);
  transform: rotateY(0deg);
  z-index:2;
}

.flip-container:hover .front {
  -webkit-transform: rotateY(180deg);
  -moz-transform: rotateY(180deg);
  -ms-transform:  rotateY(180deg);
  -o-transform:  rotateY(180deg);
  transform: rotateY(180deg);
  z-index:10;
}


</style>
