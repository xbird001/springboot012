spring boot web 三
	1、spring boot 拦截器的使用
		1.1、编写具体的拦截器实现类，并实现HandlerInterceptor接口，并实现对应的三个方法：
			1.1.1、preHandle：被拦截的方法之前调用
			1.1.2、postHandle：被拦截的方法之后调用
			1.1.3、afterCompletion：页面渲染完毕后调用，主要用于一些资源的清理工作
		1.2、编写适配器类并继承抽象类WebMvcConfigurerAdapter，并重写addInterceptors方法，将我们编写的拦截器实现类注册进去
			具体参见实现类：springboot010.MyWebMvcConfigurerAdapter.class
	
	2、spring boot 的异常处理：****去除spring boot默认的错误处理方式exclude=ErrorMvcAutoConfiguration.class***
		2.1、方式一：
			编写实现ErrorPageRegistrar接口的实现类，并实现registerErrorPages方法，并将该类纳入到spring容器中进行管理
			具体参见：springboot010.MyErrorPageRegistrar.class
				@Override
				public void registerErrorPages(ErrorPageRegistry registry) {
					ErrorPage e400 = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
					ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
					ErrorPage eIllegalArgumentException = new ErrorPage(IllegalArgumentException.class, "/illeagalArgumentsException.html");
					registry.addErrorPages(e400,e500,eIllegalArgumentException);
				}
		2.2、方式二（注释掉方式一中的MyErrorPageRegistrar异常处理方式）,此种方式不能按照HttpStatus状态码进行引导页面，只能按照异常类型引导
			2.2.1、局部的异常处理
				在具体的controller里面添加如下代码：
					@ExceptionHandler(value=Exception.class)
					public String error() {
						return "/illeagalArgumentsException.html";
					}
				1、方法是具体捕捉到异常后具体的页面逻辑处理
				2、注解@ExceptionHandler则是可以配置捕捉哪些具体的异常类型
				3、具体参见类：springboot010.UserController.class的error方法
			2.2.2、全局的异常处理
				1、编写一个类加上注解@ControllerAdvice
				2、在编写的类里面添加方法，添加注解@ExceptionHandler，这里可以根据不同的异常类型进行捕捉
				3、具体参见类springboot010.GlobalExceptionHandler.class
				@ControllerAdvice
				public class GlobalExceptionHandler {
					
					@ExceptionHandler(value=IllegalArgumentException.class)
					public String errorIllegalArgumentException(Exception e) {
						return "/illeagalArgumentsException.html";
					}
				
				}