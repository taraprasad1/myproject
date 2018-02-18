package com.rest.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.rest.models.UserDetails;
 
@Component("poi")
public class ApachePoi {
public List readfile(String location) throws IOException
{

	List l=new ArrayList();
FileInputStream fis=new FileInputStream(new File(location));
XSSFWorkbook workbook=new XSSFWorkbook(fis);	
XSSFSheet sheet=workbook.getSheetAt(0);
XSSFRow row;
Iterator<Row>  itr=sheet.iterator();
while(itr.hasNext())
{
	row=(XSSFRow)itr.next();
	Iterator<Cell> citr=row.cellIterator();
	UserDetails ud=new UserDetails();
	while(citr.hasNext())
	{
		Cell cell=(Cell)citr.next();
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
		{
			if(cell.getColumnIndex()==0)
			{
			System.out.println(cell.getStringCellValue());
			ud.setFname(cell.getStringCellValue());
			}
			if(cell.getColumnIndex()==1)
			{
			System.out.println(cell.getStringCellValue());
			ud.setMname(cell.getStringCellValue());
			}
			if(cell.getColumnIndex()==2)
			{
			System.out.println(cell.getStringCellValue());
			ud.setLname(cell.getStringCellValue());
			}
			
		}
		
	}l.add(ud);
}
return l;
}

}
