package co.edu.ucentral.app.usuario.Controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.commonusuarios.model.Usuario;
import co.edu.ucentral.app.usuario.servicio.UsuarioService;
import co.edu.ucentral.servicio.common.controller.CommonController;

@RestController
public class UsuarioController extends CommonController<Usuario, UsuarioService> {
/* 
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Usuario usuario, @PathVariable Long id) {
		Optional<Usuario> optional = service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Usuario usuarioBd = optional.get();
		
		usuarioBd.setPassword(usuario.getPassword());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioBd));
	} */

/* 	@GetMapping("/buscar-username")
	public ResponseEntity<?> verPorusername(@RequestParam("username") String username) {
		Usuario usuario = service.findByUsername(username);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(usuario);

	} */

	@GetMapping("/filtrar-usuarios/{term}")
public ResponseEntity<?> listarporNombre(@PathVariable String term){
		return ResponseEntity.ok().body(service.findUsuariobyNombre(term));
	}

		@GetMapping("/fiter-role")
public ResponseEntity<?> listarRole(){
		System.out.println(ResponseEntity.ok().body(service.findAll())); 
		return null;
	}

}
