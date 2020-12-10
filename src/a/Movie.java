package a;
import java.sql.SQLException;
import database.databaseOperations;
public class Movie {
	
	int movieId;
	String movieName;
	String movieGenre;
	
	public Movie() {
		
	}
	
	public Movie(int movieID, String movieName, String movieGenre)
	{
		this.movieId = movieID;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		
	}
	
	public int getMovieId() {
		return movieId;
		
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	
	public static void selectMovies() throws SQLException {
		
		databaseOperations.viewngQuery("select * from movies");
		System.out.println("bruh");
	}
	
	public static  void insertMoviesIntoDB(String movieID,String movieName,String movieGenre) throws SQLException{
		
		String Query = "insert into movies values('"+movieID+"','"+movieName+"','"+movieGenre+"')";
		System.out.println(Query);
		databaseOperations.adjustingQuery(Query);
		
	}
	
	
	//public static void main (String[] args) throws SQLException {
		//String movieId = "5";
		//String movieName = "Shrek2";
		//String movieGenre = "Comedy";
		//selectMovies();
		//insertMoviesIntoDB(movieId,movieName,movieGenre);
		
		
		
	//}
}

	
