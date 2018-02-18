package com.rest.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.rest.business.Business;
import com.rest.business.BusinessImpl;
import com.rest.dao.DaoImpl;
import com.rest.exceptions.SimpleException;
import com.rest.models.Message;
import com.rest.poi.ApachePoi;
//@Component
@Path("/upload")
public class MainResource {
	
	@Autowired
	private Business business;

	public void setBusiness(Business business) {
		this.business = business;
	}
public Business getBusiness() {
		return business;
	}

	public ApachePoi getPoi() {
		return poi;
	}
@Autowired
@Qualifier("poi")
private ApachePoi poi;

public void setPoi(ApachePoi poi) {
	this.poi = poi;
}

@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.APPLICATION_JSON)
public Message upload(@FormDataParam("file")InputStream fileupload,
		@FormDataParam("file")FormDataContentDisposition fileDetails) throws IOException
{int i=0;
if(i==0)
{
throw new SimpleException("exception Occers")	;
}
	String workingDirectory=System.getProperty("user.dir");
	String locationUpload=workingDirectory+System.getProperty("file.separator")+fileDetails.getFileName();
	writeToFile(fileupload,locationUpload);
	//poi.readfile(locationUpload);
	//ApachePoi ap=new ApachePoi();
	//List list=ap.readfile(locationUpload);
	//System.out.println("ok");
	
	List list=poi.readfile(locationUpload);
	System.out.println(list.get(2));
	//Business business=new BusinessImpl(); 
	//DaoImpl dao=new DaoImpl();
	//dao.save(list);
	String s1=business.save(list);
	 
	Message message=new Message(404,s1,"google.com");
return message;	
}

private void writeToFile(InputStream fileupload, String locationUpload) {
	// TODO Auto-generated method stub
try
{
	FileOutputStream fos;
	byte bytes[] =new byte[1024];
	fos=new FileOutputStream(new File(locationUpload));
	int read=0;
	while((read=fileupload.read(bytes))!=-1)
	{
		fos.write(bytes, 0, read);
	}
	fos.flush();
	fos.close();
}
catch(Exception ex)
{
System.err.println(ex.getMessage());	
}
}
}
