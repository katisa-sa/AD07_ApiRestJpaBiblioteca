package eus.birt.domain;



import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="libro")
public class Libro implements Serializable {
	private static final long serialVersionUID =1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String isbn;

	@Column
	private String titulo;

	@Column
	private String autor;

	@Column(name="anio_ed")
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private Date anioEdicion;

	@JsonBackReference
	@ManyToOne
	@JoinColumn (name="biblioteca_id")
	private Biblioteca biblioteca;

	//Añade propiedad teamName a JSON 
		@JsonProperty("bibliotecaName")
		public String getTeamName() {
		    return biblioteca != null ? biblioteca.getName() : null;
		}
	
	public Libro(String isbn, String titulo, String autor, Date anioEdicion, Biblioteca biblioteca) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.anioEdicion = anioEdicion;
		this.biblioteca = biblioteca;
	}


}