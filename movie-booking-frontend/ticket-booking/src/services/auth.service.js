import axios from "axios";

const API_URL = "http://localhost:8080/api/v1/auth/";

class AuthService {
  login(username, password) {
    return axios
      .post(API_URL + "signin", { username, password })
      .then((response) => {
        if (response.data.accessToken) {
       localStorage.setItem("user", JSON.stringify(response.data));
        }

        return response.data;
      });
  }

  logout() {
    localStorage.removeItem("user");
  }

  register(firstName, lastName, phoneNumber, email, password) {
    return axios.post(API_URL + "signup", {
        firstName,
        lastName,
        phoneNumber,
      email,
      password,
    });
  }
}

export default new AuthService();