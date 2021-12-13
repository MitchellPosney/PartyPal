<template>
  <div class="search-results"> Search Results Page
    </div>
</template>

<script>

import sharedService from "@/services/SharedService"
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
        })

    }

};
</script>

<style>


</style>