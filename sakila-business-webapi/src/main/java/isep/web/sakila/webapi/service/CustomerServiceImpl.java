package isep.web.sakila.webapi.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.AddressRepository;
import isep.web.sakila.dao.repositories.CityRepository;
import isep.web.sakila.dao.repositories.CustomerRepository;
import isep.web.sakila.dao.repositories.StoreRepository;
import isep.web.sakila.jpa.entities.Address;
import isep.web.sakila.jpa.entities.City;
import isep.web.sakila.jpa.entities.Customer;
import isep.web.sakila.jpa.entities.Store;
import isep.web.sakila.webapi.model.CustomerWO;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private AddressRepository addressRepository;

	private static final Log log = LogFactory.getLog(CustomerServiceImpl.class);

	@Override
	public CustomerWO findById(int id) {
		log.debug(String.format("Looking for customer by Id %s", id));
		Customer customer = customerRepository.findOne(id);

		if (customer != null) {
			return new CustomerWO(customer);
		}
		return null;
	}

	@Override
	public void updateCustomer(CustomerWO customerWO) {

		Store store = storeRepository.findOne(customerWO.getStore_id());
		City city = cityRepository.findOne(customerWO.getCity_id());

		Customer customer = customerRepository.findOne(customerWO.getCustomerId());
		customer.setStore(store);
		customer.setFirstName(customerWO.getFirstName());
		customer.setLastName(customerWO.getLastName());
		customer.setEmail(customerWO.getEmail());
		customer.setActive(customerWO.getActive());
		customer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		customerRepository.save(customer);

		Address address = addressRepository.findOne(customerWO.getAddressId());
		address.setAddress(customerWO.getAddress());
		address.setAddress2(customerWO.getAddress2());
		address.setDistrict(customerWO.getDistrict());
		address.setCity(city);
		address.setPostalCode(customerWO.getPostalCode());
		address.setPhone(customerWO.getPhone());
		address.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		addressRepository.save(address);

	}

	@Override
	public List<CustomerWO> findAllCustomers() {
		System.out.println("CustomerService - findAllCustomers");

		List<CustomerWO> customers = new LinkedList<CustomerWO>();

		for (Customer cust : customerRepository.findAll()) {
			System.out.println(cust.getEmail());
			customers.add(new CustomerWO(cust));
			log.debug("Adding " + cust);
		}

		return customers;
	}

	@Override
	public void createCustomer(CustomerWO customerWO) {

		System.out.println("create cust store_id " + customerWO.getStore_id());
		Store store = storeRepository.findOne(customerWO.getStore_id());

		City city = cityRepository.findOne(customerWO.getCity_id());

		System.out.println(customerWO.getAddress() + customerWO.getAddress2() + customerWO.getDistrict()
				+ customerWO.getPostalCode() + customerWO.getPhone());
		Address address = new Address();
		address.setAddress(customerWO.getAddress());
		address.setAddress2(customerWO.getAddress2());
		address.setDistrict(customerWO.getDistrict());
		address.setCity(city);
		address.setPostalCode(customerWO.getPostalCode());
		address.setPhone(customerWO.getPhone());
		address.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		addressRepository.save(address);

		Customer customer = new Customer();
		customer.setStore(store);
		customer.setFirstName(customerWO.getFirstName());
		customer.setLastName(customerWO.getLastName());
		customer.setEmail(customerWO.getEmail());
		customer.setAddress(address);
		customer.setActive(customerWO.getActive());
		customer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		customer.setCreateDate(new Date());
		customerRepository.save(customer);
	}

}
