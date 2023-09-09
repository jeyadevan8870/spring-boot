package com.omsakthi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARTICULAR")
public class ParticularEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "INVOICENUMBER")
	private String invoiceNumber;

	@Column(name = "ITEM")
	private String item;

	@Column(name = "HSN_SAC")
	private String hsnsac;

	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "RATE")
	private int rate;

	@Column(name = "TOTALPRICE")
	private int totalPrice;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getHsnsac() {
		return hsnsac;
	}

	public void setHsnsac(String hsnsac) {
		this.hsnsac = hsnsac;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

}
