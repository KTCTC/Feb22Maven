package dataprovider.annotation;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helper.ExcelHelper;

public class DataProviderClass2 {
	

	
	@DataProvider (name = "pair")
	public Object[][] sendUserCredentials()
	{
		ExcelHelper excelHelper = new ExcelHelper("KTCTC.xlsx", "Aug");
		ArrayList<String> keys = excelHelper.getKeysList();
		ArrayList<String> val = excelHelper.getValueList();
		String [][] data = new String[keys.size()][2];
		for (int i=0;i<keys.size();i++)
		{
			data[i][0] = keys.get(i);
			data[i][1] = val.get(i);
		}	
		
		
		return data;
	}
	

	@Test (dataProvider =  "pair" )
	public void verifyUserCanLoginWithProvidedCredentials2(String key, String val)
	{
		System.out.println(key);
		System.out.println(val);
		
	}
}
