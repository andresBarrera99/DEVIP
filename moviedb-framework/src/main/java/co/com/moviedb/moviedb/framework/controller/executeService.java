package co.com.moviedb.moviedb.framework.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public abstract class executeService<T> {
	
	private BindingResult bindingResult;
	private Object request;
	
	/**
	 * for services with input parameters
	 * @author Jonathan.Barrera
	 * @param bindingResult
	 * @param request
	 */
	public executeService(BindingResult bindingResult, Object request) {
		super();
		this.bindingResult = bindingResult;
		this.request = request;
	}
	/**
	 * for services without input parameters
	 * @author Jonathan.Barrera
	 * @param bindingResult
	 */
	public executeService(BindingResult bindingResult) {
		super();
		this.bindingResult = bindingResult;
		this.request = null;
	}
	/**
	 * 
	 */
	public executeService() {
		super();
		this.bindingResult = null;
		this.request = null;
	}
	
	/**
	 * Abstract method to call services and handle errors
	 * @param response
	 * @return abstract response to client
	 * @throws Exception
	 */
	public abstract ResponseEntity<T> execute(T response) throws Exception;
	
	/**
	 * @return the bindingResult
	 */
	public BindingResult getBindingResult() {
		return bindingResult;
	}
	/**
	 * @param bindingResult the bindingResult to set
	 */
	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
	/**
	 * @return the request
	 */
	public Object getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(Object request) {
		this.request = request;
	}
	@Override
	public String toString() {
		return "executeService [bindingResult=" + bindingResult + ", request=" + request + "]";
	}
	
	

}
