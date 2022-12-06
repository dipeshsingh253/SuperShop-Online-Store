import React from "react";
import { useState } from "react";
import UserService from "../services/UserService";
import swal from "sweetalert";

const LoginFrom = () => {
  const [userDto, setUserDto] = useState({
    email: "",
    password: "",
    role: "admin",
  });

  const handleChange = (e) => {
    const value = e.target.value;
    setUserDto({
      ...userDto,
      [e.target.name]: value,
    });
  };

  const loginUser = (e) => {
    e.preventDefault();
    console.log(userDto);
    UserService.loginUser(userDto)
      .then((res) => {
        console.log(res);
        swal({
          title: res.data,
          icon: "success",
        });
      })
      .catch((error) => {
        swal({
          title: error.response.data.message,
          icon: "error",
        });
      });
  };

  return (
    <div className="flex rounded justify-center items-center w-3/4 mx-auto my-8">
      <div className="px-8 py-8">
        <div className="font-bold text-2xl tracking-wider">
          <h1>Login Page</h1>
        </div>

        {/* Input Fields */}
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            E-Mail
          </label>
          <input
            type="email"
            name="email"
            value={userDto.email}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"
          ></input>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            Password
          </label>
          <input
            type="password"
            name="password"
            value={userDto.password}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"
          ></input>
        </div>

        {/* Buttons */}

        <div className="items-center justify-center h-14 w-full my-4 space-x-4 pt-4">
          <button
            onClick={loginUser}
            className="rounded text-white bg-green-500 hover:bg-green-700 px-6 py-2"
          >
            Login
          </button>
        </div>
      </div>
    </div>
  );
};

export default LoginFrom;
