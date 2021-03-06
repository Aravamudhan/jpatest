package com.amudhan.jpatest.model.simple;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "SIMPLE_BID")
public class Bid {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	public Long getId() { // Optional but useful
		return id;
	}

	public Bid() {
	}

	@NotNull
	protected BigDecimal amount;

	public Bid(BigDecimal amount, Item item) {
		this.amount = amount;
		this.item = item;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@ManyToOne(optional = false, fetch = FetchType.LAZY)// NOT NULL
	@JoinColumn(name = "ITEM_ID")// Actually the default name
	protected Item item;

	public Bid(Item item) {
		this.item = item;
		item.getBids().add(this); // Bidirectional
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
