package com.ilegra.nps.service.statistics;

import java.util.List;

import com.ilegra.nps.model.Summary;

public interface Analytics {
	
	Summary summarize(List<String> lines) throws Exception;

}