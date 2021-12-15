<template>
 <div class="available-songs">
    <div v-for="song in songs" v-bind:key="song.id" class="song"> 
         <h3 class="song-title">{{ song.title }}</h3>
      <p class="song-artist">
        {{ song.artist }}
      </p>
    </div>  
  </div>





  <!-- <table>
    <thead>
      <tr> -->
        <!-- <th># Id</th> -->
        <!-- <th>Title</th>
        <th>Artist</th>
      </tr>
    </thead> -->
    <!-- <tbody>
      <tr v-for="song in songs" v-bind:key="song.id">
        <td>{{ song.title }}</td>
        <router-link v-bind:to="{name: 'EventPlaylist-detail', params: {id: playlist.id}}">
          <td>{{ song.artist  }}</td>
        </router-link>
        <td>{{ playlist.Id.length }}</td>
      </tr>
    </tbody> -->
  <!-- </table> -->
</template>

<script>
import sharedService from "../services/SharedService";
export default {
  name: "event-playlist-comp", 
 
  // eventID: {
  //   type: Number,
  //   id: 1,
  // },
    data() {
    return { 
      songs: []
        // id: 0,
        // title: "",
        // artist: "",

      ,
      errorMsg: "",
    };
  }, getAvailableSongs() { 
    sharedService.getAvailableSongs(this.$route.params.id).then((response) => { 
      this.songs = response.data;
    });

}, 
}
</script>

<style>

</style>
