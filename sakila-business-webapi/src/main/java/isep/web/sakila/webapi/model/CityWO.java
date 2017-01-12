package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.City;

public class CityWO extends WebObject {

	protected int cityId;
	protected String city;
	protected int countryId;

	public CityWO() {
		super();
	}

	public CityWO(int cityId, String city, int countryId) {
		super();
		this.cityId = cityId;
		this.city = city;
		this.countryId = countryId;
	}

	public CityWO(final City city) {
		super();
		this.cityId = city.getCityId();
		this.city = city.getCity();
		this.countryId = city.getCountry().getCountryId();
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

}
