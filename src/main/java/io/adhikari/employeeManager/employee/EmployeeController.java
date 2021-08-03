package io.adhikari.employeeManager.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees(){
		List<EmployeeEntity> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id){
		EmployeeEntity employees = employeeService.getEmployee(id);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeEntity employee) {
		EmployeeEntity newEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<EmployeeEntity>(newEmployee, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity employee) {
		EmployeeEntity updatedEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<EmployeeEntity>(updatedEmployee, HttpStatus.OK);
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<EmployeeEntity>(HttpStatus.OK);
	}

}
