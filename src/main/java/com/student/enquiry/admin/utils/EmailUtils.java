package com.student.enquiry.admin.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class EmailUtils {


    @Autowired
    private JavaMailSender mailSender;

    public boolean sendEmail(String to, String subject, String body){

        boolean isSent = false;

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body,true);

            mailSender.send(message);

            isSent = true;
        }catch (Exception e){

            System.out.println(e.getMessage());
        }

        return isSent;

    }

}
