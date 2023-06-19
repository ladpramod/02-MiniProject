package com.student.enquiry.admin.service.impl;

import com.student.enquiry.admin.entities.UserDetailsEntity;
import com.student.enquiry.admin.payloads.LoginForm;
import com.student.enquiry.admin.payloads.SignUpForm;
import com.student.enquiry.admin.payloads.UnlockForm;
import com.student.enquiry.admin.repository.UserRepository;
import com.student.enquiry.admin.service.StudentService;
import com.student.enquiry.admin.utils.EmailUtils;
import com.student.enquiry.admin.utils.PwdUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private UserRepository repository;

	@Autowired
	private EmailUtils emailUtils;

	@Override
	public String login(LoginForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean signUp(SignUpForm form) {
		
		//To validate the email from user
		
		 UserDetailsEntity user = repository.findByEmail(form.getEmail());
		
		 if(user !=null) {
			 
			 return false;
		 }
		
		//TODO: Copy data from binding obj to entity obj
		UserDetailsEntity entity = new UserDetailsEntity();
		BeanUtils.copyProperties(form,entity);


		//generate random password and set to object

		String tempPwd = PwdUtils.generateRandomPwd();
		entity.setPassword(tempPwd);

		//TODO: Set account status as locked
		entity.setActiveStatus("LOCKED");
		
		//TODO: Insert Record
		repository.save(entity);
		
		//TODO: Send Email to the unlocked account
		String to = form.getEmail();
		String subject = "Please unlock your account |Ashok-IT";
		StringBuffer body = new StringBuffer("");
		body.append("Dear User,");
		body.append("");
		body.append("<h2>User below temporary password to login</h2>");
		body.append("Your temporary password is:"+entity.getPassword());
		body.append("<br/>");
		body.append("<a href= \"http://localhost:9192/unlock?email="+to+"\">  Click here to unlock account</a>");
		

		emailUtils.sendEmail(to,subject,body.toString());

		return true;
	}

	@Override
	public String unlockAccount(UnlockForm form) {
		//TODO: Unlock account from entered temp password and create new password
		//and change status as Activate.
		
		UserDetailsEntity entity = new UserDetailsEntity();
		BeanUtils.copyProperties(form,entity);
		
		
		entity.setActiveStatus("UNLOCKED");
		
		return null;
	}

	@Override
	public String forgotPwd(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
