package com.damith.talkingclock.service;

import com.damith.talkingclock.exception.InvalidTimeException;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

import static com.damith.talkingclock.utils.TimeToTextConvertUtil.getFullTextForTime;
import static com.damith.talkingclock.utils.TimeToTextConvertUtil.isValidTimeFormat;

@Service
public class TimeServiceImpl implements TimeService {

    @Override
    public String getTimeAsText(String time) throws InvalidTimeException {

        if (!isValidTimeFormat(time)) {
            throw new InvalidTimeException("Incorrect time format should provide : HH:mm");
        }

        int hour;
        int min;

        if (time == null) {
            LocalTime localTime = LocalTime.now().withSecond(0).withNano(0);
            hour = localTime.getHour();
            min = localTime.getMinute();
        } else {
            String[] hoursMints = time.split(":");
            hour = Integer.parseInt(hoursMints[0]);
            min = Integer.parseInt(hoursMints[1]);
        }

        return getFullTextForTime(hour, min);
    }

}
