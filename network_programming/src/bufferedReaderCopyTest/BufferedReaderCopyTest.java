package bufferedReaderCopyTest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BufferedReaderCopyTest {
	public static void main(String args[]) {
		String oriPath = "E:\\javaTest\\JavaIOTestFile\\IOTest001.txt";
		String desPath = "E:\\javaTest\\JavaIOTestFileCopy\\IOTest001Copy.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(oriPath, StandardCharsets.UTF_8));
				BufferedWriter bw = new BufferedWriter(new FileWriter(desPath, StandardCharsets.UTF_8));
				){
			String line;
			while((line=br.readLine())!=null) {
				bw.write(line);
				bw.newLine();	
			}	
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
}
