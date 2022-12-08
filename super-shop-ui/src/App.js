import { createBrowserRouter, RouterProvider, Route } from "react-router-dom";
import RegistrationForm from "./components/RegistrationFrom";
import LoginFrom from "./components/LoginFrom";
import Home from "./components/Home";
import Dashboard from "./components/admin/Dashboard";
import AddCategory from "./components/admin/AddCategory";
import AddProduct from "./components/admin/AddProduct";
import AllProduct from "./components/admin/AllProducts";
import EditProduct from "./components/admin/EditProduct";

const router = createBrowserRouter([
  {
    path: "/register",
    element: <RegistrationForm />,
  },
  {
    path: "/login",
    element: <LoginFrom />,
  },
  {
    path: "/home",
    element: <Home />,
  },
  {
    path: "/dashboard",
    element: <Dashboard />,
  },
  {
    path: "/addcategory",
    element: <AddCategory />,
  },
  {
    path: "/addproduct",
    element: <AddProduct />,
  },
  {
    path: "/allproduct",
    element: <AllProduct />,
  },
  {
    path: "/editproduct",
    element: <EditProduct />,
  },
]);

function App() {
  return (
    <>
      <RouterProvider router={router} />
    </>
  );
}

export default App;
