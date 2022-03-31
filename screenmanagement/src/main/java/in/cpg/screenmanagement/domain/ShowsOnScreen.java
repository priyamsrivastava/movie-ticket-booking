package in.cpg.screenmanagement.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class ShowsOnScreen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable = false, unique = true)
	@NotBlank(message = "Show Name is required")
	@Size(min = 4, max = 30, message = "Please use 4 to 30 characters only")
	private String showName;
	
	@NotBlank(message = "Movie name is required")
	private String movie;
	
//	@NotNull(message = "Screen Id is required")
//	private int screensId;
	
	@NotNull(message = "Theatre Id is required")
	private int theatreId;
	
	private LocalDateTime showStartDateTime;
	private LocalDateTime showEndDateTime;
	
//	//ManyToOne Relationship.
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
//	@JoinColumn(name = "screen_id", updatable = false , nullable = false)
//	@JsonIgnore
//	private Screen screen;
//	
//	private String screenSequence;
//	
//	private String status;
//	
//	private int priority;
//	
//	public Integer getPriority() {
//		return priority;
//	}
//
//
//	public void setPriority(Integer priority) {
//		this.priority = priority;
//	}
//
//
//	public String getStatus() {
//		return status;
//	}
//
//
//	public void setStatus(String status) {
//		this.status = status;
//	}


	public ShowsOnScreen() {
		super();
	}

	
	public Long getId() {
		return id;
	}
	public void setShowId(Long id) {
		this.id = id;
	}
//	
//	public Screen getScreen() {
//		return screen;
//	}
//	public void setScreen(Screen screen) {
//		this.screen = screen;
//	}

	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}

//	public int getScreensId() {
//		return screensId;
//	}
//	public void setScreensId(int screensId) {
//		this.screensId = screensId;
//	}
//
//	public String getScreenSequence() {
//		return screenSequence;
//	}
//	public void setScreenSequence(String screenSequence) {
//		this.screenSequence = screenSequence;
//	}
	
	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	
	public LocalDateTime getShowStartDateTime() {
		return showStartDateTime;
	}
	public void setShowStartDateTime(LocalDateTime showStartDateTime) {
		this.showStartDateTime = showStartDateTime;
	}
	
	public LocalDateTime getShowEndDateTime() {
		return showEndDateTime;
	}
	public void setShowEndDateTime(LocalDateTime showEndDateTime) {
		this.showEndDateTime = showEndDateTime;
	}
	
	@PrePersist
	public void onCreate() {
		this.showStartDateTime = showStartDateTime.now();
		this.showEndDateTime = this.showStartDateTime.plusHours(3);
	}
	
	@PreUpdate
	public void onUpdate() {
		this.showStartDateTime = showStartDateTime.now();
		this.showEndDateTime = this.showStartDateTime.plusHours(3);
	}
	
}
