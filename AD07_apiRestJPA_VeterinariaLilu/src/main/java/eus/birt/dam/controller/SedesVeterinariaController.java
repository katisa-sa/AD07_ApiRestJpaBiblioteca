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

import eus.birt.dam.domain.SedesVeterinaria;
import eus.birt.dam.repository.SedesVeterinariaRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("api/sedes")

public class SedesVeterinariaController {

	@Autowired
   	SedesVeterinariaRepository sedesRepository;
	
	@GetMapping({"/", ""})
	public List <SedesVeterinaria> index() {
		return sedesRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public SedesVeterinaria show(@PathVariable("id")Long id) {
		return sedesRepository.findById(id).orElse(null);
	}
	
	@PostMapping({"/", ""})
	@ResponseStatus (HttpStatus.CREATED)
	public SedesVeterinaria create(@RequestBody SedesVeterinaria sede) {
		return sedesRepository.save(sede);
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public SedesVeterinaria update(@RequestBody SedesVeterinaria sede, @PathVariable("id") Long id) {
		SedesVeterinaria tempSede = sedesRepository.findById(id).orElse(null);
		
		/*tempSede.setName(sede.getName());
		tempSede.setDireccion(sede.getDireccion());
		tempSede.setCity(sede.getCity());		
		tempSede.setTelefono(sede.getTelefono());*/
		//Al ser un id diferente, el método save hace en realidad un update
		
		tempSede.setName(sede.getName());
		//Al ser un id diferente, el método save hace en realidad un update
		
		
		return sedesRepository.save(tempSede);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		sedesRepository.deleteById(id);
	}

}
