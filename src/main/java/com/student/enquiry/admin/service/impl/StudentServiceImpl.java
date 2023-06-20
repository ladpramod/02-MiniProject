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
	public boolean signUp(SignUpForm form) {
		
		//To validate the email from user
		
		 UserDetailsEntity user = repository.findByEmail(form.getEmail());
		
		 if(user !=null) {
			 
			 return false;
		 }
		
		//Copy data from binding obj to entity obj
		UserDetailsEntity entity = new UserDetailsEntity();
		BeanUtils.copyProperties(form,entity);


		//generate random password and set to object

		String tempPwd = PwdUtils.generateRandomPwd();
		entity.setPassword(tempPwd);

		//Set account status as locked
		entity.setActiveStatus("LOCKED");
		
		//Insert Record
		repository.save(entity);
		
		//Send Email to the unlocked account
		String to = form.getEmail();
		String subject = "Please unlock your account |Ashok-IT";
		StringBuffer body = new StringBuffer("");
		body.append("Dear User,");
		body.append("");
		body.append("<h2>User below temporary password to login</h2>");
		body.append("Your temporary password is:"+tempPwd);
		body.append("<br/>");
		body.append("<a href= \"http://localhost:9192/unlock?email="+to+"\">  Click here to unlock account</a>");
		

		emailUtils.sendEmail(to,subject,body.toString());

		return true;
	}

	@Override
	public boolean unlockAccount(UnlockForm form) {

		//Checking the data is the database whether received email is available or not

		UserDetailsEntity entity = repository.findByEmail(form.getEmail());

		//Validated the entity password and form password matching or not
		if (entity.getPassword().equals(form.getTempPwd())){

			//if valid password then update new password in the database
			entity.setPassword(form.getNewPwd());

			//Change the account status as Unlocked and save into database and return true
			entity.setActiveStatus("UNLOCKED");
			repository.save(entity);
			return true;
		}else{
			//if password not matching then return false
			return false;
		}

	}

	@Override
	public String login(LoginForm form) {


		UserDetailsEntity entity = repository.findByEmailAndPassword(form.getEmail(), form.getPassword());

		if(entity==null){
			return "Invalid credentials";
		}


		if(entity.getActiveStatus().equals("LOCKED")){
			return "Your Account is Locked";
		}

		return "success";
	}

	@Override
	public String forgotPwd(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
