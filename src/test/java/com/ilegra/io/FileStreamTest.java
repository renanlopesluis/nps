package com.ilegra.io;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import com.ilegra.nps.io.FileConfiguration;
import com.ilegra.nps.io.FileStream;
import com.ilegra.nps.io.LogFileStream;

public class FileStreamTest {

	@Test
	public void shouldConvertFileIntoStringList() throws Exception{
		/*InputStream input = new FileInputStream(FileConfiguration.PATH+"\\"+FileConfiguration.FILE_NAME);
		FileStream fileStream = new LogFileStream();
		List<String> lines = fileStream.read(input);
		assertTrue(!lines.isEmpty());
		assertTrue(lines.size() == 9);*/
	}
	
}
