package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import businessLogic.Flight;
import businessLogic.User;
import database.DBQueries;
import database.VO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TableViewController implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	@FXML
	private TableColumn<Flight, String> col_avail_ID;
	
	@FXML
    private TableColumn<Flight, String> col_avail_arrival;

    @FXML
    private TableColumn<Flight, String> col_avail_arrival_date;

    @FXML
    private TableColumn<Flight, String> col_avail_arrival_time;

    @FXML
    private TableColumn<Flight, String> col_avail_depart;

    @FXML
    private TableColumn<Flight, String> col_avail_depart_date;

    @FXML
    private TableColumn<Flight, String> col_avail_depart_time;
    
    @FXML
    private TableColumn<Flight, String> col_scheduled_ID;

    @FXML
    private TableColumn<Flight, String> col_scheduled_arrival;

    @FXML
    private TableColumn<Flight, String> col_scheduled_arrival_date;

    @FXML
    private TableColumn<Flight, String> col_scheduled_arrival_time;

    @FXML
    private TableColumn<Flight, String> col_scheduled_depart;

    @FXML
    private TableColumn<Flight, String> col_scheduled_depart_date;

    @FXML
    private TableColumn<Flight, String> col_scheduled_depart_time;

    @FXML
    private Button returnToLoginButton;

    @FXML
    private TableView<Flight> table_avail_flights;

    @FXML
    private TableView<Flight> table_scheduled_flights;
    @FXML
    private Button deleteFlightButton;
    @FXML
    private Button addFlightButton;
    @FXML
    private Button updateFlightButton;
    
    ObservableList<Flight> list;
    User user = new User();
//    		new Flight("ATL", "12/1", "12:00", "JFK", "12/2", "4:00"),
//    		new Flight("JDK", "12/1", "12:00", "JFK", "12/2", "4:00"),
//    		new Flight("LON", "12/1", "12:00", "JFK", "12/2", "4:00"));
    		
    		

    		

	//Method to go to Login Page
    public void switchToScene1(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		//set all existing flights to tableview
		col_avail_ID.setCellValueFactory(
				new PropertyValueFactory<Flight,String>("flightid"));
		col_avail_depart.setCellValueFactory(
				new PropertyValueFactory<Flight,String>("departAirport"));
		col_avail_depart_date.setCellValueFactory(
				new PropertyValueFactory<Flight,String>("departDate"));
		col_avail_depart_time.setCellValueFactory(
				new PropertyValueFactory<Flight,String>("departTime"));
		col_avail_arrival.setCellValueFactory(
				new PropertyValueFactory<Flight,String>("arrivalAirport"));
		col_avail_arrival_date.setCellValueFactory(
				new PropertyValueFactory<Flight,String>("arrivalDate"));
		col_avail_arrival_time.setCellValueFactory(
				new PropertyValueFactory<Flight,String>("arrivalTime"));
		
	
		table_avail_flights.setItems(DBQueries.flightList());
		
		
		
		
		
		
		
		//set booked flight to scheduled flights
		col_scheduled_ID.setCellValueFactory(
				new PropertyValueFactory<Flight,String>("flightid"));
		col_scheduled_depart.setCellValueFactory(
				new PropertyValueFactory<Flight,String>("departAirport"));
		col_scheduled_depart_date.setCellValueFactory(
				new PropertyValueFactory<Flight,String>("departDate"));
		col_scheduled_depart_time.setCellValueFactory(
				new PropertyValueFactory<Flight,String>("departTime"));
		col_scheduled_arrival.setCellValueFactory(
				new PropertyValueFactory<Flight,String>("arrivalAirport"));
		col_scheduled_arrival_date.setCellValueFactory(
				new PropertyValueFactory<Flight,String>("arrivalDate"));
		col_scheduled_arrival_time.setCellValueFactory(
				new PropertyValueFactory<Flight,String>("arrivalTime"));
		
		//int uid = Integer.parseInt(user.getUserid());
		//table_scheduled_flights.setItems(list);
		
		//ObservableList<Flight> bkd =
		
		table_scheduled_flights.setItems(DBQueries.retrieveBookings(VO.getUser().getUserid()));
		
	
		
	}
	
	
	
	// when show add flight button is clicked the users currently booked flights are shown
	public void displayBookedFlights(ActionEvent event) throws Exception {
		

		String id = VO.getUser().getUserid();

		String query = "SELECT * FROM public.ticket WHERE userid = " + "'" + id + "'";
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "ric", null);
	        System.out.println("Connected to PostgreSQL database!");
			PreparedStatement psbf = connection.prepareStatement(query);
			ResultSet rsbf = psbf.executeQuery();
				
			while(rsbf.next()) {
				list.add(new Flight(rsbf.getString("flightid"), rsbf.getString("departureairport"), rsbf.getString("departuredate"), rsbf.getString("departuretime"), 
						rsbf.getString("arrivalairport"), rsbf.getString("arrivaldate"), rsbf.getString("arrivaltime")));		
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	
	
	//Method to add from Available Flights TableView
	public void addRowFromTable(ActionEvent event) throws IOException {
		
		//User u = new User();
		String id = VO.getUser().getUserid();
		System.out.println("addRowFromTable uid: " + id);
	
		Flight selectedFlight = table_avail_flights.getSelectionModel().getSelectedItem();
		
		System.out.println("Adding flight " + selectedFlight.getFlightid());
	
		//create if block that checks flightid for existing vbooked flight
		//if flight != existing booking, continue
		
		
		DBQueries.insertBooking(VO.getUser(), selectedFlight);
			
		
		//User u = new User(DBQueries.getUserID());
		
		//u = u.setUserid(u);
		
		//VO vo = new VO();
		//vo.setFl(selectedFlight.getFlightid());
		//System.out.println(uid);

		//String flt = selectedFlight.getFlightid();
		//String usr = u.getUserid();
		
		//VO vo = new VO();
		
//		VO.setFl(selectedFlight.getFlightid());
//		vo.setUser(u);
//		
//		vo.getUser();
//		vo.getFlight();
//		
//		System.out.println(vo.toString());
		
	}
	
	
//	public User createUser(User user) {
//		User yooser = user;
//		return yooser;
//	}
	
	
	//Method to remove from Scheduled Flights TableView
    public void deleteRowFromTable(ActionEvent event) throws IOException {
    	
    	String id = VO.getUser().getUserid();
    	System.out.println("deleteRowFromTable uid: " + id);
    	
    	Flight toDelete = table_scheduled_flights.getSelectionModel().getSelectedItem();
    	System.out.println("Deleting flight " + toDelete.getFlightid());
    	
    	//DBQueries.deleteBooking(VO.getUser(), toDelete);
    	DBQueries.deleteBooking(toDelete);
    	//table_scheduled_flights.getItems().remove(toDelete);
    	
    	//table_scheduled_flights.getItems().removeAll(table_scheduled_flights.getSelectionModel().getSelectedItem());
    	
    	
    }
    
    
    
	public void switchToScene4(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		System.out.println("Page refreshed");
	}
    
    
    
    
}


	







