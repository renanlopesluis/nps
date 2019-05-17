package com.ilegra.nps.model;

public class RankedURL {
	
	private String url;
	private String regionCode;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public RankedURL(String url, String regionCode) {
		super();
		this.url = url;
		this.regionCode = regionCode;
	}
	
}
