package com.atguigu2.interceptor;


import com.atguigu2.utils.ETLUtil;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.util.ArrayList;
import java.util.List;

public class ETLInterceptor implements Interceptor {

    private List<Event> list = new ArrayList<>();

    @Override
    public void initialize() {

    }

    @Override
    public Event intercept(Event event) {

        String body = new String(event.getBody());

        boolean flag;

        if(body.contains("start")){

            flag = ETLUtil.etlStart(body);

        }else{

            flag = ETLUtil.etlEvent(body);
        }

        if (flag){
            return event;
        }else{
            return null;
        }

    }

    @Override
    public List<Event> intercept(List<Event> events) {

        list.clear();

        for (Event event : events){

            Event etlEvent = intercept(event);

            if(etlEvent != null){
                list.add(etlEvent);
            }
        }

        return list;

    }

    @Override
    public void close() {

    }

    public static class Builder implements Interceptor.Builder{

        @Override
        public Interceptor build() {
            return new ETLInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }
}
