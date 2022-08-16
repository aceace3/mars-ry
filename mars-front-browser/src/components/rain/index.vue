<template>
  <div class="rain">

    <el-row>
      <el-col :span="6" style="padding: 20px">
        <span style="color: white">Author:Tate.Zhao<br>PV:0<br></span>
        <div class="billboardContainer">
          总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>
        </div>
      </el-col>
      <el-col :span="12">
          <div>
            <div class="flip-box">
              <div :class="{'flip-front':playFlip}"
                   class="flip-item flip-item-front"
                   style="margin-top: 150px;background-color: rgba(255,255,255,0.2);color: gold;border: 1px solid #787be8">
                <span>
<!--                    {{sentences.contentHtml}}总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>-->
<!--                    {{sentences.contentHtml}}总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>-->
                  <div v-html="sentences.contentHtml"></div>
                </span>
              </div>
              <div :class="{'flip-back':playFlip}"
                   class="flip-item flip-item-back"
                   style="margin-top: 150px;background-color: rgba(255,255,255,0.3);color: gold;border: 1px solid #787be8">
                <span>反面</span>
              </div>
            </div>
<!--            <button @click="play">点击翻转</button>-->
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
        console.log("res:"+JSON.stringify(response))
        console.log("res.code:"+response.code)
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
  height: 100vh;
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
  background-image: url('./bgimg2.png');
  background-size: cover;
  padding: 50px;
  color: #efeef0;
}
</style>


<!--
下边是翻转卡片
-->

<style scoped>
.flip-box {
  position: relative;
  /*overflow: hidden;*/
  height: 400px;
  width: 100%;
}

.flip-item {
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  transition: all 1s ease-in-out 0s;
  backface-visibility: hidden;
  box-sizing: border-box;
  border-radius: 5px;
}

.flip-item-front {
  z-index: 2;
  /*background: red;*/
  /*color: white;*/
  min-height: 300px;
}

.flip-item-back {
  transform: rotateY(180deg);
  z-index: 1;
  /*background: green;*/
  /*color: white;*/
  min-height: 300px;
}

.flip-box:hover .flip-item-front {
  transform: rotateY(180deg);
}

.flip-box:hover .flip-item-back {
  transform: rotateY(0deg);
}

.flip-front {
  transform: rotateY(180deg);
}

.flip-back {
  transform: rotateY(0deg);
}
</style>
