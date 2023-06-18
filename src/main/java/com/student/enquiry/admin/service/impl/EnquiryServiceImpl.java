package com.student.enquiry.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.enquiry.admin.payloads.DashboardResponse;
import com.student.enquiry.admin.payloads.EnquiryForm;
import com.student.enquiry.admin.payloads.EnquirySearchCriteria;
import com.student.enquiry.admin.repository.StudentEnqRepository;
import com.student.enquiry.admin.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService{

	@Autowired
	private StudentEnqRepository repository;

	@Override
	public DashboardResponse getDashBoardData(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addEnquiry(EnquiryForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnquiryForm> getEnqiries(Integer userId, EnquirySearchCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCourseNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getEnqStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnquiryForm getEnquiry(Integer enquiryId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
