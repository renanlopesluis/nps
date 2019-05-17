package com.ilegra.nps.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class FileStream {

	public abstract List<String> read(InputStream input) throws IOException;
	
	public void delete(File file) {
		file.delete();
	}
}
