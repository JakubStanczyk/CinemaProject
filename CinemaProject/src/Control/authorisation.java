package Control;
import java.util.regex.Pattern;

import Database.databaseOperations;

import java.sql.SQLException;
import java.util.regex.Matcher;



public class authorisation {
	
	
	
	public static boolean authorisationRegister (String username,String password) {
		boolean bool = true;
		
		final Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
		Matcher matcher = pattern.matcher(password);
		if((username != null||password != null)&&(bool==matcher.find())) {
			System.out.println("password correct");
			return true;
		}
		else {
			return false;
			}
	}
	
	public static boolean authorisationLogin (String username,String password) throws SQLException {
		
		
			if ((databaseOperations.doesUserExists(username,password))&&(username != null||password !=null)) {
				
				return true;
	
				}
			
			else {
				return false;
			}
			
	}
	
	


}
