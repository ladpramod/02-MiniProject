package com.student.enquiry.admin.service;

import com.student.enquiry.admin.payloads.LoginForm;
import com.student.enquiry.admin.payloads.SignUpForm;
import com.student.enquiry.admin.payloads.UnlockForm;

public interface StudentService {

	
	public String login(LoginForm form);
	
	public String signUp(SignUpForm form);
	
	public String unlockAccount(UnlockForm form);
	
	public String forgotPwd(String email);
}
