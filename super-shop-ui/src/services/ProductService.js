import axios from "axios";

const TOKEN = localStorage.getItem("token");

class ProductService {
  saveProduct(product) {
    return axios.post(`http://localhost:8088/products?token=${TOKEN}`, product);
  }
}

export default new ProductService();
