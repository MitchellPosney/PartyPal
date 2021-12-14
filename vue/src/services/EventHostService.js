import axios from 'axios';

export default {
   
    updateEvent(event) {
        return axios.put(`/edit/event/${event.id}`, event);
      },

    // get(event) {
    //   return http.get(`/events/`)
    // }
}