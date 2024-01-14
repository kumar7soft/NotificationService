package com.thrivefuse.notification.controller;


import com.thrivefuse.notification.dto.EmailInfo;
import com.thrivefuse.notification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailNotificationController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailInfo emailInfo) {
        emailService.sendSimpleEmail(emailInfo.getToMailAddress().get(0), emailInfo.getSubject(), emailInfo.getMessage());
        return ResponseEntity.ok("Email sent successfully");
    }

    @PostMapping("bulk/send")
    public ResponseEntity<?> sendBulkEmails(@RequestBody EmailInfo emailInfo){
        emailService.sendBulkEmail(emailInfo);
        return ResponseEntity.ok("Email sent successfully");
    }

}
