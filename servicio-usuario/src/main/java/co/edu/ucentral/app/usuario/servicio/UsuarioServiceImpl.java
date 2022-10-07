package co.edu.ucentral.app.usuario.servicio;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.app.usuario.Repository.UsuarioRepository;
import co.edu.ucentral.app.commonusuarios.model.Usuario;
import co.edu.ucentral.servicio.common.service.CommonServiceImpl;
@Service
public class UsuarioServiceImpl extends CommonServiceImpl<Usuario, UsuarioRepository> implements UsuarioService {

	
	/* @Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		return repository.findByUsername(username);
	} */

	

	@Transactional(readOnly = true)
	public List<Usuario> findUsuariobyNombre(String term) {
		// TODO Auto-generated method stub
		return this.repository.findByNombre(term);
	}


}
