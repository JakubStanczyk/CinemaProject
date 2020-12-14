package CinemaGUI;

import static org.junit.Assert.*;
import org.junit.*;

import Movie.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CinemaGUITest {

	
	/*@Test
	public void testDisplay() throws Exception{
		fail();
	}*/

	@Test 
	public void testGetMovies() {
		ObservableList<Movie> movies = FXCollections.observableArrayList();
		movies.add(new Movie("test1", "12/12", "13:00", "10.00"));
		//check that movies list is populated
		assertTrue(movies.size() > 0);
	}

	@Test
	public void testGetBookings() {
		ObservableList<Movie> bookings = FXCollections.observableArrayList();
		bookings.add(new Movie("bookingTest", "12/12", "13:00", "10.00"));
		//test bookings is populated
		assertTrue(bookings.size() > 0);
	}

	/*@Test
	public void testDeleteMovie() {
		fail();
	
	}*/

}
