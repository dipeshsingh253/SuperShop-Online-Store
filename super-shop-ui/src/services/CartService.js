import axios from "axios";

const TOKEN = localStorage.getItem("token");

class CartService {
  //http://localhost:8088/additemtocart?authenticationToken=WFEoYLhtLfae
  addItemToCart(cartDto) {
    return axios.post(
      `http://localhost:8088/additemtocart?authenticationToken=${TOKEN}`,
      cartDto
    );
  }
}

export default new CartService();
