package com.student.enquiry.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.enquiry.admin.payloads.LoginForm;
import com.student.enquiry.admin.payloads.SignUpForm;
import com.student.enquiry.admin.payloads.UnlockForm;
import com.student.enquiry.admin.repository.StudentEnqRepository;
import com.student.enquiry.admin.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentEnqRepository repository;

	@Override
	public String login(LoginForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String signUp(SignUpForm form) {
		
		
		// TODO: generate random password and set to object
		
		//TODO: Set account status as locked
		
		//TODO: Insert Record
		
		//TODO: Send Email to the unlocked account
		
		
		
		
		
		
		
		return null;
	}

	@Override
	public String unlockAccount(UnlockForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgotPwd(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
