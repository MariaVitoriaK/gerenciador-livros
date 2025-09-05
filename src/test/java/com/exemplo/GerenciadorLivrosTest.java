package com.exemplo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Testes de UNIDADE

public class GerenciadorLivrosTest {
    private GerenciadorLivros gerenciador;
    private Livro livro1;
    private Livro livro2;

    @BeforeEach
    public void setup() {
        gerenciador = new GerenciadorLivros();
        livro1 = new Livro("O Pequeno Príncipe");
        livro2 = new Livro("Em águas Profundas");
    }

    @Test
    public void testAdicionarLivro() {
        // Testa se livros são adicionados corretamente
        gerenciador.adicionarLivro(livro1);
        assertEquals(1, gerenciador.getLivros().size());
        gerenciador.adicionarLivro(livro2);
        assertEquals(2, gerenciador.getLivros().size());
    }

    @Test
    public void testContarFavoritosNenhum() {
        // Nenhum livro é favorito
        gerenciador.adicionarLivro(livro1);
        gerenciador.adicionarLivro(livro2);
        assertEquals(0, gerenciador.contarFavoritos());
    }

    @Test
    public void testContarFavoritosAlguns() {
        // Apenas um favorito
        gerenciador.adicionarLivro(livro1);
        gerenciador.adicionarLivro(livro2);
        livro1.marcarComoFavorito();
        assertEquals(1, gerenciador.contarFavoritos());
    }

    @Test
    public void testContarFavoritosTodos() {
        // Todos favoritos
        gerenciador.adicionarLivro(livro1);
        gerenciador.adicionarLivro(livro2);
        livro1.marcarComoFavorito();
        livro2.marcarComoFavorito();
        assertEquals(2, gerenciador.contarFavoritos());
    }

    @Test
    public void testMarcarEDesmarcarFavorito() {
        // Testa estado no atributo favorito
        livro1.marcarComoFavorito();
        assertTrue(livro1.isFavorito());
        livro1.desmarcarComoFavorito();
        assertFalse(livro1.isFavorito());
    }
      
}
