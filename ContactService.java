package Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ContactService {
	private final List<Contact> contacts;
	
	public ContactService() {
		this.contacts = new ArrayList<>();
	}
	
	//////// ADD CONTACT ////////

	// Add new contact using ID
	public void add(Contact contact) {
		
		if (contact == null) {
			throw new IllegalArgumentException("Contact ID cannot be null.");
		}
		for (Contact c : contacts) {
			if (c.getContactId().equals(contact.getContactId())) {
				throw new IllegalArgumentException("ID already exists.");
			}
		}
		contacts.add(copy(contact));
	}
	
	//////// DELETE CONTACT ////////
	
	public void delete(String id) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be null.");
		}
		boolean removed = contacts.removeIf(c -> c.getContactId().equals(id));
		if (!removed) {
			throw new NoSuchElementException("Contact ID cannot be found.");
		}
	}

	//////// EDIT CONTACT ////////
	
	public void edit(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Contact ID cannot be null.");
		}
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getContactId().equals(contact.getContactId())) {
				Contact updated = copy(contact);
				contacts.set(i,  updated);
				return;
			}
		}
		throw new NoSuchElementException("Contact cannot be found.");
	}
	
	//////// ALLOW ACCESS TO ALL CONTACTS ////////
	
	public List<Contact> getAll() {
		List<Contact> copies = new ArrayList<>();
		for (Contact contact : contacts) {
			copies.add(copy(contact));
		}
		return copies;
	}
	
	//////// RETURN SINGLE CONTACT ////////
	
	public Contact get(String id) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be found.");
		}
		for (Contact contact: contacts) {
			if (contact.getContactId().equals(id)) {
				return copy(contact);
			}
		}
		return null;
	}
	
	//////// CREATE DEEP COPY ////////
	
	private Contact copy(Contact original) {
		return new Contact(original.getContactId(), original.getFirstName(), original.getLastName(), original.getPhone(), original.getAddress());
	}
}
	