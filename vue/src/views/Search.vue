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
        sharedService.getEvent(this.$route.query.name)
        .then(res=>
        {
            console.log(res.data)
            this.Events=res.data;
        })

    },
    components:{
        Event
      
    },
    data(){
      return {
        Events: [],
        errorMsg: ""
      };
    },


};
</script>

<style>


</style>