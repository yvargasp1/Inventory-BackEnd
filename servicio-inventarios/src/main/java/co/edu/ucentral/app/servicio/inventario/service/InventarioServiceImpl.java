package co.edu.ucentral.app.servicio.inventario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.ucentral.app.servicio.inventario.repository.InventarioRepository;
import co.edu.ucentral.commoninventarios.model.Inventario;
import co.edu.ucentral.servicio.common.service.CommonServiceImpl;
@Service
public class InventarioServiceImpl extends CommonServiceImpl<Inventario, InventarioRepository> implements InventarioService {

//	@Override
//	public List<Curso> findCursosByEstudianteId(Long id) {
//		// TODO Auto-generated method stub
//		return repository.findCursosByEstudianteId(id);
//	}

/* 	@Override
	public List<Inventario> findEstudianteByCursosId(Long id) {
		// TODO Auto-generated method stub
		return repository.findEstudianteByCursosId(id);
	} */

/* 	@Override
	public List<Inventario> findInventarioByCursosId(Long id) {
		// TODO Auto-generated method stub
		return null;
	} */

//	@Override
//	public Estudiante obtenerEstudiante(Long id) {
//		// TODO Auto-generated method stub
//		return repository.obtenerEstudiante(id);
//	}

}
