package com.omsakthi.dto;

import java.util.List;

public class Invoice {
	/**hello**/
	private String invoiceNumber;

	private String invoiceDate;

	private String vendorId;

	private int totalAmount;

	private int cgst;

	private int sgst;
	
	private int tax;
	


	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	private List<Particulars> particulars;

	public List<Particulars> getParticulars() {
		return particulars;
	}

	public void setParticulars(List<Particulars> particulars) {
		this.particulars = particulars;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
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
