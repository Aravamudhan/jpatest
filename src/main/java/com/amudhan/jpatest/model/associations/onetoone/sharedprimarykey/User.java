package com.amudhan.jpatest.model.associations.onetoone.sharedprimarykey;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity( name = "ASSOCIATIONS_ONETOONE_SHAREDPRIMARYKEY_USER")
@Table( name = "ASSOCIATIONS_ONETOONE_SHAREDPRIMARYKEY_USER")
public class User {

	//TODO:Check difference between OneToOne uni and bi. 
	/*@IdUsing application generated id.
	private long id;*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	private String name;
	@OneToOne(
		fetch = FetchType.LAZY,//Default is EAGER.
		cascade = CascadeType.ALL,
		optional = false)
	/* We are using the primary id of User as a foreign key to the Address.*/
	@PrimaryKeyJoinColumn
	private Address shippingAddress;
	
	public User(){}
	
	public User(long id, String name){
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name +" ] ";
	}
	
}
