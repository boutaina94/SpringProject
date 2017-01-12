package isep.web.sakila.webapi.service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.CityRepository;
import isep.web.sakila.dao.repositories.CountryRepository;
import isep.web.sakila.jpa.entities.City;
import isep.web.sakila.jpa.entities.Country;
import isep.web.sakila.webapi.model.CityWO;

@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService {
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;

	private static final Log log = LogFactory.getLog(CityServiceImpl.class);

	@Override
	public List<CityWO> findAllCity() {
		List<CityWO> cities = new LinkedList<CityWO>();

		for (City city : cityRepository.findAll()) {
			cities.add(new CityWO(city));
			System.out.println("Adding " + city.getCity());
		}

		return cities;
	}

	@Override
	public CityWO findById(int id) {
		log.debug(String.format("Looking for city by Id %s", id));
		City city = cityRepository.findOne(id);

		if (city != null) {
			return new CityWO(city);
		}
		return null;
	}

	@Override
	public void saveCity(CityWO cityWO) {

		Country country = countryRepository.findOne(cityWO.getCountryId());

		City city = new City();
		city.setCity(cityWO.getCity());
		city.setCountry(country);
		city.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		cityRepository.save(city);
	}

	@Override
	public void updateCity(CityWO cityWO) {

		City city = cityRepository.findOne(cityWO.getCityId());
		Country country = countryRepository.findOne(cityWO.getCountryId());

		city.setCity(cityWO.getCity());
		city.setCountry(country);
		city.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		cityRepository.save(city);
	}

	@Override
	public void deleteCityById(int id) {
		cityRepository.delete(id);
	}

}