import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date date = f.parse("2014-12-25");
		System.out.println(date);
	}
}
