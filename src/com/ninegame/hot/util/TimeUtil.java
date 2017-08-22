package com.ninegame.hot.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtil {

    public final static TimeZone TIME_ZONE_BEIJIN = TimeZone.getTimeZone("GMT-8:00");

    public static Calendar getNowCalendar(){
        return Calendar.getInstance();
    }

    public static long getNowTime(){
        return System.currentTimeMillis();
    }


    public static long getTimeZoneTime(){
        return TimeZone.getDefault().getRawOffset();
    }

    public static long parseTime(String timeStr){
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sf.parse(timeStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal.getTimeInMillis();
        }catch (Exception e){
            return 0;
        }
    }

    public static long parseTime(String timeStr, String format){
        try {
            SimpleDateFormat sf = new SimpleDateFormat(format);
            Date date = sf.parse(timeStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal.getTimeInMillis();
        }catch (Exception e){
            return 0;
        }
    }

    public static Date long2Date(long time){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        return cal.getTime();
    }

    public static String formatDate(Date date){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(date);
    }

    public static String formatDate(Date date, String format){
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(date);
    }

    /**
     * 今日的时间字符串转 long
     * @param nowTime
     * @param timeStr
     * @return
     */
    public static long getTodayTime(long nowTime, String timeStr){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(nowTime);
        String timeArr[] = timeStr.split(":");
        int h = Integer.parseInt(timeArr[0]);
        int m = Integer.parseInt(timeArr[1]);
        int s = Integer.parseInt(timeArr[2]);
        cal.set(Calendar.HOUR_OF_DAY, h);
        cal.set(Calendar.MINUTE, m);
        cal.set(Calendar.SECOND, s);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    public static long getTodayHourTime(long nowTime, int hour){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(nowTime);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    public static long getNextDayHourTime(long nowTime, int hour){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(nowTime);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    /**
     * 判断两个时间是否在同一天
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isInSameDay(long time1, long time2){
        long dayTimeMiS = 60 * 60 * 24 * 1000;
        final long interval = time1 - time2;
        return interval < dayTimeMiS && interval > -1L * dayTimeMiS && toDay(time1, dayTimeMiS) == toDay(time2, dayTimeMiS);
    }

    private static long toDay(long millis, long dayTimeMiS) {
        return (millis + TimeZone.getDefault().getOffset(millis)) / dayTimeMiS;
    }

    /**
     * 取得两个时间的相差天数
     * @param time1
     * @param time2
     * @return
     */
    public static int getDays(long time1, long time2){
        time1 = time1 + getTimeZoneTime();
        time1 = time1 - time1 % (24 * 3600 * 1000);
        time2 = time2 + getTimeZoneTime();
        time2 = time2 - time2 % (24 * 3600 * 1000);
        long time = time1 - time2;
        if(time < 0){
            time = -time;
        }
        int cnt = (int)(time / (24 * 3600 * 1000));
        return cnt;
    }

    /**
     * 取得时间的小时数
     * @param time
     * @return
     */
    public static int getTimeHour(long time){
    	int hour = (int)((TimeUtil.getTimeZoneTime() + time) % (3600 * 24 * 1000) /(3600 * 1000));
    	return hour;
    }
    
    /**
     * 获取距离明日0点还剩多少时间
     * @return
     */
    public static long getTodayRemain(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTimeInMillis() - System.currentTimeMillis();
    }

    /**
     * 取得今天的开始时间
     * @return
     */
    public static long getTodayBeginTime(long nowTime){
        long tmp = getTimeZoneTime();
        nowTime += tmp;
        nowTime = nowTime - nowTime % (3600 * 24 * 1000);
        return nowTime - tmp;
    }
}
