import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

//자바에서 엑셀로쓰기
//jakarta에서 pio다운로드
//빌드패쓰로 poi-5.0.0 // commons-math3-3.6.1 가저오기

public class WriteExcel {

	public WriteExcel() {
		// TODO Auto-generated constructor stub
		
		//1객체생성
		HSSFWorkbook workbook =new HSSFWorkbook();
		
		//2시트 객체생성
		HSSFSheet sheet1 =workbook.createSheet("회원 목록");
		HSSFSheet sheet2 =workbook.createSheet();
		
		//3.로우 객체 생성
		HSSFRow row1 =sheet1.createRow(0);
		
		//4.cel객체 생성
		HSSFCell cell1=row1.createCell(0);
		
		//5.발루어 세팅
		cell1.setCellValue("번호");
		
		row1.createCell(1).setCellValue("이름");
		row1.createCell(2).setCellValue("연락처");
		row1.createCell(3).setCellValue("이메일");
		
		//////////////////////////////////
		String data[][]= {
				{"1","김길동","010-1234-1211","aab@naver.com"},
				{"2","나길동","010-1234-1311","aac@naver.com"},
				{"3","다길동","010-1234-1411","aaf@naver.com"},
				{"4","홍길동","010-1234-1511","aaa@naver.com"},
				{"5","차길동","010-1234-1611","aah@naver.com"}


				
		};	
		
		for(int r=0;r<data.length;r++) {
			HSSFRow cRow =sheet1.createRow(r+1);
			for(int c=0;c<data[r].length;c++) {
				if(c==0) {
					
				cRow.createCell(c).setCellValue(Integer.parseInt(data[r][c]));
				}else {
				cRow.createCell(c).setCellValue(data[r][c]);
				
			}
		}
		
	}
		//
		File f=new File("c://javaIO/member.xls");
		
		try {
		FileOutputStream fos=new FileOutputStream(f);
		workbook.write(fos);
		workbook.close();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
         System.out.println("엑셀로쓰기 완료");
		
		
		
	}
	public static void main(String[] args) {
		new WriteExcel();

	}

}
