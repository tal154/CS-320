package contact;

public class Contact {
	final String contactID;
	private String lastName;
	private String firstName;
	private String phone;
	private String address;
	
	public Contact(String contactID, String lastName, String firstName, String phone, String address) {
		// Conditions for valid Contact ID
		if(contactID == null||contactID.length()>10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		// Conditions for valid Last Name
		if(lastName == null||lastName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		// Conditions for valid First Name
		if(firstName == null||firstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		// Conditions for valid Phone
		if(phone == null||phone.length()!=10) {
			throw new IllegalArgumentException("Invalid Phone");
		}
		
		// Conditions for valid Address
		if(address == null||address.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.contactID = contactID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.phone = phone;
		this.address = address;
	}
	
	// All the getters for contacts
	public String getContactID() {
		return contactID;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	// All the setters for contacts
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
