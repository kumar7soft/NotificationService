package com.thrivefuse.notification.dto;

import lombok.Data;

@Data
public class SMSInfo {

    private String receiverMobileNumber;

    private String textMessage;
}
