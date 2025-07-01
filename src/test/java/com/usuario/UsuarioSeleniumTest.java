package com.usuario;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioSeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() throws Exception {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        // Directorio temporal único para evitar conflicto de perfil en Chrome
        Path tempProfile = Files.createTempDirectory("chrome-profile-");
        options.addArguments("--user-data-dir=" + tempProfile.toAbsolutePath().toString());

        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPaginaGoogle() {
        driver.get("https://www.google.com");
        assertEquals("Google", driver.getTitle());
    }
}
