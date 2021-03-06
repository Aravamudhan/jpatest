package com.amudhan.jpatest.model.associations.onetomany.jointable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.amudhan.jpatest.model.AbstractUser;

@Entity(name = "ASSOCIATIONS_ONETOMANY_JOINTABLE_USER")
@Table(name = "ASSOCIATIONS_ONETOMANY_JOINTABLE_USER")
public class User extends AbstractUser {

	@OneToMany(mappedBy = "buyer")
	private Set<Item> boughtItems = new HashSet<Item>();

	public Set<Item> getBoughtItems() {
		return boughtItems;
	}

	public void setBoughtItems(Set<Item> boughtItems) {
		this.boughtItems = boughtItems;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}
