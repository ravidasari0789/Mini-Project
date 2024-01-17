package com.dataforge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dataforge.entity.StudentEnqInfo;
import com.dataforge.model.SearchCriteria;
import com.dataforge.service.EnquiryServiceImpl;

@Controller
public class EnquiryController {

	@Autowired
	private EnquiryServiceImpl enquiryServiceImpl;
	@GetMapping("/addenq")
	public String enqPage(Model model) {
		
		model.addAttribute("studentenq", new StudentEnqInfo());
		
		return "enqpage";
	}
	@PostMapping("/handleenquire")
	public String addEnquiry(StudentEnqInfo se, Model model) {
		boolean s=enquiryServiceImpl.addEnq(se);
		model.addAttribute("enquire", s);
		  return "enqpage";
	}

	public String viewEnquiries(Model model) {
		
		return "viewenquire";
	}

	public String filterEnquiries(SearchCriteria sc, Model model) {
		
		return "filterenquires";  
	}
}
