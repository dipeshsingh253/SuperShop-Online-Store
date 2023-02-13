import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import ProductService from "../../services/ProductService";
import Navbar from "./../general/Navbar";
import SingleProduct from "./SingleProduct";

const ProductPage = () => {
  const { id } = useParams();

  const [loading, setLoading] = useState(true);

  const [product, setProduct] = useState(null);

  const fetchData = async () => {
    setLoading(true);
    try {
      const response = await ProductService.getProductById(id);
      // console.log(response.data);
      setProduct(response.data);

    } catch (error) {

    }
    setLoading(false);
  };
  useEffect(() => {
    

    fetchData();
  }, []);

  return (
    <div>
      <Navbar />
      {!loading && (
        <SingleProduct
          key={product.id}
          id={product.id}
          name={product.name}
          description={product.description}
          imageUrl={product.imageUrl}
          price={product.price}
          stock={product.stock}
          fetchData={fetchData}
        />
      )}
    </div>
  );
};

export default ProductPage;
