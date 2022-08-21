package co.edu.udea.LupinosDEV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class LupinosDevApplication {
	public static void main(String[] args) {
		SpringApplication.run(LupinosDevApplication.class, args);
	}
	//Villanueva Zuly

}
