package cn.shi.leasplat.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Title:        DateUtil
 * 
 * @Description:  时间转换类
 * 
 * @author        石强
 * 
 * @Date          2017年2月2日
 * 
 * @version       1.0
 * 
 */
public class DateUtil {
	
	/**
	 * 获取当前日期-字符串
	 * @return 年月日
	 */
	public static String getToDate(){
		SimpleDateFormat ss = new SimpleDateFormat("yyyyMMdd");
		return ss.format(new Date());
	}
	
	/**
	 * 获取当前日期-字符串
	 * @return 年月日
	 */
	public static String getToDateLine(){
		SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");
		return ss.format(new Date());
	}

	/**
	 * 获取日期-字符串
	 * @return 年月日
	 */
	public static String getToDateUK(String str) throws ParseException{
		SimpleDateFormat sdf1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
		Date date = sdf1.parse(str);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 获取日期-字符串
	 * @param date 日期
	 * @return 年月日
	 */
	public static String getDate(Date date){
		SimpleDateFormat ss = new SimpleDateFormat("yyyyMMdd");
		return ss.format(date);
	}
	
	/**
	 * 获取日期-字符串
	 * @param date 日期
	 * @return 年-月-日
	 */
	public static String getDateLine(Date date){
		SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");
		return ss.format(date);
	}

	/**
	 * 获取日期-字符串
	 * @param date 日期
	 * @return 年-月-日
	 */
	public static String getDateStr(Date date){
		SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return ss.format(date);
	}
	
	/**
	 * 获取时间-字符串
	 * @return 时:分:秒
	 */
	public static String getTime(){
		SimpleDateFormat ss = new SimpleDateFormat("HH:mm:ss");
		return ss.format(new Date());
	}
	
	/**
	 * 获取日期时间-字符串
	 * @return 年-月-日 时:分:秒
	 */
	public static String getDateTime(){
		SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return ss.format(new Date());
	}
	
	/**
	 * 比较日期大小 并返回日期较大的-字符串
	 * @param date1 日期1
	 * @param date2 日期2
	 * @return 年月日
	 */
	public static String equalsDate(Date date1,Date date2){
		SimpleDateFormat ss = new SimpleDateFormat("yyyyMMdd");
		String dateStr1 = ss.format(date1);
		String dateStr2 = ss.format(date2);
		if(Integer.parseInt(dateStr1) - Integer.parseInt(dateStr2) > 0){
			return dateStr1;
		}
		return dateStr2;
	}
	
	
	/**
	 * 两日期做差 并返回天数-字符串
	 * @param date1 日期1
	 * @param date2 日期2
	 * @return 天数
	 * @throws ParseException
	 */
	public static String mistakeDate(String date1,Date date2) throws ParseException{
		SimpleDateFormat ss = new SimpleDateFormat("yyyyMMdd");
		String dateStr2 = ss.format(date2);
		long dateOne = ss.parse(date1).getTime();
		long dateTwo = ss.parse(dateStr2).getTime();
		int days = (int) ((dateTwo - dateOne)/(1000*60*60*24));	
		return Math.abs(days)+"";
	}

	/**
	 *	将格式化的字符串转换成时间戳
	 * @param dateTime
	 * @return 时间戳
	 * @throws ParseException
	 */
	public static Long getLongTime(String dateTime) throws ParseException{
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(dateTime);
		return date.getTime();
	}

	/*public static void main(String args[]) throws ParseException {
		System.out.println(DateUtil.getToDateUK(""));
	}*/
}

