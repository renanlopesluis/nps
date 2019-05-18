package com.ilegra.io;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ilegra.nps.io.FileConfiguration;
import com.ilegra.nps.io.FileStream;
import com.ilegra.nps.io.LogFileStream;

public class FileStreamTest { 
	
	private final String FILE_NAME = "\\access.log";
	
	@Before
	public void createALogFile() throws Exception{
		FileWriter arquivo;
		arquivo = new FileWriter(new File(FileConfiguration.PATH.toString()+FILE_NAME));
		arquivo.write("/pets/exotic/cats/10 1037825323957 5b019db5-b3d0-46d2-9963-437860af707f 1");
		arquivo.close();
	}

	@Test
	public void shouldConvertFileIntoStringList() throws Exception{
		FileStream fileStream = new LogFileStream();
		List<String> lines = fileStream.read();
		assertTrue(!lines.isEmpty());
		assertTrue(lines.size() == 1);
	}
	
}
