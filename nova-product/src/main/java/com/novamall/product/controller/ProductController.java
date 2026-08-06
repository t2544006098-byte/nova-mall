package com.novamall.product.controller;

import com.github.pagehelper.PageInfo;
import com.novamall.common.Result;
import com.novamall.product.dto.ProductCreateRequest;
import com.novamall.product.dto.ProductUpdateRequest;
import com.novamall.product.entity.Product;
import com.novamall.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 创建商品
     * @param prodectCreateRequest
     * @return
     */
    @RequestMapping("/createProduct")
    public Result<Product> createProduct(@Valid @RequestBody ProductCreateRequest prodectCreateRequest){
        return productService.createProduct(prodectCreateRequest);
    }


    /**
     * 分页查询商品列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/selectAllProduct")
    public Result<PageInfo<Product>> selectAllProduct(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        return productService.selectAllProduct(pageNum,pageSize);
    }

    /**
     * 根据商品名称模糊查询商品
     * @param name
     * @return
     */
    @RequestMapping("/selectProductByName")
    public Result<List<Product>> selectProductByName(@RequestParam("name") String name){
        return productService.selectProductByName(name);
    }

    /**
     * 根据商品id查询商品
     * @param id
     * @return
     */
    @RequestMapping("/selectProductById")
    public Result<Product> selectProductById(@RequestParam("id") Long id){
        return productService.selectProductById(id);
    }

    /**
     * 根据商品id列表查询商品
     * @param listProductId
     * @return
     */
    @RequestMapping("/selectProductListByIdList")
    public Result<List<Product>> selectProductListByIdList(@RequestBody List<Long> listProductId){
        return productService.selectProductListByIdList(listProductId);
    }

    /**
     * 根据商品id逻辑删除商品
     * @param productId
     * @return
     */
    @RequestMapping("/deleteProductById")
    public Result<Void> deleteProductById(@RequestParam("productId") Long productId){
        return productService.deleteProductById(productId);
    }

    /**
     * 根据商品id列表逻辑删除商品
     * @param listProductId
     * @return
     */
    @RequestMapping("/deleteProductListByIdList")
    public Result<Void> deleteProductListByIdList(@RequestBody List<Long> listProductId){
        return productService.deleteProductListByIdList(listProductId);
    }

    /**
     * 修改商品
     * @param productUpdateRequest
     * @return
     */
    @RequestMapping("/updateProduct")
    public Result<Product> updateProduct(@Valid @RequestBody ProductUpdateRequest productUpdateRequest){
        return productService.updateProduct(productUpdateRequest);
    }


}
