package co.edu.udea.LupinosDEV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class LupinosDevApplication {
	/*
	PARA QUE FUNCIONE DEBE CREAR UN EMPLEADO Y EN LA TABLA MOVIMIENTO DINERO EN EL CAMPO empleado_id
	darle el id del empleado creado
	 */
	public static void main(String[] args) {
		SpringApplication.run(LupinosDevApplication.class, args);
	}

}
