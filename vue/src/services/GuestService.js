import axios from 'axios';
const http = axios.create({
    baseURL: "http://localhost:3000"
  });
export default {
getEvent(eventID) { 
    return http.get(`/events/${eventID}`)
},  
// getPlaylist() { 
//   return http.get('/playlist')
// }, 

getPlaylist(eventID) {  
  return http.get(`/playlist/${eventID}`)
}, 

addSongToPlaylist(songID, playlistID) { 
  return http.post(`/addSongToPlaylist/${songID}/${playlistID}`) 
}
  

}