import { createBrowserRouter, RouterProvider, Route } from "react-router-dom";
import RegistrationForm from "./components/RegistrationFrom";
import LoginFrom from "./components/LoginFrom";
import Home from "./components/Home";
import Dashboard from "./components/admin/Dashboard";
import AddCategory from "./components/admin/Category/AddCategory";
import AddProduct from "./components/admin/Product/AddProduct";
import AllProduct from "./components/admin/Product/AllProducts";
import EditProduct from "./components/admin/Product/EditProduct";
import AllCategory from "./components/admin/Category/AllCategory";
import EditCategory from "./components/admin/Category/EditCategory";

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
  {
    path: "/allcategory",
    element: <AllCategory />,
  },
  {
    path: "/editcategory",
    element: <EditCategory />,
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
