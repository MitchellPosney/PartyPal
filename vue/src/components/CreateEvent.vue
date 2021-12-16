<template>
  <div class="createparty">
  <form v-on:submit.prevent="submitForm" class="eventForm">
    <div class="status-message error" v-show="errorMsg !== ''">
      {{ errorMsg }}
    </div>

    <div class="form-group">
      <label for="name"> Event Name:  </label>
      <input
        id="name"
        type="text"
        class="form-control"
        v-model="event.name"
        autocomplete="off" required
      />
    </div>

    <div class="form-group">
      <label for="host"> Event Host:  </label>
      <input
        id="host"
        type="number"
        class="form-control"
        v-model="event.host"
        autocomplete="off" 
        required
      />
    </div>

    <div class="form-group">
      <label for="genre"> Genre:  </label>
      <select id="genre" class="form-control" v-model="event.genre" >
        <option value="5">Graduation</option>
        <option value="3">Summer Party</option>
        <option value="2">Birthday Party</option>
        <option value="1">Christmas</option>
        <option value="4">Wedding</option> 
      </select>


    </div>
    <div class="form-group">
      <label for="playlist"> Playlist Name: </label>
      <input
        id="playlist"
        type="text"
        class="form-control"
        v-model="event.playlist"
        autocomplete="off" required
        
      />
      <br>
      <br>
    </div>
    <!-- <div class="form-group">
      <label for="date">Date of Event:  </label>
      <input
        type="date"
        id="date"
        v-model="event.date"
        value="2021-17-12"
        min="2021-17-12"
        max="2022-17-12"
      />
    </div> -->
    <!-- <div class="form-group">
      <label for="time">Choose a Start time for your Event:</label>

      <input
        type="time"
        id="time"
        v-model="event.time"
        min="08:00"
        max="23:00"
      />
    </div> -->
    <!-- <div class="form-group">
      <label for="time">Length of Event in Minutes: </label>
      <input type="number" id="duration" name="quantity" min="30" max="480" />

    </div>
    <div class="form-group">
      <label for="location"> Location: </label> 
       <input
        id="location"
        type="text"
        class="form-control"
        v-model="event.location"
        autocomplete="off" 
      />
    </div> -->

    
    <button
      class="btn btn-cancel"
      v-on:click.prevent="cancelForm"
      type="cancel"
    >
      Cancel
    </button>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <button class="btn btn-submit">Submit</button>
  </form>
  </div>
</template>

<script>
import djService from "../services/DjService";
// import hostService from "../services/EventHostService";

export default {
  name: "event-form",
  props: {
    eventID: {
      type: Number,
      // default: 0,
    },
  },
  data() {
    return {
      event: {
        name: "",
        host: 1,
        playlist: "",
        genre: 2
        // date: "",
        // time: "",
        // duration: 35,
        // location: "",
      },
      errorMsg: "",
    };
  },
  methods: {
    submitForm() {
      const newEvent = {
        eventId: Number(this.$route.params.eventID),
        name: this.event.name,
        host: this.event.host, 
        playlist: this.event.playlist,
        genre: this.event.genre
        // date: this.event.date,
        // time: this.event.time,
        // duration: this.event.duration,
        // location: this.event.location,
 
      };

      // if (this.eventId === 'NaN') {
        // add
        djService
          .createEvent(newEvent)
          .then((response) => {
            if (response.status === 200) {
              console.log(response.data)
              this.$router.push(`/event/playlist/${response.data.eventId}`); 
             
            }
          })
          .catch((error) => {
            this.handleErrorResponse(error, "creating or updating");
          });
      // } else {
      //   // update
      //   newEvent.id = this.eventID;
      //   newEvent.name = this.event.name;
      //   (newEvent.host = this.event.host),
      //     (newEvent.genre = this.event.genre),
      //     (newEvent.date = this.event.date),
      //     (newEvent.time = this.event.time),
      //     (newEvent.duration = this.event.duration),
      //     (newEvent.location = this.event.location);

      //   hostService
      //     .updateEvent(newEvent)
      //     .then((response) => {
      //       if (response.status === 200) {
      //         this.$router.push(`/event/${newEvent.eventId}/details`);
      //       }
      //     })
      //     .catch((error) => {
      //       this.handleErrorResponse(error, "creating or updating");
      //     });
      // }
    }, cancelForm() {
      this.$router.push(`/home`);
    },
    handleErrorResponse(error, verb) {
      if (error.response) { //request reached the server and the server sent back a response
        this.errorMsg =
          "Error " + verb + " event. Response received was '" +
          error.response.statusText +
          "'.";
      } else if (error.request) {
        this.errorMsg =
          "Error " + verb + " event. Server could not be reached.";
      } else {
        this.errorMsg =
          "Error " + verb + " event. Request could not be created.";
      }
    }
  },

};
</script>

<style scoped>
.form-group {
  padding: 8px;
}

.btn-submit{
  background-color: #18CAE6;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
  border-radius: 15px;
}
.btn-submit:hover, .btn-submit:focus {
  background-color: #61E294;
}

.btn-cancel{
  background-color: #D741A7;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
  border-radius: 15px;
}

/* .createparty {
  padding-left: 100px;
} */

</style>