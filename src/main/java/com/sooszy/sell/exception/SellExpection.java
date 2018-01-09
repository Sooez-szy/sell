package com.sooszy.sell.exception;

import com.sooszy.sell.enums.ResultEnum;

/**
 * @author 沈躜毅
 * @create 2018-01-07 下午10:59
 **/

public class SellExpection extends RuntimeException{
    private Integer code;
    public SellExpection(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }


}
