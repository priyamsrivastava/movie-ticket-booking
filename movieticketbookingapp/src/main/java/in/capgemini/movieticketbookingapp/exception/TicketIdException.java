package in.capgemini.movieticketbookingapp.exception;

public class TicketIdException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TicketIdException() {
		super();
	}
	public TicketIdException(String errMsg) {
		super(errMsg);
	}
}
