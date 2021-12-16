<template>
  <div class="event-details">Event Details  EventName:{{events.name}}  DATE:{{events.date}}   Location:{{events.location}} </div>
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
</style>