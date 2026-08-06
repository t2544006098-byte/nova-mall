package com.novamall.product.mapper;

import com.novamall.product.dto.ProductCreateRequest;
import com.novamall.product.dto.ProductUpdateRequest;
import com.novamall.product.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    int createProduct(Product product);

    List<Product> selectAllProduct();

    List<Product> selectProductByName(@Param("productName") String productName);

    Product selectProductById(@Param("id") Long id);

    List<Product> selectProductListByIdList(List<Long> listProductId);

    void deleteProductById(Long productId);

    void deleteProductListByIdList(List<Long> listProductId);

    void updateProduct(Product product);
}
