package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path =System.getProperty("user.dir")+"/testData/Opencart_Logindata.xlsx"; //Taking Excel file from testData
		ExcelUtility xlutil= new ExcelUtility(path); //Creating an object for ExcelUtility
		int totalRows =xlutil.getRowCount("Sheet1");
		int totalCols =xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]= new String[totalRows][totalCols]; //Created for two Dimension array which can store the excel data
		
		for(int i=1;i<=totalRows;i++) //Reading the data from excel storing it into 2D array
		{
			for(int j=0;j<totalCols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j); //1,0
			}
		}
		
		return logindata; //returning 2D array
		
	}
	
	//@DataProvider2
	//@DataProvider3
	//@DataProvider4
}
