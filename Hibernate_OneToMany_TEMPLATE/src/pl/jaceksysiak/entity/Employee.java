package pl.jaceksysiak.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="employee",
			   cascade= {CascadeType.ALL})
	private List<Address> addresses;
	
	
	public Employee() {}
    
	public Employee(String name) {
		this.name = name;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	//!!!!!!!!!!!!!!!!!!!!IMPPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!!
    // add convenience methods for bi-directional relationship	
	public void add(Address tmpAddress) {
		if(addresses==null) {
			addresses = new ArrayList<Address>();
		}
		
		addresses.add(tmpAddress);
		tmpAddress.setEmployee(this);
	}
	
}
