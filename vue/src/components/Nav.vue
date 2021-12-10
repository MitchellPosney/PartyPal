<template>
<div id="nav">
    <div>
        <router-link v-bind:to="{ name: 'home' }"><img src="retroplay_logo_horizontal_transp.png" class="logo"></router-link>
    </div>
    <div class="searchbar">
        <text area></text>
    </div>
    <div class="dropdown">
        <button v-on:click="myFunction()" class="dropbtn">Manage Account</button>
            <div id="myDropdown" class="dropdown-content">
                <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
                <router-link v-bind:to="{ name: 'login' }">Login</router-link>
                <router-link v-bind:to="{ name: 'home' }">Home</router-link>
                <router-link v-bind:to="{ name: 'register' }" v-if="$store.state.token == ''">Register</router-link>
                <router-link v-bind:to="{ name: 'login'  }">Login</router-link>
                <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
            </div>
    </div>
</div>
</template>


<script>
export default {
    name: "nav-bar",
    methods: {
        myFunction() {
             document.getElementById("myDropdown").classList.toggle("show");
        },
        function(event) {
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

    },

    data() {
        return {
            
        }
    }

}

/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */


//Close the dropdown menu if the user clicks outside of it
// window.onclick = function(event) {
//   if (!event.target.matches('.dropbtn')) {
//     var dropdowns = document.getElementsByClassName("dropdown-content");
//     var i;
//     for (i = 0; i < dropdowns.length; i++) {
//       var openDropdown = dropdowns[i];
//       if (openDropdown.classList.contains('show')) {
//         openDropdown.classList.remove('show');
//       }
//     }
//   }
// }


</script>

<style>
#nav {
    width: 100%;
    height: 100px;
    position: fixed;
    top: 0;
    background-color: #000022;
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    gap: 30px;
    justify-content: space-between;
    
}
.logo {
    height: 100px;
    flex-basis: 0%;
}

/* div {
    border-style: solid;
} */

/* Dropdown Button */
.dropbtn {
  background-color: #18CAE6;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
  border-radius: 15px;
}

/* Dropdown button on hover & focus */
.dropbtn:hover, .dropbtn:focus {
  background-color: #61E294;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
  position: absolute;
  display: inline-block;
  right: 0px;
  padding: 25px;

}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px #000022;
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
  color:#000022;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #ddd;}

/* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */
.show {display:block;}

</style>






