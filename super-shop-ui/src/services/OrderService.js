import axios from "axios";

const TOKEN = localStorage.getItem("token");

class OrderService {
  placeOrder(order) {
    return axios.post(`http://localhost:8088/orders?token=${TOKEN}`, order);
  }

  getOrderByUser(id) {
    //for an ordinary customer passing the id is optional but if admin wants to list orders which belongs to a particular customer then passing the proper user id is mandatory
    return axios.get(`http://localhost:8088/orders/${id}?token=${TOKEN}`);
  }
}

export default new OrderService();
