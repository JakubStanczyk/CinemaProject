package Database;

import java.sql.*;
import java.util.ArrayList;
//Basically will import all the classes that will register anything with the database

import Booking.Booking;
import Movie.Movie;

public class databaseOperations {

	public static Connection getConnection() throws SQLException {

		final String databaseLocationUrl = "jdbc:mysql://localhost:3306/cinemaDB";
		final String databaseUser = "root";
		final String databasePassword = "notAgenericPassword"; // TODO make this more secure

		Connection conn = DriverManager.getConnection(databaseLocationUrl, databaseUser, databasePassword);

		return conn;

	}

	public static ArrayList<Movie> viewingMovieQuery(String query) throws SQLException {

		ArrayList<Movie> moviedataInputs = new ArrayList<Movie>();

		Statement myStatement = getConnection().createStatement();
		ResultSet myRs = myStatement.executeQuery(query);

		while (myRs.next()) {

			moviedataInputs.add(new Movie(myRs.getString("movieName"), myRs.getString("movieDate"),
					myRs.getString("movieTime"), myRs.getDouble("moviePrice")));
		}
		return moviedataInputs;
	}

	public static ArrayList<Booking> viewingBookingQuery(String query) throws SQLException {

		ArrayList<Booking> bookingdataInputs = new ArrayList<Booking>();

		Statement myStatement = getConnection().createStatement();
		ResultSet myRs = myStatement.executeQuery(query);

		while (myRs.next()) {

			bookingdataInputs.add(new Booking(myRs.getString("bookingID"), myRs.getString("bookingUser"),
					myRs.getString("movieBooked"), myRs.getString("timeOfBooking"), myRs.getString("dateOfBooking"),
					myRs.getString("meal"), myRs.getDouble("price")));
		}
		return bookingdataInputs;

	}

	public static boolean doesUserExists(String username, String password) throws SQLException {
		Statement myStatement = getConnection().createStatement();
		ResultSet myRs = myStatement.executeQuery("select username from accountDeatails where username ='" + username
				+ "' AND password ='" + password + "'");

		if (myRs.next()) {
			return true;
		}

		else {

			return false;
		}
	}

	public static void adjustingQuery(String query) throws SQLException {

		Statement myStatement = getConnection().createStatement();
		myStatement.executeUpdate(query);
		System.out.println("Query Complete");

	}

}
