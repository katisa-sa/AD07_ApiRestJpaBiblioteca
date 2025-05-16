package eus.birt.dam.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="sedesVeterinaria")
public class SedesVeterinaria implements Serializable {

	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private String direccion;
	
	private String city;
	
	private String telefono;
	
	@JsonManagedReference
	@OneToMany (mappedBy = "sede",cascade = CascadeType.ALL)
	List <Mamiferos> mamiferos = new ArrayList<>();
	
	
	public SedesVeterinaria(String name, String direccion, String city, String telefono) {
		this.name = name;
		this.direccion = direccion;
		this.city = city;
		this.telefono = telefono;
	}
	
}
