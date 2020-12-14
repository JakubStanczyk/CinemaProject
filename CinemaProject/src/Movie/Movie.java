package Movie;

import java.sql.SQLException;

import Database.databaseOperations;

public class Movie {

	String movieName, movieDate, movieTime;
	double moviePrice;

	public Movie(String movieName, String movieDate, String movieTime, double moviePrice) {
		this.movieName = movieName;
		this.movieDate = movieDate;
		this.movieTime = movieTime;
		this.moviePrice = moviePrice;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public String getMovieTime() {
		return movieTime;
	}

	public double getMoviePrice() {
		return moviePrice;
	}

	public static void managerAddMovieToDB(String movieName, String movieDate, String movieTime, String moviePrice)
			throws SQLException {

		String Query = "insert into movies values('" + movieName + "','" + movieDate + "','" + movieTime + "','"
				+ moviePrice + "')";
		databaseOperations.adjustingQuery(Query);
	}

	public static void managerDeleteMovieFromDB(String movieName) throws SQLException {

		String Query = "delete from movies where movieName ='" + movieName + "'";
		databaseOperations.adjustingQuery(Query);
	}

}