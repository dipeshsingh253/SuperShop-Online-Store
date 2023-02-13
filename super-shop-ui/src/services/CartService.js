import axios from "axios";



class CartService {
  //http://localhost:8088/additemtocart?authenticationToken=WFEoYLhtLfae
  addItemToCart(cartDto) {
    
    const TOKEN = localStorage.getItem("token");

    return axios.post(
      `http://localhost:8088/additemtocart?authenticationToken=${TOKEN}`,
      cartDto
    );
  }

  getCartByUser() {

    const TOKEN = localStorage.getItem("token");

    return axios.get(
      `http://localhost:8088/carts/user?authenticationToken=${TOKEN}`
    );
  }
}

export default new CartService();
