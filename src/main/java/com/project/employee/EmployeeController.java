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

import com.project.employee.model.EmployeeModel;
import com.project.employee.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins ="*")
public class EmployeeController {

	@Autowired
	private EmployeeRepository EmployeeRepo;
	
	@PostMapping("/EmployeeCreate")
	public String create(@RequestBody EmployeeModel empModel) {
		
		EmployeeRepo.save(empModel);
		return "success";
	}
	
	@GetMapping("/list")
	public List<EmployeeModel> list(){
		return EmployeeRepo.findAll();
		
	}
	
	@GetMapping("edit/{id}")
	public ResponseEntity<EmployeeModel> getEmpById(@PathVariable int id){
		
		return EmployeeRepo.findById(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	} 
	
	@PostMapping("/EmployeeEdit")
	public ResponseEntity<String> update(@RequestBody EmployeeModel empmaster){
		
		return EmployeeRepo.findById(empmaster.getEmid())
				.map(emp ->
				{
					emp.setName(empmaster.getName());
					emp.setEmail(empmaster.getEmail());
					emp.setDepartment(empmaster.getDepartment());
					emp.setSalary(empmaster.getSalary());
					emp.setDateofjoin(empmaster.getDateofjoin());
					EmployeeRepo.save(emp);
					return ResponseEntity.ok("updated");
				})
				.orElse(ResponseEntity.notFound().build());
				
	}
	
	@PostMapping("/delete")
	public String deleteemployee(@RequestBody EmployeeModel empMaster ) {
		
		EmployeeRepo.deleteById(empMaster.getEmid());
		
		return"success";
	}
}
