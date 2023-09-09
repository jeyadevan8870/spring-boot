package com.omsakthi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.omsakthi.dto.Particulars;

@Entity
@Table(name = "INVOICE")
public class InvoiceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INVOICEID")
	private long id;

	@Column(name = "INVOICENUMBER")
	private long invoiceNumber;

	@Column(name = "INVOICEDATE")
	private String invoiceDate;

	@Column(name = "VENDORID")
	private String vendorId;

	@Column(name = "TOTALAMOUNT")
	private int totalAmount;

	@Column(name = "CGST")
	private int cgst;

	@Column(name = "SGST")
	private int sgst;
	@Column(name = "TAX")
	private int tax;
	
	

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	

	public long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getCgst() {
		return cgst;
	}

	public void setCgst(int cgst) {
		this.cgst = cgst;
	}

	public int getSgst() {
		return sgst;
	}

	public void setSgst(int sgst) {
		this.sgst = sgst;
	}



}
