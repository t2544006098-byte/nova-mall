package com.novamall.product.service;

import com.github.pagehelper.PageInfo;
import com.novamall.common.Result;
import com.novamall.product.dto.ProductCreateRequest;
import com.novamall.product.dto.ProductUpdateRequest;
import com.novamall.product.entity.Product;

import java.util.List;

public interface ProductService {

    Result<Product> createProduct(ProductCreateRequest prodectCreateRequest);

    Result<PageInfo<Product>> selectAllProduct(Integer pageNum, Integer pageSize);

    Result<List<Product>> selectProductByName(String name);

    Result<Product> selectProductById(Long id);

    Result<List<Product>> selectProductListByIdList(List<Long> listProductId);

    Result<Void> deleteProductById(Long ProductId);

    Result<Void> deleteProductListByIdList(List<Long> listProductId);

    Result<Product> updateProduct(ProductUpdateRequest productUpdateRequest);
}
