package br.com.biblioteca.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.configs.ControllerConfig;
import br.com.biblioteca.controllers.dto.AutorInput;
import br.com.biblioteca.controllers.dto.AutorOutput;
import br.com.biblioteca.converts.AutorConvert;
import br.com.biblioteca.converts.LivroConvert;
import br.com.biblioteca.entities.AutorEntity;
import br.com.biblioteca.services.AutorService;
import br.com.biblioteca.services.LivroService;

	@RestController
	@RequestMapping(ControllerConfig.PRE_URL + "/autores")
		public class AutorController {
	
	@Autowired
		private AutorService autorService;
	
	@Autowired
		private AutorConvert autorConvert;
	
	@Autowired
		private LivroService livroService;
	
	@Autowired
		private LivroConvert livroConvert;
	
	@PostMapping
		public AutorOutput cadastra(@RequestBody @Valid AutorInput autorInput) {
			AutorEntity autorEntity = autorConvert.inputToNewEntity(autorInput);
			AutorEntity cadastraAutor = autorService.cadastra(autorEntity);
		return autorConvert.entityToOutput(cadastraAutor);
		
	}
	
	@PostMapping
		public AutorOutput cadastraBio(@RequestBody @Valid AutorInput bioInput) {
			AutorEntity bioEntity = autorConvert.inputToNewEntity(bioInput);
			AutorEntity cadastraBio = autorService.cadastra(bioEntity);
		return autorConvert.entityToOutput(cadastraBio);
		
	}
	
	@PutMapping("/{id}")
		public AutorOutput altera(@PathVariable Long id, @RequestBody @Valid AutorInput autorInput) {
			AutorEntity encontraAutor = autorService.listarPeloId(id);
			autorConvert.copyInputToEntity(encontraAutor, autorInput);
			AutorEntity autorAlterado = autorService.altera(encontraAutor);
		return autorConvert.entityToOutput(autorAlterado); 
		
	}
			
    @GetMapping
		public List<AutorOutput> listarTodos() {
		    List<AutorEntity> listarTodos = autorService.listarTodos();
		return autorConvert.entityToOutput(listarTodos);
			}
    
    @GetMapping("/{id}")
		public AutorOutput listarPorId(@PathVariable Long id) {
	    		AutorEntity localizou = autorService.listarPeloId(id);
	    return autorConvert.entityToOutput(localizou);
    }
		}
		
		
		
		
			