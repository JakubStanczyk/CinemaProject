package CinemaGUI;
import Concession.MealBuilder;
import javafx.stage.Stage;
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
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Movies");
		
		// instantiate and populate tables
		
		movieTable = createMovieTable();
		movieTable.setItems(getMovies());

		viewMovieTable = createMovieTable();
		viewMovieTable.setItems(movieTable.getItems());
		
		// Login Page
		
		Label loginUserLbl = new Label("username");
		TextField loginUserTxtF = new TextField();
		Label loginPasswordLbl = new Label("password");
		PasswordField loginPasswordPassF = new PasswordField();
		
		Button loginBtn = new Button("Login");
		loginBtn.setOnAction(e -> {
			System.out.println(loginUserTxtF.getText());
			if(loginUserTxtF.getText().equals("manager")) {
				window.setScene(welcomeManagerScene);
			} else {
				window.setScene(welcomeScene);
			}
			loginUserTxtF.clear();
			loginPasswordPassF.clear();
		});
		
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
		TextField registerPasswordTxtF = new TextField();
		
		Button registerBtn = new Button("Register");
		registerBtn.setOnAction(e -> System.out.print(
				"User " + registerUserTxtF.getText() + " created"));
		
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
		
		Label welcomeLbl = new Label("Welcome");
		
		Button viewMoviesBtn = new Button("View Movies");
		viewMoviesBtn.setOnAction(e -> window.setScene(movieScene));
		
		Button concessionBtn = new Button("Concessions");
		concessionBtn.setOnAction(e -> window.setScene(concessionScene));
		
		Button viewBookingsBtn = new Button("Your Bookings");
		viewBookingsBtn.setOnAction(e -> window.setScene(bookingScene));
		
		Button accountBtn = new Button("Your Account");
		accountBtn.setOnAction(e -> window.setScene(accountScene));
		
		Button logoutBtn = new Button("Logout");
		logoutBtn.setOnAction(e -> window.setScene(loginScene));
		
		VBox welcomeCustomerLayout = new VBox(10);
		welcomeCustomerLayout.setAlignment(Pos.CENTER);
		welcomeCustomerLayout.getChildren().addAll(welcomeLbl, viewMoviesBtn,
				concessionBtn, viewBookingsBtn, accountBtn, logoutBtn);
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
		nextMovieBtn.setOnAction(e -> window.setScene(concessionScene));
		
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
		MealBuilder menu = new MealBuilder(null, null, null, null, 0);
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
		addItemBtn5.setOnAction(e -> menu.buildMeal());
		
		concessionLeftLayout.setAlignment(Pos.CENTER);
		concessionLeftLayout.getChildren().addAll(foodComboBox,addItemBtn,flavourComboBox, addItemBtn2,drinkTComboBox, addItemBtn3, drinkComboBox, addItemBtn4, addItemBtn5);
		
			// concession right menu
		Label orderLbl = new Label("order items go here");
		
		VBox concessionRightLayout = new VBox(10);
		concessionRightLayout.setAlignment(Pos.CENTER);
		concessionRightLayout.getChildren().addAll(orderLbl);
		
			// concession bottom menu
		Button backConBtn = new Button("Back");	
		backConBtn.setOnAction(e -> window.setScene(welcomeScene));
		
		VBox concessionBottomLayout = new VBox(10);
		concessionBottomLayout.setAlignment(Pos.CENTER);
		concessionBottomLayout.getChildren().add(backConBtn);
		
		BorderPane concessionLayout = new BorderPane();
		concessionLayout.setTop(concessionTopLayout);
		concessionLayout.setLeft(concessionLeftLayout);
		concessionLayout.setRight(concessionRightLayout);
		concessionLayout.setBottom(concessionBottomLayout);
		concessionScene = new Scene(concessionLayout, 250, 400);
		
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
			ChangePasswordWindow.display();
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

	private static void addItemtoOrder() {
		System.out.println("TODO implement add item to order");
	}
	
	public static ObservableList<Movie> getMovies() {
		ObservableList<Movie> movies = FXCollections.observableArrayList();
		movies.add(new Movie("test1", "12/12", "13:00", "10.00"));
		movies.add(new Movie("test2", "15/12", "18:30", "12.00"));
		return movies;
	}
	
	public static ObservableList<Movie> getBookings() {
		ObservableList<Movie> bookings = FXCollections.observableArrayList();
		bookings.add(new Movie("bookingTest", "12/12", "13:00", "10.00"));
		return bookings;
	}
	
	public static void deleteMovie() {
		ObservableList<Movie> movieSelected, allMovies;
		allMovies = movieTable.getItems();
		movieSelected = movieTable.getSelectionModel().getSelectedItems();
		
		movieSelected.forEach(allMovies::remove);
	}
}
