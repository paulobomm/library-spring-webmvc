package br.com.bpkedu.library_spring_webmvc.dto;

import br.com.bpkedu.library_spring_webmvc.domain.Livro;

public class LivroDTO {

    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private String isbn;
    private String editora;

    // Getters e Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public Integer getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(Integer anoPublicacao) { this.anoPublicacao = anoPublicacao; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getEditora() { return editora; }
    public void setEditora(String editora) { this.editora = editora; }

    // Método para converter LivroDTO para Livro
    public Livro toLivro() {
        return new Livro(titulo, autor, anoPublicacao, isbn, editora);
    }

    // Método para converter Livro para LivroDTO
    public static LivroDTO fromLivro(Livro livro) {
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setTitulo(livro.getTitulo());
        livroDTO.setAutor(livro.getAutor());
        livroDTO.setAnoPublicacao(livro.getAnoPublicacao());
        livroDTO.setIsbn(livro.getIsbn());
        livroDTO.setEditora(livro.getEditora());
        return livroDTO;
    }
}