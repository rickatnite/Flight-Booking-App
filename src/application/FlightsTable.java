package application;

import businessLogic.Flight;
import javafx.scene.control.TableView;

//extends Application?
public class FlightsTable {

	
	
	private TableView<Flight> table;
	
	//create new TableColumn<Flight, String> for every columns
	//name.setCellValueFactory(new PropertyValueFactory<>("name"));

	
	
	
	ObservableList<Flight> allFlights = tableView.getItems();
	table = new TableView<>();
	table.setItems(DBQueries.flightList);
	table.getColumns().addAll(column1, column2, .....);
	
	
	int flightnum = Integer.parseInt(inputFlightnum.getText());
	Booking.bookFlight(flightnum);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}











