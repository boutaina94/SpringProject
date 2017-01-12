package isep.web.sakila.webapi.model;

import java.util.Date;

import isep.web.sakila.jpa.entities.Customer;

public class CustomerWO extends WebObject {

	protected int customerId;
	protected byte store_id;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected byte active;

	protected int addressId;
	protected String address;
	protected String address2;
	protected String district;
	protected int city_id;
	protected String postalCode;
	protected String phone;

	public CustomerWO() {
		super();
	}

	public CustomerWO(int customerId, byte store_id, String firstName, String lastName, String email, byte active,
			Date createDate, int addressId, String address, String address2, String district, int city_id,
			String postalCode, String phone) {
		super();
		this.customerId = customerId;
		this.store_id = store_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
		this.addressId = addressId;
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.city_id = city_id;
		this.postalCode = postalCode;
		this.phone = phone;
	}

	public CustomerWO(final Customer customer) {
		super();
		this.customerId = customer.getCustomerId();
		this.store_id = customer.getStore().getStoreId();
		this.firstName = customer.getFirstName();
		this.lastName = customer.getLastName();
		this.email = customer.getEmail();
		this.active = customer.getActive();
		this.addressId = customer.getAddress().getAddressId();
		this.address = customer.getAddress().getAddress();
		this.address2 = customer.getAddress().getAddress2();
		this.district = customer.getAddress().getDistrict();
		this.city_id = customer.getAddress().getCity().getCityId();
		this.postalCode = customer.getAddress().getPostalCode();
		this.phone = customer.getAddress().getPhone();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public byte getStore_id() {
		return store_id;
	}

	public void setStore_id(byte store_id) {
		this.store_id = store_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

}
