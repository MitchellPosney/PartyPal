import axios from 'axios';
const http = axios.create({
    baseURL: "http://localhost:3000"
  });

export default { 

createEvent(event) { 
    return http.post('/create/event', event);
    },

addGenre(genre) { 
    return http.post('/create/genre', genre);
}, 

deleteGenre(genreID) {
    return http.delete(`/delete/${genreID}`);
  }, 

addSongToGenre(songID, genre,) { 
 return http.post(`/add/song/${songID}`, genre);
}, 

deleteSongFromGenre(songID, genre) { 
return http.put(`/remove/song/${songID}`, genre);
},


  

}