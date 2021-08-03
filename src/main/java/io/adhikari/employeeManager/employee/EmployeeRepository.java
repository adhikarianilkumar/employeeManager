package io.adhikari.employeeManager.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	EmployeeEntity findEmployeeEntityById(Long id);

}
