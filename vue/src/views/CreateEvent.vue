<template>
    <div class="createparty" align="center">
        <h1>Let's Start this Party!</h1>
        <h3 class="tell-party">Tell us about the party:</h3>
        <create-event/>
    </div>
</template> 

<script>
import CreateEvent from "@/components/CreateEvent";


export default {
  components: {
    CreateEvent
   
  }
};
</script>
<style scoped>
/* .createparty{
  padding-left: 100px;
} */

.tell-party {
  color: #61E294;
  font-weight: bold;
}

</style>