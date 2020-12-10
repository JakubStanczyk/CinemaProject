package CinemaGUI;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CinemaGUI {
	static Scene loginScene, registerScene, welcomeScene, movieScene, 
			concessionScene, bookingScene, accountScene;
	static Scene welcomeManagerScene, manageMovieScene,
			manageBookingScene, manageConcessionScene;
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Movies");
		
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
		
		Label viewMovieLbl = new Label("move times page");
		Button backMovieBtn = new Button("Back");
		backMovieBtn.setOnAction(e -> window.setScene(welcomeScene));
		
		Button nextMovieBtn = new Button("Next");
		nextMovieBtn.setOnAction(e -> window.setScene(concessionScene));
		
		VBox movieLayout = new VBox(10);
		movieLayout.setAlignment(Pos.CENTER);
		
		movieLayout.getChildren().addAll(viewMovieLbl, nextMovieBtn, backMovieBtn);
		movieScene = new Scene(movieLayout, 200, 250);
		
		// Concessions Page
		
			// concession top menu
		Label concessionLbl = new Label("concessions page");
		
		VBox concessionTopLayout = new VBox(10);
		concessionTopLayout.setAlignment(Pos.CENTER);
		concessionTopLayout.getChildren().add(concessionLbl);
		
			// concession left menu
		ComboBox<String> orderComboBox = new ComboBox<>();
		orderComboBox.getItems().addAll("popcorn", "drink", "candy");
		
		Button addItemBtn = new Button("Add to Order");
		addItemBtn.setOnAction(e -> addItemtoOrder());
		
		VBox concessionLeftLayout = new VBox(10);
		concessionLeftLayout.setAlignment(Pos.CENTER);
		concessionLeftLayout.getChildren().addAll(orderComboBox, addItemBtn);
		
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
		concessionScene = new Scene(concessionLayout, 200, 250);
		
		// Bookings Page
		
		Label bookingLbl = new Label("bookings page");
		Button backBookingBtn = new Button("Back");	
		backBookingBtn.setOnAction(e -> window.setScene(welcomeScene));
		
		VBox bookingLayout = new VBox(10);
		bookingLayout.setAlignment(Pos.CENTER);
		bookingLayout.getChildren().addAll(bookingLbl, backBookingBtn);
		bookingScene = new Scene(bookingLayout, 200, 250);
		
		// Account Page
		
		Label accountLbl = new Label("account page");
	
		Button changePassButton = new Button("Change Password");
		changePassButton.setOnAction(e -> {
			ChangePasswordWindow.display();
		});
		Button deleteButton = new Button("Delete Account");
		deleteButton.setOnAction(e -> ConfirmWindow.display());
		
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
		
		Button backMgMovieBtn = new Button("Back");	
		backMgMovieBtn.setOnAction(e -> window.setScene(welcomeManagerScene));
		
		VBox manageMovieLayout = new VBox(10);
		manageMovieLayout.setAlignment(Pos.CENTER);
		manageMovieLayout.getChildren().addAll(backMgMovieBtn);
		manageMovieScene = new Scene(manageMovieLayout, 200, 200);
		
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

	private static void addItemtoOrder() {
		System.out.println("TODO implement add item to order");
	}
}
