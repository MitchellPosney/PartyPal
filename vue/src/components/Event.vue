<template>
   <div class= "event-details">  <router-link :to="{name: 'EventDetail', params:{eventId: event.eventId}}" >{{event.eventId}}</router-link> 
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

</style>