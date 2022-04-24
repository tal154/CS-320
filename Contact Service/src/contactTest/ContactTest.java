package contactTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	// Testing class
	@Test
	void testContact() {
		Contact contact = new Contact("0000000001", "Lee", "Anthony", "0123456789", "123 Example St.");
		assertTrue(contact.getContactID().equals("0000000001"));
		assertTrue(contact.getLastName().equals("Lee"));
		assertTrue(contact.getFirstName().equals("Anthony"));
		assertTrue(contact.getPhone().equals("0123456789"));
		assertTrue(contact.getAddress().equals("123 Example St."));
	}
	
	// Testing Contact ID length
	@Test
	void testContactContactIDTooLong() {
		// generate string with length of 11
		int width = 11;
		char fill = '0';
				
		// padding the string
		String toPad = "1";
		String idTest = new String(new char[width - toPad.length()]).replace('\0', fill) + toPad;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(idTest, "Lee", "Anthony", "0123456789", "123 Example St.");
		});		}
	
	// Testing Contact ID for null
	@Test
	void testContactContactIDIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Lee", "Anthony", "0123456789", "123 Example St.");
		});		}
	
	
	// Testing Last Name length
	@Test
	void testContactLastNameTooLong() {
		// generate string with length of 11
		int width = 11;
		char fill = '0';
		
		// padding the string
		String toPad = "name";
		String nameTest = new String(new char[width - toPad.length()]).replace('\0', fill) + toPad;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(nameTest, "Lee012345678", "Anthony", "0123456789", "123 Example St.");
		});		}
	
	// Testing Last Name for null
	@Test
	void testContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", null, "Anthony", "0123456789", "123 Example St.");
		});		}
	
	
	// Testing First Name length
	@Test
	void testContactFirstNameTooLong() {
		// generate string with length of 11
		int width = 11;
		char fill = '0';
		
		// padding the string
		String toPad = "name";
		String nameTest = new String(new char[width - toPad.length()]).replace('\0', fill) + toPad;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(nameTest, "Lee", "Anthony01234", "0123456789", "123 Example St.");
		});		}
	
	// Testing First Name for null
	@Test
	void testContactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", "Lee", null, "0123456789", "123 Example St.");
		});		}
	
	// Testing Phone for length
	@Test
	void testContactPhoneIsTooLong() {		
		// generate string with length of 11
		int width = 11;
		char fill = '0';
		
		// padding the string
		String toPad = "name";
		String phoneTest = new String(new char[width - toPad.length()]).replace('\0', fill) + toPad;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", "Lee", "Anthony", phoneTest, "123 Example St.");
		});		}
	
	// Testing Phone for length
	@Test
	void testContactPhoneIsTooShort() {
		// generate string with length of 9
		int width = 9;
		char fill = '0';
		
		// padding the string
		String toPad = "name";
		String phoneTest = new String(new char[width - toPad.length()]).replace('\0', fill) + toPad;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", "Lee", "Anthony", phoneTest, "123 Example St.");
		});		}
	
	// Testing Phone for null
	@Test
	void testContactPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", "Lee", "Anthony", null, "123 Example St.");
		});		}
	
	// Testing Address for Length
	@Test
	void testContactAddressTooLong() {
		// generate string with length of 31
		int width = 31;
		char fill = '0';
		
		// padding the string
		String toPad = "name";
		String addressTest = new String(new char[width - toPad.length()]).replace('\0', fill) + toPad;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", "Lee", "Anthony", "0123456789", addressTest);
		});		}
	
	// Testing Address for null
	@Test
	void testContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0000000001", "Lee", "Anthony", "0123456789", null);
		});		}
}
