package com.ilegra.nps.service.converter;

public interface Converter<T> {
	T convert(String row) throws Exception;
	
}