package com.tech22.employee.ms.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.tech22.employee.ms.model.Employee;
import com.tech22.employee.ms.services.EmployeeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	
	@MockBean
	EmployeeService employeeService;
	
	@Autowired
	MockMvc mckMvc;
	
	
	@Test
	public void testFindAll() throws Exception {
		Employee emp = new Employee("Mrinal", "Jana");
		List<Employee> empList = new ArrayList<>();
		empList.add(emp);
		when(employeeService.findAll()).thenReturn(empList);
		
		mckMvc.perform(get("/employee/employee"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(1)))
		.andExpect(jsonPath("$.[0].firstName", Matchers.is("Mrinal")));
		
		
	}
	

}
