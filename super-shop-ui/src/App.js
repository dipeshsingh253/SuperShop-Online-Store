import { createBrowserRouter, RouterProvider, Route } from "react-router-dom";
import RegistrationForm from "./components/RegistrationFrom";
import LoginFrom from "./components/LoginFrom";
import Home from "./components/Home";
import Dashboard from "./components/admin/Dashboard";
import AddCategory from "./components/admin/AddCategory";
import AddProduct from "./components/admin/AddProduct";

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
]);

function App() {
  return (
    <>
      <RouterProvider router={router} />
    </>
  );
}

export default App;
