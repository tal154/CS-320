package contactTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

class ContactServiceTest {

	// Need something to test add, delete, and update
	/*
	 * Contact("0000000001", "Lee", "Anthony", "0123456789", "123 Example St.")
	 * Contact("0000000002", "Smith", "John", "1122334455", "Seattle")
	 * Contact("0000000003", "Beaumont", "Mary", "0123456789", "Denver")
	 * */
	
	// Testing adding when the information given should work
	@Test
	public void testAdd() {
		// Create contact list
		ContactService cs = new ContactService();
		
		// New contacts to add
		Contact test1 = new Contact("0000000001", "Lee", "Anthony", "0123456789", "123 Example St.");
		Contact test2 = new Contact("0000000002", "Smith", "John", "1122334455", "Seattle");
		Contact test3 = new Contact("0000000003", "Beaumont", "Mary", "0123456789", "Denver");
		
		// If the information is passes, add to list
		assertEquals(true, cs.addContact(test1));
		assertEquals(true, cs.addContact(test2));
		assertEquals(true, cs.addContact(test3));
		
	}
	
	// Test adding if the information should not work
	@Test
	public void testAddFail() {
		// Create contact list
		ContactService cs = new ContactService();
			
		// New contacts to add
		Contact test1 = new Contact("0000000001", "Lee", "Anthony", "0123456789", "123 Example St.");
		Contact test2 = new Contact("0000000002", "Smith", "John", "1122334455", "Seattle");
		Contact test3 = new Contact("0000000003", "Beaumont", "Mary", "0123456789", "Denver");
		
		// If the information is passes, add to list
		assertTrue(cs.addContact(test1));	
		assertTrue(cs.addContact(test2));
		assertTrue(cs.addContact(test3));
		
		// Try to add information that is already in the list
		assertEquals(false, cs.addContact(test3));
		
	}
	
	// Test deleting
	@Test
	public void testDelete() {
		// Create contact list
		ContactService cs = new ContactService();
					
		// New contacts to add
		Contact test1 = new Contact("0000000001", "Lee", "Anthony", "0123456789", "123 Example St.");
		Contact test2 = new Contact("0000000002", "Smith", "John", "1122334455", "Seattle");
		Contact test3 = new Contact("0000000003", "Beaumont", "Mary", "0123456789", "Denver");
	
		// If the information is passes, add to list
		assertEquals(true, cs.addContact(test1));
		assertEquals(true, cs.addContact(test2));
		assertEquals(true, cs.addContact(test3));
				
		// Delete contacts
		assertEquals(true, cs.deleteContact("0000000001"));
			
	}
	
	// Test deleting when it fails
	// Test for trying to delete a contact that does not exist
	@Test
	public void testDeleteFail1() {
		// Create contact list
		ContactService cs = new ContactService();
					
		// New contacts to add
		Contact test1 = new Contact("0000000001", "Lee", "Anthony", "0123456789", "123 Example St.");
		Contact test2 = new Contact("0000000002", "Smith", "John", "1122334455", "Seattle");
		Contact test3 = new Contact("0000000003", "Beaumont", "Mary", "0123456789", "Denver");
		
		// If the information is passes, add to list
		assertEquals(true, cs.addContact(test1));
		assertEquals(true, cs.addContact(test2));
		assertEquals(true, cs.addContact(test3));
		
		// Delete contacts
		assertEquals(true, cs.deleteContact("0000000001"));
		assertEquals(true, cs.deleteContact("0000000002"));
		
		// Try to delete a contact that does not exist
		assertEquals(false, cs.deleteContact("1"));
	}
	
	// Testing for deleting a contact that has already been deleted
	@Test
	public void testDeleteFail2() {
		// Create contact list
		ContactService cs = new ContactService();
					
		// New contacts to add
		Contact test1 = new Contact("0000000001", "Lee", "Anthony", "0123456789", "123 Example St.");
		Contact test2 = new Contact("0000000002", "Smith", "John", "1122334455", "Seattle");
		Contact test3 = new Contact("0000000003", "Beaumont", "Mary", "0123456789", "Denver");
		
		// If the information is passes, add to list
		assertEquals(true, cs.addContact(test1));
		assertEquals(true, cs.addContact(test2));
		assertEquals(true, cs.addContact(test3));
		
		// Delete contacts
		assertEquals(true, cs.deleteContact("0000000001"));
		assertEquals(true, cs.deleteContact("0000000002"));
		
		// Try to delete a contact that has already been deleted
		assertEquals(false, cs.deleteContact("0000000001"));
	}
	
	// Test updating
	@Test
	public void testUpdate() {
		// Create contact list
		ContactService cs = new ContactService();
							
		// New contacts to add
		Contact test1 = new Contact("0000000001", "Lee", "Anthony", "0123456789", "123 Example St.");
		Contact test2 = new Contact("0000000002", "Smith", "John", "1122334455", "Seattle");
		Contact test3 = new Contact("0000000003", "Beaumont", "Mary", "0123456789", "Denver");
		
		// If the information is passes, add to list
		assertEquals(true, cs.addContact(test1));
		assertEquals(true, cs.addContact(test2));
		assertEquals(true, cs.addContact(test3));	
		
		// Update Contacts
		assertEquals(true, cs.updateContact("0000000002", "lastname", "firstname", "9988776655", "City"));
	}
	
	// Test updating when it fails
	// Test updating when a condition is not met
	@Test
	public void testUpdateFail1() {
		// Create contact list
		ContactService cs = new ContactService();
							
		// New contacts to add
		Contact test1 = new Contact("0000000001", "Lee", "Anthony", "0123456789", "123 Example St.");
		Contact test2 = new Contact("0000000002", "Smith", "John", "1122334455", "Seattle");
		Contact test3 = new Contact("0000000003", "Beaumont", "Mary", "0123456789", "Denver");
		
		// If the information is passes, add to list
		assertEquals(true, cs.addContact(test1));
		assertEquals(true, cs.addContact(test2));
		assertEquals(true, cs.addContact(test3));	
		
		// Update Contacts
		assertEquals(true, cs.updateContact("0000000002", "lastname", "firstname", "9988776655", "City"));
		
		// Try to update contact when it fails a condition
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.updateContact("0000000002", "lastname", "firstname", "9988776655", null);
		});	
	}
	
	// Test updating contact that does not exist
	@Test
	public void testUpdateFail2() {
		// Create contact list
		ContactService cs = new ContactService();
							
		// New contacts to add
		Contact test1 = new Contact("0000000001", "Lee", "Anthony", "0123456789", "123 Example St.");
		Contact test2 = new Contact("0000000002", "Smith", "John", "1122334455", "Seattle");
		Contact test3 = new Contact("0000000003", "Beaumont", "Mary", "0123456789", "Denver");
		
		// If the information is passes, add to list
		assertEquals(true, cs.addContact(test1));
		assertEquals(true, cs.addContact(test2));
		assertEquals(true, cs.addContact(test3));	
		
		// Update Contacts
		assertEquals(true, cs.updateContact("0000000002", "lastname", "firstname", "9988776655", "City"));
				
		// Try to update contact that does not exist
		assertEquals(false, cs.updateContact("1", "lastname", "firstname", "9988776655", "city"));
	}
}

