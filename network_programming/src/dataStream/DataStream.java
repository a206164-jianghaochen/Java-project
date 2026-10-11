package dataStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {
	public static void main(String atgs[]) {
		
		String sourcePath = "E:\\ST-courses\\3AK2SK-ST\\TTTK2323\\A206164_JiangHaochen_TTTK2323_SitiZahidah_lab3_video.mp4";
		String desPath = "E:\\javaTest\\outputStreamTest\\copy_video.mp4";
		
		try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourcePath));
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(desPath));
				){
			byte[] b = new byte[1024];
			int len;
			while((len=bufferedInputStream.read(b))!=-1) {
				bufferedOutputStream.write(b, 0, len);
			}	
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
}
