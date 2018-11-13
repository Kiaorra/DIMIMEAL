package kr.hs.dimigo.meal.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCalculator {

    private static String date;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    private static Calendar calendar = Calendar.getInstance();

    public DateCalculator() { }

    // 요청한 메소드를 포함한 클래스에 따라 다른 값을 리턴하는 메소드이다.
    public static String getDate(int position) {

        date = simpleDateFormat.format(calendar.getTime());

        switch (position) {
            case 0:
                date = String.valueOf(Integer.parseInt(date) - 1);
                break;
            case 1:
                return date;
            case 2:
                date = String.valueOf(Integer.parseInt(date) + 1);
                break;
            default:
                return null;
        }
        return date;
    }

    public String getTitleByDate(int position) {

        String titleDate = getDate(position);

        return titleDate.substring(0, 4) + "년" +
                titleDate.substring(4, 6) + "월" +
                titleDate.substring(6, 8) + "일";
    }

    private String getWeekDay(Date date) {
        calendar.setTime(date);
        switch (calendar.get(calendar.DAY_OF_WEEK)) {
            case 1:
                return "일요일";
            case 2:
                return "월요일";
            case 3:
                return "화요일";
            case 4:
                return "수요일";
            case 5:
                return "목요일";
            case 6:
                return "금요일";
            case 7:
                return "토요일";
            default:
                return null;
        }
    }

    public static int lampSelector() {
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
}
