package dataDriveTwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTxtOne {
	
	String line;
	String testData1[];
	int lineNum;
	public String[] readTxt() throws IOException{
	FileReader fr=new FileReader("src/testDataOne.txt");
	BufferedReader br=new BufferedReader(fr);
	
	while((line=br.readLine())!=null){
		lineNum++;
		if(lineNum>1){
			String [] testData1=line.split(" ", 2);
			
		}
		
	}
	
	return testData1;
	
	}

}
