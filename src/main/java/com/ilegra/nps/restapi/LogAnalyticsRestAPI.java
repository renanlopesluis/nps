package com.ilegra.nps.restapi;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataParam;

import com.ilegra.nps.io.FileStream;
import com.ilegra.nps.io.LogFileStream;
import com.ilegra.nps.model.Summary;
import com.ilegra.nps.service.statistics.Analytics;
import com.ilegra.nps.service.statistics.LogAccessAnalytics;

@Path("/laar")
public class LogAnalyticsRestAPI {

	private Analytics analytics;

	public LogAnalyticsRestAPI() {
		analytics = new LogAccessAnalytics();
	}

	@Path("/ingest")
	@POST
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	@Produces(MediaType.APPLICATION_JSON)
	public Response summarizerLogs(@FormDataParam("file") InputStream file) {
		try {
			FileStream stream = new LogFileStream();
			Summary summary = analytics.summarize(stream.read(file));
			return Response.ok(summary).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
