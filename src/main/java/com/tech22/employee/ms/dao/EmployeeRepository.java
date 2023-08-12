package com.tech22.employee.ms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tech22.employee.ms.model.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
