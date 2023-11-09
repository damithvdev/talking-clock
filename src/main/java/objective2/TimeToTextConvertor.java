package objective2;

import com.damith.talkingclock.utils.TimeToTextConvertUtil;

import java.util.Scanner;

public class TimeToTextConvertor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] hoursMints = input.split(":");
        convertToText(hoursMints);
    }
    private static void convertToText(String[] array) {

        int hour = Integer.parseInt(array[0]);
        int min = Integer.parseInt(array[1]);

        System.out.println(TimeToTextConvertUtil.getFullTextForTime(hour, min));

    }
}
