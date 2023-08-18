package com.assesment;
import static org.testng.AssertJUnit.assertEquals;
import com.hooks.*;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class pirate extends hooks{
    @Test(enabled =true)
    public void test_check_query_input_and_search_button_existence() {
        WebElement searchInput = driver.findElement(By.id("search-input"));
        WebElement searchButton = driver.findElement(By.id("search-button"));
        assertTrue(searchInput != null);
        assertTrue(searchButton != null);
    }

    @Test(enabled =false)
    public void test_check_search_with_empty_query() {
        driver.findElement(By.id("search-button")).click();
        String errorMessage = driver.findElement(By.id("error-empty-query")).getText();
        assertEquals("Provide some query", errorMessage);
    }

    @Test(enabled =false)
    public void test_check_query_for_isla_returns_at_least_one_result() {
        driver.findElement(By.id("search-input")).sendKeys("isla");
        driver.findElement(By.id("search-button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#search-results li")));
        assertTrue(results.size() >= 1);
    }

    @Test(enabled =false)
    public void test_check_feedback_for_no_results() {
        driver.findElement(By.id("search-input")).sendKeys("castle");
        driver.findElement(By.id("search-button")).click();
        String noResultsMessage = driver.findElement(By.id("error-no-results")).getText();
        assertEquals("No results", noResultsMessage);
    }

    @Test(enabled =false)
    public void test_check_results_match_query() {
        driver.findElement(By.id("search-input")).sendKeys("port");
        driver.findElement(By.id("search-button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#search-results li")));
        assertEquals(1, results.size());
        assertEquals("Port Royal", results.get(0).getText());
    }

}
