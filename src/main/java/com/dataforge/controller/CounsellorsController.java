package com.dataforge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dataforge.entity.CounsellorsInfo;
import com.dataforge.model.DashBordResponse;
import com.dataforge.service.CounsellorService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorsController {

	@Autowired
	private CounsellorService counsellorService;

	@GetMapping("/")
	public String index(Model model) {
		// display login page
		model.addAttribute("c", new CounsellorsInfo());
		return "loginpage";
	}

	@GetMapping("/handlelogin")
	public String handleLogin(CounsellorsInfo c,HttpServletRequest request,Model model) {
		CounsellorsInfo info = counsellorService.loginCheck(c.getEmail(),c.getPwd());
		if (info == null) {
			model.addAttribute("errmsg", "Invalid credentials");
			return "redirect:/";
		}
		HttpSession session=request.getSession(true);
		session.setAttribute("CID", info.getCid());
		
		return "redirect:/dashboard";
	}
	@GetMapping("/dashboard")
	public String buildDashboard(HttpServletRequest req, Model model) {
		HttpSession session=req.getSession(false);
		Object obj=session.getAttribute("CID");
		Integer id=(Integer)obj;
		DashBordResponse dash=	counsellorService.getDashboardInfo(id);
		model.addAttribute("dash", dash);
		return "builddashborad";
	}

	@GetMapping("/register")
	public String regPage(Model model) {

		model.addAttribute("register", new CounsellorsInfo());
		// display signup page
		return "registerpage";
	}

	@PostMapping("/handleregister")
	public String handleRegistration(@ModelAttribute("register") CounsellorsInfo register, Model model) {
		String regmsg = counsellorService.saveCounsellor(register);
		if(regmsg!=null) {
		model.addAttribute("regmsg",regmsg);
		}
		return "registerpage";
	}


	@GetMapping("/recover")
	public String recoverPwdPage(Model model) {
		// display fpwd page
		return "recoverpwd";
	}

	@GetMapping("/handleforget")
	public String handleForgotPwd(String email, Model model) {
		boolean c=counsellorService.recoverPwd(email);
		if(c) {
			model.addAttribute("smgs", "pwsd sent you mail id");
		}else {
			model.addAttribute("error", "invalid email");
		}
		
		return "recoverpwd";
	}

}
