<template>
  <div id="app">
 
    <router-view/>
 
    
    <backtotop></backtotop>
  </div>
</template>

<script>
import backtotop from './components/backtotop'

export default {
  name: 'app',
  components: {
    backtotop
  }
}
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
