package com.mvc.service.impl;

import org.springframework.stereotype.Service;

import com.mvc.bean.Person;
import com.mvc.service.PersonService;
@Service("personService")
public class PersonServiceImpl implements PersonService{
	@Override
	public Person getPersonbyId(Integer personId) {
		Person per = new Person();
		per.setId(personId);
		per.setAge("15");
		per.setName("zsc");
		return per;
	}
/*	public Person getPersonbyId(Integer personId) {
		// TODO Auto-generated method stub
		Person per = new Person();
		per.setId(personId);
		per.setAge("15");
		per.setName("zsc");
		return per;
	}*/
}
