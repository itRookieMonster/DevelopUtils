package com.bland.developutils.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by fan on 2016/6/23.
 */
public class TimeUtils {

    static Calendar c1 = Calendar.getInstance();
    static Calendar c2 = Calendar.getInstance();

    //毫秒转秒
    public static String long2String(long time) {

        //毫秒转秒
        int sec = (int) time / 1000;
        int min = sec / 60;    //分钟
        sec = sec % 60;        //秒
        if (min < 10) {    //分钟补0
            if (sec < 10) {    //秒补0
                return "0" + min + ":0" + sec;
            } else {
                return "0" + min + ":" + sec;
            }
        } else {
            if (sec < 10) {    //秒补0
                return min + ":0" + sec;
            } else {
                return min + ":" + sec;
            }
        }

    }

    /**
     * 返回当前时间的格式为 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(System.currentTimeMillis());
    }

    public static String datePickerResultFormat(int year, int month, int day) {
        StringBuilder sb = new StringBuilder();
        sb.append(year).append("-");
        if (month + 1 < 10) {
            sb.append("0").append(month + 1).append("-");

        } else {
            sb.append(month + 1).append("-");

        }
        if (day < 10) {
            sb.append("0").append(day);
        } else {
            sb.append(day);

        }


        return sb.toString();

    }

    public static boolean compareTime(String startTime, String endTime) {

        if ("".equals(startTime) || "".equals(endTime)) {
            return true;
        }


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date start;
        Date end;
        try {
            start = format.parse(startTime);
            end = format.parse(endTime);
            return end.getTime() - start.getTime() >= 0;

        } catch (ParseException e) {
            e.printStackTrace();
        }


        return false;


    }

    public static String formatDate8(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(date);
    }

    public static String formatDate12(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA).format(date);
    }

    public static String formatDateFull(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(date);
    }

    public static Date parseDate8(String dateString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).parse(dateString);
    }

    public static String parseDateString(String dateString, boolean onlyTime) throws ParseException {
        if (dateString != null) {
            Date parse = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CHINA).parse(dateString);
            if (onlyTime) {
                return new SimpleDateFormat("a HH:mm", Locale.CHINA).format(parse);
            }
            return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(parse);
        }
        return null;
    }

    public static String parseString(String dateString, boolean onlyTime) {
        if (dateString != null) {
            try {
                Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(dateString);
                if (onlyTime) {
                    return new SimpleDateFormat("HH:mm:ss", Locale.CHINA).format(parse);
                }
                return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(parse);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static boolean isToday(long time) {
        return allTheSame(time, System.currentTimeMillis());
    }

    public static boolean allTheSame(long time1, long time2) {

        return isSameYear(time1, time2) && isSameMonth(time1, time2) && isSameDay(time1, time2);

    }

    public static boolean isSameYear(long time1, long time2) {

        c1.setTimeInMillis(time1);
        c2.setTimeInMillis(time2);

        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR);
    }

    public static boolean isSameMonth(long time1, long time2) {
        c1.setTimeInMillis(time1);
        c2.setTimeInMillis(time2);
        return c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH);
    }

    public static boolean isSameDay(long time1, long time2) {
        c1.setTimeInMillis(time1);
        c2.setTimeInMillis(time2);
        return c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH);
    }

    public static Date getYouWant(long time, int interval) {
        c1.setTimeInMillis(time);
        c1.add(Calendar.DAY_OF_MONTH, interval);
        return c1.getTime();
    }

}
