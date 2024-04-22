package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.graphbuilder.math.func.RoundFunction;

public class ExcelUtility {

	public static String readCellData(String sheetName, int rowNum, int cellNum)  {
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(FrameworkConstants.EXCEL_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Workbook workBook=WorkbookFactory.create(fis);
//		
//		Sheet sheet=workBook.getSheet("Sheet1");
//		
//		Row row=sheet.getRow(0);
//		
//		Cell cell=row.getCell(3);
//		
//		String stringvalue=cell.getStringCellValue();
//		System.out.println(stringvalue);
		
		try {
			return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
			
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	public static String[][] readRowData(String sheetName) throws IOException {
		FileInputStream fis=null;
		try {
			 fis=new FileInputStream(FrameworkConstants.EXCEL_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Workbook workBook=null;
		try {
			workBook=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Sheet sheet=workBook.getSheet(sheetName);
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println(rowCount);
		System.out.println(cellCount);
		
		String[][] data=new String[rowCount-1][cellCount];
		
		
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
				 
			}
		}
		
		workBook.close();
		return data;
		
	}
	
	
	
	public static void setDataIntoExcel(String sheetName, int rowNum, int cellNum,String data) {
		FileInputStream fis=null;
		try {
			 fis=new FileInputStream(FrameworkConstants.EXCEL_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Workbook workBook=null;
		try {
			workBook=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Sheet sheet=workBook.getSheet(sheetName);
		
		sheet.getRow(rowNum).getCell(cellNum).setCellValue(data);
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(FrameworkConstants.EXCEL_PATH);
			workBook.write(fos);
			workBook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	public static void main(String[] args) {
		setDataIntoExcel("Sheet3", 0, 0, "Abi");
	}
	
	
}
