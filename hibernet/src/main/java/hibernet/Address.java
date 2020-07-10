package hibernet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {
	
	
	private int addId;
	@Column(name="Street",nullable=false,length=200)
	private String street;
	@Column(name="State",nullable=false,length=200)
	private String state;
	@Column(name="PIN",nullable=false,length=200)
	private String pin;
	
	@Id
	@GeneratedValue
	
	@Column(name="ADDRESS_ID")
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	;
}
