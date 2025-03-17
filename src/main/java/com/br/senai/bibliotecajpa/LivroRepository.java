package com.br.senai.bibliotecajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

	Livro findByTitulo(String titulo);
	
	Livro findByAutor(String autor);
	
    List<Livro> findByQuantidadeDisponivelGreaterThan(Integer quantidade);
    
    List<Livro> findByCategoriaId(Integer categoriaId);
}
