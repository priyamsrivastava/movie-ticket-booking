package in.capgemini.movieticketbookingapp.exception;

public class TicketIdExceptionResponse {

	private String ticketIdentifier;
	public TicketIdExceptionResponse(String ticketIdentifier) {
		super();
		this.ticketIdentifier=ticketIdentifier;
	}
	public String getTicketId() {
		return ticketIdentifier;
	}
	public void setTicketId(String ticketIdentifier) {
		this.ticketIdentifier=ticketIdentifier;
	}
}
