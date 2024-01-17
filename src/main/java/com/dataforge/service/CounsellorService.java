package com.dataforge.service;

import org.springframework.stereotype.Service;

import com.dataforge.entity.CounsellorsInfo;
import com.dataforge.model.DashBordResponse;


public interface CounsellorService {

	public String saveCounsellor(CounsellorsInfo c);

	public CounsellorsInfo loginCheck(String email, String pwd);

	public boolean recoverPwd(String email);

	public DashBordResponse getDashboardInfo(Integer cid);
}
