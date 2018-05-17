package springboot010;

import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.http.HttpStatus;

/*@Component*/
public class MyErrorPageRegistrar implements ErrorPageRegistrar {

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		ErrorPage e400 = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
		ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
		ErrorPage eIllegalArgumentException = new ErrorPage(IllegalArgumentException.class, "/illeagalArgumentsException.html");
		registry.addErrorPages(e400,e500,eIllegalArgumentException);
	}

}
