package com.student.enquiry.admin.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="enquiry_status")
public class EnquiryStatusEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer stausId;
	private String statusName;
	
}
