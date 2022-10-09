package pl.jaceksysiak.springboot.Thymeleafdemo.service;

import java.util.List;

import pl.jaceksysiak.springboot.Thymeleafdemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
