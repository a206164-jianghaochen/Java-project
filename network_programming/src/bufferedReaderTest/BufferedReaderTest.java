package bufferedReaderTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		
		String filePath = "E:\\javaTest\\outputStreamTest\\test001";
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String read;
			while((read=br.readLine())!=null) {
				System.out.println(read);	
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
