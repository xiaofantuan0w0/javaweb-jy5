package com.itdr.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesGetUtil {
    public static String getValue(String key){
        Properties ps = new Properties();
        try {
            InputStreamReader inr = new InputStreamReader(PropertiesGetUtil.class.getClassLoader().
                getResourceAsStream("const.properties"),"UTF-8");
          ps.load(inr);
        }catch (Exception e){
            e.printStackTrace();
        }
        String value = ps.getProperty(key);
        return value;
    }
    public static Integer getstatus(String key){
        return Integer.parseInt(PropertiesGetUtil.getValue(key));
    }
    public static void main(String[] args) {

        System.out.println(PropertiesGetUtil.getValue("USER_PARAMETER_MSG"));

}}
