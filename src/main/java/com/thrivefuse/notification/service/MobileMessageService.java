package com.thrivefuse.notification.service;

import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MobileMessageService {

    private String fromNumber = "+12067178778";

    public String sendSms(String to, String textMessage) {
        Message responseMessage = Message.creator(new PhoneNumber(to), new PhoneNumber(fromNumber), textMessage).create();
        return responseMessage.toString();
    }
}
