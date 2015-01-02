import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;


public class Test {
	public static void main(String[] args) throws ParseException {
		String pass = "anhthats";
		System.out.println(DigestUtils.md5Hex(pass));
		//IQY10P
	}
}
