package com.cimc.po;

import lombok.Data;

import java.util.Date;

@Data
public class ProductCategoryPo {
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;


}