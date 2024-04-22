package genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	public static String getProperty(String key) {
		//Step 1: Get the Java representation of Physical file
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(FrameworkConstants.PROPERTIES_PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//Step 2: Create the object of Properties class
		Properties pObj=new Properties();
		
		//Step 3: Load Key and values to the Properties object
		try {
			pObj.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Step 4: Get the property 
		return pObj.getProperty(key);
		
		
	}
	
	public static String getStringValue(String sheetName,int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
	
		Workbook book=WorkbookFactory.create(fis);
		
		Sheet sheet=book.getSheet(sheetName);
		
		Row row=sheet.getRow(rowNum);
		
		Cell cell=row.getCell(cellNum);
		
		return cell.getStringCellValue();
	
	}
	
	public static double getNumericValue(String sheetName,int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
//	
//		Workbook book=WorkbookFactory.create(fis);
//		
//		Sheet sheet=book.getSheet(sheetName);
//		
//		Row row=sheet.getRow(rowNum);
//		
//		Cell cell=row.getCell(cellNum);
//		
//		return cell.getNumericCellValue();
		
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
		
	}
	
	
	public static String[][] getExcelData(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet(sheetName);
		int rowCount=sheet.getPhysicalNumberOfRows();
		
		int colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		String[][] data=new String[rowCount-1][colCount];
		
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}

//		for(int i=0;i<rowCount-1;i++) {
//			for(int j=0;j<colCount;j++) {
//				System.out.print(data[i][j]+"     ");
//			}
//			System.out.println();
//		}
		
		
		return data;
		
	}
	
	
	
	
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		getExcelData("Login");	}
	
	

}
