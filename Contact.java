package Contact;

import java.util.Objects;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode

public class Contact {
	
	private String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact (String contactId, String firstName, String lastName, String phone, String address) {
		setContactId(contactId);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}
	
	//////// SETTERS ////////

	private void setContactId(String contactId) {
		if (contactId == null) {
			throw new IllegalArgumentException("Contact ID cannot be null.");
		}
		if (contactId.length() < 1) {
			throw new IllegalArgumentException("Contact ID must contain at least one character.");
		}
		if (contactId.length() > 10) {
			throw new IllegalArgumentException("Contact ID cannot be greater than ten characters.");
		}
			
		this.contactId = contactId;
	}
		
	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("First name cannot be null.");
		}
		if (firstName.length() < 1) {
			throw new IllegalArgumentException("First name must contain at least one character.");
		}
		if (firstName.length() > 10) {
			throw new IllegalArgumentException("First name cannot be greater than ten characters.");
		}
		
		this.firstName = firstName;
	}
		
	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last name cannot be null.");
		}
		if (lastName.length() < 1) {
			throw new IllegalArgumentException("Last name must contain at least one character.");
		}
		if (lastName.length() > 10) {
			throw new IllegalArgumentException("Last name cannot be greater than ten characters.");
		}
			
		this.lastName = lastName;
	}
		
	public void setPhone(String phone) {
		if (phone == null) {
			throw new IllegalArgumentException("Phone number cannot be null.");
		}
		if (!phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Phone number must be exactly ten characters.");
		}
		this.phone = phone;
	}
			
	public void setAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Address cannot be null.");
		}
		if (address.length() < 1) {
			throw new IllegalArgumentException("Address must contain at least one character.");
		}
		if (address.length() > 30) {
			throw new IllegalArgumentException("Address cannot be greater than 30 characters.");
		}
		this.address = address;
	}

	//////// GETTERS ////////
	
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	//////// EQUALS OVERRIDE ////////
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Contact)) {
			return false;
		}
		
		Contact other = (Contact) obj;
		
		return Objects.equals(contactId, other.contactId) &&
			   Objects.equals(firstName, other.firstName) &&
			   Objects.equals(lastName, other.lastName) &&
			   Objects.equals(phone, other.phone) &&
			   Objects.equals(address, other.address);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(contactId, firstName, lastName, phone, address);
	}
}