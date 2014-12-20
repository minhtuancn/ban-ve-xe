import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {
	public static void main(String[] args) throws ParseException {
		Date d1 = new Date(System.currentTimeMillis());
		Date d2 = new Date(System.currentTimeMillis() + 10*60*1000);
		System.out.println(d1.compareTo(d2));
	}
}
