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

        resultDate = checkWeekday(date) + ", " + checkMonth(dates) + " " + checkDay(dates) + ", " + checkYear(dates);
        return resultDate;
    }

    public int lampSelector() {
        int result;
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("kkmm");

        result = Integer.parseInt(dateFormat.format(date));

        if(result <= 810) {
            return 0;
        } else if(result >=811 && result <= 1350) {
            return 1;
        } else if(result >=1351 && result <= 1940) {
            return 2;
        } else if(result >= 1941 && result <= 2140) {
            return 3;
        } else {
            return 4;
        }
    }

    private String checkWeekday(Date date) {
        String weekday = null;

        calendar.setTime(date);

        switch (calendar.get(calendar.DAY_OF_WEEK)) {
            case 1:
                weekday = "SUN";
                break;
            case 2:
                weekday = "MON";
                break;
            case 3:
                weekday = "TUE";
                break;
            case 4:
                weekday = "WED";
                break;
            case 5:
                weekday = "THU";
                break;
            case 6:
                weekday = "FRI";
                break;
            case 7:
                weekday = "SAT";
                break;
            default:
                break;
        }

        return weekday;
    }

    private String checkMonth(String dates) {
        String month = dates.substring(4, 6);

        switch (month) {
            case "01":
                month = "JANUARY";
                break;
            case "02":
                month = "FEBRUARY";
                break;
            case "03":
                month = "MARCH";
                break;
            case "04":
                month = "APRIL";
                break;
            case "05":
                month = "MAY";
                break;
            case "06":
                month = "JUNE";
                break;
            case "07":
                month = "JULY";
                break;
            case "08":
                month = "AUGUST";
                break;
            case "09":
                month = "SEPTEMBER";
                break;
            case "10":
                month = "OCTOBER";
                break;
            case "11":
                month = "NOVEMBER";
                break;
            case "12":
                month = "DECEMBER";
            default:
                break;
        }

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
