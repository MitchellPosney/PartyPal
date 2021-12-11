<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <br>
      <label for="username">Username:  </label>
      <input
        type="text"
        id="username"
        class="form-control userpass"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <br>
      <br>
      <label for="password">Password:  </label>
      <input
        type="password"
        id="password"
        class="form-control userpass"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <br>
      <br>
      <button type="submit" class="loginbtn">Sign in</button>
      <br>
      <br>
      <router-link :to="{ name: 'register' }"><button class="registerbtn">Need an account?</button></router-link>
    </form>
  </div>
</template>

<script>

import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>
.text-center {
  align-content: center;
  text-align: center;
}

.loginbtn {
  background-color: #18CAE6;
  color: white;
  padding: 10px;
  font-size: 16px;
  border: none;
  cursor: pointer;
  border-radius: 15px;
}

.loginbtn:hover, .loginbtn:focus {
  background-color: #61E294;
}

.registerbtn {
  background-color: #D741A7;
  color: white;
  padding: 10px;
  font-size: 16px;
  border: none;
  cursor: pointer;
  border-radius: 15px;
}

.registerbtn:hover, .registerbtn:focus {
  background-color: #61E294;
}

.userpass {
    width: 300px;  
    height: 30px;  
    border: none;  
    border-radius: 3px;  
    padding-left: 8px;
}


</style>
