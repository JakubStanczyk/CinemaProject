package Movie;

import java.sql.SQLException;

import Database.databaseOperations;

public class Movie {
	
	String movieName, movieDate, movieTime, moviePrice;
	
	public Movie(String movieName, String movieDate, String movieTime, String moviePrice)
	{
		this.movieName = movieName;
		this.movieDate = movieDate;
		this.movieTime = movieTime;
		this.moviePrice = moviePrice;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public String getMovieDate() {
		return movieDate;
	}
	
	public String getMovieTime() {
		return movieTime;
	}
	
	public String getMoviePrice() {
		return moviePrice;
	}
	
	public void managerAddMovieToDB(String movieName,String movieDate,String movieTime, String moviePrice) throws SQLException {
		
		String Query = "insert into movies values('"+movieName+"','"+movieDate+"','"+movieTime+"','"+moviePrice+"')";
		databaseOperations.adjustingQuery(Query);
	}
	
	
}