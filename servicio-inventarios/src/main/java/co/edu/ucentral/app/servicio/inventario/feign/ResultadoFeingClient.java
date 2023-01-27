package co.edu.ucentral.app.servicio.inventario.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import co.edu.ucentral.commoninventarios.model.Inventario;
@FeignClient("servicio-inventarios")

public interface ResultadoFeingClient {
	
	//REST con otros servicios
	@GetMapping("/{id}/x/{x}/x")
	public Inventario x(@PathVariable Long id);

}
