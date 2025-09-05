package com.exemplo;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class GerenciadorLivros {
    private List<Livro> livros; // Lista de livros gerenciados

    public GerenciadorLivros() {
        // Inicializa a lista vazia
        livros = new ArrayList<>();
    }

    // Adiciona um livro manualmente na lista.
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    // Conta quantos livros estão marcados como favoritos.
    public int contarFavoritos() {
        int count = 0;
        for (Livro livro : livros) {
            if (livro.isFavorito()) {
                count++;
            }
        }
        return count;
    }

    // Retorna a lista de livros cadastrados.
    public List<Livro> getLivros() {
        return livros;
    }

    // Adiciona um livro consultando a API OpenLibrary.
    public void adicionarLivroExterno(String olid) throws IOException {
    OpenLibraryClient client = new OpenLibraryClient();
    Livro livro = client.buscarLivro(olid);
    adicionarLivro(livro);
 }
}
