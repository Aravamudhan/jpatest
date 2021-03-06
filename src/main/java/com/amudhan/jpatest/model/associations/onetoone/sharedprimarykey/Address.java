package com.amudhan.jpatest.model.associations.onetoone.sharedprimarykey;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.amudhan.jpatest.model.AbstractAddress;

@Entity( name = "ASSOCIATIONS_ONETOONE_SHAREDPRIMARYKEY_ADDRESS")
@Table( name = "ASSOCIATIONS_ONETOONE_SHAREDPRIMARYKEY_ADDRESS")
public class Address extends AbstractAddress{

	public Address(){
		super();
	}
	
	public Address(String street, String zipCode, String city) {
		super(street, zipCode, city);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", zipCode="
				+ zipCode + ", city=" + city + "]";
	}
	
}
