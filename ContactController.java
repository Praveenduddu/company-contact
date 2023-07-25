package de.zeroco.contact;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.zeroco.company.Service;

@org.springframework.stereotype.Controller
public class ContactController {
	
	@Autowired
	ContactService contactService;
	@Autowired
	Service service;
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Integer> insert(@ModelAttribute Contact contact, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = service.get("name", request.getParameter("company name"));
		contact.setCompanyId((int) map.get("pk_id"));
		return ResponseEntity.ok(contactService.contactInsert(contact));
	}
	
	@RequestMapping(value = "/contact-update", method = RequestMethod.GET, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Integer> update(@ModelAttribute Contact contact, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = service.get("name", request.getParameter("company name"));
		contact.setCompanyId((int) map.get("pk_id"));
		return ResponseEntity.ok(contactService.update(contact));
	}
	
	@RequestMapping(value = "/contact-delete", method = RequestMethod.GET, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Integer> delete(HttpServletRequest request, HttpServletResponse response) {
		return ResponseEntity.ok(contactService.delete(Integer.parseInt(request.getParameter("id"))));
	}
	
	@RequestMapping(value = "/contact-list", method = RequestMethod.GET)
	public ResponseEntity<String> list() {
//		return ResponseEntity.ok(contactService.list());
		return new ResponseEntity<String>(contactService.list() + "", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/contact-get", method = RequestMethod.GET)
	public ResponseEntity<String> get(int id) {
//		return ResponseEntity.ok(contactService.get(id));
		return new ResponseEntity<String>(contactService.get(id) + "", HttpStatus.OK);
	}
	
}
