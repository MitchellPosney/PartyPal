<template>
  <form v-on:submit.prevent="submitForm" class="eventForm"> 
       <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
    <div class="form-group">
      <label for="title">Event Name: </label>
      <input id="title" type="text" class="form-control" v-model="card.title" autocomplete="off" />
    </div>
    <div class="form-group">
      <label for="tag"> Tag:</label>
      <select id="tag" class="form-control" v-model="card.tag">
        <option value="Feature Request">Feature Request</option>
        <option value="Design">Design</option>
        <option value="Q&A">Q&A</option>
      </select>
      <label for="status">Status:</label>
      <select id="tag" class="form-control" v-model="card.status">
        <option value="Planned">Planned</option>
        <option value="In Progress">In Progress</option>
        <option value="Completed">Completed</option>
      </select>
    </div>
    <div class="form-group">
      <label for="description">Description:</label>
      <textarea id="description" class="form-control" v-model="card.description"></textarea>
    </div>
    <button class="btn btn-submit">Submit</button>
    <button class="btn btn-cancel" v-on:click.prevent="cancelForm" type="cancel">Cancel</button>
  </form>
</template>

<script>
export default {
name: "event-form", 
    data() { 
      return { 
          event: { 


              name: "",  
              host: "", 
              playlist: 1, 
              genre: "", 
              date: "", 
              time: "",  
              duration: "", 
              location: "", 
              
          }
      };  
    }
}
</script>

<style>

</style>