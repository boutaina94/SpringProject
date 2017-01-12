package isep.web.sakila.webapi.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import isep.web.sakila.webapi.model.CityWO;
import isep.web.sakila.webapi.service.CityService;

@RestController
public class CityRestController {

	@Autowired
	CityService cityService;
	private static final Log log = LogFactory.getLog(CityRestController.class);

	// -------------------Sign in ----------------------------------

	@RequestMapping(value = "/getCities/", method = RequestMethod.GET)
	public ResponseEntity<List<CityWO>> listAllCities() {
		List<CityWO> cities = cityService.findAllCity();
		if (cities.isEmpty()) {
			System.out.println("vide");
			return new ResponseEntity<List<CityWO>>(HttpStatus.NO_CONTENT);
		}
		System.out.println(cities.size());
		return new ResponseEntity<List<CityWO>>(cities, HttpStatus.OK);
	}

	@RequestMapping(value = "/city/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CityWO> getCity(@PathVariable("id") int id) {
		System.out.println("Fetching City with id " + id);
		CityWO cityWO = cityService.findById(id);
		if (cityWO == null) {
			System.out.println("Film with id " + id + " not found");
			return new ResponseEntity<CityWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CityWO>(cityWO, HttpStatus.OK);
	}

	// ---------------------------------------------------------------------------------------------

	@RequestMapping(value = "/createCity/", method = RequestMethod.POST)
	public ResponseEntity<Void> createCity(@RequestBody CityWO cityWO, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating City " + cityWO.getCity());
		cityService.saveCity(cityWO);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/city/{id}").buildAndExpand(cityWO.getCityId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/updateCity/", method = RequestMethod.POST)
	public ResponseEntity<Void> updateCity(@RequestBody CityWO cityWO, UriComponentsBuilder ucBuilder) {
		System.out.println(String.format("Updating City %s ", cityWO.getCity()));

		CityWO currentCity = cityService.findById(cityWO.getCityId());

		if (currentCity == null) {
			System.out.println("City with id " + cityWO.getCity() + " not found");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		cityService.saveCity(cityWO);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/city/{id}").buildAndExpand(cityWO.getCityId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteCity/{id}", method = RequestMethod.GET)
	public ResponseEntity<CityWO> deleteCity(@PathVariable("id") int id) {

		System.out.println("Fetching & Deleting City with id " + id);

		CityWO currentCity = cityService.findById(id);
		if (currentCity == null) {
			System.out.println("Unable to delete. City with id " + id + " not found");
			return new ResponseEntity<CityWO>(HttpStatus.NOT_FOUND);
		}
		cityService.deleteCityById(id);
		return new ResponseEntity<CityWO>(HttpStatus.NO_CONTENT);
	}

}
