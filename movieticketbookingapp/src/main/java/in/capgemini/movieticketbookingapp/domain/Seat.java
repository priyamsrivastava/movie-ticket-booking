package in.capgemini.movieticketbookingapp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Seat {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer seatId;
	private String seatSequence;
	private String seatNumber;
	@Transient
	private int numberOfSeats=0;
	private String type;
	private double price;
	@Column(updatable=false)
	private String ticketIdentifier;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.REFRESH)
	@JoinColumn(name="ticket",updatable=false,nullable=false)
	@JsonIgnore
	private Ticket ticket;
	
	public Seat() {
		super();
	}	
	
	public Integer getSeatId() {
		return seatId;
	}
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getSeatSequence() {
		return seatSequence;
	}

	public void setSeatSequence(String seatSequence) {
		this.seatSequence = seatSequence;
	}

	public String getTicketIdentifier() {
		return ticketIdentifier;
	}

	public void setTicketIdentifier(String ticketIdentifier) {
		this.ticketIdentifier = ticketIdentifier;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
}
