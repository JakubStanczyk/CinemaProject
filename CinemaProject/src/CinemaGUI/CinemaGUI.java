package CinemaGUI;
import Concession.MealBuilder;
import javafx.stage.Stage;
import Database.databaseOperations;
import Control.authorisation;
import java.sql.SQLException;
import java.util.ArrayList;

import Account.Account;
import Booking.Booking;
import Movie.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

public class CinemaGUI {
	static Scene loginScene, registerScene, welcomeScene, movieScene, 
			concessionScene, bookingScene, accountScene;
	static Scene welcomeManagerScene, manageMovieScene,
			manageBookingScene, manageConcessionScene;
	
	static TableView<Movie> movieTable, viewMovieTable, bookingTable;
	static TableView<MealBuilder> concessionsTable;
	static MealBuilder menu = new MealBuilder(null, null, null, null, 0);
	private static Account account = new Account();
	static Movie movie = new Movie(null, null, null, 0);
	
	public static void display()  {
		
		Stage window = new Stage();
		window.setTitle("Movies");
		
		Label welcomeLbl = new Label("Welcome");
		// instantiate and populate tables
		
		concessionsTable = createConcessionsTable();
		
		movieTable = createMovieTable();
		try {
			movieTable.setItems(getMovies());
		} catch (SQLException e2) {
		}

		viewMovieTable = createMovieTable();
		viewMovieTable.setItems(movieTable.getItems());
		
		// Login Page
		
		Label loginUserLbl = new Label("username");
		TextField loginUserTxtF = new TextField();
		Label loginPasswordLbl = new Label("password");
		PasswordField loginPasswordPassF = new PasswordField();
		
		Button loginBtn = new Button("Login");
		loginBtn.setOnAction(e -> {
			try {
				if(authorisation.authorisationLogin(loginUserTxtF.getText(),loginPasswordPassF.getText())){
					account.setUsername(loginUserTxtF.getText());
					welcomeLbl.setText("welcome "+account.getUserName());
					window.setScene(welcomeScene);
					loginUserTxtF.clear();
					loginPasswordPassF.clear();
				
				}else if((loginUserTxtF.getText().equals("manager"))&&(loginPasswordPassF.getText().equals("managerPassword"))){
					window.setScene(welcomeManagerScene);
					loginUserTxtF.clear();
					loginPasswordPassF.clear();
					
				}
				else {
					AlertWindow.display("Error","login failed");
					}
				}
			 catch (SQLException e1) {
		}
		});
		
			loginUserTxtF.clear();
			loginPasswordPassF.clear();
		
		Button createBtn = new Button("Create Account");
		createBtn.setOnAction(e -> window.setScene(registerScene));
		
		VBox loginLayout = new VBox(10);
		loginLayout.setAlignment(Pos.CENTER);
		loginLayout.getChildren().addAll(loginUserLbl, loginUserTxtF, 
				loginPasswordLbl, loginPasswordPassF, loginBtn, createBtn);
		loginScene = new Scene(loginLayout, 200, 250);
		
		// New Account Page
		
		Label registerUserLbl = new Label("username");
		TextField registerUserTxtF = new TextField();
		Label registerPasswordLbl = new Label("password");
		PasswordField registerPasswordTxtF = new PasswordField();
		
		Button registerBtn = new Button("Register");
		registerBtn.setOnAction(e -> 
		{
			if(authorisation.authorisationRegister(registerUserTxtF.getText(),registerPasswordTxtF.getText())){
					
				
				try {
					
					Account.addNewAccountToDB(registerUserTxtF.getText(),registerPasswordTxtF.getText());
					window.setScene(loginScene);
					registerUserTxtF.clear();
					registerPasswordTxtF.clear();
				} catch (SQLException e1) {
					
					AlertWindow.display("Error","username already in use");
				}
				
				}
				else {
					AlertWindow.display("Error","fields null or password is in the wrong format");
					
				}
		});
		
		Button backLoginBtn = new Button("Back");
		backLoginBtn.setOnAction(e -> window.setScene(loginScene));
		
		VBox registerLayout = new VBox(10);
		registerLayout.setAlignment(Pos.CENTER);
		registerLayout.getChildren().addAll(registerUserLbl, registerUserTxtF, 
				registerPasswordLbl, registerPasswordTxtF, registerBtn, backLoginBtn);
		registerScene = new Scene(registerLayout, 200, 250);
		
		window.setScene(loginScene);
		window.show();
		
		// Customer Page
		
		
		
		Button viewMoviesBtn = new Button("Make a Movie Booking");
		viewMoviesBtn.setOnAction(e -> window.setScene(movieScene));
		
		Button viewBookingsBtn = new Button("Your Bookings");
		viewBookingsBtn.setOnAction(e -> window.setScene(bookingScene));
		
		Button accountBtn = new Button("Your Account");
		accountBtn.setOnAction(e -> window.setScene(accountScene));
		
		Button logoutBtn = new Button("Logout");
		logoutBtn.setOnAction(e -> window.setScene(loginScene));
		
		VBox welcomeCustomerLayout = new VBox(10);
		welcomeCustomerLayout.setAlignment(Pos.CENTER);
		welcomeCustomerLayout.getChildren().addAll(welcomeLbl, viewMoviesBtn,
				 viewBookingsBtn, accountBtn, logoutBtn);
		welcomeScene = new Scene(welcomeCustomerLayout, 200, 250);
		
		// View Movies Page
		
		Label viewMovieLbl = new Label("movie times page");
		VBox movieLabelLayout = new VBox(10);
		movieLabelLayout.getChildren().add(viewMovieLbl);
		
		VBox viewMovieLayout = new VBox(10);
		viewMovieLayout.setAlignment(Pos.CENTER);
		viewMovieLayout.getChildren().add(viewMovieTable);
		
			// buttons
		Button backMovieBtn = new Button("Back");
		backMovieBtn.setOnAction(e -> window.setScene(welcomeScene));
		
		Button nextMovieBtn = new Button("Next");
		nextMovieBtn.setOnAction(e -> 
		{
		window.setScene(concessionScene);
		movie = viewMovieTable.getSelectionModel().getSelectedItems().get(0);
		
		});
		HBox movieCtlLayout = new HBox(10);
		movieCtlLayout.setPadding(new Insets(10,10,10,10));
		movieCtlLayout.setAlignment(Pos.CENTER);
		movieCtlLayout.getChildren().addAll(backMovieBtn, nextMovieBtn);
		
			// assemble layout
		BorderPane movieLayout = new BorderPane();
		movieLayout.setTop(movieLabelLayout);
		movieLayout.setCenter(viewMovieLayout);
		movieLayout.setBottom(movieCtlLayout);
		movieScene = new Scene(movieLayout, 500, 200);
		
		// Concessions Page
		
			// concession top menu
		Label concessionLbl = new Label("concessions page");
		
		VBox concessionTopLayout = new VBox(10);
		concessionTopLayout.setAlignment(Pos.CENTER);
		concessionTopLayout.getChildren().add(concessionLbl);
		
			// concession left menu
		ComboBox<String> flavourComboBox = new ComboBox<>();
		ComboBox<String> foodComboBox = new ComboBox<>();
		ComboBox<String> drinkTComboBox = new ComboBox<>();
		ComboBox<String> drinkComboBox = new ComboBox<>();
		VBox concessionLeftLayout = new VBox(10);
		ObservableList<String> food = FXCollections.observableArrayList("Popcorn", "Nachos");
		ObservableList<String> popFlavour = FXCollections.observableArrayList("Salted - 6.99", "Butter - 7.49", "Caramel - 7.99");
		ObservableList<String> nachFlavour = FXCollections.observableArrayList("Cheese - 5.99","Guacamole - 6.49");
		ObservableList<String> drinkType = FXCollections.observableArrayList("Hot Drink","Cold Drink");
		ObservableList<String> drinkHot = FXCollections.observableArrayList("Tea - 2.99","Coffee - 3.49");
		ObservableList<String> drinkCold = FXCollections.observableArrayList("Coke - 4.99", "Fanta - 4.99", "Sprite - 4.99");
		Button addItemBtn = new Button("Choose Food");
		Button addItemBtn2 = new Button("Choose Flavour");
		Button addItemBtn3 = new Button("Choose Drink");
		Button addItemBtn4 = new Button("Choose Drink");
		Button addItemBtn5 = new Button("Complete Order");
		foodComboBox.setItems(food);
		addItemBtn.setOnAction(e -> {
			if((foodComboBox.getValue().equals("Popcorn"))) { 
				flavourComboBox.setItems(popFlavour);
				menu.foodType("Pocporn");
				addItemBtn2.setOnAction(en -> {
					if(flavourComboBox.getValue().equals("Salted - 6.99")) {
						menu.flavour("Salted");
						menu.foodPrice(6.99);
					}
					else if(flavourComboBox.getValue().equals("Butter - 7.49")) {
						menu.flavour("Butter");
						menu.foodPrice(7.49);
					}
					else if(flavourComboBox.getValue().equals("Caramel - 7.99")) {
						menu.flavour("Caramel");
						menu.foodPrice(7.99);
					}
				});
			}
			else if(foodComboBox.getValue().equals("Nachos")) {
				flavourComboBox.setItems(nachFlavour);
				menu.foodType("Nacho");
				addItemBtn2.setOnAction(en -> {
					if(flavourComboBox.getValue().equals("Cheese - 5.99")) {
						menu.flavour("Cheese");
						menu.foodPrice(5.99);
					}
					else if(flavourComboBox.getValue().equals("Guacamole - 6.49")) {
						menu.flavour("Guacamole");
						menu.foodPrice(6.49);
					}
				});
			}
		});
		drinkTComboBox.setItems(drinkType);
		addItemBtn3.setOnAction(e ->{
			if((drinkTComboBox.getValue().equals("Hot Drink"))) {
				drinkComboBox.setItems(drinkHot);
				menu.drinkType("Hot Drink");
				addItemBtn4.setOnAction(en ->{
					if(drinkComboBox.getValue().equals("Tea - 2.99")){
						menu.drink("Tea");
						menu.drinkPrice(2.99);
					}
					else if(drinkComboBox.getValue().equals("Coffee - 3.49")) {
						menu.drink("Coffee");
						menu.drinkPrice(3.49);
					}
				});
			}
			else if((drinkTComboBox.getValue().equals("Cold Drink"))) {
				drinkComboBox.setItems(drinkCold);
				menu.drinkType("Cold Drink");
				addItemBtn4.setOnAction(en -> {
					if(drinkComboBox.getValue().equals("Coke - 4.99")) {
						menu.drink("Coke");
						menu.drinkPrice(4.99);
					}
					else if(drinkComboBox.getValue().equals("Fanta - 4.99")) {
						menu.drink("Fanta");
						menu.drinkPrice(4.99);
					}
					else if(drinkComboBox.getValue().equals("Sprite - 4.99")) {
						menu.drink("Sprite");
						menu.drinkPrice(4.99);
					}
				});
			}
		});
		addItemBtn5.setOnAction(e -> {
			menu.buildMeal();
			concessionsTable.setItems(getConcessions());
		});
		
		concessionLeftLayout.setAlignment(Pos.CENTER);
		concessionLeftLayout.getChildren().addAll(foodComboBox,addItemBtn,flavourComboBox, addItemBtn2,drinkTComboBox, addItemBtn3, drinkComboBox, addItemBtn4, addItemBtn5);
		
		// concession right menu
		Label orderLbl = new Label("Order of Meal");
		
		VBox concessionRightLayout = new VBox(10);
		concessionRightLayout.setAlignment(Pos.CENTER);
		concessionRightLayout.getChildren().addAll(orderLbl, concessionsTable);
		
		// concession bottom menu
		Button backConBtn = new Button("Back");	
		Button finishBooking = new Button("Finish Booking");
		backConBtn.setOnAction(e -> window.setScene(welcomeScene));
		finishBooking.setOnAction(e ->{
			
			try {
				Booking.addBookingToDB(account,movie,menu);
			} catch (SQLException e1) {
			System.out.print(e1);
			}
			window.setScene(welcomeScene);
			
		});
		
		VBox concessionBottomLayout = new VBox(10);
		concessionBottomLayout.setAlignment(Pos.CENTER);
		concessionBottomLayout.getChildren().addAll(backConBtn, finishBooking);
		
		BorderPane concessionLayout = new BorderPane();
		concessionLayout.setTop(concessionTopLayout);
		concessionLayout.setLeft(concessionLeftLayout);
		concessionLayout.setRight(concessionRightLayout);
		concessionLayout.setBottom(concessionBottomLayout);
		concessionScene = new Scene(concessionLayout, 650, 600);
		
		// Bookings Page
		
		Label bookingLbl = new Label("bookings page");
		Button backBookingBtn = new Button("Back");	
		backBookingBtn.setOnAction(e -> window.setScene(welcomeScene));

		bookingTable = createMovieTable();
		bookingTable.setItems(getBookings());
		
		VBox bookingLayout = new VBox(10);
		bookingLayout.setAlignment(Pos.CENTER);
		bookingLayout.getChildren().addAll(bookingLbl, bookingTable, backBookingBtn);
		bookingScene = new Scene(bookingLayout, 500, 200);
		
		// Account Page
		
		Label accountLbl = new Label("account page");
	
		Button changePassButton = new Button("Change Password");
		changePassButton.setOnAction(e -> {
			ChangePasswordWindow.display(null);
		});
		Button deleteButton = new Button("Delete Account");
		deleteButton.setOnAction(e -> {
			ConfirmWindow.display();
			window.setScene(loginScene);
		});
		
		Button backAccountBtn = new Button("Back");	
		backAccountBtn.setOnAction(e -> window.setScene(welcomeScene));
		
		VBox accountLayout = new VBox(10);
		accountLayout.setAlignment(Pos.CENTER);
		accountLayout.getChildren().addAll(accountLbl, changePassButton, 
				deleteButton, backAccountBtn);
		accountScene = new Scene(accountLayout, 200, 250);
		
		// Manager Page

		Label welcomeManagerLbl = new Label("Welcome");
		
		Button manageMoviesBtn = new Button("Manage Movies");
		manageMoviesBtn.setOnAction(e -> window.setScene(manageMovieScene));
		
		Button manageBookingBtn = new Button("Manage Bookings");
		manageBookingBtn.setOnAction(e -> window.setScene(manageBookingScene));
		
		Button manageConcessionBtn = new Button("Manage Inventory");
		manageConcessionBtn.setOnAction(e -> window.setScene(manageConcessionScene));
		
		Button managerLogoutBtn = new Button("Logout");
		managerLogoutBtn.setOnAction(e -> window.setScene(loginScene));
		
		VBox welcomeManagerLayout = new VBox(10);
		welcomeManagerLayout.setAlignment(Pos.CENTER);
		welcomeManagerLayout.getChildren().addAll(welcomeManagerLbl, manageMoviesBtn,
				manageBookingBtn, manageConcessionBtn, managerLogoutBtn);
		welcomeManagerScene = new Scene(welcomeManagerLayout, 200, 250);
		
		// Manage Movies Page	
		
			// table/center layout
		VBox movieTableLayout = new VBox(10);
		movieTableLayout.getChildren().add(movieTable);
		
			// bottom layout
		Button backMgMovieBtn = new Button("Back");	
		backMgMovieBtn.setOnAction(e -> window.setScene(welcomeManagerScene));
		
		Button addMovieBtn = new Button("Add");
		addMovieBtn.setOnAction(e -> {
			AddMovieWindow.display(movieTable);
		});
		
		Button deleteMovieBtn = new Button("Delete");
		deleteMovieBtn.setOnAction(e -> deleteMovie());
		
		HBox movieButtonLayout = new HBox(10);
		
		movieButtonLayout.setAlignment(Pos.CENTER);
		movieButtonLayout.setPadding(new Insets(10,10,10,10));
		movieButtonLayout.getChildren().addAll(addMovieBtn,
				deleteMovieBtn, backMgMovieBtn);
		
			// assemble final layout
		BorderPane manageMovieLayout = new BorderPane();
		manageMovieLayout.setCenter(movieTableLayout);
		manageMovieLayout.setBottom(movieButtonLayout);
		manageMovieScene = new Scene(manageMovieLayout, 500, 200);
		
		// Manage Bookings Page
		
		Button backMgBookingBtn = new Button("Back");	
		backMgBookingBtn.setOnAction(e -> window.setScene(welcomeManagerScene));
		
		VBox manageBookingLayout = new VBox(10);
		manageBookingLayout.setAlignment(Pos.CENTER);
		manageBookingLayout.getChildren().addAll(backMgBookingBtn);
		manageBookingScene = new Scene(manageBookingLayout, 200, 200);
		
		// Manage Inventory Page
		
		Button backMgConcessionBtn = new Button("Back");	
		backMgConcessionBtn.setOnAction(e -> window.setScene(welcomeManagerScene));
		
		VBox manageConcessionLayout = new VBox(10);
		manageConcessionLayout.setAlignment(Pos.CENTER);
		manageConcessionLayout.getChildren().addAll(backMgConcessionBtn);
		manageConcessionScene = new Scene(manageConcessionLayout, 200, 200);
	}
	
	private static TableView<MealBuilder> createConcessionsTable() {
		TableColumn<MealBuilder, String> typeColumn = new TableColumn<>("Type of Food");
		typeColumn.setMinWidth(100);
		typeColumn.setCellValueFactory(new PropertyValueFactory<MealBuilder, String>("foodType"));
		
		TableColumn<MealBuilder, String> flavourColumn = new TableColumn<>("Flavour Chosen");
		flavourColumn.setMinWidth(100);
		flavourColumn.setCellValueFactory(new PropertyValueFactory<MealBuilder, String>("flavour"));
		
		TableColumn<MealBuilder, String> tDrinkColumn = new TableColumn<>("Type of Drink");
		tDrinkColumn.setMinWidth(100);
		tDrinkColumn.setCellValueFactory(new PropertyValueFactory<MealBuilder, String>("drinkType"));
		
		TableColumn<MealBuilder, String> drinkColumn = new TableColumn<>("Drink Chosen");
		drinkColumn.setMinWidth(100);
		drinkColumn.setCellValueFactory(new PropertyValueFactory<MealBuilder, String>("drink"));
		
		TableColumn<MealBuilder, Double> priceColumn = new TableColumn<>("Price of Order");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<MealBuilder, Double>("mealPrice"));

		TableView<MealBuilder> table = new TableView<>();
		table.getColumns().addAll(typeColumn,flavourColumn , tDrinkColumn, drinkColumn, priceColumn);
		
		return table;
	}

	private static TableView<Movie> createMovieTable() {
		TableColumn<Movie, String> movieNameCol = new TableColumn<>("Title");
		movieNameCol.setMinWidth(200);
		movieNameCol.setCellValueFactory(new PropertyValueFactory<>("movieName"));
		
		TableColumn<Movie, String> movieDateCol = new TableColumn<>("Date");
		movieDateCol.setMinWidth(100);
		movieDateCol.setCellValueFactory(new PropertyValueFactory<>("movieDate"));
		
		TableColumn<Movie, String> movieTimeCol = new TableColumn<>("Time");
		movieTimeCol.setMinWidth(100);
		movieTimeCol.setCellValueFactory(new PropertyValueFactory<>("movieTime"));
		
		TableColumn<Movie, String> moviePriceCol = new TableColumn<>("Price");
		moviePriceCol.setMinWidth(100);
		moviePriceCol.setCellValueFactory(new PropertyValueFactory<>("moviePrice"));

		TableView<Movie> table = new TableView<>();
		table.getColumns().addAll(movieNameCol, movieDateCol, movieTimeCol, moviePriceCol);
		
		return table;
	}
	
	private static ObservableList<MealBuilder> getConcessions() {
		ObservableList<MealBuilder> concessions = FXCollections.observableArrayList();
		concessions.add(new MealBuilder(menu.getFoodType(), menu.getFlavour(), menu.getDrinkType(), menu.getDrink(), menu.getMealPrice()));
		return concessions;
	}

	
	public static ObservableList<Movie> getMovies() throws SQLException {
		ObservableList<Movie> movies = FXCollections.observableArrayList();
		ArrayList<Movie> moviesFromDB = databaseOperations.viewingMovieQuery("select * from movies");
		for (int i = 0; i < moviesFromDB.size();i++) {
			movies.add(moviesFromDB.get(i));
		}
		
		
		return movies;
	}
	
	public static ObservableList<Movie> getBookings() {
		ObservableList<Movie> bookings = FXCollections.observableArrayList();
		bookings.add(new Movie("bookingTest", "12/12", "13:00", 10.00));
		return bookings;
	}
	
	public static void deleteMovie() {
		ObservableList<Movie> movieSelected, allMovies;
		allMovies = movieTable.getItems();
		movieSelected = movieTable.getSelectionModel().getSelectedItems();
		 Movie selectedToDelete = movieTable.getSelectionModel().getSelectedItems().get(0);
		 movieSelected.forEach(allMovies::remove);
		 try {
			Movie.managerDeleteMovieFromDB(selectedToDelete.getMovieName());
		} catch (SQLException e) {
			
		}
		 
		}
		 
		 public static Movie setMovie() {
				ObservableList<Movie> movieSelected;
				movieSelected = movieTable.getSelectionModel().getSelectedItems();
				 Movie selectedToDelete = movieTable.getSelectionModel().getSelectedItems().get(0);
				 return  movieTable.getSelectionModel().getSelectedItems().get(0);
		
		
	}
}