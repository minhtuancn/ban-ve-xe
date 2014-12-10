import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {
	public static void main(String[] args) throws ParseException {
		String s = "25-12-2014 23:59:59 PM";
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a");
		Date d = f.parse(s);
		d.setTime(d.getTime()+1000);
		System.out.println(d);
	}
}
