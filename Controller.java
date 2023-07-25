package de.zeroco.company;

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

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	Service service;
   
	@RequestMapping(value = "/save", method = RequestMethod.GET, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<String> save(@ModelAttribute Company company, BindingResult bindingResult) {
		return new ResponseEntity<String>(service.insert(company) + "", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Integer> update(@ModelAttribute Company company, BindingResult bindingResult) {
		return ResponseEntity.ok(service.update(company));
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Integer> delete(HttpServletRequest request, HttpServletResponse response) {
		return ResponseEntity.ok(service.delete(Integer.parseInt(request.getParameter("id"))));
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<String> list() {
//		return ResponseEntity.ok(service.list());
		return new ResponseEntity<String>(service.list() + "", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<String> get(int id) {
//		return ResponseEntity.ok(service.get(id));
		return new ResponseEntity<String>(service.get(id) + "", HttpStatus.OK);
	}
	
}
