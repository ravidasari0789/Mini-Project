package com.dataforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.dataforge.entity.StudentEnqInfo;
import com.dataforge.model.SearchCriteria;
import com.dataforge.repo.StudentEnqRepo;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private StudentEnqRepo studentEnqRepo;
	@Override
	public boolean addEnq(StudentEnqInfo se) {
		StudentEnqInfo s=studentEnqRepo.save(se);
		return s.getEnqid()!=null;
	}

	@Override
	public List<StudentEnqInfo> getEnquiries(Integer cid, SearchCriteria s) {
		
		StudentEnqInfo studentEnqInfo = new StudentEnqInfo();
		studentEnqInfo.setCid(cid);
		
		if(s.getStudentmode()!=null && !s.getStudentmode().equals(" ")) {
			studentEnqInfo.setStudentmode(s.getStudentmode());
		}
		if(s.getStudentcourse()!=null && !s.getStudentcourse().equals(" ")) {
			studentEnqInfo.setStudentcourse(s.getStudentcourse());
		}
		if(s.getStudentstatus()!=null && !s.getStudentstatus().equals(" ")) {
			studentEnqInfo.setStudentstatus(s.getStudentstatus());
		}
		 Example<StudentEnqInfo> off=Example.of(studentEnqInfo);
		 List<StudentEnqInfo> list=	studentEnqRepo.findAll(off);
		return list;
	}

}
