package br.com.biblioteca.controllers.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

	@Getter
	@Setter
		public class LivroOutput {
	
		private Long id;
		private String titulo;
		private Integer anoDeLancamento;
		private List<AutorOutput> autores;
}