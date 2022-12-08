import React from "react";

const Navbar = () => {
  return (
    <div className="flex bg-blue-300 justify-around items-center p-4">
      <div className="text-xl font-bold">
        <h1>SuperStore</h1>
      </div>

      <div>
        <a>Home</a>
      </div>
      <div>
        <a>Products</a>
      </div>
      <div>
        <a>Orders</a>
      </div>
      <div>
        <a>Logout</a>
      </div>
    </div>
  );
};

export default Navbar;
