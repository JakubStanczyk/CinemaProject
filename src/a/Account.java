package a;
import java.sql.SQLException;
import database.databaseOperations;

public class Account {
	
	
	String username;
	String password;
	String name;

	public Account() {
		
	}
	
	public Account(int accountID, String username, String password,String name)
	{
		
		this.username = username;
		this.password = password;
		this.name = name;
		
	}
	
	
	public static void addNewAccountToDB(String username,String password,String name) throws SQLException {
		

		String Query = "insert into accountDeatails values('"+username+"','"+password+"','"+name+"')";
		databaseOperations.adjustingQuery(Query);
		
		
		
		
		
		
		
		
	}
	
	

}
