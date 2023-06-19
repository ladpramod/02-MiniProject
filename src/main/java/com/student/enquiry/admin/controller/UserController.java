package com.student.enquiry.admin.controller;

import com.student.enquiry.admin.payloads.SignUpForm;
import com.student.enquiry.admin.payloads.UnlockForm;
import com.student.enquiry.admin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String handelSignUp(@ModelAttribute("user") SignUpForm form, Model model){

		boolean status = studentService.signUp(form);

		if (status){
			model.addAttribute("succMsg","Account created, please check your registered email...");
		}else {
			model.addAttribute("errMsg","Type unique email id...");
		}
		return "signup";
	}

	@GetMapping("/unlock")
	public String unlockPage(@RequestParam String email, Model model) {
		
		UnlockForm unlockFormObj = new UnlockForm();
		unlockFormObj.setEmail(email);
		
		model.addAttribute("unlock",unlockFormObj);
		
		return "unlock";
	}
	
	@PostMapping("/unlock")
	public String unlockUserAccount(@ModelAttribute("unlock)") UnlockForm unlock, Model model) {
		



		//validate user entered password and current password should same
		if (unlock.getNewPwd().equals(unlock.getConfPwd())){

			//if valid then unlock the account
			boolean status = studentService.unlockAccount(unlock);

			if (status){
				model.addAttribute("succMsg", "Your account unlocked successfully..");
			}else {

				model.addAttribute("errMsg","Given temporary password is incorrect, check email once..");
			}
		}else {

			//if not valid then send error msg as response to the client
			model.addAttribute("errMsg", "New Password and Confirm password must be same");
		}

		return "unlock";
	}
	
	
	@GetMapping("/login")
	public String loginPage() {
		
		return "login";
	}


	@GetMapping("/forgot")
	public String forgotPwdPage() {
		
		return "forgotPwd";
	}
	
	
}
