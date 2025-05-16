/*package eus.birt.dam.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Mamiferos;
import eus.birt.dam.domain.SedesVeterinaria;
import eus.birt.dam.repository.MamiferosRepository;
import eus.birt.dam.repository.SedesVeterinariaRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
		@Autowired
	   	private MamiferosRepository mamiferosRepository;
		@Autowired
	   	private SedesVeterinariaRepository sedeRepository;
		
		@Override
		public void run(String... arg0) throws Exception {
			SedesVeterinaria sede1 = new SedesVeterinaria("Lilura Veterinaria Vitoria", "c/Zabalgana, 6", "Vitoria", "945269874");
			sedeRepository.save(sede1);
			Mamiferos mamifero1 = new Mamiferos("StarLord", "Minerva Potter", "Perro", "de Lanas", "Grande","A1258845GHJ51456", "Es de color negro y lleva tratamiento para la ansiedad");
			mamiferosRepository.save(mamifero1);
			
			
			System.out.println("Started in Bootstrap");
	        System.out.println("Number of mamiferos: " + mamiferosRepository.count());
				
		}
		
}*/


