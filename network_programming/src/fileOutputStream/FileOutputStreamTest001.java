package fileOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest001 {
	public static void main(String args[]){
		String filePath1 = "E:\\javaTest\\outputStreamTest\\test001";
		String filePath2 = "E:\\javaTest\\outputStreamTest\\test002";
		try(FileInputStream input = new FileInputStream(filePath1); FileOutputStream f = new FileOutputStream(filePath2)) {
			int read;
			while((read = input.read()) !=-1) {
				System.out.print((char)read);
				f.write(read);
			}
			System.out.println("file has been read successfully. Resources have been released by JVM");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
