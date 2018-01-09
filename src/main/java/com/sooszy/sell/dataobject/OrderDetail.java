package com.sooszy.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 沈躜毅
 * @create 2018-01-07 下午4:56
 **/

@Entity
@Data
@DynamicUpdate
public class OrderDetail {

    @Id
    private String detailId;

    /*订单id*/
    private String orderId;

    /*商品id*/
    private String productId;

    /*商品名称*/
    private String productName;

    /*单价*/
    private BigDecimal productPrice;

    /*商品数量*/
    private Integer productQuantity;


    private String productIcon;

    private Date createTime;

    private Date updateTime;






}
