package com.exemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Teste de INTEGRAÇÃO

public class GerenciadorLivrosIntegrationTest {
      @Test
    public void deveAdicionarLivroExterno() throws Exception {
        GerenciadorLivros ger = new GerenciadorLivros();

        // Código de exemplo da OpenLibrary
        ger.adicionarLivroExterno("OL45819W");

        // Verifica se o livro foi adicionado e possui título
        assertFalse(ger.getLivros().isEmpty());
        assertNotNull(ger.getLivros().get(0).getTitulo());
        
        System.out.println("Livro adicionado: " + ger.getLivros().get(0).getTitulo());
    }
}

