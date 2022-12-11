import React from "react";
import { useNavigate } from "react-router-dom";

const Navbar = () => {
  // const navigate = useNavigate();
  // const handleClick = (e) => {
  //   console.log(e.target.getAttribute("href"));
  // };

  return (
    <div className="flex bg-blue-300 justify-around items-center p-4">
      <div className="text-xl font-bold">
        <h1>SuperStore</h1>
      </div>
      <div>
        <a href="/home">Home</a>
      </div>
      <div>
        <a href="/allproduct">Products</a>
      </div>
      <div>
        <a href="/orders">Orders</a>
      </div>
      <div>
        <a href="/cart">Cart</a>
      </div>
      <div>
        <a>Logout</a>
      </div>
    </div>
  );
};

export default Navbar;
