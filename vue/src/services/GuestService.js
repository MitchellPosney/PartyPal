import axios from 'axios';
const http = axios.create({
    baseURL: "http://localhost:3000"
  });
export default {
getEvent(eventName) { 
    return http.get(`/events/${eventName}`);
},  

getAvailableSongs(genreID) { 
  return http.get(`/availableSongs/${genreID}`);
}, 

getPlaylist(playlistID) {  
  return http.get(`/playlist/${playlistID}`);
},  

addSongToPlaylist(songID, playlist) { 
  return http.put(`/addSongToPlaylist/${songID}`, playlist);
}
  

}