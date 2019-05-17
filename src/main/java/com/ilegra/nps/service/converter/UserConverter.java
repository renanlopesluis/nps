package com.ilegra.nps.service.converter;

import com.ilegra.nps.model.User;

public class UserConverter implements Converter<User>{
	
	private static final int BEGIN_INDEX = 10;
	private static final int ID_INDEX = 0;
	private static final int UUID_INDEX = 1;
	protected static final String SPLITTER = " ";

	@Override
	public User convert(String row) throws Exception {
		String[] data = row.split(SPLITTER);
		return new User(data[ID_INDEX].substring(BEGIN_INDEX), data[UUID_INDEX]);
	}

}
