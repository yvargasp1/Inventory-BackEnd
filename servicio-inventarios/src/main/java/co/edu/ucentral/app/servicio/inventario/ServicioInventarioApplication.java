package co.edu.ucentral.app.servicio.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan({ "co.edu.ucentral.commoninventarios.model", "co.edu.ucentral.app.commonusuarios.model",
		"co.edu.ucentral.app.servicio.modulos.model" })
@EnableEurekaClient
@SpringBootApplication
public class ServicioInventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioInventarioApplication.class, args);
	}

}
