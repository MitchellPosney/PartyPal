<template>
  <div class="list">  
     <ul class="song">  
    <div class="available-songs" v-for="song in songs" v-bind:key="song.songId" >  
   
        <li onClick="window.location.reload(true)" v-on:click="addSongToPlaylist(song);;"> 
            <h3 class="song-title" > {{song.songTitle }}</h3>
      <p class="song-artist">
        {{ song.songArtist }}
      </p>
        </li>
     
    
    </div>  
     </ul>

  <div class="current-playlist"> 
  <ul class="playlist"> 
    <div v-for="playlist in playlists" v-bind:key="playlist.songId" class="playlist"> 
    <li id="playlistList"> 
      <h3 class="song-title" > {{playlist.songTitle }}</h3>
      <p class="song-artist">
        {{ playlist.songArtist }}
      </p> 
      </li>
    </div> 
    </ul>
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

  data() {
    return {
      songs: [], 
      playlists: [],
      // id: 0,
      // title: "",
      // artist: "",
      errorMsg: "",
    };
  },
  methods: {
    getAvailableSongs() {
      sharedService
        .getAvailableSongs(this.$route.params.id)
        .then((response) => {
          console.log(response);
          this.songs = response.data;
        })
        .catch((error) => console.log(error));
    }, 
    addSongToPlaylist(song) {  
      sharedService.addSongToPlaylist(song.songId, this.$route.params.id).then((response)  =>  { 
        if (response === 200) { 
          console.log(response);  
        this.getCurrentPlaylist();   
        // this.playlists.push(song);
        // this.$forceUpdate(); 
  
        }
      }); this.$forceUpdate();
    }, 
    getCurrentPlaylist() {  
    
      sharedService.getCurrentPlaylist(this.$route.params.id).then((response) => {
          console.log(response);
          this.playlists = response.data; 
        })
        .catch((error) => console.log(error));
    }
  },
  created() { 
    this.getAvailableSongs(); 
    this.getCurrentPlaylist(); 
    // this.addSongToPlaylist()
  }
};
</script>

<style> 
 ul{height:200px; width:25%;}
 ul{overflow:hidden; overflow-y:scroll;} 



.list {
  /* display: flex-; */
  flex-direction: row;
  justify-content: space-around;
  padding: 10px;
} 
</style>
