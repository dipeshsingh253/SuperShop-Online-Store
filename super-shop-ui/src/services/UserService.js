import axios from "axios";

// const USER_BASE_URL =

class UserService {
  saveUser(user) {
    return axios.post("http://localhost:8088/register", user);
  }

  loginUser(userDto) {
    return axios.post("http://localhost:8088/login", userDto);
  }
}

export default new UserService();
