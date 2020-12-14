package Database;
import java.sql.*;
import java.util.ArrayList;
//Basically will import all the classes that will register anything with the database

import Movie.Movie;

public class databaseOperations {

	public static  Connection getConnection() throws SQLException {
		
		final String databaseLocationUrl = "jdbc:mysql://localhost:3306/cinemaDB"; 
		final String databaseUser = "root";
		final String databasePassword = "notAgenericPassword"; //TODO make this more secure
		
		Connection conn = DriverManager.getConnection(databaseLocationUrl,databaseUser,databasePassword);
		
		return conn;
		
		
	}
	
	
	public static   ArrayList<Movie> viewingMovieQuery(String query) throws SQLException{
		
		ArrayList<Movie>dataInputs = new ArrayList<Movie>();
		
		Statement myStatement = getConnection().createStatement();
		ResultSet myRs = myStatement.executeQuery(query);
		ArrayList<String> temp = new ArrayList<String>();
		while(myRs.next()) {
			dataInputs.add(new Movie(myRs.getString("movieName"),myRs.getString("movieDate"),myRs.getString("movieTime"),myRs.getDouble("moviePrice")));
		}
		
		return dataInputs;
		

		
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
		System.out.println("Query Complete");
		
		
		
	}
	

}

