package com.corp.folderlist.service;
import java.io.File;
import java.util.Map;

import com.corp.folderlist.dto.FileInfo;
import com.corp.folderlist.exception.ResourceNotFoundException;


public interface IFolderListService {
	public Map<String, Object> listDirectory( File dir )throws ResourceNotFoundException;
	public FileInfo getFileInfo(File file) throws ResourceNotFoundException;
}

