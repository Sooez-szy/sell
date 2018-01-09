package com.sooszy.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(0,"支付成功"),

    ;

    private Integer code;
    private String message;
}
