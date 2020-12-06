package co.com.moviedb.moviedb.framework.controller;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import co.com.moviedb.moviedb.framework.error.InformationException;
import co.com.moviedb.moviedb.framework.response.BaseResponse;
import co.com.moviedb.moviedb.framework.service.BaseService;
import co.com.moviedb.moviedb.framework.util.TextManager;


public class BaseController <T extends BaseService<?>> {
	
	private T service;
	
	@SuppressWarnings("unchecked")
	public BaseController() {
		setupService(
					(Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0])
				);
	}

	private void setupService(Class<T> serviceClass) {
		if( null == service ) {
			synchronized (BaseController.class) {
				if ( null == service ) {
					try {
						setService(serviceClass.getDeclaredConstructor().newInstance());
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T extends BaseResponse<?>> ResponseEntity<T> executeService( executeService<T> executeService) throws Exception{
		T response = (T) BaseResponse.class.getDeclaredConstructor().newInstance();
		BindingResult bindingResult = executeService.getBindingResult();
		try {
			if ( null != bindingResult) {
				if(!validateBinding(response,bindingResult)) {
					return new ResponseEntity<>(response,HttpStatus.OK);
				}
			}else {
				response.setOk(true);
			}

			ResponseEntity<T> result = executeService.execute(response);
			try {
				T resp = result.getBody();
				if (null != resp && resp.isOk()) {
					return new ResponseEntity<>(resp,HttpStatus.OK);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				T resp = (T)handleError(e);
				return new ResponseEntity<>(resp,HttpStatus.OK);
			} catch (Exception e1) {
				throw e1;
			}
		}
	}
	
	

	private BaseResponse<?> handleError(Exception e) {
		BaseResponse<Object> obj = new BaseResponse<Object>();
		obj.setOk(false);
		String msg = e.getMessage();
		if (TextManager.isNull(msg)) {
			msg = "Null value error";
		}else if ( e instanceof NumberFormatException) {
			msg = "The number "+ e.getMessage() + " is invalid";
		}
		obj.setErrorMessage(msg);
		if (e instanceof InformationException) {
			obj.setErrorCode(((InformationException) e).getErrorCode());
		}
		return obj;
	}

	private boolean validateBinding(BaseResponse<?> response, BindingResult bindingResult) {
		Boolean resp = true;
		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				response.setErrorMessage((TextManager.isNull(response.getErrorMessage())? "" : response.getErrorMessage() +"\n")+error.getDefaultMessage());
			}
			
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError fieldError: fieldErrors) {
				response.setErrorMessage((TextManager.isNull(response.getErrorMessage())? "" : response.getErrorMessage() +"\n")+"@|"+fieldError.getField() + "||" + fieldError.getDefaultMessage());
			}
			resp = false;
		}
		response.setOk(resp);
		return resp;
	}

	/**
	 * @return the service
	 */
	public T getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(T service) {
		this.service = service;
	}
	

}
