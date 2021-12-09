<template>
<div id="nav">
    <div>
        <img src="retroplay_logo.png">
    </div>
    <div>
        <h1>Retroplay</h1>
    </div>
    <div>
        <h2>Music for Party People</h2>
    </div>
    <div class="dropdown">
        <button onclick="myFunction()" class="dropbtn">Dropdown</button>
            <div id="myDropdown" class="dropdown-content">
                <a href="#">Link 1</a>
                <a href="#">Link 2</a>
                <a href="#">Link 3</a>
             </div>
    </div>
</div>
</template>


<script>
export default {
    name: "nav-bar",

    data() {
        return {
            
        }
    }

}

/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
//function myFunction() {
 // document.getElementById("myDropdown").classList.toggle("show");
//}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}


</script>


<style>
#nav {
    width: 100%;
    height: 100px;
    position: fixed;
    top: 0;
    background-color: green;
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    
}
img {
    height: 100px;
    width: 100px
}

h1 {
    color: pink;
}

div {
    border: blue;
    border-width: 2px;
    border-style: solid;
}

/* Dropdown Button */
.dropbtn {
  background-color: #3498DB;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

/* Dropdown button on hover & focus */
.dropbtn:hover, .dropbtn:focus {
  background-color: #2980B9;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
  position: relative;
  display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #ddd}

/* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */
.show {display:block;}

</style>






