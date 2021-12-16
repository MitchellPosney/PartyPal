<template>
   <div class= "event-details">  
       <div class="search-results">
        <router-link :to="{name: 'EventDetail', params:{eventId: event.eventId}}" >
           <button class="btn-event">{{event.name}} hosted by {{event.host}}</button>
        </router-link> 
       </div>
    </div> 
</template>

<script>
export default {
    data(){
        return {
            
        }
    }, props: {
        event: Object
    }
   
}
</script>
<style>
.btn-event{
  background-color: #18CAE6;
  color: white;
  padding: 10px;
  font-size: 16px;
  border: none;
  cursor: pointer;
  border-radius: 7px;
}

.search-results {
    padding-top: 20px;
}

.btn-event:hover, .btn-event:focus {
  background-color: #61E294;
}



</style>