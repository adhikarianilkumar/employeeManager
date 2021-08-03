package io.adhikari.employeeManager.employee;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public List<EmployeeEntity> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public EmployeeEntity addEmployee(EmployeeEntity employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}
	
	public EmployeeEntity getEmployee(Long id) {
		return employeeRepository.findEmployeeEntityById(id);
	}
	
	public EmployeeEntity updateEmployee(EmployeeEntity employee) {
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

}
