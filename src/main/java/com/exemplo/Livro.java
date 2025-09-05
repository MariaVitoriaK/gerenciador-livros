package com.exemplo;

public class Livro {
    private String titulo;
    private boolean favorito;

    public Livro(String titulo) {
        this.titulo = titulo;
        this.favorito = false; // Por padrão, livro não é favorito
    }

    // Marca o livro como favorito.
    public void marcarComoFavorito() {
        this.favorito = true;
    }

    // Remove a marcação de favorito do livro.
    public void desmarcarComoFavorito() {
        this.favorito = false;
    }

    // Retorna se o livro está marcado como favorito.
    public boolean isFavorito() {
        return favorito;
    }

    // Retorna o título do livro.
    public String getTitulo() {
        return titulo;
    }
}
