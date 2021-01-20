package com.springlec.base0702.dto;


public class BDto {
	
	int addressId;
	String addressName;
	String addressTel;
	String addressAddress;
	String addressEmail;
	String addressRelation;
	
	public BDto() {
		// TODO Auto-generated constructor stub
	}

	public BDto(int addressId, String addressName, String addressTel, String addressAddress, String addressEmail,
			String addressRelation) {
		super();
		this.addressId = addressId;
		this.addressName = addressName;
		this.addressTel = addressTel;
		this.addressAddress = addressAddress;
		this.addressEmail = addressEmail;
		this.addressRelation = addressRelation;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getAddressTel() {
		return addressTel;
	}

	public void setAddressTel(String addressTel) {
		this.addressTel = addressTel;
	}

	public String getAddressAddress() {
		return addressAddress;
	}

	public void setAddressAddress(String addressAddress) {
		this.addressAddress = addressAddress;
	}

	public String getAddressEmail() {
		return addressEmail;
	}

	public void setAddressEmail(String addressEmail) {
		this.addressEmail = addressEmail;
	}

	public String getAddressRelation() {
		return addressRelation;
	}

	public void setAddressRelation(String addressRelation) {
		this.addressRelation = addressRelation;
	}
	

}
