/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.exemplo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GerenciadorLivrosTest {
    private GerenciadorLivros gerenciador;
    private Livro livro1;
    private Livro livro2;

    @BeforeEach
    public void setup() {
        gerenciador = new GerenciadorLivros();
        livro1 = new Livro("O Pequeno Príncipe");
        livro2 = new Livro("Harry Potter");
    }

    @Test
    public void testAdicionarLivro() {
        gerenciador.adicionarLivro(livro1);
        assertEquals(1, gerenciador.getLivros().size());
        gerenciador.adicionarLivro(livro2);
        assertEquals(2, gerenciador.getLivros().size());
    }

    @Test
    public void testContarFavoritosNenhum() {
        gerenciador.adicionarLivro(livro1);
        gerenciador.adicionarLivro(livro2);
        assertEquals(0, gerenciador.contarFavoritos());
    }

    @Test
    public void testContarFavoritosAlguns() {
        gerenciador.adicionarLivro(livro1);
        gerenciador.adicionarLivro(livro2);
        livro1.marcarComoFavorito();
        assertEquals(1, gerenciador.contarFavoritos());
    }

    @Test
    public void testContarFavoritosTodos() {
        gerenciador.adicionarLivro(livro1);
        gerenciador.adicionarLivro(livro2);
        livro1.marcarComoFavorito();
        livro2.marcarComoFavorito();
        assertEquals(2, gerenciador.contarFavoritos());
    }

    @Test
    public void testMarcarEDesmarcarFavorito() {
        livro1.marcarComoFavorito();
        assertTrue(livro1.isFavorito());
        livro1.desmarcarComoFavorito();
        assertFalse(livro1.isFavorito());
    }
    
    
}
