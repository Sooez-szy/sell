package com.sooszy.sell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 沈躜毅
 * @create 2018-01-08 下午10:09
 **/

@Data
@AllArgsConstructor
public class CartDTO {
    /*商品Id*/
    private String productId;
    /*商品数量*/
    private Integer productQuantity;
}
