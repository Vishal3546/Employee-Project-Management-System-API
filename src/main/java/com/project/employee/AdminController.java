package com.project.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.employee.model.AdminLogin;
import com.project.employee.model.AdminModel;
import com.project.employee.repository.AdminRepository;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepo;
	
	 @PostMapping("admin/signup")
	 public AdminModel signup(@RequestBody AdminModel admin) {
	        return adminRepo.save(admin); 
	  }
	 
	 @PostMapping("/admin/login")
		public String login(@RequestBody AdminLogin adm) {
		 AdminModel byEmailAndPassword = adminRepo.findByEmailAndPassword(adm.getEmail(),adm.getPassword());
			if(byEmailAndPassword != null) {
				return "success";
			}
			else {
				return "fail";
			}
     }
}
