import axios from "axios";

// const USER_BASE_URL = 

class UserService{

    saveUser(user){
        return axios.post("http://localhost:8088/register",user);
    }

}

export default new UserService();