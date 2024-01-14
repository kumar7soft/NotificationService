package com.thrivefuse.notification.controller;

import com.thrivefuse.notification.dto.SMSInfo;
import com.thrivefuse.notification.service.MobileMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class MobileMessageController {

    @Autowired
    MobileMessageService mobileMessageService;
    @PostMapping("/sms")
    public ResponseEntity<?> sendMobileSms(@RequestBody SMSInfo smsInfo){
        return ResponseEntity.ok(mobileMessageService.sendSms(smsInfo.getReceiverMobileNumber(),smsInfo.getTextMessage()));
    }


}
