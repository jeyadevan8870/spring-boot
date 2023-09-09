package com.omsakthi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "VENDOR")
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "VENDORNAME")
	private String vendorName;
	
	@Column(name = "GSTNUMBER")
	private String gstNo;
	
	@Column(name = "PAN")
	private String panNo;
	
	@Column(name = "ADDRESSLINE1")
	private String address1;
	
	@Column (name="ADDRESSLINE2")
	private String address2;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "PINCODE")
	private String pinCode;
	
	@Column(name = "COUNTRY")
	private String contry;
	
	@Column(name = "PHONENUMBER")
	private String phoneNumber;
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}



	

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String sate) {
		this.state = sate;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	




}
