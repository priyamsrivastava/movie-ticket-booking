package in.capgemini.movieticketbookingapp.exception;

public class SeatSequenceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SeatSequenceException() {
		super();
	}
	public SeatSequenceException(String errMsg) {
		super(errMsg);
	}
}
