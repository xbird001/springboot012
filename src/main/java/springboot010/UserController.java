package springboot010;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	/**
	 * 将所有的异常都进行拦截，当然也可以按照具体的异常类型进行配置
	 * @return
	 */
	/*@ExceptionHandler(value=Exception.class)*/
	public String error() {
		return "/illeagalArgumentsException.html";
	}

	@RequestMapping(value="/createUser")
	@ResponseBody
	public String createUser() {
		System.out.println("=============createUser======================");
		return "create user...";
	}
	
	@RequestMapping(value="/createException")
	public String createException() {
		throw new IllegalArgumentException("name is IllegalArgumentException");
	}
	
	@RequestMapping(value="/createNullPointException")
	public String createNullPointException() {
		throw new NullPointerException("name is not present");
	}
	
}
