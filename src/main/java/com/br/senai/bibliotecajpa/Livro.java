package com.br.senai.bibliotecajpa;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "editora", length = 100)
    private String editora;
    
    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @Column
    private Integer anoPublicacao;

    @Column
    private Integer isbn;
    
    @Column
    private Integer quantidadeDisponivel;
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column
    @DateTimeFormat
    private LocalDate dataCadastro;

    
    public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Livro() {
    }

    public Livro(Integer id, String titulo, String autor, Integer anoPublicacao, Integer quantidadeDisponivel, LocalDate dataCadastro, Integer isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.dataCadastro = dataCadastro;
        this.isbn = isbn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
	public Integer getIsbn() {
		return isbn;
	}
	
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoPublicacao, autor, dataCadastro, id, isbn, quantidadeDisponivel, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(anoPublicacao, other.anoPublicacao) && Objects.equals(autor, other.autor)
				&& Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(id, other.id)
				&& Objects.equals(isbn, other.isbn) && Objects.equals(quantidadeDisponivel, other.quantidadeDisponivel)
				&& Objects.equals(titulo, other.titulo);
	}

}
