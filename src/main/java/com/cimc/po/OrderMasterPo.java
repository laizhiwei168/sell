package com.cimc.po;

import com.cimc.enums.OrderStatusEnum;
import com.cimc.enums.PayStatusEnum;
import com.cimc.utils.Date2LongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderMasterPo {
    private String orderId;

    private String orderName;

    private String orderPhone;

    private String orderAddress;

    private String orderOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date careateTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

}