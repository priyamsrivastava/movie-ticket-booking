package in.capgemini.movieticketbookingapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ticketId;
	@Column(updatable=true)
	private int noOfSeats=0;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="ticket")
	private List<Seat> seatNumber=new ArrayList<>();
	private String bookingRef;
	private boolean bookingStatus;
	private Integer TSequence=0;
	private String ticketIdentifier;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="booking_id",nullable=false)
	@JsonIgnore
	private TicketBooking ticketBooking;
	public Ticket() {
		super();
	}
	public TicketBooking getTicketBooking() {
		return ticketBooking;
	}
	public void setTicketBooking(TicketBooking ticketBooking) {
		this.ticketBooking = ticketBooking;
	}
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public List<Seat> getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(List<Seat> seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getBookingRef() {
		return bookingRef;
	}
	public void setBookingRef(String bookingRef) {
		this.bookingRef = bookingRef;
	}
	public boolean isBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public Integer getTSequence() {
		return TSequence;
	}
	public void setTSequence(Integer tSequence) {
		TSequence = tSequence;
	}
	public String getTicketIdentifier() {
		return ticketIdentifier;
	}
	public void setTicketIdentifier(String ticketIdentifier) {
		this.ticketIdentifier = ticketIdentifier;
	}
	
	
}
