<template>
  <div class="event-details">
    <div class="detail-text">
      <h1>Event Details</h1>
      <div class="titles">Event:</div>
      <div>{{events.name}}</div>  
      <br>
      <div class="titles">Event Host:</div>
      <div>{{events.host}}</div>
      <br>
      <div class="titles">Playlist:</div>
      <div>{{events.playlist}}</div>
    </div>

    <div>
      <img src="/vote.png" class="vote-on-songs">

    </div>

    <!-- Date:  {{events.date}}   
    <br>
    Location:{{events.location}}  -->
  </div>
</template>

<script>

import sharedService from "@/services/SharedService"
export default {
  name: "event-details",
  methods: {
    cursorToSearch () {
      document.querySelector("searchbar").focus();
      document.querySelector("searchbar").setSelectionRange(0,0);
    }
  },
    created(){
        sharedService.getEventById(this.$route.params.eventId).then(res=>{
            console.log(res.data)
            this.events=res.data
        })
    },
    components:{   
    },
    data(){
      return {
        events: [],
        errorMsg: ""
      } 
    }
};
</script>

<style>
.event-details {
  display: flex;
  text-align: center;
  padding-top: 20px;
  flex-direction: row;
  width: 100%;
  align-content: center;
  justify-content: center;
}

.titles {
  text-decoration: underline;
  font-size: 20px;
}

.vote-on-songs {
  height: 250px;
}

.detail-text {
  padding: 15px;
}

</style>