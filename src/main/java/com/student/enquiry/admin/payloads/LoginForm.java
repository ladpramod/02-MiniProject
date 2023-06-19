package com.student.enquiry.admin.payloads;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data

public class LoginForm {

    private String email;
    private String pwd;
}
