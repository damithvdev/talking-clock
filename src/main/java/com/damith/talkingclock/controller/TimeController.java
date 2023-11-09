package com.damith.talkingclock.controller;

import com.damith.talkingclock.Response;
import com.damith.talkingclock.exception.InvalidTimeException;
import com.damith.talkingclock.service.TimeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/time")
public class TimeController {

    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping
    public Response convertTimeToText(@RequestParam(value = "time", required = false) String time) throws InvalidTimeException{
        Response response = new Response();
        response.setValue(timeService.getTimeAsText(time));
        return response;
    }

    @ExceptionHandler(InvalidTimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidTimeHandler(InvalidTimeException ex) {
        return ex.getMessage();
    }
}
