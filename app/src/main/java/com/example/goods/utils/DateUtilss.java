package com.example.goods.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
//时间工具类
public class DateUtilss {
    public static Long getDateToTime(String date,String format){
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINESE);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        Date _date = null;
        try {
            _date = sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _date.getTime()/1000;
    }

    public static String getStandardDate(Long publish) {
        String temp = "";
        try {
            long now = System.currentTimeMillis() / 1000;
            long diff = now - publish;
            long months = diff / (60 * 60 * 24*30);
            long days = diff / (60 * 60 * 24);
            long hours = (diff - days * (60 * 60 * 24)) / (60 * 60);
            long minutes = (diff - days * (60 * 60 * 24) - hours * (60 * 60)) / 60;
            if (months > 0) {
                temp = months + "月前";
            } else if (days > 0) {
                temp = days + "天前";
            } else if (hours > 0) {
                temp = hours + "小时前";
            } else {
                temp = minutes + "分钟前";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    //秒转yyyy-MM-dd
    public static String getDateFromSeconds(String seconds){
        if(seconds==null)
            return " ";
        else{
            Date date=new Date();
            try{
                date.setTime(Long.parseLong(seconds)*1000);
            }catch(NumberFormatException nfe){

            }
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        }
    }


    //yyyy-MM-dd转秒数
    public static long getSecondsFromDate(String expireDate){
        if(expireDate==null||expireDate.trim().equals(""))
            return 0;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try{
            date=sdf.parse(expireDate);
            return (long)(date.getTime()/1000);
        }
        catch(ParseException e)
        {
            e.printStackTrace();
            return 0L;
        }
    }
}
