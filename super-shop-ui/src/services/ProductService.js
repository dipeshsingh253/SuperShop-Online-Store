import axios from "axios";



class ProductService {


  saveProduct(product) {

    const TOKEN = localStorage.getItem("token");

    return axios.post(`http://localhost:8088/products?token=${TOKEN}`, product);
  }

  getAllProducts() {

    const TOKEN = localStorage.getItem("token");

    return axios.get(`http://localhost:8088/products`);
  }

  updateProduct(product) {

    const TOKEN = localStorage.getItem("token");

    return axios.put(`http://localhost:8088/products?token=${TOKEN}`, product);
  }

  getProductById(id) {

    const TOKEN = localStorage.getItem("token");

    return axios.get(`http://localhost:8088/products/${id}`);
  }

  deleteProductById(id){

    const TOKEN = localStorage.getItem("token");

    return axios.delete(`http://localhost:8088/products/${id}`);
  }

}

export default new ProductService();
