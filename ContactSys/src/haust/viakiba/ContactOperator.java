package haust.viakiba;

import java.util.List;

public interface ContactOperator {
	public void addContact(Contact contact);
	public void deleteContact(String id);
	public void updateContact(Contact contact);
	public List<Contact> findAll();
}
