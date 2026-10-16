
package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import base.BaseTest;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void testValidLogin() {

        // Debug BEFORE interacting with the login page
        System.out.println("URL before login: " + driver.getCurrentUrl());
        System.out.println("Title before login: " + driver.getTitle());
        System.out.println("Username fields found: "
                + driver.findElements(By.name("username")).size());
        System.out.println("Password fields found: "
                + driver.findElements(By.name("password")).size());

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.urlContains("/dashboard"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/dashboard"),
                "Login failed: dashboard was not opened");

        System.out.println("URL after login: " + driver.getCurrentUrl());
        System.out.println("Title after login: " + driver.getTitle());
    }
}
