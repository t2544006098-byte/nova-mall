package com.novamall.product.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCreateRequest {

    //商品名称
    @NotBlank(message = "商品名称不能为空")
    private String name;
    //商品描述
    private String description;

    //售价
    @NotNull(message = "价格不能为空")
    @DecimalMin(value = "0.01", message = "价格${validatedValue}必须大于0")
    private BigDecimal price;

    //库存数量
    @NotNull(message = "库存不能为空")
    @Min(value = 0, message = "库存不能小于0")
    private Integer stock;

    //分类ID
    private Long categoryId;
    //品牌
    private String brand;
    //主图URL
    private String mainImage;
    //状态：1上架 0下架
    private Integer status;
}
