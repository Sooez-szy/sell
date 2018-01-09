package com.sooszy.sell.dataobject;

import com.sooszy.sell.enums.OrderStatusEnum;
import com.sooszy.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 沈躜毅
 * @create 2018-01-04 下午10:08
 **/
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;
    private String buyerName;

    /*买家手机号*/
    private String buyerPhone;


    private String buyerAddress;

    /*买家微信openid*/
    private String buyerOpenid;

    private BigDecimal orderAmount;

    /*订单状态 默认为 新订单*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /*支付状态 默认为0 未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /*创建时间*/
    private Date createTime;

    /*更新时间*/
    private Date updateTime;

}
