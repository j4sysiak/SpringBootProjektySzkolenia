package pl.jaceksysiak.springdemo.dao;

import java.util.List;

import pl.jaceksysiak.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
}
