package com.damith.talkingclock.utils;

import com.damith.talkingclock.exception.InvalidTimeException;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeToTextConvertUtil {
    private static final String TIME_PATTERN = "^(?:[01]\\d|2[0-3]):[0-5]\\d$";

    private TimeToTextConvertUtil() {
    }

    private static String getHourText(int hour) {
        return switch (hour) {
            case 1, 13 -> "one";
            case 2, 14 -> "two";
            case 3, 15 -> "three";
            case 4, 16 -> "four";
            case 5, 17 -> "five";
            case 6, 18 -> "six";
            case 7, 19 -> "seven";
            case 8, 20 -> "eight";
            case 9, 21 -> "nine";
            case 10, 22 -> "ten";
            case 11, 23 -> "eleven";
            case 12, 0 -> "twelve";
            default -> throw new IllegalStateException("Unexpected value: " + hour);
        };
    }

    private static String getMinText(int num) throws InvalidTimeException {

        if (num > 59) {
            throw new InvalidTimeException("Can not have more than 59 minutes");
        }

        if (num > 30) {
            num = 60 - num;
        }

        String[] ones = {
                "", "one", "two", "three", "four",
                "five", "six", "seven", "eight",
                "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen",
                "nineteen"
        };

        String twenty = "twenty";

        if (num < 20) {
            return ones[num];
        } else {
            return twenty + " " + ones[num % 10];
        }
    }

    public static String getFullTextForTime(int hour, int min) throws InvalidTimeException {
        StringBuilder timeText = new StringBuilder();

        if (min == 0) {
            timeText.append(getHourText(hour)).append(" o'clock");
        } else if (min > 30) {
            if (min == 45) {
                timeText.append("Quarter");
            } else {
                timeText.append(getMinText(min));
            }
            timeText.append(" to ").append(getHourText(hour + 1));
        } else {
            if (min == 30) {
                timeText.append("Half");
            } else if (min == 15) {
                timeText.append("Quarter");
            } else {
                timeText.append(getMinText(min));
            }
            timeText.append(" past ").append(getHourText(hour));
        }
        return StringUtils.capitalize(timeText.toString());
    }

    public static boolean isValidTimeFormat(String time) {
        if (time == null) {
            return true;
        }
        Pattern pattern = Pattern.compile(TIME_PATTERN);
        Matcher matcher = pattern.matcher(time);

        return matcher.matches();
    }

}
