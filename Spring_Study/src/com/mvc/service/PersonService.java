package com.mvc.service;

import org.springframework.stereotype.Service;

import com.mvc.bean.Person;
@Service
public interface PersonService {
	Person getPersonbyId(Integer personId);
}
