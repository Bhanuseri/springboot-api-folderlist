package com.corp.folderlist.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.corp.folderlist.service.FolderListServiceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
class FolderListImplTest {


	@InjectMocks
    FolderListServiceImpl FolderListBusinessImpl;
	
	  @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	     
	  @Test
	    public void getDirListTest() {
	    	try {
			    	final String FILE_NAME = "C:\\\\Users";
			    	FolderListBusinessImpl.listDirectory(new File(FILE_NAME));
			    	assertTrue(FolderListBusinessImpl.listDirectory(new File(FILE_NAME)).size() > 0 );	    	
	    		}catch(Exception e) {
	    			e.printStackTrace();
	    			}
	    }

	@Test
    public void getFileInfoTest() {
		try {
		    	final String FILE_NAME = "C:\\\\Bhanu-Demo-Software\\\\menulist\\pom.xml";		    	
		    	assertTrue(Integer.parseInt(FolderListBusinessImpl.getFileInfo(new File(FILE_NAME)).getSize()) > 0 );	    	
    		}catch(Exception e) {
    			e.printStackTrace();
    			}
    }
	
	
}