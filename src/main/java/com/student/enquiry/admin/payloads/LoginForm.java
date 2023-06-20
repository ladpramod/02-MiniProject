package com.student.enquiry.admin.payloads;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LoginForm {

    private String email;
    private String password;
}
