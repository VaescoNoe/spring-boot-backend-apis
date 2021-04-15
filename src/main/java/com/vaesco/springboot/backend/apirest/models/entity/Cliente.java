package com.vaesco.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6698445303179302595L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable = false)
	@NotEmpty(message = "no puede ser vacio")
	@NotNull	
	@Pattern(regexp="^([a-zA-Z]{2,40})|([a-zA-Z]{2,40} [a-zA-Z]{2,40})$", message=": no es correcto")
	@Size(min = 2 , max = 40, message = "el tamaño tiene que estar entre 2 y 40 caracteres")
	private String nombre;

	@Column
	@Size(min = 2 , max = 40, message = "el tamaño tiene que estar entre 2 y 40 caracteres")
	@NotEmpty(message = "no puede ser vacio")
	@NotNull
	@Pattern(regexp="^([a-zA-Z]{2,40})|([a-zA-Z]{2,40} [a-zA-Z]{2,40})$", message=": no es correcto")
	private String apellido;
	
	@Column(nullable = false, unique = true)
	@Email
	@NotEmpty(message = "no puede ser vacio")
	@NotNull	
	private String email;
	
	@Column(name = "create_at")
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	private String foto;
	
//	@PrePersist
//	public void prePresist() {
//		createAt = new Date();
//	}

	
	public Long getId() {
		return id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

}
