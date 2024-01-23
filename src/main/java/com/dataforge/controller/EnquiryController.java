package com.dataforge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dataforge.entity.StudentEnqInfo;
import com.dataforge.model.SearchCriteria;
import com.dataforge.service.EnquiryServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

	@Autowired
	private EnquiryServiceImpl enquiryServiceImpl;
	@GetMapping("/addenq")
	public String enqPage(Model model) {
		
		model.addAttribute("studentenq", new StudentEnqInfo());
		
		return "studentadd";
	}
	@PostMapping("/handleenquire")
	public String addEnquiry(@ModelAttribute("studentenq") StudentEnqInfo studentenq,HttpServletRequest request, Model model) {
		HttpSession session=request.getSession(false);
		Integer id=(Integer) session.getAttribute("CID");
		studentenq.setCid(id);
		if(id==null) {
			return "redirect:/";
		}
		boolean s=enquiryServiceImpl.addEnq(studentenq);
		if(s) {
		model.addAttribute("enqsucess", "Saved Sucessfully Student Enquire");
		}else {
			model.addAttribute("enqerror","Failed to saved Student Enquire");
		}
		  return "studentadd";
	}

	@GetMapping("/allviewpage")
	public String viewEnquiries(HttpServletRequest req, Model model) {
		
		HttpSession session=req.getSession(false);
		Integer id=(Integer) session.getAttribute("CID");
		if(id==null) {
			return "redirect:/";
		}
		model.addAttribute("student", new SearchCriteria());
	List<StudentEnqInfo> list=	enquiryServiceImpl.getEnquiries(id, new SearchCriteria());
		model.addAttribute("entities", list);
		return "viewenquire";
	}
    @PostMapping("/filter")
	public String filterEnquiries(@ModelAttribute("student") SearchCriteria student,HttpServletRequest req, Model model) {	
    	HttpSession session=req.getSession(false);
		Integer id=(Integer) session.getAttribute("CID");
		if(id==null) {
			return "redirect:/";
		}
    List<StudentEnqInfo> list=	enquiryServiceImpl.getEnquiries(id, student);
    	model.addAttribute("entities", list);
		return "filterenquire";  
	}
}
