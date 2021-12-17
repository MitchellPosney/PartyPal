<template>
  <div class="about-section">
  <h1 style="text-align:center">Meet Team DJ</h1>

  <p class="about-summary">For the past 14-weeks we have been learning how 
     to develop dynamic web-based software systems using the Java programming language.
     We hope you've enjoyed our final capstone project utilizing our new-found Java, SQL, Vue.js, 
     SpringBoot, Axios, and HTML/CSS.
  </p>


<div class="row">
  
  <div class="column">
    <div class="card">
      <img src="pause.png" alt="Caroline" class="pic">
        <h2>Caroline Lundy </h2>
        <p class="title"> Java BootCamp Graduate </p>
        <p class="summary">"My Coding Super Power is that I have a knack for Seeing Future Potential errors while writing Code!"</p>
        <p> carolinegracelundy@gmail.com </p> 
        <a href="http://www.linkedin.com/in/carolinelundy" target="new">
        <button class="contact-btn">Contact</button>
        </a> 
    </div>
  </div>

  <div class="column right-align">
    <div class="card">
      <img src="sade.jpg" alt="Sade" class="pic">
        <h2>Sade Akinkuotu</h2>
        <h3>&#40; Like the singer &#41;</h3>
        <p class="title"> Java BootCamp Graduate </p>
        <p class="summary">"Wanting to embody the change that's needed in this world, I am grateful for the space to upskill 
          with Tech Elevator and apply new knowledge to a capstone that 
          marries creativity and my passion in music with the development of streaming 
          platform software!"</p>
        <p>sadeakin85@gmail.com</p>
       <a href="https://www.linkedin.com/in/ade-s-akinkuotu" target="new">
       <button class="contact-btn">Contact</button>
       </a>
      </div>
  </div>

  <div class="column">
    <div class="card">
      <img src="mitchell.jpg" alt="Mitchell" class="pic">
        <h2>Mitchell Posney</h2>
        <p class="title"> Java BootCamp Graduate </p>
        <p class="summary">"When not watching Home Alone and imagining myself as Kevin McAllister, I'm keen on setting up my own 
          programming booby traps and outsmarting the burglars in the Java backend."</p>
        <p>mposney@gmail.com </p> 
        <a href="http://www.linkedin.com/in/mitchellposney" target="new">
        <button class="contact-btn">Contact</button>
        </a> 
    </div>
  </div>

  <div class="column right-align">
    <div class="card">
      <img src="ashley.png" alt="Ashley" class="pic">
        <h2>Ashley Shewmaker</h2>
        <p class="title"> Java BootCamp Graduate </p>
        <p class="summary">"Ashley is a lifelong skill collector who is currently enthusiastic 
          about putting her English and Philosophy degrees to work hunting vagrant punctuation 
          marks in code and reasoning her way out of a FizzBuzz in as many different ways as she can find." </p>
        <p>ashley.e.shewmaker@gmail.com</p>
       <a href="https://www.linkedin.com/in/ashley-shewmaker" target="new">
       <button class="contact-btn">Contact</button>
       </a>
      </div>
  </div>
  </div>
  </div>
</template>

<script>
export default {
  name: 'about-us',
}
</script>
<style>
.contact-btn {
  background-color:#61E294 ;
  color: white;
  padding: 10px;
  font-size: 12px;
  font-weight: bolder;
  border: none;
  cursor: pointer;
  border-radius: 15px;
}

/* Dropdown button on hover & focus */
.contact-btn:hover, .contact-btn:focus {
  background-color: #18CAE6;
}

.right-align {
  text-align: right;
}

.column {
  padding-right: 40px;
  padding-left: 40px;
}

.title {
  color: #D741A7;
  font-weight: bold;
}

.summary {
  font-style: italic;
  font-size: 17px;
}

.about-summary {
  text-align: center;
  padding: 10px 75px;
  font-weight: bold;
}

.pic {
  width: 200px;
  border-radius: 100%;
  border-color: #F2CD5D;
  border-width: 3px;
  border-style: solid
}

h1 {
  text-shadow: 2px 2px green;
  color: #D741A7;
  background-color: coral;
}

</style>