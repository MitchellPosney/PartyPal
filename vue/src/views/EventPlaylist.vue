<template>
  <div class="EventPlaylist">
      <h1>Playlist</h1>
      <EventPlaylist/>
  </div>
</template>

<script>
import EventPlaylist from '@/components/EventPlaylist.vue'

export default {
    name: 'EventPlaylist-view',
    components: {
        EventPlaylist
    }
};
</script>

<style>

</style>