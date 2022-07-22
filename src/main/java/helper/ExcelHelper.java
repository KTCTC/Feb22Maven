package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	private XSSFSheet sh;
	public ExcelHelper(String fileName, String sheetName)
	{
		 try {
			File f = new File(System.getProperty("user.dir")+"\\"+fileName);
			    
			    FileInputStream fis = new FileInputStream(f);
			    
			    XSSFWorkbook wb = new XSSFWorkbook(fis);
			    
			    sh = wb.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		    
			
	}
	
	public ArrayList<String> getKeysList()
	{
		ArrayList<String> data = new ArrayList<>();
		for (int i=1; i<=sh.getLastRowNum();i++)
		{
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(0);
			String key = getCellValueAccordingToCellType(cel);
			data.add(key);
		}
		return data;
		
	}
	public ArrayList<String> getValueList()
	{
		ArrayList<String> data = new ArrayList<>();
		for (int i=1; i<=sh.getLastRowNum();i++)
		{
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(1);
			String key = getCellValueAccordingToCellType(cel);
			data.add(key);
		}
		return data;
		
	}
	public HashMap<String,String> getKeyValuePair()
	{
		HashMap<String, String> data = new HashMap<>();
		for (int i=1; i<=sh.getLastRowNum();i++)
		{
			XSSFRow row = sh.getRow(i);
			
			String key = getCellValueAccordingToCellType(row.getCell(0));
			String val = getCellValueAccordingToCellType(row.getCell(1));
			data.put(key, val);
			
		}
		
		return data;
		
	}
	
	public ArrayList<String> getColumnData(int columnIndex)
	{
		ArrayList<String> data = new ArrayList<>();
		for (int i=1; i<=sh.getLastRowNum();i++)
		{
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(i);
			String key = getCellValueAccordingToCellType(cel);
			data.add(key);
		}
		return data;
	}
	
	
	private static String getCellValueAccordingToCellType(XSSFCell cel)
	{
		Object data= null;
		switch (cel.getCellType()) {
		case STRING:
			data = cel.getStringCellValue();
			break;
		case BOOLEAN:
			data = cel.getBooleanCellValue();
			break;
		case NUMERIC:
			DataFormatter df = new DataFormatter();
			data = df.formatCellValue(cel);
			//data = cel.getNumericCellValue();
			break;
		case FORMULA:
			data = cel.getCellFormula();

			break;
		case BLANK:
			System.out.println("Cell is blank");

			break;
		default:
			System.out.println("Unknown cell type");
			break;
		}
		
		return data.toString();

		
	}
	


}
