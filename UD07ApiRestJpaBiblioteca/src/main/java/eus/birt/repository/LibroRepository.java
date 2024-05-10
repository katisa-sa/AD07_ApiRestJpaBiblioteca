package eus.birt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.domain.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{

	Libro findByIsbn(String isbn);

	void deleteByIsbn(String isbn);

	List <Libro> findAllByAutor(String autor);

	void deleteAllByAutor(String autor);
}
