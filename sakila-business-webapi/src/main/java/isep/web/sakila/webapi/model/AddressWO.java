package isep.web.sakila.webapi.model;

public class AddressWO extends WebObject {

	protected int addressId;
	protected String address;
	protected String address2;
	protected String district;
	protected String postalCode;
	protected String phone;
	protected CityWO city;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
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

	public CityWO getCity() {
		return city;
	}

	public void setCity(CityWO city) {
		this.city = city;
	}

	public AddressWO(int addressId, String address, String address2, String district, String postalCode, String phone,
			CityWO city) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.postalCode = postalCode;
		this.phone = phone;
		this.city = city;
	}

	public AddressWO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
