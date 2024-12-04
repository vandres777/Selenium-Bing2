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

        String[] teams = {"Nike", "Adidas", "Puma", "Reebok", "New Balance",
                "Converse", "Vans", "Dr. Martens", "Timberland", "Clarks",
                "Gucci", "Louis Vuitton", "Prada", "Chanel", "Dior",
                "Jimmy Choo", "Christian Louboutin", "Manolo Blahnik", "Salvatore Ferragamo", "Tod's",
                "Steve Madden", "Aldo", "Charles & Keith", "Nine West", "Schutz",
                "H&M", "Zara", "Mango", "Bershka", "Pull & Bear",
                "Asos", "Shein", "Romwe", "Forever 21", "Topshop",
                "Fila", "Saucony", "Brooks", "Hoka One One", "On Running",
                "Skechers", "Crocs", "Ugg", "Sperry", "Keds"};

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

/////prueba github nueva rama