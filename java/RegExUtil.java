import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExUtil {

	private static Pattern emailPattern = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");
	private static Pattern mobilePattern = Pattern.compile("^(1)\\d{10}$");

	public static boolean isEmailFormat(String email) {
		Matcher m = emailPattern.matcher(email);
		return m.matches();
	}
	public static boolean isValidMobile(String mobile) {
		Matcher m = mobilePattern.matcher(mobile);
		return m.matches();
	}
}
