package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// 서블릿 자동 등록
// 스프링이 현재 내 패키지를 포함한 하위 패키지에서 서블릿을 찾아 자동으로 서블릿을 등록/실행을 도와주는 어노테이션
@ServletComponentScan
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}
}
