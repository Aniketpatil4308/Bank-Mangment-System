package com.ap.bankApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Account {

	@Id
	@SequenceGenerator(sequenceName = "Account_Sequence", initialValue = 100000, allocationSize = 1, name = "ac_seq")
	@GeneratedValue(generator = "ac_seq", strategy = GenerationType.SEQUENCE)
	private long acNo;
	
	private String acName;
	
	private long mobileNo;
	
	private String address;
	
	private long adharNo;
	
	private String PanNo;
	
	private String gender;
	
	private String acType;
	
	private double balance;

	public long getAcNo() {
		return acNo;
	}

	public void setAcNo(long acNo) {
		this.acNo = acNo;
	}

	public String getAcName() {
		return acName;
	}

	public void setAcName(String acName) {
		this.acName = acName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}

	public String getPanNo() {
		return PanNo;
	}

	public void setPanNo(String panNo) {
		PanNo = panNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAcType() {
		return acType;
	}

	public void setAcType(String acType) {
		this.acType = acType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [acNo=" + acNo + ", acName=" + acName + ", mobileNo=" + mobileNo + ", address=" + address
				+ ", adharNo=" + adharNo + ", PanNo=" + PanNo + ", gender=" + gender + ", acType=" + acType
				+ ", balance=" + balance + "]";
	}
	
	
	
}
