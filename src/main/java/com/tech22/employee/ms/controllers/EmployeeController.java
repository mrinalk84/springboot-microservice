package com.tech22.employee.ms.controllers;



import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tech22.employee.ms.model.Employee;
import com.tech22.employee.ms.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	  @Autowired
	  EmployeeService employeeService;

	  @PostMapping("/employee")
	  Employee create(@RequestBody Employee employee)  {
	    return employeeService.save(employee);
	  }

	  @GetMapping("/employee")
	  Iterable<Employee> read() {
	    return employeeService.findAll();
	  }

	  @PutMapping("/employee")
	  Employee update(@RequestBody Employee employee) {
	    return employeeService.save(employee);
	  }

	  @DeleteMapping("/employee/{id}")
	  void delete(@PathVariable Integer id) {
		  employeeService.deleteById(id);
	  }

	  @GetMapping("/wrong")
	  Employee somethingIsWrong() {
	    throw new ValidationException("Something is wrong");
	  }

	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  @ExceptionHandler(ValidationException.class)
	  String exceptionHandler(ValidationException e) {
	    return e.getMessage();
	  }
}
