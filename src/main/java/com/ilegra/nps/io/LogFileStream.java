package com.ilegra.nps.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogFileStream extends FileStream{
	
	@Override
	public List<String> read(InputStream input) throws IOException {
		List<String> lines = new ArrayList<>();
		Scanner reader = new Scanner(input);
		while (reader.hasNext()) {
			lines.add(reader.nextLine());
		}
		reader.close();
		return lines;
	}

}
