package com.eagle.cloud.route.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 时间类操作，一律使用此文件
 * @author Administrator
 */

@Repository
public class DateUtil {


    public static String defaultDateFormat = "yyyy-MM-dd";
    public static String defaultDateTimeFormat = "yyyy-MM-dd HH:mm:ss";
    public static String defaultAllDateTimeFormat = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String YYYYMM = "yyyyMM";
    public static final String DATETIME = "yyyyMMddHHmmss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String HH_MM_SS = "HH:mm:ss";
    public static final String YYYY_MM_DD_CN = "yyyy年MM月dd日";
    public static final String DATETIME_CN = "yyyy年MM月dd日  HH时mm分ss秒";
    public static final String DATETIME_M_CN = "yyyy年MM月dd日  HH时mm分";
    public static final String DATE_SPRIT = "yyyy/MM/dd";

    /**
     * 获取系统当前13位时间
     * @return
     */
    public static long getCurrentTimeMillis(){
        return System.currentTimeMillis();
    }


//    public static Date getCurrentDate(){
//        return new Date();
//    }
    /**
     * 获取当前日期字符串
     * @return yyyy-MM-dd
     */
    public static String getCurrentDateStr(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(defaultDateFormat);
        return simpleDateFormat.format(getCurrentDate());
    }
    public static String getCurrentDateTimeStr(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(defaultDateTimeFormat);
        return simpleDateFormat.format(getCurrentDate());
    }

    public static String getCurrentAllDateTimeStr(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(defaultAllDateTimeFormat);
        return simpleDateFormat.format(getCurrentDate());
    }
    /**
     * 获取当前日期字符串
     * @return format格式的当前时间
     */
    public static String getCurrentDateStrByFormat(String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(getCurrentDate());
    }
//    /**
//     * 格式化当前时间
//     * @param pattern   格式
//     * @return
//     */
//    public static Date getCurrentDate(String pattern){
//        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//        try {
//            return sdf.parse( getCurrentDateTimeStr());
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
    /**
     * 格式化日期，返回固定格式
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return returnValue;
    }


    public static String formatDateTime(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(defaultDateTimeFormat);
        return simpleDateFormat.format(date);
    }
    public static String formatYYYY_MM_DD(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD);
        return simpleDateFormat.format(date);
    }
    /**
     * 返回时间：yyyy-MM-dd HH:mm:ss（字符串转换）
     * @param str
     * @return
     */
    public static Date paresStringToDateTime(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(defaultDateTimeFormat);
        try {
            return dateFormat.parse(str);
        } catch (Exception ex) {
            return null;
        }
    }
    /**
     * 返回时间
     * @param str   日期
     * @param pattern   日期对应格式
     * @return
     */
    public static Date paresStringToDateTime(String str, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            return dateFormat.parse(str);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Date parseDateTime(long s){
        return new Date(s);
    }

    public static int getCurrentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int getCurrentMonth(){
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    public static int getCurrentDay(){
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    public static int getCurrentMaxDay(){
        return Calendar.getInstance().getMaximum(Calendar.DAY_OF_MONTH);
    }


    /**
     * 将时间yyyy-MM-dd HH:mm:ss转换为yyyyMMdd样式的字符串
     * @return
     */
    public static String formatFullDateToString() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String a[] = sdf.format(date).split(" ");
        return a[0];
    }

    /**
     * 将时间转换为pattern样式的字符串
     * @param date   时间
     * @param pattern   日期对应格式
     * @return
     */
    public static String formatDateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String d = sdf.format(date);
        return d;
    }
    

    public static int getHour(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinute(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    public static int getMinute(long s){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDateTime(s));
        return calendar.get(Calendar.MINUTE);
    }

    public static int second2Minute(long s){
        return (int) (s/1000/60);
    }

    /**
     * 比较两个时间间间隔的分钟，不足一分钟按一分钟计算
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return
     */
    public static long getSplitMinutes(Date startDate,Date endDate) {
        int oneMinute = 1000 * 60;
        long splitMilS = endDate.getTime() - startDate.getTime();
        long count = splitMilS / oneMinute ;
        if(splitMilS % oneMinute != 0) count += 1;
        return count;
    }

    /**
     * 添加几天
     * @param date 日期
     * @param days 添加的几天
     * @return
     */
    public static Date addDays(Date date, int days){
        Calendar thisDay = new GregorianCalendar();
        thisDay.setTime(date);
        thisDay.add(Calendar.DATE, days);
        return thisDay.getTime();
    }
    
    /**
     * 添加几个月
     * @param date
     * @param months
     * @return
     */
    public static Date addMonths(Date date, int months){
    	 Calendar thisDay = new GregorianCalendar();
         thisDay.setTime(date);
         thisDay.add(Calendar.MONTH, months);
         return thisDay.getTime();
    }
    
    /**
     * 添加几年
     * @param date
     * @param years
     * @return
     */
    public static Date addYears(Date date, int years){
    	Calendar thisDay = new GregorianCalendar();
        thisDay.setTime(date);
        thisDay.add(Calendar.YEAR, years);
        return thisDay.getTime();
    }

    /**
     * 添加几分
     * @param date 日期
     * @param mun 分钟
     * @return
     */
    public static Date addMinutes(Date date, int mun){
        Calendar thisDay = new GregorianCalendar();
        thisDay.setTime(date);
        thisDay.add(Calendar.MINUTE, mun);
        return thisDay.getTime();
    }
    /**
     * 添加几小时
     * @param date 日期
     * @param mun 分钟
     * @return
     */
    public static Date addHours(Date date, int mun){
        Calendar thisDay = new GregorianCalendar();
        thisDay.setTime(date);
        thisDay.add(Calendar.HOUR, mun);
        return thisDay.getTime();
    }
    /**
     * 获取指定月天数
     * @param year
     * @param month
     * @return
     */
    public static int getMonthLastDay(int year, int month)  
    {  
        Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, year);  
        a.set(Calendar.MONTH, month - 1);  
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天  
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    }  
    
    /**
     * 返回当前的小时
     */
    public static int getHour() {
    	GregorianCalendar gcNow = new GregorianCalendar();
    	return gcNow.get(GregorianCalendar.HOUR);
    }
    
    /**
     * 返回当前的分钟
     * @return int 返回当前的分钟
     */
    public static int getMinute() {
    	GregorianCalendar gcNow = new GregorianCalendar();
    	return gcNow.get(GregorianCalendar.MINUTE);
    }
    
    /**
     * 返回当前的秒数
     * @return int 第几秒
     */
    public static int getSecond() {
    	GregorianCalendar gcNow = new GregorianCalendar();
    	return gcNow.get(GregorianCalendar.SECOND);
    }
    
	/**
     * 返回今天是本月的第几天
     */
    public static int getToDayOfMonth() {
        GregorianCalendar gcNow = new GregorianCalendar();
        return gcNow.get(GregorianCalendar.DAY_OF_MONTH);
    }
    /**
     * 返回今天是本年的第几天
     */
    public static int getToDayOfYear() {
        GregorianCalendar gcNow = new GregorianCalendar();
        return gcNow.get(GregorianCalendar.DAY_OF_YEAR);
    }
    /**
     * 返回本月第一天00:00:00
     */
    public static Date getFirstDateOfMonth() {
    	String dateStr = getCurrentDateStr().substring(0,7)+"-01 00:00:00";
        return paresStringToDateTime(dateStr);
    }
    
    /**
     * 返回本年第一天00:00:00
     */
    public static Date getFirstDateOfYear() {
    	String dateStr = getCurrentDateStr().substring(0,4)+"-01-01 00:00:00";
        return paresStringToDateTime(dateStr);
    }
    
    /**
     * 返回本日00:00:00
     */
    public static Date getFirstTimeOfDay() {
    	String dateStr = getCurrentDateStr()+" 00:00:00";
        return paresStringToDateTime(dateStr);
    }
    /**
     * 返回本周第一天00:00:00
     */
    public static Date getFirstTimeOfWeek(){
    	Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); 
    	cal.set(Calendar.HOUR_OF_DAY, 0);
    	cal.set(Calendar.MINUTE, 0);
    	cal.set(Calendar.SECOND, 0);
    	Date date = cal.getTime();
    	return date;
    	}
    
    
    public static Date convert2Date(String dateStr) {
		Date date = null;
		int length = dateStr.length();
		SimpleDateFormat sdf = null;
		if (length == 16) {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		} else if(length == 10){
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		} else if(length == 7){
			sdf = new SimpleDateFormat("yyyy-MM");
		}else{
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			date = null;
		}
		return date;
	}
    
    /**
	 * 获取小时和分钟，24小时制
	 * @param date  需要转换的日期
	 * @return 返回DateTimeStame类型的当前时间
	 * @throws java.text.ParseException
	 * 
	 */
	public static String getHourAndMinute(Date date) {
		if (date == null)
			return null;
		String dateStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		dateStr = sdf.format(date);
		return dateStr;
	}
	/**
	 * 返回两个日期之间的天数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDifferentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
       int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年            
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            
            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }
	/**
	 * 计算两个时间点之间的周数
	 */
	public static int getWeeksBy2Date(Date startDate,Date endDate){
		return (int)((startDate.getTime()-startDate.getTime())/86400000/7);
	}
	/**
	 * 计算两个时间点之间的月数
	 */
	public static int getMonthsBy2Date(Date startDate,Date endDate){
		return (int)((startDate.getTime()-startDate.getTime())/86400000/30);
	}
	/**
	 * 计算两个时间点之间的季数
	 */
	public static int getQuarterBy2Date(Date startDate,Date endDate){
		return (int)((startDate.getTime()-startDate.getTime())/86400000/90);
	}

   private static final Logger logger = LoggerFactory.getLogger(com.eagle.cloud.route.utils.DateUtil.class);

    // 用来全局控制 上一周，本周，下一周的周数变化
    private static int weeks = 0;

    private static int MaxDate;// 一月最大天数

    private static int MaxYear;// 一年最大天数

    private static String defaultDatePattern = null;
    private static String timePattern = "HH:mm";

    public static final String TS_FORMAT = com.eagle.cloud.route.utils.DateUtil.getDatePattern() + " HH:mm:ss.S";
    /** 日期格式yyyy-MM字符串常量 */
    public static final String MONTH_FORMAT = "yyyy-MM";
    /** 日期格式yyyyMM字符串常量 */
    public static final String MONTH_FORMAT_SHORT = "yyyyMM";
    /** 日期格式yyyy-MM-dd字符串常量 */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_DIT = "yyyy.MM.dd";
    /** 日期格式yyyyMMdd字符串常量 */
    public static final String DATE_FORMAT_SHORT = "yyyyMMdd";
    /** 日期格式yyyyMMddHHmm字符串常量 */
    public static final String DATE_FORMAT_LONG = "yyyyMMddHHmm";

    public static final String DATE_FORMAT_MD = "MMdd";

    public static final String DATE_FORMAT_CHN_MD = "M月dd日";

    /** 日期格式yyyy MM dd字符串常量 */
    public static final String DATE_FORMAT_BANK = "yyyy MM dd";


    /** 日期格式HH:mm:ss字符串常量 */
    public static final String HOUR_FORMAT = "HH:mm:ss";
    /** 日期格式yyyy-MM-dd HH:mm:ss字符串常量 */
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /** 日期格式yyyy-MM-dd HH:mm:ss字符串常量 */
    public static final String DATETIME_FORMAT1 = "yyyy-MM-dd 00:00:00";
    /** 日期格式yyyy-MM-dd HH:mm:ss字符串常量 */
    public static final String DATETIME_FORMAT0 = "yyyy-MM-dd 01:00:00";
    /** 日期格式yyyy-MM-dd HH:mm:ss字符串常量 */
    public static final String DATETIME_FORMAT2 = "yyyy-MM-dd 23:59:59";
    /** 格式化到小时 */
    public static final String HOUR_DATETIME_FORMAT = "yyyy-MM-dd HH";

    /** 日期格式yyyy-MM-dd HH:mm:ss字符串常量 */
    public static final String MILLISECOND_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss.S";

    /** 日期格式yyyy-MM-dd HH:mm:ss字符串常量 */
    public static final String MILLI3SECOND_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    /** 日期格式yyyy-MM-dd HH:mm:ss字符串常量 */
    public static final String yyyyMMddHHmmss_FORMAT = "yyyyMMddHHmmss";

    public static final String yyyyMMddHHmmssSSS_FORMAT = "yyyyMMddHHmmssSSS";

    /** 某天开始时分秒字符串常量 00:00:00 */
    public static final String DAY_BEGIN_STRING_HHMMSS = " 00:00:00";
    /** 某天结束时分秒字符串常量 23:59:59 */
    public static final String DAY_END_STRING_HHMMSS = " 23:59:59";
    private static SimpleDateFormat sdf_date_format = new SimpleDateFormat(DATE_FORMAT);

    private static SimpleDateFormat sdf_date_format_bank = new SimpleDateFormat(DATE_FORMAT_BANK);

    private static SimpleDateFormat sdf_hour_format = new SimpleDateFormat(HOUR_FORMAT);
    private static SimpleDateFormat sdf_datetime_format = new SimpleDateFormat(DATETIME_FORMAT);
    private static SimpleDateFormat sdf_datetime_format2 = new SimpleDateFormat(yyyyMMddHHmmss_FORMAT);
    public static long calTowDateOfDay(Date endDate,Date nowDate){
        long nd = 1000 * 24 * 60 * 60;
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        return day;
    }
    public static long calTowDateOfHour(Date endDate,Date nowDate){
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少小时
        long hour = diff % nd / nh;
        return hour;
    }
    public static long calTowDateOfMin(Date endDate,Date nowDate){
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        return min;
    }
    public static long calTowDateOfSecond(Date endDate,Date nowDate){
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少分钟
        long second = diff % nd % nh % nm / ns;
        return second;
    }
    public static String calTime(Date nowDate,Date create_time){
        String subTime="";
        long min = 0;
        long day;
        long hour = 0;
        long second = com.eagle.cloud.route.utils.DateUtil.calTowDateOfSecond(nowDate, create_time);
        min = com.eagle.cloud.route.utils.DateUtil.calTowDateOfMin(nowDate, create_time);
        hour = com.eagle.cloud.route.utils.DateUtil.calTowDateOfHour(nowDate, create_time);
        day = com.eagle.cloud.route.utils.DateUtil.calTowDateOfDay(nowDate, create_time);
        if (day > 0) {
            subTime = day + "天前";
        } else if (hour > 0) {
            subTime = hour + "小时前";
        } else if (min > 0) {
            subTime = min + "分钟前";
        }else if(second > 0) {
            subTime = second + "秒前";
        }
        return subTime;
    }
    public DateUtil() {
    }


    /**
     * 自定义格式化日期,
     * @param format
     * @param date
     * @return
     */
    public static String formatDateTime(String  format,Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.format(date.getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.getDateTime():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期及时间，以格式为：yyyy-MM-dd HH:mm:ss的日期字符串形式返回
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @return
     */
    public static String getDateTime() {
        try {
            return sdf_datetime_format.format(Calendar.getInstance().getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.getDateTime():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期，以格式为：yyyy-MM-dd的日期字符串形式返回
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @return
     */
    public static String getDate() {
        try {
            return sdf_date_format.format(Calendar.getInstance().getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.getDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期，以格式为：yyyy MM dd的日期字符串形式返回
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @return
     */
    public static String getDateWithBank() {
        try {
            return sdf_date_format_bank.format(Calendar.getInstance().getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.getDateWithBank():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前时间，以格式为：HH:mm:ss的日期字符串形式返回
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @return
     */
    public static String getTime() {
        String temp = " ";
        try {
            temp += sdf_hour_format.format(Calendar.getInstance().getTime());
            return temp;
        } catch (Exception e) {
            logger.debug("DateUtil.getTime():" + e.getMessage());
            return "";
        }
    }

    /**
     * 统计时开始日期的默认值
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @return
     */
    public static String getStartDate() {
        try {
            return getYear() + "-01-01";
        } catch (Exception e) {
            logger.debug("DateUtil.getStartDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 统计时结束日期的默认值
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @return
     */
    public static String getEndDate() {
        try {
            return getDate();
        } catch (Exception e) {
            logger.debug("DateUtil.getEndDate():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期的年份
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @return
     */
    public static String getYear() {
        try {
            return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        } catch (Exception e) {
            logger.debug("DateUtil.getYear():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器当前日期的年份
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @return
     */
    public static Date getLongAgoYear() {
        Date date = null;
        try {

            Calendar calendar = Calendar.getInstance();
            calendar.set(1900, 0, 0, 00, 00, 00);
            date = calendar.getTime();
            return date;
        } catch (Exception e) {
            logger.debug("DateUtil.getYear():" + e.getMessage());

            return null;
        }
    }



    /**
     * 获得服务器当前日期的月份
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @return
     */
    public static String getMonth() {
        try {
            java.text.DecimalFormat df = new java.text.DecimalFormat();
            df.applyPattern("00;00");
            return df.format((Calendar.getInstance().get(Calendar.MONTH) + 1));
        } catch (Exception e) {
            logger.debug("DateUtil.getMonth():" + e.getMessage());
            return "";
        }
    }

    /**
     * 获得服务器在当前月中天数
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @return
     */
    public static String getDay() {
        try {
            return String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        } catch (Exception e) {
            logger.debug("DateUtil.getDay():" + e.getMessage());
            return "";
        }
    }

    /**
     * 比较两个日期相差的天数
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @param date1
     * @param date2
     * @return
     */
    public static int getMargin(String date1, String date2) {
        int margin;
        try {
            ParsePosition pos = new ParsePosition(0);
            ParsePosition pos1 = new ParsePosition(0);
            Date dt1 = sdf_date_format.parse(date1, pos);
            Date dt2 = sdf_date_format.parse(date2, pos1);
            long l = dt1.getTime() - dt2.getTime();
            margin = (int) (l / (24 * 60 * 60 * 1000));
            return margin;
        } catch (Exception e) {
            logger.debug("DateUtil.getMargin():" + e.toString());
            return 0;
        }
    }

    /**
     * 比较两个日期相差的天数
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @param date1
     * @param date2
     * @return
     */
    public static double getDoubleMargin(String date1, String date2) {
        double margin;
        try {
            ParsePosition pos = new ParsePosition(0);
            ParsePosition pos1 = new ParsePosition(0);
            Date dt1 = sdf_datetime_format.parse(date1, pos);
            Date dt2 = sdf_datetime_format.parse(date2, pos1);
            long l = dt1.getTime() - dt2.getTime();
            margin = (l / (24 * 60 * 60 * 1000.00));
            return margin;
        } catch (Exception e) {
            logger.debug("DateUtil.getMargin():" + e.toString());
            return 0;
        }
    }

    /**
     * 比较两个日期相差的月数
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonthMargin(String date1, String date2) {
        int margin;
        try {
            margin = (Integer.parseInt(date2.substring(0, 4)) - Integer.parseInt(date1.substring(0, 4))) * 12;
            margin += (Integer.parseInt(date2.substring(4, 7).replaceAll("-0", "-")) - Integer.parseInt(date1
                    .substring(4, 7).replaceAll("-0", "-")));
            return margin;
        } catch (Exception e) {
            logger.debug("DateUtil.getMargin():" + e.toString());
            return 0;
        }
    }

    /**
     * 返回日期加X天后的日期
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @param date
     * @param i
     * @return
     */
    public static String addDay(String date, int i) {
        try {
            GregorianCalendar gCal = new GregorianCalendar(Integer.parseInt(date.substring(0, 4)),
                    Integer.parseInt(date.substring(5, 7)) - 1, Integer.parseInt(date.substring(8, 10)));
            gCal.add(GregorianCalendar.DATE, i);
            return sdf_date_format.format(gCal.getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.addDay():" + e.toString());
            return getDate();
        }
    }

    /**
     * 返回日期加X月后的日期
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @param date
     * @param i
     * @return
     */
    public static String addMonth(String date, int i) {
        try {
            GregorianCalendar gCal = new GregorianCalendar(Integer.parseInt(date.substring(0, 4)),
                    Integer.parseInt(date.substring(5, 7)) - 1, Integer.parseInt(date.substring(8, 10)));
            gCal.add(GregorianCalendar.MONTH, i);
            return sdf_date_format.format(gCal.getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.addMonth():" + e.toString());
            return getDate();
        }
    }

    /**
     * 返回日期加X年后的日期
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @param date
     * @param i
     * @return
     */
    public static String addYear(String date, int i) {
        try {
            GregorianCalendar gCal = new GregorianCalendar(Integer.parseInt(date.substring(0, 4)),
                    Integer.parseInt(date.substring(5, 7)) - 1, Integer.parseInt(date.substring(8, 10)));
            gCal.add(GregorianCalendar.YEAR, i);
            return sdf_date_format.format(gCal.getTime());
        } catch (Exception e) {
            logger.debug("DateUtil.addYear():" + e.toString());
            return "";
        }
    }

    /**
     * 返回某年某月中的最大天
     *
     * @author dylan_xu
     * @date Mar 11, 2012
    //     * @param year
    //     * @param month
     * @return
     */
    public static int getMaxDay(int iyear, int imonth) {
        int day = 0;
        try {
            if (imonth == 1 || imonth == 3 || imonth == 5 || imonth == 7 || imonth == 8 || imonth == 10 || imonth == 12) {
                day = 31;
            } else if (imonth == 4 || imonth == 6 || imonth == 9 || imonth == 11) {
                day = 30;
            } else if ((0 == (iyear % 4)) && (0 != (iyear % 100)) || (0 == (iyear % 400))) {
                day = 29;
            } else {
                day = 28;
            }
            return day;
        } catch (Exception e) {
            logger.debug("DateUtil.getMonthDay():" + e.toString());
            return 1;
        }
    }

    /**
     * 格式化日期
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @param orgDate
     * @param Type
     * @param Span
     * @return
     */
    @SuppressWarnings("static-access")
    public String rollDate(String orgDate, int Type, int Span) {
        try {
            String temp = "";
            int iyear, imonth, iday;
            int iPos = 0;
            char seperater = '-';
            if (orgDate == null || orgDate.length() < 6) {
                return "";
            }

            iPos = orgDate.indexOf(seperater);
            if (iPos > 0) {
                iyear = Integer.parseInt(orgDate.substring(0, iPos));
                temp = orgDate.substring(iPos + 1);
            } else {
                iyear = Integer.parseInt(orgDate.substring(0, 4));
                temp = orgDate.substring(4);
            }

            iPos = temp.indexOf(seperater);
            if (iPos > 0) {
                imonth = Integer.parseInt(temp.substring(0, iPos));
                temp = temp.substring(iPos + 1);
            } else {
                imonth = Integer.parseInt(temp.substring(0, 2));
                temp = temp.substring(2);
            }

            imonth--;
            if (imonth < 0 || imonth > 11) {
                imonth = 0;
            }

            iday = Integer.parseInt(temp);
            if (iday < 1 || iday > 31)
                iday = 1;

            Calendar orgcale = Calendar.getInstance();
            orgcale.set(iyear, imonth, iday);
            temp = this.rollDate(orgcale, Type, Span);
            return temp;
        } catch (Exception e) {
            return "";
        }
    }

    public static String rollDate(Calendar cal, int Type, int Span) {
        try {
            String temp = "";
            Calendar rolcale;
            rolcale = cal;
            rolcale.add(Type, Span);
            temp = sdf_date_format.format(rolcale.getTime());
            return temp;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 返回默认的日期格式
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @return
     */
    public static synchronized String getDatePattern() {
        defaultDatePattern = DATETIME_FORMAT;
        return defaultDatePattern;
    }

    /**
     * 将指定日期按默认格式进行格式代化成字符串后输出如：yyyy-MM-dd
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @param aDate
     * @return
     */
    public static final String getDate(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";
        if (aDate != null) {
            df = new SimpleDateFormat(getDatePattern());
            returnValue = df.format(aDate);
        }
        return (returnValue);
    }

    /**
     * 取得给定日期的时间字符串，格式为当前默认时间格式
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @param theTime
     * @return
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(timePattern, theTime);
    }

    /**
     * 取得当前时间的Calendar日历对象
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @return
     * @throws ParseException
     */
    public Calendar getToday() throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));
        return cal;
    }

    /**
     * 将日期类转换成指定格式的字符串形式
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @param aMask
     * @param aDate
     * @return
     */
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            logger.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }
        return (returnValue);
    }

    /**
     * 将指定的日期转换成默认格式的字符串形式
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @param aDate
     * @return
     */
    public static final String convertDateToString(Date aDate) {
        return getDateTime(getDatePattern(), aDate);
    }

    /**
     * 将日期字符串按指定格式转换成日期类型
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @param aMask
     *            指定的日期格式，如:yyyy-MM-dd
     * @param strDate
     *            待转换的日期字符串
     * @return
     * @throws ParseException
     */
    public static final Date convertStringToDate(String aMask, String strDate) throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        if (logger.isDebugEnabled()) {
            logger.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
        }
        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            logger.error("ParseException: " + pe);
            throw pe;
        }
        return (date);
    }

    public static final String formatDate(String format, String strDate) {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(format);
        if (logger.isDebugEnabled()) {
            logger.debug("converting ".concat(strDate).concat(" to date with mask ").concat(format));
        }
        try {
            date = df.parse(strDate);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return getDateTime(format,date);
    }

    /**
     * 将日期字符串按默认格式转换成日期类型
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date convertStringToDate(String strDate) throws ParseException {
        Date aDate = null;

        try {
            if (logger.isDebugEnabled()) {
                logger.debug("converting date with pattern: " + getDatePattern());
            }
            aDate = convertStringToDate(getDatePattern(), strDate);
        } catch (ParseException pe) {
            logger.error("Could not convert '" + strDate + "' to a date, throwing exception");
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }
        return aDate;
    }

    /**
     * 返回一个JAVA简单类型的日期字符串
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @return
     */
    public static String getSimpleDateFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat();
        String NDateTime = formatter.format(new Date());
        return NDateTime;
    }

    /**
     * 将指定字符串格式的日期与当前时间比较
     *
     * @author DYLAN
     * @date Feb 17, 2012
     * @param strDate
     *            需要比较时间
     * @return <p>
     *         int code
     *         <ul>
     *         <li>-1 当前时间 < 比较时间</li>
     *         <li>0 当前时间 = 比较时间</li>
     *         <li>>=1当前时间 > 比较时间</li>
     *         </ul>
     *         </p>
     */
    public static int compareToCurTime(String strDate) {
        if (StringUtils.isBlank(strDate)) {
            return -1;
        }
        Date curTime = Calendar.getInstance().getTime();
        String strCurTime = null;
        try {
            strCurTime = sdf_datetime_format.format(curTime);
        } catch (Exception e) {
            if (logger.isDebugEnabled()) {
                logger.debug("[Could not format '" + strDate + "' to a date, throwing exception:"
                        + e.getLocalizedMessage() + "]");
            }
        }
        if (StringUtils.isNotBlank(strCurTime)) {
            return strCurTime.compareTo(strDate);
        }
        return -1;
    }

    /**
     * 为查询日期添加最小时间
     *
     //     * @param 目标类型Date
     //     * @param 转换参数Date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Date addStartTime(Date param) {
        Date date = param;
        try {
            date.setHours(0);
            date.setMinutes(0);
            date.setSeconds(0);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.MILLISECOND, 0);
            return calendar.getTime();
        } catch (Exception ex) {
            return date;
        }
    }

    /**
     * 为查询日期添加最大时间
     *
     //     * @param 目标类型Date
     //     * @param 转换参数Date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Date addEndTime(Date param) {
        Date date = param;
        try {
            date.setHours(23);
            date.setMinutes(59);
            date.setSeconds(59);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.MILLISECOND, 999);
            return calendar.getTime();
        } catch (Exception ex) {
            return date;
        }
    }

    /**
     * 返回系统现在年份中指定月份的天数
     *
     //     * @param 月份month
     * @return 指定月的总天数
     */
    @SuppressWarnings("deprecation")
    public static String getMonthLastDay(int month) {
        Date date = new Date();
        int[][] day = { { 0, 30, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
                { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };
        int year = date.getYear() + 1900;
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return day[1][month] + "";
        } else {
            return day[0][month] + "";
        }
    }

//    /**
//     * 返回指定年份中指定月份的天数
//     *
//     //     * @param 年份year
//     //     * @param 月份month
//     * @return 指定月的总天数
//     */
//    public static String getMonthLastDay(int year, int month) {
//        int[][] day = { { 0, 30, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
//                { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };
//        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
//            return day[1][month] + "";
//        } else {
//            return day[0][month] + "";
//        }
//    }

    /**
     * 判断是平年还是闰年
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @param year
     * @return
     */
    public static boolean isLeapyear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400) == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 取得当前时间的日戳
     *
     * @author dylan_xu
     * @date Mar 11, 2012
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String getTimestamp() {
        Date date = Calendar.getInstance().getTime();
        String timestamp = "" + (date.getYear() + 1900) + date.getMonth() + date.getDate() + date.getMinutes()
                + date.getSeconds() + date.getTime();
        return timestamp;
    }

    /**
     * 取得指定时间的日戳
     *
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String getTimestamp(Date date) {
        String timestamp = "" + (date.getYear() + 1900) + date.getMonth() + date.getDate() + date.getMinutes()
                + date.getSeconds() + date.getTime();
        return timestamp;
    }

    /**
     * @Title: getStartTime
     * @Description: 取某一天的最开始的时分秒
     * @param param
     * @return 参数说明
     * @return String 返回类型
     */
    public static String getStartTime(Date param) {
        return sdf_datetime_format.format(addStartTime(param));
    }

    public static String getStartTime2(Date param) {
        return sdf_datetime_format2.format(addStartTime(param));
    }

    /**
     * @Title: getEndTime
     * @Description: 取某一天的结束时分秒
     * @param param
     * @return 参数说明
     * @return String 返回类型
     */
    public static String getEndTime(Date param) {
        return sdf_datetime_format.format(addEndTime(param));
    }

    public static String getEndTime2(Date param) {
        return sdf_datetime_format2.format(addEndTime(param));
    }

    /**
     * 获得当前时间，格式yyyy-MM-dd hh:mm:ss
     *
     //     * @param format
     * @return
     */
    public static String getCurrentDate() {
        return getCurrentDate(DATETIME_FORMAT);
    }

    /**
     * 获得当前时间，格式自定义
     *
     * @param format
     * @return
     */
    public static String getCurrentDate(String format) {
        if (StringUtils.isBlank(format)) {
            format = DATETIME_FORMAT;
        }
        Calendar day = Calendar.getInstance();
        day.add(Calendar.DATE, 0);
        SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"
        String date = sdf.format(day.getTime());
        return date;
    }

    /**
     * 日期转字符串
     *
     * @param date
     * @return
     */
    public static String date2String(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
        return sdf.format(date);
    }

    /**
     * 获得昨天时间
     *
     * @return
     */
    public static String getYesterdayDate() {
        return getYesterdayDate(DATETIME_FORMAT);
    }

    /**
     * 获得昨天时间，格式自定义
     *
     * @param format
     * @return
     */
    public static String getYesterdayDate(String format) {
        if ("".equals(format)) {
            format = DATETIME_FORMAT;
        }
        Calendar day = Calendar.getInstance();
        day.add(Calendar.DATE, -1);
        SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"
        String date = sdf.format(day.getTime());
        return date;
    }

    /**
     //     * @param date1
     //     *            需要比较的时间 不能为空(null),需要正确的日期格式 ,如：2009-09-12
     //     * @param date2
     //     *            被比较的时间 为空(null)则为当前时间
     * @param stype
     *            返回值类型 0为多少天，1为多少个月，2为多少年
     * @return 举例： compareDate("2009-09-12", null, 0); //比较天
     *         compareDate("2009-09-12", null, 1);//比较月
     *         compareDate("2009-09-12", null, 2);//比较年
     */
    public static int compareDate(String startDay, String endDay, int stype) {
        int n = 0;
        String formatStyle = stype == 1 ? "yyyy-MM" : "yyyy-MM-dd";

        endDay = endDay == null ? getCurrentDate("yyyy-MM-dd") : endDay;

        DateFormat df = new SimpleDateFormat(formatStyle);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(startDay));
            c2.setTime(df.parse(endDay));
        } catch (Exception e3) {
            System.out.println("wrong occured");
        }
        // List list = new ArrayList();
        while (!c1.after(c2)) { // 循环对比，直到相等，n 就是所要的结果
            // list.add(df.format(c1.getTime())); // 这里可以把间隔的日期存到数组中 打印出来
            n++;
            if (stype == 1) {
                c1.add(Calendar.MONTH, 1); // 比较月份，月份+1
            } else {
                c1.add(Calendar.DATE, 1); // 比较天数，日期+1
            }
        }
        n = n - 1;
        if (stype == 2) {
            n = (int) n / 365;
        }
        // System.out.println(startDay+" -- "+endDay+" 相差多少"+u[stype]+":"+n);
        return n;
    }

    /**
     * 判断时间是否符合时间格式
     */
    public static boolean isDate(String date, String dateFormat) {
        if (date != null) {
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            format.setLenient(false);
            try {
                format.format(format.parse(date));
            } catch (ParseException e) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * 实现给定某日期，判断是星期几 date:必须yyyy-MM-dd格式
     */
    public static String getWeekday(String date) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdw = new SimpleDateFormat("E");
        Date d = null;
        try {
            d = sd.parse(date);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return sdw.format(d);
    }

    /**
     * method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
     *
     * @param dateString
     *            需要转换为timestamp的字符串
     * @return dataTime timestamp
     */
    public final static Timestamp string2Time(String dateString) {
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);// 设定格式
        dateFormat.setLenient(false);
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        // java.sql.Timestamp dateTime = new java.sql.Timestamp(date.getTime());
        return new Timestamp(date.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
    }

    /**
     * method 将字符串类型的日期转换为一个Date（java.sql.Date）
     *
     * @param dateString
     *            需要转换为Date的字符串
     * @return dataTime Date
     */
    public final static java.sql.Date string2Date(String dateString) {
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        dateFormat.setLenient(false);
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        // java.sql.Date dateTime = new java.sql.Date(date.getTime());// sql类型
        return new java.sql.Date(date.getTime());
    }


    /**
     * @Title: string2Date
     * @Description:
     * @param dateString
     * @param df
     * @return    参数说明
     * @return java.util.Date    返回类型
     */
    public final static Date string2Date(String dateString,String df) {
        DateFormat dateFormat = new SimpleDateFormat(df, Locale.SIMPLIFIED_CHINESE);
        dateFormat.setLenient(false);
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return date;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int daysBetween(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 取得当前日期N天后的日期
     *
     //     * @param date
     * @param days
     * @return
     */
    public static Date addDays(int days) {
        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DAY_OF_MONTH, days);

        return cal.getTime();
    }

    /**
     * 取得指定日期N天后的日期
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addXDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.DAY_OF_MONTH, days);

        return cal.getTime();
    }

    // 记录考勤， 记录迟到、早退时间
    public static String getState() {
        String state = "正常";
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date d = new Date();
        try {
            Date d1 = df.parse("08:00:00");
            Date d2 = df.parse(df.format(d));
            Date d3 = df.parse("17:30:00");

            int t1 = (int) d1.getTime();
            int t2 = (int) d2.getTime();
            int t3 = (int) d3.getTime();
            if (t2 < t1) {

                long between = (t1 - t2) / 1000;// 除以1000是为了转换成秒
                long hour1 = between % (24 * 3600) / 3600;
                long minute1 = between % 3600 / 60;

                state = "迟到 ：" + hour1 + "时" + minute1 + "分";

            } else if (t2 < t3) {
                long between = (t3 - t2) / 1000;// 除以1000是为了转换成秒
                long hour1 = between % (24 * 3600) / 3600;
                long minute1 = between % 3600 / 60;
                state = "早退 ：" + hour1 + "时" + minute1 + "分";
            }
            return state;
        } catch (Exception e) {
            return state;
        }
    }

    /**
     * 得到二个日期间的间隔天数
     */
    public static String getTwoDay(String sj1, String sj2) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        long day = 0;
        try {
            Date date = myFormatter.parse(sj1);
            Date mydate = myFormatter.parse(sj2);
            day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            return "";
        }
        return day + "";
    }

    /**
     * 根据一个日期，返回是星期几的字符串
     *
     * @param sdate
     * @return
     */
    public static String getWeek(String sdate) {
        // 再转换为时间
        Date date = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // int hour=c.get(Calendar.DAY_OF_WEEK);
        // hour中存的就是星期几了，其范围 1~7
        // 1=星期日 7=星期六，其他类推
        return new SimpleDateFormat("EEEE").format(c.getTime());
    }

    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 两个时间之间的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDays(String date1, String date2) {
        if (date1 == null || date1.equals(""))
            return 0;
        if (date2 == null || date2.equals(""))
            return 0;
        // 转换为标准时间
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date mydate = null;
        try {
            date = myFormatter.parse(date1);
            mydate = myFormatter.parse(date2);
        } catch (Exception e) {
        }
        long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }

    // 计算当月最后一天,返回字符串
    public static String getDefaultDay() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
        lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天

        str = sdf.format(lastDate.getTime());
        return str;
    }

    // 计算当月最后一天,返回字符串
    public static String getLastDayTimeOfMonth() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);

        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
        lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
        lastDate.set(Calendar.HOUR_OF_DAY, 23);
        lastDate.set(Calendar.MINUTE, 59);
        lastDate.set(Calendar.SECOND, 59);

        str = sdf.format(lastDate.getTime());
        return str;
    }

    // 计算当月最后一天,返回字符串
    public static String getLastDayTimeOfMonth2() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat(yyyyMMddHHmmss_FORMAT);

        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
        lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
        lastDate.set(Calendar.HOUR_OF_DAY, 23);
        lastDate.set(Calendar.MINUTE, 59);
        lastDate.set(Calendar.SECOND, 59);

        str = sdf.format(lastDate.getTime());
        return str;
    }

    // 上月第一天
    public static String getPreviousMonthFirst() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号
        // lastDate.add(Calendar.DATE,-1);//减去一天，变为当月最后一天

        str = sdf.format(lastDate.getTime());
        return str;
    }

    // 获取当月第一天
    public static String getFirstDayOfMonth() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String getFirstDayTimeOfMonth() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.set(Calendar.HOUR_OF_DAY, 0);
        lastDate.set(Calendar.MINUTE, 0);
        lastDate.set(Calendar.SECOND, 0);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String getFirstDayTimeOfMonth2() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat(yyyyMMddHHmmss_FORMAT);
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.set(Calendar.HOUR_OF_DAY, 0);
        lastDate.set(Calendar.MINUTE, 0);
        lastDate.set(Calendar.SECOND, 0);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    // 获得本周星期日的日期
    public static String getCurrentWeekday() {
        weeks = 0;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
        Date monday = currentDate.getTime();

        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    // 获取当天时间
    public static String getNowTime(String dateformat) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);// 可以方便地修改日期格式
        String hehe = dateFormat.format(now);
        return hehe;
    }

    // 获得当前日期与本周日相差的天数
    public static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        if (dayOfWeek == 1) {
            return 0;
        } else {
            return 1 - dayOfWeek;
        }
    }

    // 获得本周一的日期
    public static String getMondayOFWeek() {
        weeks = 0;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();

        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    // 获得相应周的周六的日期
    public static String getSaturday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks + 6);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    // 获得上周星期日的日期
    public static String getPreviousWeekSunday() {
        weeks = 0;
        weeks--;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + weeks);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    // 获得上周星期一的日期
    public static String getPreviousWeekday() {
        weeks--;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    // 获得下周星期一的日期
    public static String getNextMonday() {
        weeks++;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    // 获得下周星期日的日期
    public static String getNextSunday() {

        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 + 6);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }

    public static int getMonthPlus() {
        Calendar cd = Calendar.getInstance();
        int monthOfNumber = cd.get(Calendar.DAY_OF_MONTH);
        cd.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        cd.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
        MaxDate = cd.get(Calendar.DATE);
        if (monthOfNumber == 1) {
            return -MaxDate;
        } else {
            return 1 - monthOfNumber;
        }
    }

    // 获得上月最后一天的日期
    public static String getPreviousMonthEnd() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, -1);// 减一个月
        lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
        str = sdf.format(lastDate.getTime());
        return str;
    }

    // 获得下个月第一天的日期
    public static String getNextMonthFirst() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, 1);// 减一个月
        lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        str = sdf.format(lastDate.getTime());
        return str;
    }

    // 获得下个月最后一天的日期
    public static String getNextMonthEnd() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, 1);// 加一个月
        lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
        str = sdf.format(lastDate.getTime());
        return str;
    }

    // 获得明年最后一天的日期
    public static String getNextYearEnd() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.YEAR, 1);// 加一个年
        lastDate.set(Calendar.DAY_OF_YEAR, 1);
        lastDate.roll(Calendar.DAY_OF_YEAR, -1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    // 获得明年第一天的日期
    public static String getNextYearFirst() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.YEAR, 1);// 加一个年
        lastDate.set(Calendar.DAY_OF_YEAR, 1);
        str = sdf.format(lastDate.getTime());
        return str;

    }

    // 获得本年有多少天
    public static int getMaxYear() {
        Calendar cd = Calendar.getInstance();
        cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天
        cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天。
        int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
        return MaxYear;
    }

    public static int getYearPlus() {
        Calendar cd = Calendar.getInstance();
        int yearOfNumber = cd.get(Calendar.DAY_OF_YEAR);// 获得当天是一年中的第几天
        cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天
        cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天。
        int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
        if (yearOfNumber == 1) {
            return -MaxYear;
        } else {
            return 1 - yearOfNumber;
        }
    }

    // 获得本年第一天的日期
    public static String getCurrentYearFirst() {
        int yearPlus = getYearPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, yearPlus);
        Date yearDay = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preYearDay = df.format(yearDay);
        return preYearDay;
    }

    // 获得本年最后一天的日期 *
    public static String getCurrentYearEnd() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
        String years = dateFormat.format(date);
        return years + "-12-31";
    }

    // 获得上年第一天的日期 *
    public static String getPreviousYearFirst() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
        String years = dateFormat.format(date);
        int years_value = Integer.parseInt(years);
        years_value--;
        return years_value + "-1-1";
    }

    // 获得上年最后一天的日期
    public static String getPreviousYearEnd() {
        weeks--;
        int yearPlus = getYearPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, yearPlus + MaxYear * weeks + (MaxYear - 1));
        Date yearDay = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preYearDay = df.format(yearDay);
        getThisSeasonTime(11);
        return preYearDay;
    }

    // 获得本季度
    public static String getThisSeasonTime(int month) {
        int array[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
        int season = 1;
        if (month >= 1 && month <= 3) {
            season = 1;
        }
        if (month >= 4 && month <= 6) {
            season = 2;
        }
        if (month >= 7 && month <= 9) {
            season = 3;
        }
        if (month >= 10 && month <= 12) {
            season = 4;
        }
        int start_month = array[season - 1][0];
        int end_month = array[season - 1][2];

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
        String years = dateFormat.format(date);
        int years_value = Integer.parseInt(years);

        int start_days = 1;// years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month);
        int end_days = getLastDayOfMonth(years_value, end_month);
        String seasonDate = years_value + "-" + start_month + "-" + start_days + ";" + years_value + "-" + end_month
                + "-" + end_days;
        return seasonDate;

    }

    /**
     * 获取某年某月的最后一天
     *
     * @param year
     *            年
     * @param month
     *            月
     * @return 最后一天
     */
    public static int getLastDayOfMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        }
        return 0;
    }

    /**
     * 是否闰年
     *
     * @param year
     *            年
     * @return
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     *
     * @Title: getNowTimeStampTime
     * @Description: 获取当前时间（TimeStamp类型的）
     * @return
     * @return Timestamp
     * @throws
     */
    public static Timestamp getNowTimeStampTime() {
        Timestamp time = new Timestamp(System.currentTimeMillis());

        return time;
    }

    /**
     *
     * @Title: calcTwoTimeDifferInOneHour
     * @Description: 计算最后一次访问时间距离现在时间是不是在1小时之内。
     * @param lastestVisitTime
     *            最后一次访问的毫秒时间
     * @param nowTime
     *            现在的毫秒时间
     * @return void
     * @throws
     */
    public static boolean calcTwoTimeDifferInOneHour(Long lastestVisitTime, Long nowTime) {
        long differ = nowTime - lastestVisitTime;// 两个时间的毫秒差

        long differHour = differ / (60 * 60 * 1000);

        if (differHour < 1) {
            return true;
        }

        return false;
    }

    /**
     * @Title: compareDate
     * @Description: 比较时间大小（第一个时间在第二个时间之前返回-1；第一个时间在第二个时间之后返回1，相同返回0）
     * @param dt1
     * @param dt2
     * @return    参数说明
     * @return int    返回类型
     */
    public static int compareDate(Date dt1, Date dt2) {
        try {
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    public static String getPreviousMonth(String dateFormat) {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, -1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

}
