package io.cs.mbnakaya.aula7;

import org.junit.jupiter.api.AfterEach;
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

    @AfterEach
    public void afterTests() {
        this.driver.quit();
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
    }

    @Test
    public void testSauceDemo() {
        driver.get("https://www.saucedemo.com/");

        WebElement usernameBox = driver.findElement(By.id("user-name"));
        usernameBox.sendKeys("standard_user");

        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys("secret_sauce");
        passwordBox.submit();

        WebElement logo = driver.findElement(By.className("app_logo"));

        assertTrue(logo.isDisplayed());
        assertTrue(logo.getText().startsWith("Swag"));
    }
}
