package kr.hs.dimigo.meal.util;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateGenerator {

    String currentDate;
    String resultDate;
    Date date;

    Calendar calendar = Calendar.getInstance();

    public DateGenerator() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        currentDate = simpleDateFormat.format(calendar.getTime());
    }

    public String getToday() {
        return currentDate;
    }

    public String getYesterday() {
        currentDate = String.valueOf((Integer.parseInt(currentDate) - 1));
        return currentDate;
    }

    public String getTomorrow() {
        currentDate = String.valueOf((Integer.parseInt(currentDate) + 1));
        return currentDate;
    }

    public String dateTitleProvider(String dates) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            date = dateFormat.parse(dates);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        resultDate = checkYear(dates) + "년 " + checkMonth(dates) + "월 " + checkDay(dates) + "일 " + checkWeekday(date) + "요일";
//        resultDate = checkWeekday(date) + ", " + checkMonth(dates) + " " + checkDay(dates) + ", " + checkYear(dates);
        return resultDate;
    }

    public int lampSelector() {
        int result;
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("kkmm");

        result = Integer.parseInt(dateFormat.format(date));

        if(result <= 815) {
            return 0;
        } else if(result >=816 && result <= 1340) {
            return 1;
        } else if(result >=1341 && result <= 1920) {
            return 2;
        } else if(result >= 1921 && result <= 2140) {
            return 3;
        } else {
            return 0;
        }
    }

    private String checkWeekday(Date date) {
        String weekday = null;

        calendar.setTime(date);

        switch (calendar.get(calendar.DAY_OF_WEEK)) {
            case 1:
                weekday = "일";
                break;
            case 2:
                weekday = "월";
                break;
            case 3:
                weekday = "화";
                break;
            case 4:
                weekday = "수";
                break;
            case 5:
                weekday = "목";
                break;
            case 6:
                weekday = "금";
                break;
            case 7:
                weekday = "토";
                break;
            default:
                break;
        }

        return weekday;
    }

    private String checkMonth(String dates) {
        String month = String.valueOf(Integer.parseInt(dates.substring(4, 6)));
        return month;
    }

    private String checkDay(String dates) {
        String day = dates.substring(6, 8);
        return day;
    }

    private String checkYear(String dates) {
        String year = dates.substring(0,4);
        return year;
    }
}
