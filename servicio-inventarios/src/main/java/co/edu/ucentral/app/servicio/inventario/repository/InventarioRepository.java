package co.edu.ucentral.app.servicio.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.PathVariable;

//import co.edu.ucentral.app.servicio.departamento.model.Curso;
import co.edu.ucentral.commoninventarios.model.Inventario;

public interface InventarioRepository extends PagingAndSortingRepository<Inventario, Long> {
/* 
	@Query("select f from inventario f join fetch f.cursos c where c.id = ?1")
	public List<Inventario> findEstudianteByCursosId(Long id); */

//	@Query("select Curso.id, Curso.nombre from Curso inner join estudiante_cursos on estudiante_cursos.curso_id=Curso.id where estudiante_cursos.estudiante_id = ?1")
//	public List<Curso> findCursosByEstudianteId(Long id);

	
}
