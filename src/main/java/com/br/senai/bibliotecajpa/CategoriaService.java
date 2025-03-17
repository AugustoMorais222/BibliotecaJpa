package com.br.senai.bibliotecajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Integer id) {
        if (id == null || id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        }
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada"));
    }

    public Categoria save(Categoria categoria) {
        if (categoria == null || categoria.getNome() == null || categoria.getNome().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome da categoria é obrigatório");
        }
        return categoriaRepository.save(categoria);
    }

    public void delete(Integer id) {
        if (id == null || id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID inválido");
        }
        if (!categoriaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada");
        }
        categoriaRepository.deleteById(id);
    }

    public Categoria update(Categoria categoria) {
        if (categoria == null || categoria.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria e ID são obrigatórios para atualização");
        }
        if (!categoriaRepository.existsById(categoria.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada para atualização");
        }
        return categoriaRepository.save(categoria);
    }
}

