package kr.hs.dimigo.meal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NumberToWord {

    String resultDate;
    Date date;

    Calendar cal = Calendar.getInstance();


    public String startChange(String dates) {

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            date = dateFormat.parse(dates);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        resultDate = checkWeekday(date) + ", " + checkMonth(dates) + " " + checkDay(dates) + ", " + checkYear(dates);

        return resultDate;
    }

    private String checkWeekday(Date date) {
        String weekday = null;

        cal.setTime(date);

        switch (cal.get(cal.DAY_OF_WEEK)) {
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
        return null;
    }

}
