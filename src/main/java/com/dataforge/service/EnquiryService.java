package com.dataforge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dataforge.entity.StudentEnqInfo;
import com.dataforge.model.SearchCriteria;


public interface EnquiryService {

	public boolean addEnq(StudentEnqInfo se);

	public List<StudentEnqInfo> getEnquiries(Integer cid, SearchCriteria s);
}
