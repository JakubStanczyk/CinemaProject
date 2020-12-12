package Booking;
import java.sql.SQLException;

import Account.Account;
import Movie.Movie;
import Concession.MealBuilder;
import Database.databaseOperations;

public class Booking {
	private Account account;
	private Movie movie;
	private MealBuilder mealbuilder;
	
	
	
	public Booking(Account account,Movie movie,MealBuilder mealbuilder) {
		
		this.account = account;
		this.movie = movie;
		this.mealbuilder = mealbuilder;
		
		
		
	}
	
	
	public void addBookingToDB(Account account,Movie movie,MealBuilder mealbuilder) throws SQLException {
		
		
		//The meal also needs to be added but I have no idea how need to ask Kristof
		
		String Query ="insert into bookings values('"+account.getUserName()+"','"+movie.getMovieName()+"','"+movie.getMovieTime()+"','"+movie.getMovieDate()+"')";
		databaseOperations.adjustingQuery(Query);
		
		
	}

}
