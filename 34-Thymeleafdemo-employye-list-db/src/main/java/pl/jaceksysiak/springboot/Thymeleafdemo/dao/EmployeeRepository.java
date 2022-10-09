package pl.jaceksysiak.springboot.Thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.jaceksysiak.springboot.Thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
}
