package com.novamall.user.controller;

import com.novamall.common.Result;
import com.novamall.user.client.ProductFeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user/feign")
public class FeignTestController {

    private final ProductFeignClient productFeignClient;

    public FeignTestController(ProductFeignClient productFeignClient){
        this.productFeignClient = productFeignClient;
    }

    @RequestMapping("/selectProductById")
    public Result<Map<String,Object>> selectProductById(@RequestParam("id") Long id){
        return productFeignClient.selectProductById(id);
    }
}
