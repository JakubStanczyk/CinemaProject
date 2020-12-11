package Account;
import java.sql.SQLException;
import Database.databaseOperations;

public class Account {
	
	
	 private String username;
	 private String password;


	

	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getUserName(){
		
		return this.username;
	}
	public static void addNewAccountToDB(String username,String password) throws SQLException {
		

		String Query = "insert into accountDeatails values('"+username+"','"+password+"')";
		databaseOperations.adjustingQuery(Query);
	}
	
	public static void changeAccountPassword(String username,String password) throws SQLException{
		String Query = "update accountDeatails set password='"+password+"' where username='"+username+"'";
		databaseOperations.adjustingQuery(Query);
	}
	
	public static void removeAccount(String username) throws SQLException {
		String Query = "delete from accountDeatails where username='"+username+"'";
		databaseOperations.adjustingQuery(Query);
	}
	
	

}
