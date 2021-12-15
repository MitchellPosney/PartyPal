<template>
    <div>
        <h1>Let's Start this Party!</h1>
        <br>
        <h5>Tell us about the party:</h5>
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