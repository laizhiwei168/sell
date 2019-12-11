package com.cimc.po;

import com.cimc.utils.DateToLongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductInfoPo {
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer categoryType;

    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = DateToLongSerializer.class)
    private Date updateTime;
}