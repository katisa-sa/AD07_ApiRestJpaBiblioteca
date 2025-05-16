package eus.birt.dam.controller;

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

import eus.birt.dam.domain.Mamiferos;
import eus.birt.dam.repository.MamiferosRepository;
import eus.birt.dam.repository.SedesVeterinariaRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("api/mamiferos")
public class MamiferosController {

	@Autowired
   	MamiferosRepository mamiferosRepository;
	@Autowired
   	SedesVeterinariaRepository sedesRepository;
	
	@GetMapping({"/",""})
	public List<Mamiferos> index() {
		return mamiferosRepository.findAll();
		}
	
	@GetMapping("/{id}")
	public Mamiferos show(@PathVariable("id") Long id) {
		return mamiferosRepository.findById(id).orElse(null);
		}
	
	@PostMapping({"","/"})
	@ResponseStatus (HttpStatus.CREATED)
	public  Mamiferos  create(@RequestBody Mamiferos mamiferos) {
		return mamiferosRepository.save(mamiferos);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Mamiferos update(@RequestBody Mamiferos mamiferos, @PathVariable("id") Long id) {
		Mamiferos tempMamiferos = mamiferosRepository.findById(id).orElse(null);
		
		tempMamiferos.setName(mamiferos.getName());
		tempMamiferos.setDueño(mamiferos.getDueño());
		tempMamiferos.setTipo(mamiferos.getTipo());
		tempMamiferos.setRaza(mamiferos.getRaza());
		tempMamiferos.setTamaño(mamiferos.getTamaño());
		tempMamiferos.setChip(mamiferos.getChip());
		tempMamiferos.setDescripcion(mamiferos.getDescripcion());
		tempMamiferos.setSede(mamiferos.getSede());
		
		return mamiferosRepository.save(tempMamiferos);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		mamiferosRepository.deleteById(id);
	}
}
