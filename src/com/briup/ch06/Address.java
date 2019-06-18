/**
 * @author xuchunlin
 * @time 2019年6月10日上午11:41:40
 * @version
 * @description TODO
 */
package com.briup.ch06;

public class Address {
	private String country;//国家
	private String city;//城市
	private String street;//街道
	
	public Address() {}
	
	public Address(String country,String city,String street) {
		this.country = country;
		this.city = city;
		this.street = street;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	
}

