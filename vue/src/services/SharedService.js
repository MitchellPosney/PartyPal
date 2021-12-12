import axios from 'axios';
const http = axios.create({
    baseURL: "http://localhost:3000"
  });
export default {
getEvent(eventName) {  
  //(`events/find?name=${eventName}`
    return http.get(`events/find/${eventName}`);
},   

getEventById(eventID) { 
  return http.get(`/events/${eventID}`);
},

getAvailableSongs(eventID) { 
  return http.get(`/events/songs/${eventID}`);
}, 

getCurrentPlaylist(eventID) {  
  return http.get(`/events/playlist/${eventID}`);
},  

addSongToPlaylist(songID, event) {
  return http.put(`/events/playlist/${songID}`, event);
}
  

}