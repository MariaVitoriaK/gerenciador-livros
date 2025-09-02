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

public class GerenciadorLivrosSystemTest {

    private WebDriver driver;

@BeforeEach
public void setUp() {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
}

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAdicionarLivroInterface() {
        String path = getClass().getClassLoader().getResource("interface.html").toExternalForm();
        driver.get(path);

        WebElement inputTitulo = driver.findElement(By.id("titulo"));
        WebElement botaoAdicionar = driver.findElement(By.id("adicionar"));

        inputTitulo.sendKeys("O Pequeno Príncipe");
        botaoAdicionar.click();

        WebElement lista = driver.findElement(By.id("listaLivros"));
        assertTrue(lista.getText().contains("O Pequeno Príncipe"));
    }

    @Test
    public void testMarcarLivroComoFavorito() {
        String path = getClass().getClassLoader().getResource("interface.html").toExternalForm();
        driver.get(path);

        WebElement inputTitulo = driver.findElement(By.id("titulo"));
        WebElement botaoAdicionar = driver.findElement(By.id("adicionar"));
        inputTitulo.sendKeys("Harry Potter");
        botaoAdicionar.click();

        WebElement botaoFavorito = driver.findElement(By.id("favorito_0"));
        botaoFavorito.click();

        WebElement lista = driver.findElement(By.id("listaLivros"));
        assertTrue(lista.findElement(By.tagName("li")).getAttribute("class").contains("favorito"));
    }

    @Test
    public void testRemoverLivro() {
        String path = getClass().getClassLoader().getResource("interface.html").toExternalForm();
        driver.get(path);

        WebElement inputTitulo = driver.findElement(By.id("titulo"));
        WebElement botaoAdicionar = driver.findElement(By.id("adicionar"));
        inputTitulo.sendKeys("Dom Quixote");
        botaoAdicionar.click();

        WebElement botaoRemover = driver.findElement(By.id("remover_0"));
        botaoRemover.click();

        WebElement lista = driver.findElement(By.id("listaLivros"));
        assertFalse(lista.getText().contains("Dom Quixote"));
    }
}
