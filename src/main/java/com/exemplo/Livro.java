/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemplo;

/**
 *
 * @author mvk09
 */
public class Livro {
    private String titulo;
    private boolean favorito;

    public Livro(String titulo) {
        this.titulo = titulo;
        this.favorito = false;
    }

    public void marcarComoFavorito() {
        this.favorito = true;
    }

    public void desmarcarComoFavorito() {
        this.favorito = false;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public String getTitulo() {
        return titulo;
    }
}
