<template>
  <div class="rain">
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
  name: "rain-component",
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
      // console.log(rainArr);
      rainArr.forEach((item) => {
        // console.log(item.children);
        item.style.top = Math.floor(Math.random() * 250 + 1) + "px";
        item.style.left = Math.floor(Math.random() * 700 + 1) + "px";
      });
    },
  },
};
</script>

<style lang='less' scoped>
.rain {
  width: 700px;
  height: 250px;
  position: relative;
  background: radial-gradient(
    at 50% 0%,
    rgba(6, 55, 111, 1) 0%,
    rgba(11, 26, 57, 1) 70%
  );
  .rain-item {
    position: absolute;
    width: 2px;
    height: 30px;
    // background: skyblue;
    display: inline-block;
    // overflow: hidden;
    .line {
      animation: raining 2s infinite linear;
      position: absolute;
      content: "";
      top: -30px;
      left: 0;
      width: 100%;
      height: 100%;
      background: rgba(0, 183, 255, 0.7);
    }
  }
}
@keyframes raining {
  0% {
    top: -30px;
    opacity: 0;
  }
  50% {
    top: 0px;
    opacity: 1;
  }
  100% {
    top: 30px;
    opacity: 0;
  }
}
</style>
