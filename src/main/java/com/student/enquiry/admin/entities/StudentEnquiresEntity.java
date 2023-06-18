package com.student.enquiry.admin.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="student_enquiry")

public class StudentEnquiresEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer enquiryId;
	private String stdName;
	private Integer phone;
	private String classMode;
	private String courseName;
	private String enquiryStatus;
	private Date createdDate;
	private Date updatedDate;

	@ManyToOne
	private UserDetailsEntity userId;
	
	
}
