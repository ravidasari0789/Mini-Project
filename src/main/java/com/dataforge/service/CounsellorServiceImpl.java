package com.dataforge.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataforge.entity.CounsellorsInfo;
import com.dataforge.entity.StudentEnqInfo;
import com.dataforge.model.DashBordResponse;
import com.dataforge.model.EmailRequest;
import com.dataforge.repo.CounsellorRepo;
import com.dataforge.repo.StudentEnqRepo;
import com.dataforge.utilities.EmailService;

@Service
public class CounsellorServiceImpl implements CounsellorService {

	@Autowired
	private StudentEnqRepo studentEnqRepo;
	@Autowired
	private EmailService emailService;
	@Autowired
	private CounsellorRepo counsellorrepo;
	@Override
	public String saveCounsellor(CounsellorsInfo c) {
		
		CounsellorsInfo counsellors_Info=	counsellorrepo.save(c);
		
		if(counsellors_Info.getCid()!=null) {
			    return "Register Counsellor Sucessfully";
		}
			return "Failed  Counsellor Register";
		
	}

	@Override
	public CounsellorsInfo loginCheck(String email, String pwd) {
		// TODO Auto-generated method stub
		return	counsellorrepo.findByEmailAndPwd(email, pwd);
		
	}

	@Override
	public boolean recoverPwd(String email) {
		// TODO Auto-generated method stub
		CounsellorsInfo counsellorsInfo= counsellorrepo.findByEmail(email);
		
		if(counsellorsInfo==null) {
			return false;
		}
		String subject="Recoverd Password From Ravi IT";
		String body="Your Password:"+counsellorsInfo.getPwd();
		return emailService.sendMail(subject,body,email);
	}

	@Override
	public DashBordResponse getDashboardInfo(Integer cid) {
		// TODO Auto-generated method stub
	List<StudentEnqInfo> enroll=studentEnqRepo.findByCid(cid);
   	  int enrollr= enroll.stream().filter(e->e.getStudentstatus().equals("enrolled")).collect(Collectors.toList()).size();
		DashBordResponse dashBordResponse =new DashBordResponse();
		dashBordResponse.setTotal_enq(enroll.size());
		dashBordResponse.setEnrolled(enrollr);
		dashBordResponse.setLost(enroll.size()-enrollr);
		return dashBordResponse;
	}

}
