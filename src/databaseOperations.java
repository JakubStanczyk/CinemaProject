import java.sql.*;
import java.util.ArrayList;
//Basically will import all the classes that will register anything with the database

public class databaseOperations {

	public  Connection getConnection() throws SQLException {
		
		final String databaseLocationUrl = "jdbc:mysql://localhost:3306/cinemaDB"; 
		final String databaseUser = "root";
		final String databasePassword = "notAgenericPassword"; //TODO make this more secure
		
		Connection conn = DriverManager.getConnection(databaseLocationUrl,databaseUser,databasePassword);
		
		return conn;
		
		
	}
	
	public ArrayList<String> getTimesForAMovie(int movieID) throws SQLException{
		
		ArrayList<String> times = new ArrayList<String>();
		
		Statement myStatement = getConnection().createStatement();
		ResultSet myRs = myStatement.executeQuery("select * from movies");
		
		
		
		 
		
		
		
		
		
		return null;
		
		
		
		
		
		
		
	}






}

