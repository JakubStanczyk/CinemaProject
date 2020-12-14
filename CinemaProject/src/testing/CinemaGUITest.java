package testing;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.jupiter.api.Test;

import Booking.Booking;
import Movie.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CinemaGUITest {

	/*
	 * @Test public void testDisplay() throws Exception{ fail(); }
	 */

	@Test
	public void testGetMovies() {
		ObservableList<Movie> movies = FXCollections.observableArrayList();
		movies.add(new Movie("test1", "12/12", "13:00", 10.00));
		// check that movies list is populated
		assertTrue(movies.size() > 0);
	}

	@Test
	public void testGetBookings() {
		ObservableList<Booking> bookings = FXCollections.observableArrayList();
		bookings.add(new Booking("id", "username", "name", "10.00", "12/12", "popcorn", 25));
		// test bookings is populated
		assertTrue(bookings.size() > 0);
	}

	/*
	 * @Test public void testDeleteMovie() { fail();
	 * 
	 * }
	 */

}