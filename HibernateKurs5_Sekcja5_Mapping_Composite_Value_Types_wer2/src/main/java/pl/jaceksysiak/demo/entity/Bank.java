package pl.jaceksysiak.demo.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BANK")
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BANK_ID")
	private Integer bankId;
	
	@Column(name = "NAME")
	private String name;
	
	@Embedded
	private Address address = new Address();


	@Column(name = "IS_INTERNATIONAL")
	private boolean international;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "CREATED_BY")
	private String createdBy;
	

	
	
//	public Bank() {}
//	
//	public Bank(Integer bankId, String name, Address address, boolean international, Date lastUpdatedDate,
//			String lastUpdatedBy, Date createdDate, String createdBy) {
//		this.bankId = bankId;
//		this.name = name;
//		this.address = address;
//		this.international = international;
//		this.lastUpdatedDate = lastUpdatedDate;
//		this.lastUpdatedBy = lastUpdatedBy;
//		this.createdDate = createdDate;
//		this.createdBy = createdBy;
//	}
	

	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public boolean isInternational() {
		return international;
	}
	public void setInternational(boolean international) {
		this.international = international;
	}


	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getAddressLine1() {
		return address.getAddressLine1();
	}

	public void setAddressLine1(String addressLine1) {
		this.address.setAddressLine1(addressLine1);
	}

	public String getAddressLine2() {
		return address.getAddressLine2();
	}

	public void setAddressLine2(String addressLine2) {
		this.address.setAddressLine2(addressLine2);
	}

	public String getCity() {
		return address.getCity();
	}

	public void setCity(String city) {
		this.address.setCity(city);
	}

	public String getState() {
		return address.getState();
	}

	public void setState(String state) {
		this.address.setState(state);
	}

	public String getZipCode() {
		return address.getZipCode();
	}

	public void setZipCode(String zipCode) {
		this.address.setZipCode(zipCode);
	}
	

//	@Override
//	public String toString() {
//		return "Bank [bankId=" + bankId + ", name=" + name + ", address=" + address + ", international=" + international
//				+ ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + ", createdDate="
//				+ createdDate + ", createdBy=" + createdBy + "]";
//	}	
	
	
}
