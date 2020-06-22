package com.corp.folderlist.util;

import java.io.File;

public class FileUtil {
	
	public static String getFileName(File file)
	{
		return file.getName();
	}
	
	public static String getFileType(File file)
	{
		if (file.canExecute())
			return "Execute";
		else if (file.canRead())
			return "Read";
		else if (file.canWrite())
			return "Write";
		return null;
		
	}
	public static String getFileSizeMegaBytes(File file) {
		return (double) file.length() / (1024 * 1024) + " mb";
	}
	
	public static  String getFileSizeKiloBytes(File file) {
		return (double) file.length() / 1024 + "  kb";
	}

	public static String getFileSizeBytes(File file) {
		return file.length() + " bytes";
	}
	public static boolean isFile(File file) {
		if (!file.exists() && !file.isFile()) 
			return false;
		else 
			return true;
		}
	public static boolean isDirectory(File dir) 
		{
		if (dir.exists() && dir.isDirectory()) 
			return true;
			
		else 
			return false;
}
}
