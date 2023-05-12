package io.cs.mbnakaya.aula7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    private ChromeOptions options;
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        this.options = new ChromeOptions();
        this.options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver/chromedriver");
        this.driver = new ChromeDriver(options);
    }

    @Test
    public void testChrome() {
        driver.get("https://www.google.com.br");

        WebElement searchBox = driver.findElement(By.cssSelector("[name='q']"));
        searchBox.sendKeys("Editora Globo");
        searchBox.submit();

        WebElement searchResults = driver.findElement(By.cssSelector("#search"));

        assertTrue(searchResults.isDisplayed());
        assertThat(driver.getTitle()).startsWith("Editora Globo");

        driver.quit();
    }
}
