package com.corp.folderlist.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.corp.folderlist.controller.ListFolderController;
import com.corp.folderlist.service.FolderListServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

@RunWith(MockitoJUnitRunner.class)
class AccountServiceImplTest {

	@Mock
	FolderListServiceImpl FolderListBusinessImpl;
	
	@InjectMocks
	ListFolderController ListFolderController;
	
	  @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	     
	  @Test
	    public void getDirListTest() {
	    	try {
			    	final String FILE_NAME = "C:\\\\Users";
			    	FolderListBusinessImpl.listDirectory(FILE_NAME);
			    	assertTrue(FolderListBusinessImpl.listDirectory(FILE_NAME).size() > 0 );	    	
	    		}catch(Exception e) {
	    			e.printStackTrace();
	    			}
	    }

	@Test
  public void getFileInfoTest() {
		try {
		    	final String FILE_NAME = "C:\\\\Bhanu-Demo-Software\\menulist\\pom.xml";		    	
		    	assertTrue(Integer.parseInt(FolderListBusinessImpl.getFileInfo(FILE_NAME).getSize()) > 0 );	    	
  		}catch(Exception e) {
  			e.printStackTrace();
  			}
  }
			
}