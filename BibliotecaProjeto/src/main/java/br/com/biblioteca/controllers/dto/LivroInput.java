package br.com.biblioteca.controllers.dto;

import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.biblioteca.entities.AutorEntity;
import lombok.Getter;
import lombok.Setter;

	@Getter
	@Setter
		public class LivroInput {
	
	@Length(max = 200)
	@NotNull(message = "Título dos livros é obrigatório.")
		private String titulo;
	
	@DecimalMax("9999")
	@NotNull(message = "Ano de lançamento dos livros é obrigatório.")
		private Integer anoDeLancamento;
	
	@NotEmpty(message = "Todos livros devem haver ao menos um autor.")
		private List<Long> IdsAutores;	

}
