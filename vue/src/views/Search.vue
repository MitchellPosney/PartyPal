<template>
  <div class="search-results"> Search Results Page <event v-for="event in Events" v-bind:key="event.nameDJ" :event="event"></event>
    </div>
</template>

<script>

import sharedService from "@/services/SharedService"
import Event from "@/components/Event.vue"
export default {
  name: "search",
  methods: {
    cursorToSearch () {
      document.querySelector("searchbar").focus();
      document.querySelector("searchbar").setSelectionRange(0,0);
    }
  },
    created(){
        sharedService.getEvent(this.$route.query.name).then(res=>{
            console.log(res.data)
            //this.Events=res.data
        })

    },
    components:{
        Event
      
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