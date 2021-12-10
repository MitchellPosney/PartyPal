<template>
  <div class="home">
    <div class="partylinks">
      <img src="findparty.png" class="party">
      <img src="startparty.png" class="party">
    </div>
      <iframe src="https://open.spotify.com/embed/playlist/37i9dQZF1DXaXB8fQg7xif?utm_source=generator&theme=0" 
    width="380" height="450" frameBorder="0" allowfullscreen="" allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture"></iframe>
  </div>
</template>

<script>
export default {
  name: "home"
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
