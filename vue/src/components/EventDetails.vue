<template>
  <div class="event-details">Event Details {{events.name}}</div>
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
        events: {
eventId:1, 
eventDJId:3,host:2,genre:2,playlist:1,name:"Birthday Boogie",
duration:0,},

    }
    }
};
</script>

<style>
</style>