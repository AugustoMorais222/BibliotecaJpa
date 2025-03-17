package com.br.senai.bibliotecajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;
    
    public Livro findByTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Título não pode ser vazio");
        }
        return this.livroRepository.findByTitulo(titulo);
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Integer id) {
        if (id == null || id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        }
        return this.livroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }

    public Livro save(Livro livro) {
        if (livro == null || livro.getTitulo() == null || livro.getTitulo().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Livro e título não podem ser nulos ou vazios");
        }
        return this.livroRepository.save(livro);
    }

    public void delete(Integer id) {
        if (id == null || id <= 0 || !livroRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado para exclusão");
        }
        this.livroRepository.deleteById(id);
    }

    public Livro update(Livro livro) {
        if (livro == null || livro.getId() == null || !livroRepository.existsById(livro.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado para atualização");
        }
        return this.save(livro);
    }
    
    public Livro findByAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Autor não pode ser vazio");
        }
        return this.livroRepository.findByAutor(autor);
    }
    
    public List<Livro> findByCategoriaId(Integer categoria) {
        if (categoria == null || categoria <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID de categoria inválido");
        }
        return this.livroRepository.findByCategoriaId(categoria);
    }
    
    public List<Livro> findByQuantidadeDisponivel(Integer quantidade) {
        if (quantidade == null || quantidade < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade deve ser um número positivo");
        }
        return this.livroRepository.findByQuantidadeDisponivelGreaterThan(quantidade);
    }
}
