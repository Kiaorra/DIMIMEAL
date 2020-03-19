package kr.hs.dimigo.meal.utility;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DimiMealUtils {

    public static final int DATE_YESTERDAY = 0;
    public static final int DATE_TODAY = 1;
    public static final int DATE_TOMORROW = 2;

    public static String isEmpty(String str) {
        if (str.isEmpty() || str.replaceAll("\\s", "").length() == 0) {
            return "급식 정보가 없습니다.";
        } else {
            return str;
        }
    }

    public static String getDate(int dateType) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);

        Calendar calendar = Calendar.getInstance();

        String date = simpleDateFormat.format(calendar.getTime());

        switch (dateType) {
            case DATE_TODAY:
                return date;
            case DATE_YESTERDAY:
                return String.valueOf(Integer.parseInt(date) - 1);
            case DATE_TOMORROW:
                return String.valueOf(Integer.parseInt(date) + 1);
            default:
                return null;
        }
    }

    public static boolean getCurrentTime(int position) {
        int time = Integer.parseInt(new SimpleDateFormat("kkmm", Locale.KOREA).format(new Date()));

        Log.d("ABC", String.valueOf(time));

        if (position == 0 && time <= 815) return true;
        else if (position == 1 && time > 815 && time <= 1340) return true;
        else if (position == 2 && time > 1340 && time <= 1920) return true;
        else if (position == 3 && time > 1920 && time <= 2140) return true;
        else return false;
    }
}
