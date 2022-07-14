package com.xiaomi.utils;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class DateConverterUtils {

	
	public static void convert(){
		
		
		//注册日期转化器
		 //创建对象
		 DateConverter converter=new DateConverter();
		 //设置时间格式
		 converter.setPatterns(new String[]{"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd","yyyy/MM/dd","yyyy年MM月dd日","yyyy.MM.dd"});
		 //注册
		 ConvertUtils.register(converter, java.util.Date.class);
		 
	}
}
