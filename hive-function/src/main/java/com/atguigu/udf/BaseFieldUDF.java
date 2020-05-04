package com.atguigu.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseFieldUDF extends UDF{

    public String evaluate(String line,String key){

        String[] fields = line.split("\\|");

        if("st".equals(key)){
            return fields[0];
        }

        try {

            JSONObject jsonObject = new JSONObject(fields[1]);

            if("et".equals(key)){
                if(jsonObject.has(key)){
                    return jsonObject.getString(key);
                }else{
                    return "";
                }
            }

            JSONObject cm = jsonObject.getJSONObject("cm");

            return cm.getString(key);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }
}
