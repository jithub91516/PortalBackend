package com.example.ahnlabportal.OracleUserCRUDTest;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
public class EmpOption {
//    private List<Map<String, String>> test;
    private String mail;
    private String sms;
    private String ticket;

    public EmpOption(Map<String, String> mail, Map<String, String> sms, Map<String, String> ticket ){
//        this.test = test;
        this.mail = mail.get("mail");
        this.sms = sms.get("sms");
        this.ticket = ticket.get("ticket");

    }
}
