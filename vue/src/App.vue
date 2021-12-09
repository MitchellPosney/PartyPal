<template>

  <div id="app">
    <NavBar />
    <div id="nav">
    <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
    <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    
    <router-view />
  </div>
</template>

<script>
import NavBar from "./components/Nav"; 
export default {
  components: {NavBar}
};
</script>

<style>
body {
  background-color: #000022;
  color: aliceblue;
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
}



</style>