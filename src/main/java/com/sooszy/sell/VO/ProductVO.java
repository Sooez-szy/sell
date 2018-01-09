package com.sooszy.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品包含类目
 *
 * @author 沈躜毅
 * @create 2018-01-04 下午3:29
 **/
@Data
public class ProductVO {

    /*商品类目名*/
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;




}
