<template>
  <div class="EventPlaylist">
      <h1>Playlist</h1>
    <event-playlist-comp/>
  </div>
</template>

<script>
import EventPlaylistComp from '@/components/EventPlaylistComp.vue'



export default {
    name: 'EventPlaylist',
    components: {
        EventPlaylistComp
        

    }
};
</script>

<style>

</style>