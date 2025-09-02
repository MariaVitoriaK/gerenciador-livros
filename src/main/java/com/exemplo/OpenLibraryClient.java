/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemplo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


import com.fasterxml.jackson.databind.ObjectMapper;
/**
 *
 * @author Administrador
 */
public class OpenLibraryClient {
    // Busca livro
    public Livro buscarLivro(String olid) throws IOException {
        String urlStr = "https://openlibrary.org/works/" + olid + ".json";
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        Scanner scanner = new Scanner(url.openStream());
        StringBuilder json = new StringBuilder();
        while (scanner.hasNext()) {
            json.append(scanner.nextLine());
        }
        scanner.close();

        ObjectMapper mapper = new ObjectMapper();
        OpenLibraryBook olBook = mapper.readValue(json.toString(), OpenLibraryBook.class);

        return new Livro(olBook.getTitle());
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class OpenLibraryBook {
        private String title;

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
    }
}
