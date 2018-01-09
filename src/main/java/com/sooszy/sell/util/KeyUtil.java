package com.sooszy.sell.util;

import java.util.Random;

/**
 * @author 沈躜毅
 * @create 2018-01-07 下午11:28
 **/
public class KeyUtil {
    /**
     * 生成唯一主键
     *
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
