package com.project.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.employee.model.ProjectModel;
import com.project.employee.repository.ProjectRepository;

@RestController
@CrossOrigin(origins ="*")
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@PostMapping("/ProjectCreate")
	public String project_create(@RequestBody ProjectModel pm) {
		projectRepo.save(pm);
		 return "success";
	}
	
	@GetMapping("/ProjectList")
	public List<ProjectModel> list(){
		return projectRepo.findAll();

 }
	@GetMapping("project/edit/{id}")
	public ResponseEntity<ProjectModel> getEmpById(@PathVariable int id){
		
		return projectRepo.findById(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	} 
	
	@PostMapping("/ProjectEdit")
	public ResponseEntity<String> update(@RequestBody ProjectModel promaster){
		
		return projectRepo.findById(promaster.getPrid())
				.map(pro ->
				{
					pro.setProjectname(promaster.getProjectname());
					pro.setClientname(promaster.getClientname());
					pro.setStartdate(promaster.getStartdate());
					pro.setEnddate(promaster.getEnddate());
					pro.setBudget(promaster.getBudget());
					projectRepo.save(pro);
					return ResponseEntity.ok("updated");
				})
				.orElse(ResponseEntity.notFound().build());
				
	}
	
	@PostMapping("project/delete")
	public String deleteproject(@RequestBody ProjectModel proMaster ) {
		
		projectRepo.deleteById(proMaster.getPrid());
		
		return"success";
	}
}
