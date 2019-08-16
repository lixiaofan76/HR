package com.qfedu.hr.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * Created by   Intellif Idea 2019.07
 * Author:  Wang Yun
 * Date:    2019-07-04
 * Time:    15:16
 */
public class MyBeanUtils {

    private MyBeanUtils(){}

    public static void populate(Object bean, Map<String,String[]> properties){

        try {
            //处理时间格式
            DateConverter dateConverter = new DateConverter();
            //设置日期格式
            dateConverter.setPatterns(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"});
            //注册格式
            ConvertUtils.register(dateConverter, Date.class);
            //封装数据
            BeanUtils.populate(bean, properties);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }



}
