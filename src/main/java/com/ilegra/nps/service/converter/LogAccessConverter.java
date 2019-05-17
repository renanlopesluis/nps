package com.ilegra.nps.service.converter;

import com.ilegra.nps.enumeration.ConverterTypeEnum;
import com.ilegra.nps.enumeration.DataRowTypeEnum;
import com.ilegra.nps.model.DataRow;

public class LogAccessConverter implements Converter<DataRow>{
	
	@Override
	public DataRow convert(String row) throws Exception{
		ConverterTypeEnum converterType = ConverterTypeEnum.getFromType(DataRowTypeEnum.ACCESS_DATA_ROW);
		return converterType.getConverter().convert(row);
	}

}
