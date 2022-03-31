package in.capgemini.movieticketbookingapp.exception;

public class TicketNotFoundExceptionResponse {

	private String ticketNotFound;

	public TicketNotFoundExceptionResponse(String ticketNotFound) {
		super();
		this.ticketNotFound=ticketNotFound;
	}
	public String getTicketNotFound() {
		return ticketNotFound;
	}

	public void setTicketNotFound(String ticketNotFound) {
		this.ticketNotFound = ticketNotFound;
	}
	
}
