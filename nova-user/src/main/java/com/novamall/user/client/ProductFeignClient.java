package com.novamall.user.client;


import com.novamall.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "nova-product", path = "/product")
public interface ProductFeignClient {


    @RequestMapping("/selectProductById")
    Result<Map<String,Object>> selectProductById(@RequestParam("id") Long id);
}
