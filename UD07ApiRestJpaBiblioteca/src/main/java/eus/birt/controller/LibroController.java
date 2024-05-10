package eus.birt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.domain.Libro;
import eus.birt.repository.BibliotecaRepository;
import eus.birt.repository.LibroRepository;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("api/libros")
public class LibroController {

	@Autowired
	LibroRepository libroRepository;

	@Autowired
	BibliotecaRepository bibliotecaRepository;
	
	@GetMapping({"/",""})
	public List <Libro> index() {
		return libroRepository.findAll();
	}

	@GetMapping("/{id}")
	public Libro show(@PathVariable("id") Long id) {
		return libroRepository.findById(id).orElse(null);
	}

	@GetMapping("/{isbn}")
	public Libro show1(@PathVariable("isbn") String isbn) {
		return libroRepository.findByIsbn(isbn);
	}

	@GetMapping("/{autor}")
	public List<Libro> show2(@PathVariable("autor") String autor) {
		return libroRepository.findAllByAutor(autor);
	}


	@PostMapping({"/"})
	@ResponseStatus (HttpStatus.CREATED)
	public Libro create(@RequestBody Libro libro) {
		return libroRepository.save(libro);
	}
	
	@PutMapping("/{id}" )
	@ResponseStatus (HttpStatus.CREATED)
	public Libro update(@RequestBody Libro libro, @PathVariable("id") Long id) {
		Libro tempLibro = libroRepository.findById(id).orElse(null);

		tempLibro.setIsbn(libro.getIsbn());
		tempLibro.setTitulo(libro.getTitulo());
		tempLibro.setAutor(libro.getAutor());
		tempLibro.setAnioEdicion(libro.getAnioEdicion());
		tempLibro.setBiblioteca(libro.getBiblioteca());

		return libroRepository.save(tempLibro);
	}

	@PutMapping("/{isbn}" )
	@ResponseStatus (HttpStatus.CREATED)
	public Libro update1(@RequestBody Libro libro, @PathVariable("isbn") String isbn) {
		Libro tempLibro = libroRepository.findByIsbn(isbn);

		tempLibro.setIsbn(libro.getIsbn());
		tempLibro.setTitulo(libro.getTitulo());
		tempLibro.setAutor(libro.getAutor());
		tempLibro.setAnioEdicion(libro.getAnioEdicion());
		tempLibro.setBiblioteca(libro.getBiblioteca());

		return libroRepository.save(tempLibro);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		libroRepository.deleteById(id);
	}

	@DeleteMapping("/{isbn}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete1(@PathVariable("isbn") String isbn) {
		libroRepository.deleteByIsbn(isbn);
	}

	@DeleteMapping("/{autor}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete2(@PathVariable("autor") String autor) {
		libroRepository.deleteAllByAutor(autor);
	}
}
