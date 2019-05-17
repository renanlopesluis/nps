package com.ilegra.nps.analytics;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
*/
import com.ilegra.nps.model.Summary;
import com.ilegra.nps.service.statistics.Analytics;
import com.ilegra.nps.service.statistics.LogAccessAnalytics;

public class AnalyticsTest {
	
	private List<String> data;
	private Analytics analytics;
	
	public AnalyticsTest() {
		analytics = new LogAccessAnalytics();
		data = new ArrayList<String>();
	}
	
	@Before
	public void init() {
		data.add("/pets/exotic/cats/10 1037825323957 5b019db5-b3d0-46d2-9963-437860af707f 1");
		data.add("/pets/guaipeca/dogs/1 1037825323957 5b019db5-b3d0-46d2-9963-437860af707g 2");
		data.add("/tiggers/bid/now 1037825323957 5b019db5-b3d0-46d2-9963-437860af707e 3");
		data.add("/pets/exotic/cats/10 1037825323957 5b019db5-b3d0-46d2-9963-437860af707f 2");
		data.add("/pets/exotic/cats/10 1037825323957 5b019db5-b3d0-46d2-9963-437860af707f 2");
		data.add("/tiggers/bid/now 1037825323957 5b019db5-b3d0-46d2-9963-437860af707e 1");
		data.add("/dogs/bid/now 1037825323957 5b019db5-b3d0-46d2-9963-437860af707e 3");
	}
	
	@Test
	public void shouldSummarizeData() throws Exception {
		Summary summary = analytics.summarize(data);
		Assert.assertNotNull(summary);
	}

}
