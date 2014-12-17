import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {
	public static void main(String[] args) throws ParseException {
		String s = "2014-12-16";
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date d = f.parse(s);
		d.setTime(d.getTime()+1000);
		System.out.println(new Date());
	}
}
