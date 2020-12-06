package co.com.moviedb.moviedb.framework.error;

public class InformationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer errorCode;
	
	public InformationException(String message) {
		super(message);
		this.errorCode = null;
	}
	
	public InformationException(String message, Integer errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	/**
	 * @return the errorCode
	 */
	public Integer getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	
	

}
