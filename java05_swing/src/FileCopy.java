import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {

	public FileCopy() {
		// 파일복사하기
		try{
			File srcFile = new File("C://download//docu//img.jpg");
           File tarFile = new File("C://javaIo",srcFile.getName())	;	
        
        FileInputStream fi= new FileInputStream(srcFile);
        FileOutputStream fo= new FileOutputStream(tarFile);
		
        while(true) {
        	int inData=fi.read();
        	if(inData==-1)break;
        	fo.write(inData);	
        }
        
        fo.flush();
        fo.close();
        
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

	public static void main(String[] args) {
		new FileCopy();

	}

}
