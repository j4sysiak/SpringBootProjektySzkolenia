package pl.jaceksysiak.demo.entity;
        

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FINANCES_USER")
@Access(value = AccessType.FIELD)
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Integer userId;

	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="BIRTH_DATE", nullable = true)
	private Date birthDate;
	
	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@Column(name="CREATED_DATE", updatable = false)
	private Date createdDate;

	@Column(name="CREATED_BY", updatable = false)
	private String createdBy;
	
	
	public User() {}
	




	public User(Integer userId, String firstName, String lastName, Date birthDate, String emailAddress,
			Date lastUpdatedDate, String lastUpdatedBy, Date createdDate, String createdBy) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.emailAddress = emailAddress;
		this.lastUpdatedDate = lastUpdatedDate;
		this.lastUpdatedBy = lastUpdatedBy;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}





	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", emailAddress=" + emailAddress + ", lastUpdatedDate=" + lastUpdatedDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ "]";
	}
	
	
	
}
