package com.cimc.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public  class OrderDetailPo {
    private String detailId;

    private String orderId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;

    private Date createTime;

    private Date updateTime;


}