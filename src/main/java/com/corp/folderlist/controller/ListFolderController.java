package com.corp.folderlist.controller;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.corp.folderlist.exception.RecordNotFoundException;
import com.corp.folderlist.service.FolderListServiceImpl;
import com.corp.folderlist.dto.FileInfo;
import com.corp.folderlist.dto.ReqPathForm;
@RestController
@RequestMapping(path = "/api/v1", 
consumes = MediaType.APPLICATION_JSON_VALUE, 
produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class ListFolderController {
    
    @Autowired
    FolderListServiceImpl folderManager;

    
    
    @RequestMapping(path = "/directorylist", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
    method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getAllDirectoryList(@RequestParam(name = "folderPath") String folderPath) throws RecordNotFoundException
    {
    	try
    	{
    		return folderManager.listDirectory(new File( folderPath.trim().toString() ));
	    }
		catch(Exception e)
		{	throw new RecordNotFoundException("Invalid file");
		}
    }
   
    
    
    @RequestMapping(path = "/fileinfo", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
    method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public FileInfo getFileInfo(@RequestParam(name = "filePath") String filePath) throws RecordNotFoundException
    {
    	try
    	{
    		return folderManager.getFileInfo(new File( filePath.trim().toString() ));
	    }
		catch(Exception e)
		{throw new RecordNotFoundException("Invalid file");
		}
	 }
   
    }//end of class

