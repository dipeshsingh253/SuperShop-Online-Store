import React from "react";
import Product from "../../admin/Product/Product";
import { useState } from "react";
import ProductService from "../../../services/ProductService";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const AllProducts = () => {
  const [productData, setproductData] = useState(null);
  const [loading, setloading] = useState(true);
  const navigate = useNavigate();
  useEffect(() => {
    const fetchData = async () => {
      setloading(true);
      try {
        const response = await ProductService.getAllProducts();
        setproductData(response.data);
        // console.log(response.data);
        console.log(productData);
      } catch (error) {
        console.log(error);
      }

      setloading(false);
    };

    fetchData();
  }, []);

  return (
    <>
      <div className="h-12">
        <button
          onClick={() => navigate("/addproduct")}
          className="rounded bg-slate-600 text-white px-6 py-2 font-semibold"
        >
          Add Product
        </button>
      </div>
      <div className="grid md:gap-5 md:grid-cols-3 sm:grid sm:gap-4 sm:grid-cols-2 justify-center bg-red-200 p-5">
        {loading || productData == null ? (
          <h1>Hey its Empty</h1>
        ) : (
          !loading &&
          productData.map((pro) => (
            <Product
              key={pro.id}
              name={pro.name}
              description={pro.description}
              imageUrl={pro.imageUrl}
              price={pro.price}
              stock={pro.stock}
            />
          ))
        )}
      </div>
    </>
  );
};

export default AllProducts;
