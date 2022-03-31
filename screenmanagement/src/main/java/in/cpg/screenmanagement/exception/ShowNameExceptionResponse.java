package in.cpg.screenmanagement.exception;

public class ShowNameExceptionResponse {
	
	private String showName;
	
	public ShowNameExceptionResponse(String showName) {
		super();
		this.showName = showName;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}
	
}
