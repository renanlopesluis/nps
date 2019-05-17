package com.ilegra.nps.service.converter;

import com.ilegra.nps.enumeration.RegionEnum;
import com.ilegra.nps.exception.EnumNotFoundException;
import com.ilegra.nps.model.Region;

public class RegionConverter implements Converter<Region>{

	@Override
	public Region convert(String row) throws EnumNotFoundException {
		return new Region(row, RegionEnum.getFromCode(row).getDescripton());
	}

}
