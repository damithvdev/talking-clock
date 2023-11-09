package objective1;

import java.time.LocalTime;

import static com.damith.talkingclock.utils.TimeToTextConvertUtil.getFullTextForTime;

public class TimeToTextConvertor {
    public static void main(String[] args) {
        convertToText();
    }
    private static void convertToText() {
        // 15 - > quarter past , 45 - > quarter to , 30 -> half past
        // if min is larger than 30 should use "To" else "Past"
        // then minute range is 1 - 29
        // hours range one to twelve 1 - 12
        LocalTime localTime = LocalTime.now().withSecond(0).withNano(0);
        int hour = localTime.getHour();
        int min = localTime.getMinute();

        System.out.println(getFullTextForTime(hour, min));
    }
}
