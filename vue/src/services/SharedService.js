import axios from 'axios';

export default {
getEvent(eventName) {  
  //(`events/find?name=${eventName}`
    return axios.get(`/events/find?name=${eventName}`);
},   

getEventById(eventID) { 
  return axios.get(`/events/${eventID}`);
},

getAvailableSongs(eventID) { 
  return axios.get(`/events/songs/${eventID}`);
}, 

getCurrentPlaylist(eventID) {  
  return axios.get(`/events/playlist/${eventID}`);
},  

addSongToPlaylist(songID, event) {
  return axios.put(`/events/playlist/${songID}`, event);
}
  

}