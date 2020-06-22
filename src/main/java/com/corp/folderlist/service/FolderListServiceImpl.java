package com.corp.folderlist.service;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import javax.xml.bind.annotation.*;

import com.corp.folderlist.dto.FileInfo;
import com.corp.folderlist.dto.DirInfo;
import com.corp.folderlist.exception.ResourceNotFoundException;
import com.corp.folderlist.util.FileUtil;

@Service
public class FolderListServiceImpl implements IFolderListService {
	
	/*
	 * This method returns the Directory information with list of files and subfolder for the input String Directory Path name.
	 * 
	 */

	
	public Map<String, Object> listDirectory(File  file) throws ResourceNotFoundException {

		if (!FileUtil.isDirectory(file))
			throw new ResourceNotFoundException("Directory Path is invalid");
		File[] content = file.listFiles();
		List<DirInfo> files = new LinkedList<>();
		List<DirInfo> folderData = new LinkedList<>();
		List<Map<String, Object>> folders = new LinkedList<>();		
		
		
		//looping for each file
		for (File f : content) {
			
			if (f.isDirectory()) {		
				DirInfo dirInfo = new DirInfo();//declare to store the folder data
				dirInfo.setName(f.getName());
				dirInfo.setSize(FileUtil.getFileSizeKiloBytes(f));
				dirInfo.setPath(f.getPath());
				dirInfo.setType("folder");
				dirInfo.setFlag(1);//set flag for directory	
				folderData.add(dirInfo);
				Map<String, Object> folderInfo = new HashMap<String, Object>();
				folderInfo.put("folderInfo", dirInfo);
				
				folders.add(folderInfo);//write the folder data to the list object
				Map<String, Object> subList = listDirectory(f);//recursive function calling for each sud directory folder
				folders.add(subList);//add the folder to folders				
				
			} else {
				DirInfo fileInfo = new DirInfo();//declare to store the file data
				fileInfo.setName(f.getName());
				fileInfo.setSize(FileUtil.getFileSizeKiloBytes(f));
				fileInfo.setPath(f.getPath());
				fileInfo.setType("file");
				fileInfo.setFlag(0);//set flag for file
				files.add(fileInfo);//write the file info
			}
		}

		Map<String, Object> result = new HashMap<>();		
		if (!folders.isEmpty())//if not empty then only add the folders list object	
			result.put("folders", folders);//writing collection of folders to result
		if (!files.isEmpty())//if not empty then only add the files list object	
			result.put("files", files);//writing collection of files to result
					
		return result;
	}

	
	/*
	 * This method returns the File information for the input String File name.
	 * 
	 */
	
	public FileInfo getFileInfo(File file) throws ResourceNotFoundException {

		if (!FileUtil.isFile(file))
			throw new ResourceNotFoundException("File Name is invalid");
		FileInfo fileInfo = new FileInfo();

		fileInfo.setName(FileUtil.getFileName(file));
		fileInfo.setName(FileUtil.getFileName(file));
		fileInfo.setSize(FileUtil.getFileSizeKiloBytes(file));
		fileInfo.setType(FileUtil.getFileType(file));
		fileInfo.setPath(file.getPath());
		fileInfo.setAbspath(file.getAbsolutePath());
		fileInfo.setParent(file.getParent());

		return fileInfo;//return file info object

	}// end of getFileInfo()

}// end of class()
