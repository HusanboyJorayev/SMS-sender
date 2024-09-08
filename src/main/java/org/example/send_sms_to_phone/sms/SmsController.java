package org.example.send_sms_to_phone.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {
    @Autowired
    private SmsService eskizSmsService;

    @GetMapping("/sendSms")
    public String sendSms(@RequestParam String phoneNumber) {
        return eskizSmsService.sendSms(phoneNumber);
    }
}
