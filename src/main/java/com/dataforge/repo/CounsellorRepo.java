package com.dataforge.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dataforge.entity.CounsellorsInfo;
import com.dataforge.model.DashBordResponse;


@Repository
public interface CounsellorRepo extends JpaRepository<CounsellorsInfo, Integer> {
	
	     public CounsellorsInfo findByEmailAndPwd(String email,String pwd);
	     
	     public CounsellorsInfo findByEmail(String email);

}
