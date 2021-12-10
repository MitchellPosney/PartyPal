import axios from 'axios';
const http = axios.create({
    baseURL: "http://localhost:3000"
  });

export default { 

createEvent(event) { 
    return http.post('/event', event);
    },

addGenre(genre) { 
    return http.post('/genres', genre);
}, 

deleteGenre(genreID) {
    return http.delete(`/genres/${genreID}`);
  }, 

addSongToGenre(songID, genreID, song) { 
 return http.post(`/addSongToGenre/${songID}/${genreID}`, song);
}, 

deleteSongFromGenre(song) { 
return http.put(`/deleteSongFromGenre/${song.id}`, song);
},


  

}