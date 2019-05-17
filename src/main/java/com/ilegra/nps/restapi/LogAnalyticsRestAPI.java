package com.ilegra.nps.restapi;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.ilegra.nps.io.FileStream;
import com.ilegra.nps.io.LogFileStream;
import com.ilegra.nps.model.Summary;
import com.ilegra.nps.service.statistics.Analytics;
import com.ilegra.nps.service.statistics.LogAccessAnalytics;

@Path("/")
public class LogAnalyticsRestAPI {

	private FileStream stream;
	
	public LogAnalyticsRestAPI() {
		stream = new LogFileStream();
	}

	@Path("laar/ingest")
	@POST
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	@Produces(MediaType.APPLICATION_JSON)
	public Response processLogsFile(
			@FormDataParam("file") InputStream file, @FormDataParam("file") FormDataContentDisposition fileInfo) {
		try {
			stream.write(file, fileInfo.getFileName());
			return Response.status(Response.Status.ACCEPTED).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Path("laa/metrics")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSummary() {
		try {
			Analytics analytics = new LogAccessAnalytics();
			Summary summary = analytics.summarize(stream.read());
			return Response.ok(summary).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
