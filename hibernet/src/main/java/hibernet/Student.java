package hibernet;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student")


public class Student {
	
	private int id;
	
	private String name;
	private Address address;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Student_id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="Student_Name",nullable=false,length=200)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToOne(cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="ADDRESS_ID")
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
