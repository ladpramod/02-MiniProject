package com.student.enquiry.admin.controller;

import com.student.enquiry.admin.payloads.SignUpForm;
import com.student.enquiry.admin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class UserController {

	@Autowired
	private StudentService studentService;


	@GetMapping("/signup")
	public String signupPage(Model model) {
		model.addAttribute("user", new SignUpForm());
		return"signup";
	}

	@PostMapping("/signup")
	public String handelSignUp(SignUpForm form, Model model){

		boolean status = studentService.signUp(form);

		if (status){
			model.addAttribute("succMsg","Please Check your registered email");
		}else {
			model.addAttribute("errMsg","Problem occured");
		}
		return "signup";
	}

	@GetMapping("/login")
	public String loginPage() {
		
		return "login";
	}


	@GetMapping("/forgot")
	public String forgotPwdPage() {
		
		return "forgotPwd";
	}
	
	@GetMapping("/unlock")
	public String unlockPage() {
		
		return "unlock";
	}
}
