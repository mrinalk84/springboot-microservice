package com.tech22.employee.ms.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tech22.employee.ms.model.Employee;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {
	
	@Autowired
	EmployeeRepository repository;
	
	@Test
	public void testCreateReadDelete() {
		Employee emp = new Employee("Mrinal", "Jana");
		repository.save(emp);
		
		Iterable<Employee> employees = repository.findAll();		
		Assertions.assertThat(employees).extracting(Employee::getFirstName).containsOnly("Mrinal");
		repository.deleteAll();
		Assertions.assertThat(repository.findAll()).isEmpty();
		
		
	}

}
