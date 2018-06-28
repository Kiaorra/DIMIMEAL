package kr.hs.dimigo.meal;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalDate {

    String currentDate;

    public CalDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar =  Calendar.getInstance();
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
}
