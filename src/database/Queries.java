package database;

public class Queries {
		
	//public static final String LOGIN = "SELECT count(*) as num  FROM public.test WHERE username = '?' AND password = '?'";
	public static final String LOGIN = "SELECT * FROM public.user WHERE username = ? AND password = ?";

	public static final String INSERT_NEW_USER = "INSERT INTO public.user(username, password, firstname, lastname, address, zipcode, state, email, ssn, securityquestion, securityanswer) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String GET_FLIGHT = "SELECT * FROM public.flight WHERE CAST(flightid AS varchar) = ?";
	//public static final String GET_FLIGHTS = "SELECT * FROM public.flight GROUP BY flight";
	public static final String GET_FLIGHTS = "SELECT * FROM public.flight";
	
	public static final String BOOK_TICKET = "INSERT INTO public.ticket(flightid, userid) VALUES (?::integer, ?::integer)";
	
	public static final String DELETE_TICKET = "DELETE FROM public.ticket WHERE flightid = ?";
	
	public static final String GET_BOOKED_TICKETS = "SELECT * FROM public.flight LEFT JOIN public.ticket ON (flight.flightid = ticket.flightid) WHERE userid = ?::integer";
	//public static final String GET_BOOKED_TICKETS = "SELECT * FROM public.flight INNER JOIN public.ticket ON userid = ?::integer";
	//public static final String GET_BOOKED_TICKETS = "SELECT * FROM public.ticket WHERE CAST(userid AS varchar) = ?";
	
	public static final String GET_SECURITYQUESTION = "SELECT securityquestion FROM public.user WHERE username = ?";
	
	public static final String GET_SECURITYANSWER = "SELECT securityanswer FROM public.user WHERE password = ?";

	public static final String GET_PASSWORD = "SELECT password FROM public.user WHERE username = ? AND securityanswer = ?";
	
	public static final String GET_USERID = "SELECT * FROM public.user WHERE username = ? AND password = ?";
	
	public static final String GET_FLIGHTID = "SELECT flightid FROM public.flight WHERE username = ?";

}































//public static final String GET_FLIGHT = "SELECT * FROM public.flight WHERE departureDate = ? AND departureAirport = ? AND arrivalAirport = ?";
//
//public static final String INSERT_BOOKED_TICKET = "INSERT INTO user(bookedTicket) VALUES ?";
//this one is weird and we need to ask how to insert additional booked tickets without overwriting - update with new list? data type need to be array? data mismatch if so...
//
//
//







