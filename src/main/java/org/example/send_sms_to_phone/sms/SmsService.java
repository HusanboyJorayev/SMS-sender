package org.example.send_sms_to_phone.sms;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class SmsService {
    private final String API_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MjgzOTMxOTcsImlhdCI6MTcyNTgwMTE5Nyw" +
            "icm9sZSI6InRlc3QiLCJzaWduIjoiZWRmYjQ1YmRhYzE5OGVjNzI0NDRkNmY2MTUzNTk4ODEyY" +
            "zE4YWMxZTA3NjEyYzA0ZTRjODhkZDhmZWZkNmE2MCIsInN1YiI6IjU4NDgifQ.K-D89zSHciYTh9dMt559hUMEZJLcPGKNp9zamY76X30";
    private final String BASE_URL = "https://notify.eskiz.uz/api/message/sms/send";
    private final String messageText = "Bu Eskiz dan test";

    public String sendSms(String phoneNumber) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_TOKEN);

        Map<String, String> body = new HashMap<>();
        body.put("mobile_phone", phoneNumber);
        body.put("message", messageText);
        body.put("from", "4546");

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                BASE_URL, HttpMethod.POST, entity, String.class
        );
        return response.getBody();
    }
}
