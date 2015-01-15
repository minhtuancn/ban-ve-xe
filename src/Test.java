import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;


public class Test {
	public static void search(String path) throws IOException{
		File file = new File(path);
		if(file.isFile()){
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null;
			while((line = br.readLine())!=null){
				if(line.contains("Insert title here") ){
					System.out.println(file.getName());
					break;
				}
			}
		}else{
			File[] list = file.listFiles();
			for (File f : list) {
				search(f.getAbsolutePath());
			}
		}
	}
	public static void main(String[] args) throws ParseException, IOException {
		search("D:\\program file\\webJSP\\ban-ve-xe");
	}
}
