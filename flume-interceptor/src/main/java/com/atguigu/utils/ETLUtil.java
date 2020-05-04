package com.atguigu.utils;

import org.apache.commons.lang.math.NumberUtils;

public class ETLUtil {

    public static boolean etlStart(String body){

        return body.startsWith("{") && body.endsWith("}");
    }

    public static boolean etlEvent(String body){

        String[] fields = body.split("\\|");

        if(fields[0].trim().length() != 13 || !NumberUtils.isDigits(fields[0].trim())){
            return false;
        }else{
            return fields[1].trim().startsWith("{")&& fields[1].trim().endsWith("}");
        }

    }
}
