package springboot010;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=IllegalArgumentException.class)
	public String errorIllegalArgumentException(Exception e) {
		return "/illeagalArgumentsException.html";
	}
	
	@ExceptionHandler(value=NullPointerException.class)
	public String errorNullPointerException(Exception e) {
		return "/nullPointException.html";
	}
	
	@ExceptionHandler(value=Exception.class)
	public String error(Exception e) {
		return "/commonError.html";
	}

}
