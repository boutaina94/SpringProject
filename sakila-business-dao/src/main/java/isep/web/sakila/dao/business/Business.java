package isep.web.sakila.dao.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import isep.web.sakila.dao.repositories.ActorRepository;
import isep.web.sakila.dao.repositories.CityRepository;
import isep.web.sakila.dao.repositories.CustomerRepository;
import isep.web.sakila.dao.repositories.StaffRepository;
import isep.web.sakila.dao.repositories.StoreRepository;
import isep.web.sakila.jpa.entities.Actor;
import isep.web.sakila.jpa.entities.Customer;

@Service("business")
public class Business implements IBusiness {
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private StaffRepository staffRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<Actor> getAllActors() {
		return Lists.newArrayList(actorRepository.findAll());
	}

	@Override
	public Actor getByID(int actorId) {
		return actorRepository.findOne(actorId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return Lists.newArrayList(customerRepository.findAll());
	}
}
