package com.student.enquiry.admin.payloads;

import lombok.Data;

@Data
public class DashboardResponse {

	private Integer totalEnquriesCnt;
	private Integer enrolledCnt;
	private Integer lostCnt;
	
	
}
