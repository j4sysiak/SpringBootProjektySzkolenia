package pl.jaceksysiak.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.jaceksysiak.springdemo.dao.CustomerDAO;
import pl.jaceksysiak.springdemo.entity.Customer;
import pl.jaceksysiak.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	/*obs�uga b�dzie w ServiceLayer:  CusomerServiceImpl*/
	// need to inject the customer dao
	//@Autowired
	//private CustomerDAO customerDAO;
	
	// need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the dao
		List<Customer> theCustomers = customerService.getCustomers();
				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
}


