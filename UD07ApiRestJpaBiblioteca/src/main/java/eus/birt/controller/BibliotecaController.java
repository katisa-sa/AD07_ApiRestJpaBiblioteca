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

import eus.birt.domain.Biblioteca;
import eus.birt.repository.BibliotecaRepository
;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("api/bibliotecas")
public class BibliotecaController {

	@Autowired
	BibliotecaRepository bibliotecaRepository;

	@GetMapping({"/",""})
	public List <Biblioteca> index() {
	return bibliotecaRepository.findAll();
	}

	@GetMapping("/{id}")
	public Biblioteca show(@PathVariable("id") Long id) {
		return bibliotecaRepository.findById(id).orElse(null);
	}

	@PostMapping({"/",""})
	@ResponseStatus (HttpStatus.CREATED)
	public Biblioteca create(@RequestBody Biblioteca biblioteca) {
		return bibliotecaRepository.save(biblioteca);
	}

	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Biblioteca update(@RequestBody Biblioteca biblioteca, @PathVariable("id") Long id) {
		Biblioteca tempBiblioteca = bibliotecaRepository.findById(id).orElse(null);

		tempBiblioteca.setName(biblioteca.getName());
		//Al ser un id diferente, el método save hace en realidad un update
		return bibliotecaRepository.save(tempBiblioteca);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		bibliotecaRepository.deleteById(id);
	}
}
