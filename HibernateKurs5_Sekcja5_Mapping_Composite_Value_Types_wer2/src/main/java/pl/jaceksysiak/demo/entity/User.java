package pl.jaceksysiak.demo.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "FINANCES_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long userId;
	
	@Embedded
	@AttributeOverrides({
				@AttributeOverride(name="addressLine1", column=@Column(name="USER_ADDRESS_LINE_111")),
				@AttributeOverride(name="addressLine2", column=@Column(name="USER_ADDRESS_LINE_222"))
				})
	private Address address = new Address();
	

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "BIRTH_DATE")
	private Date birthDate;

	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Formula("lower(datediff(curdate(), birth_date)/365)")
	private int age;
	
	
//	public User() {}
//
//	public User(Long userId, Address address, String firstName, String lastName, Date birthDate, String emailAddress,
//			Date lastUpdatedDate, String lastUpdatedBy, Date createdDate, String createdBy, int age) {
//		this.userId = userId;
//		this.address = address;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.birthDate = birthDate;
//		this.emailAddress = emailAddress;
//		this.lastUpdatedDate = lastUpdatedDate;
//		this.lastUpdatedBy = lastUpdatedBy;
//		this.createdDate = createdDate;
//		this.createdBy = createdBy;
//		this.age = age;
//	}


	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
 
}
