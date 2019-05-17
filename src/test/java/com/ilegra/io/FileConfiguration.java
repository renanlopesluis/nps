package com.ilegra.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileConfiguration {
	
	public static final String IN_DIRECTORY = "\\logs";
	public static final Path IN_PATH = Paths.get(System.getProperty("user.dir") + IN_DIRECTORY);
	public static final String FILE_NAME = "access.log";

}
