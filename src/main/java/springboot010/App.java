package springboot010;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 去除spring boot默认的错误处理方式exclude=ErrorMvcAutoConfiguration.class
 * @author Administrator
 *
 */
@SpringBootApplication()
public class App {
	
	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
		
	}

}
