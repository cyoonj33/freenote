import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReadExcel {

	public ReadExcel() {
		//엑셀파일 읽어오기
		try {
		File f= new File("C://javaIO/member.xls");
		FileInputStream fis=new FileInputStream(f);
		
		//1poi객체 열어오기
		POIFSFileSystem poi= new POIFSFileSystem(fis);
		//2workbook
		 HSSFWorkbook workbook =new HSSFWorkbook(poi);
		//3sheet
		int sheetCount = workbook.getNumberOfSheets();
				System.out.println(sheetCount);
				//4row
				HSSFSheet sheet=workbook.getSheet("회원 목록"); //workbook.getsheetA(0)
				
				int rowCount = sheet.getPhysicalNumberOfRows();
				
				for(int row=0; row<rowCount;row++) {
					HSSFRow memRow =sheet.getRow(row);
					
					//칸수구하기
					int colCount = memRow.getPhysicalNumberOfCells();
					for(int col=0; col<colCount; col++) {
						//5cell
						HSSFCell cell=memRow.getCell(col);
						//숫자 문자
						if(row>0 && col==0) {//숫자로읽기
							int data = (int)cell.getNumericCellValue();
							System.out.print(data+"\t");
						}else {//문자로 읽기
							String data = cell.getStringCellValue();
							System.out.print(data+"\t");
						}
					}
					System.out.println();
				}
		
				fis.close();
				poi.close();
				
		//cell
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		new ReadExcel();

	}

}
