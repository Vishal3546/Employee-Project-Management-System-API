package com.project.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.employee.model.AssignmentListModel;
import com.project.employee.model.AssignmentModel;
import com.project.employee.model.EmployeeModel;
import com.project.employee.model.ProjectModel;
import com.project.employee.repository.AssignmentRepository;
import com.project.employee.repository.EmployeeRepository;
import com.project.employee.repository.ProjectRepository;

@RestController
@CrossOrigin(origins = "*")
public class AssignmentController {
	
	@Autowired
	private AssignmentRepository assRepo;
	
	@Autowired
	private EmployeeRepository EmployeeRepo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@PostMapping("/AssignmentCreate")
	public String project_create(@RequestBody AssignmentModel am) {
		assRepo.save(am);
		 return "success";
	}
	
	@GetMapping("/AssignmentList")
	public ArrayList<AssignmentListModel> list(){
		
		ArrayList<AssignmentListModel> al = new ArrayList<AssignmentListModel>();
		List<AssignmentModel> all = assRepo.findAll();
		for (AssignmentModel adata : all) {
			Optional<EmployeeModel> emp = EmployeeRepo.findById(adata.getEmid());
			Optional<ProjectModel> prj = projectRepo.findById(adata.getPrid());
			String name="";
			String projectname="";
			if(!emp.isEmpty())
			{
				EmployeeModel empData = emp.get();	
				name=empData.getName();
			}
			if(!prj.isEmpty())
			{
				ProjectModel prData = prj.get();
				projectname=prData.getProjectname();
			}
			AssignmentListModel a  = new AssignmentListModel(adata.getAssid(), name, projectname);
			al.add(a);
		}
		return al;
		
	}
 
	
	@PostMapping("assignment/delete")
	public String deleteassignment(@RequestBody AssignmentModel assMaster ) {
		
		assRepo.deleteById(assMaster.getAssid());
		
		return"success";
	}
}	
