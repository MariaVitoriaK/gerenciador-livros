/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Administrador
 */
public class GerenciadorLivrosIntegrationTest {
      @Test
    public void deveAdicionarLivroExterno() throws Exception {
        GerenciadorLivros ger = new GerenciadorLivros();

        // Exemplo de OLID real: OL45883W
        ger.adicionarLivroExterno("OL45819W");

        assertFalse(ger.getLivros().isEmpty());
        assertNotNull(ger.getLivros().get(0).getTitulo());
        System.out.println("Livro adicionado: " + ger.getLivros().get(0).getTitulo());
    }
}

