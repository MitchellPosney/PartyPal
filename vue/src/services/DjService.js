import axios from 'axios';


export default { 

createEvent(event) { 
    return axios.post('/DJ/create/event', event);
    },

addGenre(genre) { 
    return axios.post('/create/genre', genre);
}, 

deleteGenre(genreID) {
    return axios.delete(`/delete/${genreID}`);
  }, 

addSongToGenre(songID, genre,) { 
 return axios.post(`/add/song/${songID}`, genre);
}, 

deleteSongFromGenre(songID, genre) { 
return axios.put(`/remove/song/${songID}`, genre);
},


  

}