package com.ilegra.nps.io;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.ilegra.nps.system.SystemConfig;

public class FileConfiguration {
	
	public static final String SPLITTER = SystemConfig.isWindows() ? "\\" : "/";
	public static final String DIRECTORY = SPLITTER + "logs";
	public static final Path PATH = Paths.get(System.getProperty("user.home")+DIRECTORY);
	public static final String EXTENSION = ".log";
}
