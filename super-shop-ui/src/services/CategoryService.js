import axios from "axios";

const TOKEN = localStorage.getItem("token");

class CategoryService {
  saveCategory(category) {
    console.log(TOKEN);

    return axios.post(
      `http://localhost:8088/categories?token=${TOKEN}`,
      category
    );
  }

  getAllCategories() {
    return axios.get(`http://localhost:8088/categories?token=${TOKEN}`);
  }
}
export default new CategoryService();
