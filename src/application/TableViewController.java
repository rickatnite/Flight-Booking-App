package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import businessLogic.Flight;
import businessLogic.User;
import database.DBQueries;
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
		
		
		//table_scheduled_flights.setItems(DBQueries.retrieveBookings());
		
		
		
		
	}
	
	
	

	
	
	
	
	//Method to add from Available Flights TableView
	public void addRowFromTable(ActionEvent event) throws IOException {
		Flight selectedFlight = table_avail_flights.getSelectionModel().getSelectedItem();
		
		System.out.println(selectedFlight);
	}
	
	//Method to remove from Scheduled Flights TableView
    public void deleteRowFromTable(ActionEvent event) throws IOException {
    	
    	table_scheduled_flights.getItems().removeAll(table_scheduled_flights.getSelectionModel().getSelectedItem());
    	
    	
    }
}










