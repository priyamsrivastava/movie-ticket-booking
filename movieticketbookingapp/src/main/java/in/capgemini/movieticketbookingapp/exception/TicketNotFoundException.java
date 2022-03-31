package in.capgemini.movieticketbookingapp.exception;

public class TicketNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TicketNotFoundException() {
		super();
	}
	public TicketNotFoundException(String errMsg) {
		super(errMsg);
	}
}
