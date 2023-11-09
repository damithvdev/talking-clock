package com.damith.talkingclock.service;

import org.springframework.stereotype.Service;

@Service
public interface TimeService {

    String getTimeAsText(String time);
}
