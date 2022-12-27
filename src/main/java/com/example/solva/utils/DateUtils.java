package com.example.solva.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
    private final static int GTC00TOGTC06= 21600;
    public static Date TimestampToDate(Long timestamp) throws ParseException {
        Timestamp timestamp1=new Timestamp(timestamp+GTC00TOGTC06);
        String simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy").format(timestamp1);
         return new SimpleDateFormat("dd/MM/yyyy").parse(simpleDateFormat);
    }

    public static Date LocalDateToSimpleDateFormat(LocalDateTime localDateTime) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.parse(localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
    public static int dateEquals(Date date, Date date1){
        return date.compareTo(date1);
    }




}
