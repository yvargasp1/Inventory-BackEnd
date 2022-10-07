package co.edu.ucentral.app.usuario.servicio;
import java.util.List;

import co.edu.ucentral.app.commonusuarios.model.Usuario;
import co.edu.ucentral.servicio.common.service.CommonService;

public interface UsuarioService extends CommonService<Usuario> {
/* 	public Usuario findByUsername(String username);
 */
 public List<Usuario>  findUsuariobyNombre(String term);

}
