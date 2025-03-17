package com.br.senai.bibliotecajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> getAllLivros() {
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public Livro getLivroById(@PathVariable Integer id) {
        return livroService.findById(id);
    }

    @PostMapping
    public Livro saveLivro(Livro livro) {
        return livroService.save(livro);
    }

    @PutMapping
    public Livro updateLivro(Livro livro) {
        return livroService.update(livro);
    }

    @DeleteMapping("/{id}")
    public void deleteLivro(@PathVariable Integer id) {
        this.livroService.delete(id);
    }
    
    @GetMapping("/titulo/{titulo}")
	public Livro findByTitulo(@PathVariable String titulo) {
		return livroService.findByTitulo(titulo);
    }
    
    @GetMapping("/autor/{autor}")
    public Livro findByAutor(@PathVariable String autor) {
    	return this.livroService.findByAutor(autor);
    }
    
    @GetMapping("/categoria/{categoriaId}")
    public List<Livro> findByCategoriaId(@PathVariable Integer categoriaId){ 
    	return this.livroService.findByCategoriaId(categoriaId);
    }
    
    @GetMapping("/quantidade/{quantidade}")
    public List<Livro> findByQuantidadeDisponivel(@PathVariable Integer quantidade){
    	return this.livroService.findByQuantidadeDisponivel(quantidade);
    }
    
}
