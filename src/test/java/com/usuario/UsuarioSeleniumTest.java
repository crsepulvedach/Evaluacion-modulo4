package com.usuario;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioSeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        // WebDriverManager se encarga de bajar y configurar el driver automáticamente
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testPaginaGoogle() {
        driver.get("https://www.google.com");
        assertEquals("Google", driver.getTitle());
    }

    @AfterEach
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
