<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div>
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
      <label for="confirmPassword">Confirm Password:  </label>
      <input
        type="password"
        id="confirmPassword"
        class="form-control userpass"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      </div>
      <br>
      <br>
      <button class="registerbtn" type="submit">
        Create Account
      </button>
    </form>
    <div>
      <br>
      <br>
     <router-link :to="{ name: 'login' }"><button class="loginbtn">Have an account?</button></router-link>
    </div>
  </div>

</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
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
