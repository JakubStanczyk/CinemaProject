
public class Movie {
	
	String movieName, movieDate;
	int movieTime, moviePrice;
	
	public Movie(String movieName, String movieDate, int movieTime, int moviePrice)
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
}