<template>
  <table>
    <thead>
      <tr>
        <th># Id</th>
        <th>Title</th>
        <th>Artist</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="playlist in $store.state.playlists" v-bind:key="playlist.id">
        <td>{{ playlist.id }}</td>
        <router-link v-bind:to="{name: 'EventPlaylist-detail', params: {id: playlist.id}}">
          <td>{{ playlist.name }}</td>
        </router-link>
        <td>{{ playlist.Id.length }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
//import SharedService from "../services/SharedService";
export default {
  name: "EventPlaylist",
  eventID: {
    type: Number,
    id: 1,
  },
    data() {
    return {
      event: {
        songId: -1,
        genreId: -1,
        songTitle: "",
        songArtist: "",

      },
      errorMsg: "",
    };
  },


};
</script>

<style>

</style>
