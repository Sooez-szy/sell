package com.sooszy.sell.VO;

import lombok.Data;

/**
 * @author 沈躜毅
 * @create 2018-01-04 下午3:19
 **/

@Data
public class ResultVO<T> {

    /*错误码*/
    private Integer code;

    /*提示信息*/
    private String msg;

    private T data;

}
