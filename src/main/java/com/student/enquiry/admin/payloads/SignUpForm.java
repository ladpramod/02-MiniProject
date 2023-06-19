package com.student.enquiry.admin.payloads;

import lombok.Data;

@Data
public class SignUpForm {

	private String name;
	private String email;
	private Long phone;
	
}
