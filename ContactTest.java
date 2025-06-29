package Test;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Contact.Contact;

public class ContactTest {
	
	private static final String VALID_Id = "1";
	private static final String VALID_FirstName = "A";
	private static final String VALID_LastName = "B";
	private static final String VALID_Phone = "9876543219";
	private static final String VALID_Address = "222";
	
	// Test Valid Contact Creation
	@Test
	public void validContactCreation() {
		Contact contact = new Contact(VALID_Id, VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		
		Assertions.assertEquals(VALID_Id, contact.getContactId());
		Assertions.assertEquals(VALID_FirstName, contact.getFirstName());
		Assertions.assertEquals(VALID_LastName, contact.getLastName());
		Assertions.assertEquals(VALID_Phone, contact.getPhone());
		Assertions.assertEquals(VALID_Address, contact.getAddress());
	}
	
	//////// TEST ID ////////
	
	@Test
	public void testId_withNullValue_throwsIllegalArgumentException() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> new Contact(null, VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address));
		Assertions.assertEquals("Contact ID cannot be null.", ex.getMessage());
	}
	
	@Test
	public void testId_tooShort_throwsIllegalArgumentException() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> new Contact("", VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address));
		Assertions.assertEquals("Contact ID must contain at least one character.", ex.getMessage());
	}
	
	@Test
	public void testId_tooLong_throwsIllegalArgumentException() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> new Contact("123456789000", VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address));
		Assertions.assertEquals("Contact ID cannot be greater than ten characters.", ex.getMessage());
	}
	
	
	///////// TEST FIRST NAME /////////
	
	@Test
	public void testFirstName_withNullValue() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_Id, null, VALID_LastName, VALID_Phone, VALID_Address));
		Assertions.assertEquals("First name cannot be null.", ex.getMessage());
	}
	
	@Test
	public void testFirstName_tooShort_throwsIllegalArgumentException() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_Id, "", VALID_LastName, VALID_Phone, VALID_Address));
		Assertions.assertEquals("First name must contain at least one character.", ex.getMessage());
	}
	@Test
	public void testFirstName_tooLong_throwsIllegalArgumentException() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_Id, "abcdefghijk", VALID_LastName, VALID_Phone, VALID_Address));
		Assertions.assertEquals("First name cannot be greater than ten characters.", ex.getMessage());
	}
	
	///////// TEST LAST NAME /////////
	
	@Test
	public void testLastName_withNullValue_throwsIllegalArgumentException() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_Id, VALID_FirstName, null, VALID_Phone, VALID_Address));
		Assertions.assertEquals("Last name cannot be null.", ex.getMessage());
	}
	
	@Test
	public void testLastName_tooShort_throwsIllegalArgumentException() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_Id, VALID_FirstName, "", VALID_Phone, VALID_Address));
		Assertions.assertEquals("Last name must contain at least one character.", ex.getMessage());
	}
	@Test
	public void testLastName_tooLong_ThrowsIllegalArgumentException() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_Id, VALID_FirstName, "abcdefghijk", VALID_Phone, VALID_Address));
		Assertions.assertEquals("Last name cannot be greater than ten characters.", ex.getMessage());
	}
	
	
	///////// TEST PHONE /////////
	
	@Test
	public void testPhone_withNullValue_throwsIllegalArgumentException() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_Id, VALID_FirstName, VALID_LastName, null, VALID_Address));
		Assertions.assertEquals("Phone number cannot be null.", ex.getMessage());
	}
	
	@Test
	public void testPhone_withNotTenDigits_throwsIllegalArgumentException() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_Id, VALID_FirstName, VALID_LastName, "12345678901", VALID_Address));
		Assertions.assertEquals("Phone number must be exactly ten characters.", ex.getMessage());
	}
	
	///////// TEST ADDRESS /////////
	
	@Test
	public void testAddress_withNullValue_throwsIllegalArgumentException() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_Id, VALID_FirstName, VALID_LastName, VALID_Phone, null));
		Assertions.assertEquals("Address cannot be null.", ex.getMessage());
	}
	
	@Test
	public void testAddress_tooShort_throwsIllegalArgumentException() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_Id, VALID_FirstName, VALID_LastName, VALID_Phone, ""));
		Assertions.assertEquals("Address must contain at least one character.", ex.getMessage());
	}
	@Test
	public void testAddress_tooLong_ThrowsIllegalArgumentException() {
		String longAddress = "a".repeat(31);
		Exception ex = assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_Id, VALID_FirstName, VALID_LastName, VALID_Phone, longAddress));
		Assertions.assertEquals("Address cannot be greater than 30 characters.", ex.getMessage());
	}
	
	//////// TEST EQUALS ////////
	
	@Test
	public void testEquals_withSameObject_returnsTrue() {
		Contact contact = new Contact(VALID_Id, VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		Assertions.assertTrue(contact.equals(contact));
	}

	@Test
	public void testEquals_withNull_returnsFalse() {
		Contact contact = new Contact(VALID_Id, VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		Assertions.assertFalse(contact.equals(null));
	}

	@Test
	public void testEquals_withDifferentClass_returnsFalse() {
		Contact contact = new Contact(VALID_Id, VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		Assertions.assertFalse(contact.equals("String"));
	}

	@Test
	public void testEquals_withEqualContacts_returnsTrue() {
		Contact cont1 = new Contact(VALID_Id, VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		Contact cont2 = new Contact(VALID_Id, VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		Assertions.assertTrue(cont1.equals(cont2));
}

	@Test
	public void testEquals_withDifferentContacts_returnsFalse() {
		Contact cont1 = new Contact(VALID_Id, VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		Contact cont2 = new Contact("10", VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		Assertions.assertFalse(cont1.equals(cont2));
	}

	//////// TEST HASH CODE ////////

	@Test
	public void testHashCode_withEqualObjects_returnsSameHash() {
		Contact cont1 = new Contact(VALID_Id, VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		Contact cont2 = new Contact(VALID_Id, VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		Assertions.assertEquals(cont1.hashCode(), cont2.hashCode());
	}

	@Test
	public void testHashCode_withDifferentObjects_returnsDifferentHash() {
		Contact cont1 = new Contact(VALID_Id, VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		Contact cont2 = new Contact("10", VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		Assertions.assertNotEquals(cont1.hashCode(), cont2.hashCode());
	}
}
