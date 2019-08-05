package com.example.demo.beanFactory;

import org.springframework.core.convert.converter.Converter;

public class StringToPhoneNumberConverter implements Converter<String, Number> {
	@Override
	public Number convert(String source) {
		return null;
	}
}
