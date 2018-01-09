package com.sooszy.sell.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品信息
 *
 * @author 沈躜毅
 * @create 2018-01-03 下午5:20
 **/
@Entity
@DynamicUpdate
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo {

    @Id
    private String productId;

    /*商品名*/
    private String productName;

    /*商品单价*/
    private BigDecimal productPrice;


    private Integer productStock;

    private String productDescription;

    /*小图*/
    private String productIcon;

    /*商品状态,0正常1下架*/
    private Integer productStatus;

    /*类目编号*/
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

}


