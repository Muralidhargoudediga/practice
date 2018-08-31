import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.regex.Pattern;


public class Test {
	public static void main(String[] args) throws ParseException {
		//System.out.println(Character.isAlphabetic('u'));
		//new Thread(new Thread1()).start();
	    //new Thread(new Thread2()).start();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm");
//		System.out.println(sdf.parse("27 JAN 2018 18:45"));
//		System.out.println("27 JAN 2018 18:45".split("\\s+")[3]);
//		System.out.println(Integer.parseInt("00000000000000000"));
//		Pattern p = Pattern.compile(",");
//		System.out.println(p.split(" ")[0]);
		StringTokenizer token = new StringTokenizer("fullRegScripts/main/", "/");
		System.out.println(token.countTokens());
		while(token.hasMoreTokens()) {
			System.out.println();
		}
		
		File file = new File("ABC","tst");
		file.getParentFile().mkdirs();
		file.listFiles();
	}
	
}
class Thread1 implements Runnable {
	
	@Override
	public void run() {
		System.out.println("completed thread1");
	}
	
}

class Thread2 implements Runnable {
	
	@Override
	public void run() {
		System.out.println("completed thread2");
	}
}
