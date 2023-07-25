package de.zeroco.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import de.zeroco.contact.ContactDao;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	Dao dao;
	
	@Autowired
	ContactDao contactDao;
	
	public int insert(Company company) {
		return dao.insert(company);
	}
	
	public int update(Company company) {
		return dao.update(company);
	}
	
	public int delete(int id) {
		return dao.delete(id);
	}
	
	public List<Map<String, Object>> list() {
		List <Map<String, Object>> list = dao.list();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.remove(0);
			map.put("contacts", getContacts("number", "company_id", map.get("pk_id")));
			list.add(map);
		}
		return list;
	}
	
	public Map<String, Object> get(int id) {
		Map<String, Object> map = dao.get(id);
		map.put("contacts", getContacts("number", "company_id", map.get("pk_id")));
		return map;
	}
	
	public Map<String, Object> get(String columnName, Object value) {
		return dao.get(columnName, value);
	}
	
	public List<Object> getContacts(String columnName, String conditionColumn, Object value) {
		List<Map<String, Object>> list = contactDao.get(columnName, conditionColumn, value);
		List<Object> contactList = new ArrayList<Object>();
		for (int j = 0; j < list.size(); j++) {
			contactList.add(list.get(j).get("number"));
		}
		return contactList;
	}
	
}
