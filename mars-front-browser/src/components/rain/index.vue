<template>
  <div class="rain">

    <el-row>
      <el-col :span="6">Author:Tate.Zhao<br>PV:0</el-col>
      <el-col :span="12">
        <div class="grid-content bg-purple-light">
          <el-card shadow="always" style="margin-top: 150px;background-color: rgba(255,255,255,0.2);color: gold;">
            总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>总是显示<br>
          </el-card>
        </div>
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

<script>
export default {
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
    randomRain() {
      let rainArr = this.$refs["rain-item"];
      console.log(rainArr);
      rainArr.forEach((item) => {
        // console.log(item.children);
        item.style.top = Math.floor(Math.random() * 0 + 1) + "px";
        item.style.left = Math.floor(Math.random() * 2000 + 1) + "px";
      });
    },
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
