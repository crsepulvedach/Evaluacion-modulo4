package com.usuario;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioSeleniumTest {

    private static Thread serverThread;
    private WebDriver driver;

    @BeforeAll
    public static void startServer() throws InterruptedException {
        serverThread = new Thread(() -> {
            try {
                Servidor.main(null);
            } catch (IOException e) {
                e.printStackTrace(); // o loguearlo, como prefieras
            }
        });
        serverThread.setDaemon(true);
        serverThread.start();

        // Esperar a que el servidor esté arriba
        Thread.sleep(2000);
    }


    @AfterAll
    public static void stopServer() {
        if (serverThread != null && serverThread.isAlive()) {
            serverThread.interrupt();
        }
    }

    @BeforeEach
    public void setup() throws Exception {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        
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
    public void testPaginaUsuario() {
        driver.get("http://localhost:4567/usuario");

        WebElement nombre = driver.findElement(By.id("nombre"));
        WebElement peso = driver.findElement(By.id("peso"));

        assertEquals("Ana", nombre.getText());
        assertEquals("60.0", peso.getText());
    }
}
