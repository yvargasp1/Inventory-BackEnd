package co.edu.ucentral.app.usuario.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import co.edu.ucentral.app.commonusuarios.model.Usuario;



public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
/* 	public Usuario findByUsername(String username);
 */
/*  @Query(value="select f.nombre from usuarios f user where f.nombre = ?",nativeQuery = true) */
	 public List<Usuario> findByNombre(String term);
	
	
}
