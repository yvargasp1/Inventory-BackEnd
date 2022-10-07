package co.edu.ucentral.app.servicio.inventario.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.edu.ucentral.app.servicio.inventario.service.InventarioService;
import co.edu.ucentral.commoninventarios.model.Inventario;

import co.edu.ucentral.servicio.common.controller.CommonController;
import net.bytebuddy.asm.Advice.Return;

@RestController
public class InventarioController extends CommonController<Inventario, InventarioService> {

	
	@PostMapping("/crear-con-foto")
	public ResponseEntity<?> crearConImagen(@Valid  Inventario Inventario,BindingResult result, @RequestParam MultipartFile archivo) throws IOException{
		if(!archivo.isEmpty()) {
			Inventario.setImagen(archivo.getBytes());
		}
		
		return super.crear(Inventario, result);
	}
	@PutMapping("editar-con-foto/{id}")
	public ResponseEntity<?> editarConFoto(@Valid  Inventario Inventario,BindingResult result, @PathVariable Long id, @RequestParam MultipartFile archivo) throws IOException{
		if(result.hasErrors()) {
		}
		
		Optional<Inventario> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Inventario InventarioBd = optional.get();
	
		if(!archivo.isEmpty()) {
			InventarioBd.setImagen(archivo.getBytes());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(InventarioBd));

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modificar(@PathVariable Long id , @Valid  @RequestBody Inventario Inventario) {
		
		
		Optional<Inventario> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Inventario InventarioBd = optional.get();
	InventarioBd.setNombre(Inventario.getNombre());
	InventarioBd.setCantidad(Inventario.getCantidad());
	InventarioBd.setCreateAt(Inventario.getCreateAt());
		
		return ResponseEntity.ok(service.save(InventarioBd));

	}
	
	
	
/* 	@GetMapping("/uploads/img/{id}")
	public ResponseEntity<?> verImagen(@PathVariable Long id){
		Optional<Inventario> optional = service.findById(id);
		if(!optional.isPresent() || optional.get().getImagen() ==null) {
			return ResponseEntity.notFound().build();
		}
		Resource img = new ByteArrayResource(optional.get().getImagen());
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
	}
 */
	
	
	
	
	@GetMapping("/{id}/Inventario")
	public Inventario obtenerInventario(@PathVariable Long id){
		
		Optional<Inventario> optionalR = this.service.findById(id);
	
		if(!optionalR.isPresent()) {
			return null;
		}
		
		
		return optionalR.get();
	}
	
	
	
}

