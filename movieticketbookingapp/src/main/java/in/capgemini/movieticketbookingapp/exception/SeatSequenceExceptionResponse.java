package in.capgemini.movieticketbookingapp.exception;

public class SeatSequenceExceptionResponse {

	private String seatSequence;

	public SeatSequenceExceptionResponse(String seatSequence) {
		super();
		this.seatSequence = seatSequence;
	}

	public String getSeatSequence() {
		return seatSequence;
	}

	public void setSeatSequence(String seatSequence) {
		this.seatSequence = seatSequence;
	}
	
}
