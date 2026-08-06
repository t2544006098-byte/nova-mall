package com.novamall.product.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Product {

    private Long id;
    //商品名称
    private String name;
    //商品描述
    private String description;
    //售价
    private BigDecimal price;
    //库存数量
    private Integer stock;
    //分类ID
    private Long categoryId;
    //品牌
    private String brand;
    //主图URL
    private String mainImage;
    //状态：1上架 0下架
    private Integer status;
    //数据有效性
    private String valid;
    //创建时间
    private LocalDateTime createTime;
    //修改时间
    private LocalDateTime updateTime;
}
