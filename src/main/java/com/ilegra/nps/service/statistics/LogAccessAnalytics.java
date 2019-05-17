package com.ilegra.nps.service.statistics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.ilegra.nps.model.AccessDataRow;
import com.ilegra.nps.model.DataRow;
import com.ilegra.nps.model.Summary;
import com.ilegra.nps.service.converter.DataRowListConverter;

public class LogAccessAnalytics implements Analytics{
	
	@Override
	public Summary summarize(List<String> lines) throws Exception {
		List<DataRow> dataRows = new DataRowListConverter().convert(lines);
		List<AccessDataRow> accessRows = getAcessDataRowList(dataRows);
	
		return new Summary(getTopThreeMostAccessedURLs(accessRows),
				getTopThreeMostAccessedURLsPerRegion(accessRows),
				getTheLeastAccessedURLInTheWorld(accessRows),
				getTopThreeMostAccessedURLsPerDayWeekYear(accessRows),
				getTheMostAccessedMinute(accessRows));
	}	
	
	private List<AccessDataRow> getAcessDataRowList(List<DataRow> rows) {
		return rows.stream().filter(x -> x.isClass(AccessDataRow.class))
				.map(x -> (AccessDataRow) x)
				.collect(Collectors.toList());
	}	
	
	private Map<String, Long> getTopThreeMostAccessedURLs(List<AccessDataRow> rows) {
		Map<String, Long> urls = groupByUrl(rows)
				.entrySet().stream()
		        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		        .limit(3)
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
		                (v1,v2) -> v1,
		                LinkedHashMap::new));   
		return urls;
	}
	
	private Map<Object, Long> getTopThreeMostAccessedURLsPerRegion(List<AccessDataRow> rows) {
		Map<Object, Long> urls = groupByUrlAndRegion(rows)
				.entrySet().stream()
		        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		        .limit(3)
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
		                (v1,v2) -> v1,
		                LinkedHashMap::new));
		return urls;
	}
	
	private Map<Object, Long> getTopThreeMostAccessedURLsPerDayWeekYear(List<AccessDataRow> rows) {
		Map<Object, Long> urls = groupByPerDayWeekYear(rows)
				.entrySet().stream()
		        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		        .limit(3)
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
		                (v1,v2) -> v1,
		                LinkedHashMap::new));   
		return urls;
	}
	
	private Integer getTheMostAccessedMinute(List<AccessDataRow> rows) {
		Map<Integer, Long> minutes = rows.stream().collect(
				Collectors.groupingBy(x->x.getDateTime().getMinute(), 
						Collectors.counting()));
		return Collections.max(minutes.entrySet(), Comparator.comparing(Entry::getValue)).getKey();
	}
	
	private String getTheLeastAccessedURLInTheWorld(List<AccessDataRow> rows) {
		Map<String, Long> urls = rows.stream().collect(
					Collectors.groupingBy(x->x.getUrl(), 
							Collectors.counting()));
		return Collections.min(urls.entrySet(), Comparator.comparing(Entry::getValue)).getKey();
		
	}	
	
	private Map<String, Long> groupByUrl(List<AccessDataRow> rows) {
		return rows.stream().collect(
					Collectors.groupingBy(x->x.getUrl(), 
							Collectors.counting()));
	}
	
	private Map<Object, Long> groupByUrlAndRegion(List<AccessDataRow> rows){
		return rows.stream().collect(Collectors.groupingBy(x->Arrays.
				asList(x.getUrl(), x.getRegion().getCode()), Collectors.counting()));
	}
	
	private Map<Object, Long> groupByPerDayWeekYear(List<AccessDataRow> rows){
		return rows.stream().collect(Collectors.groupingBy(x->Arrays.
				asList(x.getDateTime().getDayOfMonth(), x.getDateTime().getDayOfWeek(), x.getDateTime().getYear()), Collectors.counting()));
	}
}
