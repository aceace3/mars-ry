<template>
  <div>
    <rain  :rainNumber="20" :rotateDeg="40" :w="1" :h="140"></rain>
  </div>
</template>

<style>
body{
  /*网站背景色*/
  /*1.windows 2000 风格*/
  /*background: rgb(0, 128, 128);*/
  /*2.星空 风格*/
  background-image: url("./bg-stars.jpg");
}
</style>

<script>
import rain from "@/components/rain/index";

export default {
  data() {
    return {};
  },
  name: "browserIndex",
  components: {
    rain
  }
}

console.log("          _____ ______          _____ ______     ____  ")
console.log("    /\\   / ____|  ____|   /\\   / ____|  ____|   |___  \\ ")
console.log("   /  \\ | |    | |__     /  \\ | |    | |__        __) |")
console.log("  / /\\ \\| |    |  __|   / /\\ \\| |    |  __|      |__ < ")
console.log(" / ____ \\ |____| |____ / ____ \\ |____| |____     ___) |")
console.log("/_/    \\_\\_____|______/_/    \\_\\_____|______|   |_____/        love you guys~")
console.log("my github: aceace3")


</script>
