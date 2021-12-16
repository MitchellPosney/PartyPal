<template>
<div>
  <div class="event-playlists">
    <div class="playlist">
     <div><h1>Available Songs:</h1></div>
      <div class="songs" v-for="song in songs" v-bind:key="song.songId" >
        <h3>
          <img src="/addsong.png"  class="add-song-img" onClick="window.location.reload(true)" v-on:click="addSongToPlaylist(song);">
          
          <img src="/play.png" id="playpause" class="playpause" onClick="changePlayPauseImg()" v-on:click="changePlayPauseImg">
          {{song.songTitle }} 
        </h3>
        <p class="song-artist">
          {{ song.songArtist }}
        </p>
        <div class="border"></div> 
      </div>
    </div>
    
    <div class="playlist">
      <div><h1>Songs Added to Playlist:</h1></div>
        <div v-for="playlist in playlists" v-bind:key="playlist.songId" id="playlistList" class="songs"> 
            <h3 class="song-title" > {{playlist.songTitle }}</h3>
            <p class="song-artist"> {{ playlist.songArtist }} </p> 
        </div>
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
</div>
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
    },
    changePlayPauseImg() {
     var image = document.getElementById('playpause');
      if(image.src.match('/play.png')) {      
          document.getElementById('playpause').src='/pause.png';    
        } else {
          document.getElementById('playpause').src='/play.png';
        }
    }
  },
  created() { 
    this.getAvailableSongs(); 
    this.getCurrentPlaylist(); 
    // this.addSongToPlaylist()
  },
  changePlayPauseImg() {
    var image = document.getElementById('playpause');
      if(image.src.match('/play.png')) {      
          document.getElementById('playpause').src='/pause.png';    
        } else {
          document.getElementById('playpauseimg').src='/play.png';
        }
    }
};
</script>
<style> 

.event-playlists {
  display: flex; 
  flex-direction: row;
  justify-content: space-around;
  padding: 10px;
  scrollbar-color: #D741A7;
}

.playlist {
  height: 550px; 
  width:40%;
  overflow:hidden; 
  overflow-y: auto;
  scrollbar-color: #D741A7 black;
  scrollbar-width: thin;
}

.add-song-img {
  height: 25px;
  cursor: pointer;
  padding-right: 5px;
}

.playpause {
  height: 25px;
  cursor: pointer;
  padding-left: 5px;
  padding-right: 10px;
}

.song-artist {
  font-style: italic;
  vertical-align: middle;
}

.songs {
  padding-bottom: 5px;
}

</style>
