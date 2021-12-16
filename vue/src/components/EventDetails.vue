<template>
  <div class="event-details">
    Event Details
    <br>
    <p class="titles">Event:</p>
    {{events.name}}  
    <br>
    <p class="titles">Event Host:</p>
    {{events.host}}
    <br>
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
  text-align: center;
  padding-top: 20px;
}

.titles {
  text-decoration: underline;
  font-size: 20px;
}

</style>