/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.exemplo;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
/**
 *
 * @author mvk09
 */
public class GerenciadorLivros {
    private List<Livro> livros;

    public GerenciadorLivros() {
        livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public int contarFavoritos() {
        int count = 0;
        for (Livro livro : livros) {
            if (livro.isFavorito()) {
                count++;
            }
        }
        return count;
    }

    public List<Livro> getLivros() {
        return livros;
    }
    ////////////////////////////////////////////////////////////////
    public void adicionarLivroExterno(String olid) throws IOException {
    OpenLibraryClient client = new OpenLibraryClient();
    Livro livro = client.buscarLivro(olid);
    adicionarLivro(livro);
}

}
