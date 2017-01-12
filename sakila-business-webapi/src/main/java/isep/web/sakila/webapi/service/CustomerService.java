package isep.web.sakila.webapi.service;

import java.util.List;

import isep.web.sakila.webapi.model.CustomerWO;

public interface CustomerService {

	void createCustomer(CustomerWO customerWO);

	void updateCustomer(CustomerWO customerWO);

	CustomerWO findById(int id)   ;

	List<CustomerWO> findAllCustomers();

}
