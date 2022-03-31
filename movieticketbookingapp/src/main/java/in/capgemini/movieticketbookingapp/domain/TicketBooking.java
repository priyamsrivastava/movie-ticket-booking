package in.capgemini.movieticketbookingapp.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class TicketBooking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bookingId;
	@NotNull
	private int showId;
	private int movieId;
	private String customer;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingDate;	
	private int transactionId;
	@NotBlank(message="Transaction mode required")
	private String transactionMode;
	@Column(updatable=true)
	private String transactionStatus;
	@Size(min=5,max=7,message="Please use five to seven characters only")
	@Column(updatable=false,unique=true)
	private String ticketIdentifier;
	@Column(updatable=true)
	private double totalCost=0.0;
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="ticketBooking")
	private Ticket ticket;
	public TicketBooking() {
		super();
	}
	
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getTicketIdentifier() {
		return ticketIdentifier;
	}

	public void setTicketIdentifier(String ticketIdentifier) {
		this.ticketIdentifier = ticketIdentifier;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	
}
