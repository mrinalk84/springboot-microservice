package com.tech22.employee.ms.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tech22.employee.ms.dao.EmployeeRepository;
import com.tech22.employee.ms.model.Employee;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	
	@InjectMocks
	EmployeeService employeeService;
	
	@Mock
	EmployeeRepository empRepo;
	@Test
	void testFindAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee("John", "John");
        Employee empTwo = new Employee("Alex", "kolenchiski");
        Employee empThree = new Employee("Steve", "Waugh");
         
        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);
        
        when(empRepo.findAll()).thenReturn(list);
        //test
        List<Employee> empList = employeeService.findAll();
        assertEquals(3, empList.size());
        verify(empRepo, times(1)).findAll();
		
	}

}
