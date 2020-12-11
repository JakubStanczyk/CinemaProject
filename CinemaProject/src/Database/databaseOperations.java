package Database;
import java.sql.*;
import java.util.ArrayList;
//Basically will import all the classes that will register anything with the database

public class databaseOperations {

	public static  Connection getConnection() throws SQLException {
		
		final String databaseLocationUrl = "jdbc:mysql://localhost:3306/cinemaDB"; 
		final String databaseUser = "root";
		final String databasePassword = "notAgenericPassword"; //TODO make this more secure
		
		Connection conn = DriverManager.getConnection(databaseLocationUrl,databaseUser,databasePassword);
		
		return conn;
		
		
	}
	
	
	public static   void viewingMovieQuery(String query) throws SQLException{
		
		
		Statement myStatement = getConnection().createStatement();
		ResultSet myRs = myStatement.executeQuery(query);
		while(myRs.next()) {
			System.out.println(myRs.getString("movieName") + "," + myRs.getString("movieGenre"));
		}

		
	}
	
	public static boolean doesUserExists(String username,String password)throws SQLException{
		Statement myStatement = getConnection().createStatement();
		ResultSet myRs = myStatement.executeQuery("select username from accountDeatails where username ='"+username+"' AND password ='"+password+"'");
		
		if(myRs.next()) {
			return true;
		}
		
		else {
		
		return false;
		}
	}
	
	
	public static   void adjustingQuery(String query) throws SQLException{
		
		
		Statement myStatement = getConnection().createStatement();
		myStatement.executeUpdate(query);
		System.out.println("Insert Complete");
		
		
		
	}
	
	





}

