package com.spring.beanannotation;

import org.springframework.stereotype.Repository;

@Repository
public interface InjectionDAO {
	public void save(String arg);
}

