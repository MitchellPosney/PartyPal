<template>
  <form v-on:submit.prevent="submitForm" class="eventForm">
    <div class="status-message error" v-show="errorMsg !== ''">
      {{ errorMsg }}
    </div>
    <div class="form-group">
      <label for="title"> Event Name: </label>
      <input
        id="title"
        type="text"
        class="form-control"
        v-model="event.name"
        autocomplete="off"
      />
    </div>
    <div class="form-group">
      <label for="title"> Event Host: </label>
      <input
        id="title"
        type="text"
        class="form-control"
        v-model="event.host"
        autocomplete="off"
      />
    </div>

    <div class="form-group">
      <label for="genre"> Genre: </label>
      <select id="genre" class="form-control" v-model="event.genre">
        <option value="Graduation">Graduation</option>
        <option value="Summer">Summer Party</option>
        <option value="Birthday">Birthday Party</option>
        <option value="Christmas">Christmas</option>
        <option value="Wedding">Wedding</option>
      </select>


    </div>
    <div class="form-group">
      <label for="playlist"> Playlist Name: </label>
      <input
        id="playlist"
        type="text"
        class="form-control"
        v-model="event.playlist"
        autocomplete="off"
      />
    </div>
    <div class="form-group">
      <label for="date">Date of Event:</label>
      <input
        type="date"
        id="date"
        v-model="event.date"
        value="2021-17-12"
        min="2021-17-12"
        max="2022-17-12"
      />
      <label for="date">Date:</label>
    </div>
    <div class="form-group">
      <label for="time">Choose a Start time for your Event:</label>

      <input
        type="time"
        id="time"
        v-model="event.time"
        min="08:00"
        max="23:00"
      />
    </div>
    <div class="form-group">
      <label for="time">Length of Event in Minutes: </label>
      <input type="number" id="quantity" name="quantity" min="30" max="480" />

    </div>
    <div class="form-group">
      <label for="location"> Location: </label>
      <textarea
        id="location"
        class="form-control"
        v-model="event.location"
      ></textarea>
    </div>
    <button class="btn btn-submit">Submit</button>
    <button
      class="btn btn-cancel"
      v-on:click.prevent="cancelForm"
      type="cancel"
    >
      Cancel
    </button>
  </form>
</template>

<script>
import djService from "../services/DjService";
import hostService from "../services/EventHostService";

export default {
  name: "event-form",
  props: {
    eventID: {
      type: Number,
      default: 0,
    },
  },
  data() {
    return {
      event: {
        name: "",
        host: "",
        playlist: 1,
        genre: "",
        date: "",
        time: "",
        duration: "",
        location: "",
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
        genre: this.event.genre,
        date: this.event.date,
        time: this.event.time,
        duration: this.event.duration,
        location: this.event.location,

        // date: moment().format("MMM Do YYYY")//right now
      };

      if (this.eventId === 0) {
        // add
        djService
          .createEvent(newEvent)
          .then((response) => {
            if (response.status === 201) {
              this.$router.push(`/event/${newEvent.eventId}/details`);
            }
          })
          .catch((error) => {
            this.handleErrorResponse(error, "adding");
          });
      } else {
        // update
        newEvent.id = this.eventID;
        newEvent.name = this.event.name;
        (newEvent.host = this.event.host),
          (newEvent.genre = this.event.genre),
          (newEvent.date = this.event.date),
          (newEvent.time = this.event.time),
          (newEvent.duration = this.event.duration),
          (newEvent.location = this.event.location);

        hostService
          .updateEvent(newEvent)
          .then((response) => {
            if (response.status === 200) {
              this.$router.push(`/event/${newEvent.eventId}/details`);
            }
          })
          .catch((error) => {
            this.handleErrorResponse(error, "updating");
          });
      }
    },
  },
};
</script>

<style>
</style>