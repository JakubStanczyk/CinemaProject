package Control;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class authorisation {
	
	
	
	public static boolean authorisationRegister (String username,String password,String name) {
		boolean bool = true;
		
		final Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
		Matcher matcher = pattern.matcher(password);
		if((username != null||password != null||name != null)&&(bool==matcher.find())) {
			System.out.println("password correct");
			return true;
		}
		else {
			System.out.println("wrong format you cringe lord");
			return false;
			}
	}
	
	


}
