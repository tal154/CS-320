package contact;

import java.util.ArrayList;

public class ContactService {

	// List of contact array
	private ArrayList<Contact> contacts;
		
	public ContactService() {
		// Beginning of the array list
		contacts = new ArrayList<>();
	}
	
	// Adding, deleting, and updating contact features
	// Add contact requiring all values
	public boolean addContact(Contact contact) {
		// Set bool to false
		boolean contactExists = false;
		// Iterate through contact list
		for (Contact contactArraylist:contacts) {
			// Check if contact already exists
			// If yes, then set contactExists to true
			if(contactArraylist.equals(contact)) {
				contactExists = true;
			}			
		}
		// If not already in list, add it
		if(!contactExists) {
			contacts.add(contact);
			// Set to true
			return true;
		}
		else {
			return false;
		}
	}
	
	// Delete by contactID
	public boolean deleteContact(String contactID) {
		// Iterate through list for contactID
		for (Contact contactArraylist:contacts) {
			if(contactArraylist.getContactID().equals(contactID)) {
				// Remove and return true
				contacts.remove(contactArraylist);
				return true;
			}
		}
		// Else return false
		return false;
	}
	
	// Update information while still following parameters
	public boolean updateContact(String contactID, String lastName, String firstName, String phone, String address) {
		// Iterate through list for contactID
		for(Contact contactArraylist:contacts) {
			if(contactArraylist.getContactID().equals(contactID)) {
				// If contactID matches, run through each update and follow requirements
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
					throw new IllegalArgumentException("Invalid Phone Number");
				}
				
				// Conditions for valid Address
				if(address == null||address.length()>30) {
					throw new IllegalArgumentException("Invalid Address");
				}
				
				// Update the contact list with new information
				contactArraylist.setLastName(lastName);
				contactArraylist.setFirstName(firstName);
				contactArraylist.setPhone(phone);
				contactArraylist.setAddress(address);
				return true;
			}
		}		
		return false;
	}	

}
