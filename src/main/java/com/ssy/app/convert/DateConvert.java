package com.ssy.app.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * 时间转换器
 * 将请求的固定格式的时间字符串转换为Date类型的数据
 * @author haoze_yu
 *
 */
public class DateConvert implements Converter<String, Date>{

	@Override
	public Date convert(String text) {
		if(text == null || text.trim().isEmpty()){
			return null;
		}
		
		SimpleDateFormat[] sdfs = new SimpleDateFormat[]{
				//在此处增加新的需要转换的时间格式
				/**时间格式**/
				new SimpleDateFormat("yyyy-MM-dd"),
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
				new SimpleDateFormat("yyyyMMdd"),
				new SimpleDateFormat("yyyy年MM月dd日")
		};
		
		for (SimpleDateFormat sdf : sdfs) {
			try {
				return sdf.parse(text);
			} catch (ParseException e) {
				//	e.printStackTrace();
				continue;
			}
		}
		return null;
	}

}
