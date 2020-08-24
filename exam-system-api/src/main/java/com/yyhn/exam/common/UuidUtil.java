package com.yyhn.exam.common;

import org.springframework.stereotype.Component;

import java.util.UUID;

public class UuidUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
