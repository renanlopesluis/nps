package com.ilegra.nps.model;

import java.util.Map;

public class Summary {

	private Map<String, Long> topThreeMostAcessedURLsInTheWorld;
	private Map<Object, Long> topThreeMostAcessedURLsPerRegion;
	private String theLeastAccessedUrlInTheWorld;
	private Map<Object, Long> topThreeMostAcessedURLsPerDayWeekYear;
	private Integer theMinuteWithMoreAcess;
	
	public Summary(Map<String, Long> topThreeMostAcessedURLsInTheWorld,
			Map<Object, Long> topThreeMostAcessedURLsPerRegion,
			String theLeastAccessedUrlInTheWorld,
			Map<Object, Long> topThreeMostAcessedURLsPerDayWeekYear,
			Integer theMinuteWithMoreAcess) {
		super();
		this.topThreeMostAcessedURLsInTheWorld = topThreeMostAcessedURLsInTheWorld;
		this.topThreeMostAcessedURLsPerRegion = topThreeMostAcessedURLsPerRegion;
		this.theLeastAccessedUrlInTheWorld = theLeastAccessedUrlInTheWorld;
		this.topThreeMostAcessedURLsPerDayWeekYear = topThreeMostAcessedURLsPerDayWeekYear;
		this.theMinuteWithMoreAcess = theMinuteWithMoreAcess;
	}

	public Map<String, Long> getTopThreeMostAcessedURLsInTheWorld() {
		return topThreeMostAcessedURLsInTheWorld;
	}

	public Map<Object, Long> getTopThreeMostAcessedURLsPerRegion() {
		return topThreeMostAcessedURLsPerRegion;
	}

	public String getTheLeastAccessedUrlInTheWorld() {
		return theLeastAccessedUrlInTheWorld;
	}

	public Map<Object, Long> getTopThreeMostAcessedURLsPerDayWeekYear() {
		return topThreeMostAcessedURLsPerDayWeekYear;
	}

	public Integer getTheMinuteWithMoreAcess() {
		return theMinuteWithMoreAcess;
	}
	
}
