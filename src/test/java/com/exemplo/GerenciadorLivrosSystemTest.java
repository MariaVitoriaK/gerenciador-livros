package com.exemplo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

// Testes de SISTEMA

public class GerenciadorLivrosSystemTest {

    private WebDriver driver;

@BeforeEach
public void setUp() {
    // Configura o WebDriver do Firefox
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
}

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Fecha o navegador ao final de cada teste
        }
    }

    @Test
    public void testAdicionarLivroInterface() {
        // Abre a interface
        String path = getClass().getClassLoader().getResource("interface.html").toExternalForm();
        driver.get(path);

        // Preenche título e clica em adicionar
        WebElement inputTitulo = driver.findElement(By.id("titulo"));
        WebElement botaoAdicionar = driver.findElement(By.id("adicionar"));
        inputTitulo.sendKeys("O Labirinto do Fauno");
        botaoAdicionar.click();

        // Verifica se o livro apareceu na lista
        WebElement lista = driver.findElement(By.id("listaLivros"));
        assertTrue(lista.getText().contains("O Labirinto do Fauno"));
    }

    @Test
    public void testMarcarLivroComoFavorito() {
        String path = getClass().getClassLoader().getResource("interface.html").toExternalForm();
        driver.get(path);

        // Adiciona um livro
        WebElement inputTitulo = driver.findElement(By.id("titulo"));
        WebElement botaoAdicionar = driver.findElement(By.id("adicionar"));
        inputTitulo.sendKeys("Em águas Profundas");
        botaoAdicionar.click();

        // Clica no botão de favorito 
        WebElement botaoFavorito = driver.findElement(By.id("favorito_0"));
        botaoFavorito.click();

        // Verifica se o livro foi marcado como favorito
        WebElement lista = driver.findElement(By.id("listaLivros"));
        assertTrue(lista.findElement(By.tagName("li")).getAttribute("class").contains("favorito"));
    }

    @Test
    public void testRemoverLivro() {
        String path = getClass().getClassLoader().getResource("interface.html").toExternalForm();
        driver.get(path);

        // Adiciona um livro
        WebElement inputTitulo = driver.findElement(By.id("titulo"));
        WebElement botaoAdicionar = driver.findElement(By.id("adicionar"));
        inputTitulo.sendKeys("Orgulho e Preconceito");
        botaoAdicionar.click();

        // Remove o livro
        WebElement botaoRemover = driver.findElement(By.id("remover_0"));
        botaoRemover.click();

        // Confirma que o livro sumiu da lista
        WebElement lista = driver.findElement(By.id("listaLivros"));
        assertFalse(lista.getText().contains("Orgulho e Preconceito"));
    }
}
