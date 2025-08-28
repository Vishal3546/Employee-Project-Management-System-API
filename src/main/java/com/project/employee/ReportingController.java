package com.project.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.employee.model.AssignmentModel;
import com.project.employee.model.DepartmentViseEmployee;
import com.project.employee.model.DepartmentviseSalary;
import com.project.employee.model.EmployeeModel;
import com.project.employee.model.OnGoingProject;
import com.project.employee.model.ProjectModel;
import com.project.employee.repository.AssignmentRepository;
import com.project.employee.repository.EmployeeRepository;
import com.project.employee.repository.ProjectRepository;

@RestController
@CrossOrigin(origins = "*")
public class ReportingController {

	@Autowired
	private AssignmentRepository assRepo;
	
	@Autowired
	private EmployeeRepository EmployeeRepo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@GetMapping("/EmployeeReport")
	public ArrayList<DepartmentViseEmployee> getEmployeeReport() {
		ArrayList<String> dep= new ArrayList<String>();
		ArrayList<DepartmentViseEmployee> de = new ArrayList<DepartmentViseEmployee>();
		dep.add("It Department");
		dep.add("Java Developer");
		dep.add("UI/UX Design Developer");
		dep.add("Python Developer");
		for (String d : dep) {
			List<EmployeeModel> byDepartment = EmployeeRepo.findByDepartment(d);
			DepartmentViseEmployee dve = new DepartmentViseEmployee(d, byDepartment.size());
			de.add(dve);
		}
		return de;
		
	}
	
	@GetMapping("/TotalSalary")
	public ArrayList<DepartmentviseSalary> getTotalSalary() {
	    ArrayList<String> dep = new ArrayList<>();
	    ArrayList<DepartmentviseSalary> des = new ArrayList<>();
	    
	    dep.add("It Department");
		dep.add("Java Developer");
		dep.add("UI/UX Design Developer");
		dep.add("Python Developer");

	    for (String d : dep) {
	        
	        List<EmployeeModel> byDepartment = EmployeeRepo.findByDepartment(d);

	        int totalSalary = 0;
	        for (EmployeeModel e : byDepartment) {
	            totalSalary += e.getSalary(); 
	        }

	        DepartmentviseSalary dvs = new DepartmentviseSalary(d, totalSalary);
	        des.add(dvs);
	    }

	    return des;
	}
	
	
	@GetMapping("/AssignmentReport")
	public ArrayList<OnGoingProject> ongoingProject(){
		List<ProjectModel> allPrj = projectRepo.findAll();
		ArrayList<OnGoingProject> response= new ArrayList<OnGoingProject>();
		for (ProjectModel prjData : allPrj) {
			OnGoingProject ogp = new OnGoingProject();
			ogp.setProjectname(prjData.getProjectname());
			ArrayList<String> emps = new ArrayList<String>();
			List<AssignmentModel> byProid = assRepo.findByPrid(prjData.getPrid());
			for (AssignmentModel asm : byProid) {
				Optional<EmployeeModel> byId = EmployeeRepo.findById(asm.getEmid());
				if(!byId.isEmpty())
				{
					EmployeeModel empData = byId.get();
					emps.add(empData.getName());
				}
			}
			ogp.setNames(emps);
			response.add(ogp);
		}
		return response;
	}
	
}
