package com.ilegra.nps.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileConfiguration {
	
	public static final String DIRECTORY = "\\logs";
	public static final Path PATH = Paths.get(System.getProperty("user.home")+DIRECTORY);
	public static final String EXTENSION = ".log";
}
