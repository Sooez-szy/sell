package com.sooszy.sell.dto;

import com.sooszy.sell.dataobject.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 沈躜毅
 * @create 2018-01-07 下午10:39
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String orderId;
    private String buyerName;

    /*买家手机号*/
    private String buyerPhone;


    private String buyerAddress;

    /*买家微信openid*/
    private String buyerOpenid;

    private BigDecimal orderAmount;

    /*订单状态 默认为 新订单*/
    private Integer orderStatus;

    /*支付状态 默认为0 未支付*/
    private Integer payStatus;

    /*创建时间*/
    private Date createTime;

    /*更新时间*/
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
