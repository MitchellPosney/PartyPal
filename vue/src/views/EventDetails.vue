<template>
  <div class="event-details"> <event-details></event-details>
        </div>
</template>

<script>

import EventDetails from "@/components/EventDetails.vue"

export default {
  name: "EventDetail",
  methods: {
    cursorToSearch () {
      document.querySelector("searchbar").focus();
      document.querySelector("searchbar").setSelectionRange(0,0);
    }
  },
   
    components:{
        EventDetails
      
    },
    data(){
      return {
        Events: [{    nameDJ: "DJ Daft Punk",
                date: "12142021",
                time: "00:00:00",
                location:"New York City, NY"}, {    nameDJ: "DJ Khalid",
                date: "12312021",
                time: "23:00:00",
                location:"Atlanta, GA"}, {    nameDJ: "DJ Kaytranada",
                date: "10312022",
                time: "21:00:00",
                location:"Los Angeles, CA"}]
      }
    }

};
</script>

<style>


</style>

