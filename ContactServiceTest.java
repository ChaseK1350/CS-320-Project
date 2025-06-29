package Test;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Contact.Contact;
import Contact.ContactService;

public class ContactServiceTest {
	private ContactService service;
	
	private static final String VALID_ID = "1";
	private static final String VALID_FirstName = "Josh";
	private static final String VALID_LastName = "Allen";
	private static final String VALID_Phone = "1234567890";
	private static final String VALID_Address = "123";
	
	@BeforeEach
	public void setUp() {
		service = new ContactService();
	}
	
	//////// TEST ADD ID ////////
	
	@Test
	public void testAdd_withUniqueId_successfulAddition() {
		Contact cont = new Contact(VALID_ID, VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		service.add(cont);
		
		Assertions.assertEquals(cont, service.get(VALID_ID));
	}
	
	@Test
	public void testAdd_withNullId_throwsIllegalArgumentException() {
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> service.add(null));
		Assertions.assertEquals("Contact ID cannot be null.", thrown.getMessage());
	}
	
	@Test
	public void testAdd_withDuplicateId_throwsIllegalArgumentException() {
		Contact cont1 = new Contact("1", VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		Contact cont2 = new Contact("1", "Different", VALID_LastName, VALID_Phone, VALID_Address);
		
		service.add(cont1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.add(cont2));
	}
	
	//////// TEST DELETE WITH ID ////////
	
	@Test
	public void testDelete_existingAppointment_successfulDeletion() {
		Contact cont = new Contact(VALID_ID, VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		service.add(cont);
		
		service.delete(VALID_ID);
		Assertions.assertNull(service.get(VALID_ID));
	}
	
	@Test
	public void testDelete_withNullId_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.delete(null));
	}
	
	@Test
	public void testDelete_nonExistentId_throwsNoSuchElementException() {
		Assertions.assertThrows(NoSuchElementException.class, () -> service.delete("111"));
	}
	
	//////// TEST EDIT ////////
	
	@Test
	public void testEdit_existingContact_successfulEdit() {
		Contact original = new Contact(VALID_ID, VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		service.add(original);
		
		Contact updated = new Contact (VALID_ID, "James", VALID_LastName, VALID_Phone, VALID_Address);
		service.edit(updated);
		
		Contact fromService = service.get("1");
		Assertions.assertEquals("James", fromService.getFirstName());
		Assertions.assertEquals(VALID_LastName, fromService.getLastName());
		Assertions.assertEquals(VALID_Phone, fromService.getPhone());
		Assertions.assertEquals(VALID_Address, fromService.getAddress());
	}
	
	@Test 
	public void testEdit_withNullValue_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.edit(null));
	}
	
	@Test
	public void testEdit_nonExistentId_throwsNoSuchElementException() {
		Contact fake = new Contact("111", VALID_FirstName, VALID_LastName, VALID_Phone, "Non-existent.");
		
		Assertions.assertThrows(java.util.NoSuchElementException.class, () -> service.edit(fake));
	}
	
	//////// TEST RETURN SINGLE CONTACT ////////
	
	@Test
	public void testGet_nullId_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.get(null));
	}
	
	//////// TEST DEEP COPY ////////
	
	@Test
	public void test_getAll_returnsDeepCopy() {
		Contact cont = new Contact(VALID_ID, VALID_FirstName, VALID_LastName, VALID_Phone, VALID_Address);
		service.add(cont);
		
		var list = service.getAll();
		
		Assertions.assertEquals(1, list.size());
		Assertions.assertNotSame(cont, list.get(0));
	}
}