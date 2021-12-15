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
            this.Events=res.data
        })

    },
    components:{
        Event
      
    },
    data(){
      return {
        Events: [{"eventId":1,"eventHost":null,"eventDJ":null,"eventDJId":3,"host":2,"genre":2,"playlist":1,"name":"Birthday Boogie","date":null,"time":null,"duration":0,"location":null},{"eventId":2,"eventHost":null,"eventDJ":null,"eventDJId":3,"host":3,"genre":2,"playlist":1,"name":"Birthday Bumble","date":null,"time":null,"duration":0,"location":null},{"eventId":3,"eventHost":null,"eventDJ":null,"eventDJId":3,"host":3,"genre":2,"playlist":1,
"name":"Birthday Bumble","date":null,"time":null,"duration":0,"location":null}
]
      }
    }
};
</script>

<style>


</style>