package com.example;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Stephane Nicoll
 */
@Service
public class MyService {

	@Cacheable("foo")
	public String getFoo(Integer id) {
		return String.valueOf(id);

	}
}
