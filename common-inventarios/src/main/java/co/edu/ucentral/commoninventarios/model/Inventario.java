package co.edu.ucentral.commoninventarios.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.edu.ucentral.app.commonusuarios.model.Usuario;
//import co.edu.ucentral.app.servicio.departamento.model.Curso;

@Entity
@Table(name = "Inventario")
public class Inventario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1263204889262050009L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 3, max = 20, message = "error de caracteres")
	private String nombre;
	@NotEmpty(message = "No puede estar vacio")
	private String cantidad;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuarios")
	private Usuario usuario;
 @NotNull ( message= "whatever")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createAt;

	

	/* @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Inventario_cursos", joinColumns = @JoinColumn(name = "Inventario_id"), inverseJoinColumns = @JoinColumn(name = "curso_id"))
	private List<Curso> cursos; */

	// agregar cursos

	public Inventario id(Long id) {
		setId(id);
		return this;
	}

	public Inventario nombre(String nombre) {
		setNombre(nombre);
		return this;
	}

	public Inventario cantidad(String cantidad) {
		setCantidad(cantidad);
		return this;
	}

	public Inventario usuario(Usuario usuario) {
		setUsuario(usuario);
		return this;
	}

	public Inventario createAt(Date createAt) {
		setCreateAt(createAt);
		return this;
	}



	public Inventario imagen(byte[] imagen) {
		setImagen(imagen);
		return this;
	}

@Lob
	@JsonIgnore
	private byte[] imagen; 

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

/* 	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	} */

		public String getCantidad() {
		return this.cantidad;
	}



	
	public Long getId() {
		return id;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	
	public String getNombre() {
		return nombre;
	}




	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setId(Long id) {
		this.id = id;
	}

		public void setNombre(String nombre) {
		this.nombre = nombre;
	}


/* 
	public void addC(Curso item) {
		this.cursos.add(item);
	}

	public void removeR(Curso item) {
		this.cursos.remove(item);
	} */


	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public byte[] getImagen() {
		return imagen;
	}

/* 	public Integer getImagenHashCode() {
		return (this.imagen != null) ? imagen.hashCode() : null;

	}

	 */

/* 	
	public Double getNotaExamen() {
		return NotaExamen;
	}

	public void setNotaExamen(Double notaExamen) {
		NotaExamen = notaExamen;
	} */

	/**
	 * 
	 */
}
