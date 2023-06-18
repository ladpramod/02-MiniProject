package com.student.enquiry.admin.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "user_details")

public class UserDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer userId;
	private String name;
	private String email;
	private String password;
	private Integer phone;
	private String activeStatus;
	
	
}
