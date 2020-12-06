package co.com.moviedb.moviedb.framework.response;

import java.io.Serializable;

public class BaseResponse <B extends Object> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean ok;
	private String errorMessage;
	private Integer errorCode;
	private B responseBody;
	
	public BaseResponse() {
		super();
	}

	/**
	 * @return the ok
	 */
	public boolean isOk() {
		return ok;
	}

	/**
	 * @param ok the ok to set
	 */
	public void setOk(boolean ok) {
		this.ok = ok;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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

	/**
	 * @return the responseBody
	 */
	public B getResponseBody() {
		return responseBody;
	}

	/**
	 * @param responseBody the responseBody to set
	 */
	public void setResponseBody(B responseBody) {
		this.responseBody = responseBody;
	}

	@Override
	public String toString() {
		return "BaseResponse [ok=" + ok + ", errorMessage=" + errorMessage + ", errorCode=" + errorCode
				+ ", responseBody=" + responseBody + "]";
	}
	
	

}
