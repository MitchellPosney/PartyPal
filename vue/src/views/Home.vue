<template>
  <div class="home">
    <div class="partylinks">
      <a href="#"><img src="findparty.png" v-on:click="cursorToSearch()" class="party"></a>
      <router-link v-bind:to="{ name: 'CreateEvent' }">
      <img src="startparty.png" class="party"></router-link>
    </div>
      <iframe src="https://open.spotify.com/embed/playlist/37i9dQZF1DXaXB8fQg7xif?utm_source=generator&theme=0" 
    width="380" height="450" frameBorder="1" allowfullscreen="" allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture"></iframe>
  </div>
</template>

<script>
//v-if="$store.state.user"
export default {
  name: "home",
  methods: {
    cursorToSearch () {
      document.querySelector("searchbar").focus();
      document.querySelector("searchbar").setSelectionRange(0,0);
    }
  }
};
</script>

<style>
.home {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  padding: 0px;
}

.partylinks {
  display: flex;
  flex-direction: column;
}

.party {
    height: 200px;
    width: 200px;
    padding: 10px;
}


</style>
