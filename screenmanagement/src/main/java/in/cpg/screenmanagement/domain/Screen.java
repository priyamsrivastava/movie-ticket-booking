package in.cpg.screenmanagement.domain;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;


@Entity
public class Screen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String screenName;
	@NotBlank(message = "No sn given.")
	@Column(updatable = false)
	private String showName;
	
//	private Integer pTSequence = 0;

	private int screenRows;

	private int screenColumns;

	
//	// OneToMany Relationship
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "screen")
//	private List<ShowsOnScreen> showList = new ArrayList<ShowsOnScreen>();	
//	
	public Screen() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	
	
//	public List<ShowsOnScreen> getShowList() {
//		return showList;
//	}
//
//	public void setShowList(List<ShowsOnScreen> showList) {
//		this.showList = showList;
//	}
//
//	public Integer getpTSequence() {
//		return pTSequence;
//	}
//
//	public void setpTSequence(Integer pTSequence) {
//		this.pTSequence = pTSequence;
//	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public int getScreenRows() {
		return screenRows;
	}

	public void setScreenRows(int screenRows) {
		this.screenRows = screenRows;
	}

	public int getScreenColumns() {
		return screenColumns;
	}

	public void setScreenColumns(int screenColumns) {
		this.screenColumns = screenColumns;
	}
	
	
	
	
}
