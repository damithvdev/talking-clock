package com.damith.talkingclock.service;

import com.damith.talkingclock.exception.InvalidTimeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeServiceImplTest {

    TimeService timeService;
    @Before
    public void setUp() {
        timeService = new TimeServiceImpl();
    }

    @Test
    public void testTimeOClock() {
        String expected = timeService.getTimeAsText("12:00");
        assertEquals("Twelve o'clock", expected);
    }

    @Test
    public void testTimePast() {
        String expected = timeService.getTimeAsText("12:15");
        assertEquals("Quarter past twelve", expected);
    }

    @Test
    public void testTimeHalfPast() {
        String expected = timeService.getTimeAsText("12:30");
        assertEquals("Half past twelve", expected);
    }

    @Test
    public void testTimeTo() {
        String expected = timeService.getTimeAsText("12:45");
        assertEquals("Quarter to one", expected);
    }

    @Test
    public void testTime() {
        String expected = timeService.getTimeAsText("00:15");
        assertEquals("Quarter past twelve", expected);
    }

    @Test(expected = InvalidTimeException.class)
    public void testInvalidTimeException() {
        timeService.getTimeAsText("00:67");
    }
}