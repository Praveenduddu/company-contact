package de.zeroco.contact;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ContactService {
	
	@Autowired
	ContactDao contactDao;
	
	public int contactInsert(Contact contact) {
		return contactDao.insert(contact);
	}
	
	public int update(Contact contact) {
		return contactDao.update(contact);
	}
	
	public int delete(int id) {
		return contactDao.delete(id);
	}
	
	public List<Map<String, Object>> list() {
		return contactDao.list();
	}
	
	public Map<String, Object> get(int id) {
		return contactDao.get(id);
	}
}
