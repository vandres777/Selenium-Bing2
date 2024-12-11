package com.example.test;

import com.example.test.config.WebDriverConfig;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverConfig.getChromeDriver();
        driver.get("https://www.google.com");
    }

    @Test
    public void testSearchWikipedia() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("bing");
        searchBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("h3")));
        firstResult.click();

        // Espera y haz clic en el primer localizador
        WebElement firstElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='id_a']")));
        firstElement.click();

        // Espera y haz clic en el segundo localizador
        WebElement secondElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Iniciar sesión con una cuenta personal']")));
        secondElement.click();

// Espera y haz clic en el tercer localizador
        WebElement thirdElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='i0116']")));
        thirdElement.click();

        // Escribe el correo electrónico
        thirdElement.sendKeys("vandres182@hotmail.com");

// Espera y haz clic en el botón
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='idSIButton9']")));
        buttonElement.click();

        // Espera y haz clic en el tercer localizador
        WebElement fourElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='i0118']")));
        fourElement.click();

        // Escribe el correo electrónico
        fourElement.sendKeys("Articulo2000+");

        // Espera y haz clic en el botón
        WebElement button2Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='idSIButton9']")));
        button2Element.click();

        // Espera y haz clic en el botón
        WebElement button3Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='acceptButton']")));
        button3Element.click();

        WebElement textAreaElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='sb_form_q']")));
        textAreaElement.click();
        textAreaElement.sendKeys("cristiano ronaldo");
        textAreaElement.sendKeys(Keys.RETURN);

        String[] teams = { "Super Mario Bros.", "The Legend of Zelda", "Sonic the Hedgehog", "Donkey Kong", "Pac-Man",
                "Tetris", "Space Invaders", "Pong", "Street Fighter II", "Mortal Kombat",
                "Final Fantasy VII", "Metal Gear Solid", "Resident Evil", "Tomb Raider", "Diablo",
                "The Elder Scrolls III: Morrowind", "Half-Life", "StarCraft", "Warcraft II: Tides of Darkness", "Quake",
                "GoldenEye 007", "Grand Theft Auto III", "The Sims", "Counter-Strike", "Red Alert 2",
                "Age of Empires II", "Civilization II", "Diablo II", "StarCraft: Brood War", "Warcraft III: Reign of Chaos",
                "The Witcher", "Mass Effect", "BioShock", "Portal", "Left 4 Dead",
                "Minecraft", "The Elder Scrolls V: Skyrim", "Dark Souls", "Red Dead Redemption", "The Witcher 3: Wild Hunt",
                "Overwatch", "League of Legends", "Fortnite", "PUBG", "Rocket League",
                "Super Smash Bros. Melee", "Mario Kart 64", "Halo: Combat Evolved", "Metroid Prime", "Crash Bandicoot",
                "Spyro the Dragon", "Tony Hawk's Pro Skater 2", "Gran Turismo 2", "Twisted Metal 2", "Ridge Racer",
                "Chrono Trigger", "Final Fantasy IV", "EarthBound", "Secret of Mana", "Chrono Cross"

        };

        for (String team : teams) {
            // Re-locate the element to avoid StaleElementReferenceException
            // WebElement textAreaElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='sb_form_q']")));

            textAreaElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='sb_form_q']")));
            textAreaElement.clear();
            textAreaElement.sendKeys(team);
            textAreaElement.sendKeys(Keys.RETURN);
            Thread.sleep(5000); // Wait for 5 seconds after each search
        }
    }

    @AfterClass
    public void tearDown() {
        // Elimina o comenta el código que cierra el navegador
        // if (driver != null) {
        //     try {
        //         Thread.sleep(10000); // Espera de 10 segundos
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        //     driver.quit();
    }
}
////// subir cambio a rama main para pueba de git revert