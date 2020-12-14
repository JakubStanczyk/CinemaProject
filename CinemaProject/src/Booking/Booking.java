package Booking;
import java.sql.SQLException;

import Account.Account;
import Movie.Movie;
import Concession.MealBuilder;
import Database.databaseOperations;

public class Booking {
	private String bookingID;
	
	
	
	
	
	
	public static void addBookingToDB(Account account,Movie movie,MealBuilder mealbuilder) throws SQLException {
		
		 int randomNumber = (int) (Math.random()*(100-1+1)+1);
		 String bookingID = account.getUserName()+randomNumber;
		double fullPrice = movie.getMoviePrice()+mealbuilder.getMealPrice();
		System.out.println(fullPrice);
		
		String Query ="insert into booking values('"+bookingID+"','"+account.getUserName()+"','"+movie.getMovieName()+"','"+movie.getMovieTime()+"','"+movie.getMovieDate()+"','"+mealbuilder.getMeal()+"','"+fullPrice+"')";
		databaseOperations.adjustingQuery(Query);
		System.out.println(Query);
		
		
	}

}
