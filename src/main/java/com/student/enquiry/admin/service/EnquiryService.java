package com.student.enquiry.admin.service;

import java.util.List;

import com.student.enquiry.admin.payloads.DashboardResponse;
import com.student.enquiry.admin.payloads.EnquiryForm;
import com.student.enquiry.admin.payloads.EnquirySearchCriteria;

public interface EnquiryService {

	public List<String> getCourseNames();
	
	public List<String> getEnqStatus();
	
	public DashboardResponse getDashBoardData(Integer userId);
	
	public String addEnquiry(EnquiryForm form);
	
	public List<EnquiryForm> getEnqiries(Integer userId, EnquirySearchCriteria criteria);
	
	public EnquiryForm getEnquiry(Integer enquiryId);
}
