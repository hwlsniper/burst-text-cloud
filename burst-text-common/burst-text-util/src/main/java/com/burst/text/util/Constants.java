package com.burst.text.util;

import java.util.UUID;

public class Constants {

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }
}
