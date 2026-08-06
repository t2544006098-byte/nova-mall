package com.novamall.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.novamall.common.CodeEnum;
import com.novamall.common.Result;
import com.novamall.common.ResultEnum;
import com.novamall.product.dto.ProductCreateRequest;
import com.novamall.product.dto.ProductUpdateRequest;
import com.novamall.product.entity.Product;
import com.novamall.product.mapper.ProductMapper;
import com.novamall.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 创建商品
     * @param productCreateRequest
     * @return
     */
    @Override
    public Result<Product> createProduct(ProductCreateRequest productCreateRequest){
        //先查询商品是否已经存在
        List<Product> productList = productMapper.selectProductByName(productCreateRequest.getName());
        if(!productList.isEmpty() && productList.size() > 0){
            for(Product product : productList){
                if(productCreateRequest.getName().equals(product.getName())){
                    return Result.fail(ResultEnum.PRODUCT_IS_EXIST.getCode(),ResultEnum.PRODUCT_IS_EXIST.getMessage(),product);
                }
            }
        }
        //不存在则插入数据
        Product product = new Product();
        product.setBrand(productCreateRequest.getBrand());
        product.setName(productCreateRequest.getName());
        product.setDescription(productCreateRequest.getDescription());
        product.setPrice(productCreateRequest.getPrice());
        product.setStock(productCreateRequest.getStock());
        product.setCategoryId(productCreateRequest.getCategoryId());
        product.setBrand(productCreateRequest.getBrand());
        product.setMainImage(productCreateRequest.getMainImage());
        product.setStatus(productCreateRequest.getStatus() != null ? productCreateRequest.getStatus() : CodeEnum.YES.getCode());
        product.setCreateTime(LocalDateTime.now());
        product.setUpdateTime(LocalDateTime.now());
        productMapper.createProduct(product);
        return Result.success(product);
    }

    @Override
    public Result<PageInfo<Product>> selectAllProduct(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Product> productList = productMapper.selectAllProduct();
        PageInfo<Product> pageinfo = new PageInfo<>(productList);
        return Result.success(pageinfo);
    }

    @Override
    public Result<List<Product>> selectProductByName(String name){
        List<Product> productList = productMapper.selectProductByName(name);
        if(productList == null){
            return Result.fail(ResultEnum.PRODUCT_NOT_FOUND.getCode(), ResultEnum.PRODUCT_NOT_FOUND.getMessage());
        }
        return Result.success(productList);
    }

    @Override
    public Result<Product> selectProductById(Long id){
        Product product = productMapper.selectProductById(id);
        if (product == null){
            return Result.fail(ResultEnum.PRODUCT_NOT_FOUND.getCode(),ResultEnum.PRODUCT_NOT_FOUND.getMessage());
        }
        return Result.success(product);
    }

    @Override
    public Result<List<Product>> selectProductListByIdList(List<Long> listProductId){
        if (listProductId.isEmpty() || listProductId.size() == 0){
            return Result.fail(ResultEnum.FAIL.getCode(), "商品列表为空！");
        }
        List<Product> productList = productMapper.selectProductListByIdList(listProductId);
        return Result.success(productList);
    }

    public Result<Void> deleteProductById(Long productId){
        if(productId == null){
            return Result.fail(ResultEnum.FAIL.getCode(), "商品ID为空！");
        }
        productMapper.deleteProductById(productId);
        return Result.success(ResultEnum.SUCCESS.getCode(),"删除成功！");
    }

    public Result<Void> deleteProductListByIdList(List<Long> listProductId){
        if (listProductId.isEmpty() || listProductId.size() == 0) {
            return Result.fail(ResultEnum.FAIL.getCode(), "商品ID列表为空！");
        }
        productMapper.deleteProductListByIdList(listProductId);
        return Result.success(ResultEnum.SUCCESS.getCode(), "删除成功！");
    }

   public Result<Product> updateProduct(ProductUpdateRequest productUpdateRequest){
        Product product = productMapper.selectProductById(productUpdateRequest.getId());
        if (product == null){
            return Result.fail(ResultEnum.PRODUCT_NOT_FOUND.getCode(),ResultEnum.PRODUCT_NOT_FOUND.getMessage());
        }
        product.setStatus(productUpdateRequest.getStatus());
        product.setName(productUpdateRequest.getName());
        product.setDescription(productUpdateRequest.getDescription());
        product.setPrice(productUpdateRequest.getPrice());
        product.setStock(productUpdateRequest.getStock());
        product.setCategoryId(productUpdateRequest.getCategoryId());
        product.setBrand(productUpdateRequest.getBrand());
        product.setMainImage(productUpdateRequest.getMainImage());
        product.setUpdateTime(LocalDateTime.now());
        productMapper.updateProduct(product);
        return Result.success(product);
   }
}
