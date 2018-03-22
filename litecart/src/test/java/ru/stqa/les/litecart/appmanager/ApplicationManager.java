package ru.stqa.les.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by a.zelenskaya on 22.03.2018.
 */
public class ApplicationManager {
   FirefoxDriver wd;

   public static boolean isAlertPresent(FirefoxDriver wd) {
       try {
           wd.switchTo().alert();
           return true;
       } catch (NoAlertPresentException e) {
           return false;
       }
   }

   public void init() {
      wd = new FirefoxDriver((new FirefoxOptions().setLegacy(true).setBinary("C:/Users/a.zelenskaya/Documents/Mozilla Firefox/firefox.exe")));
      wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      wd.get("http://localhost/litecart/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");

   }

   public void login(String user, String password) {
      type(By.name("username"), user);
      type(By.name("password"), password);
      click(By.name("login"));
   }

   private void type(By locator, String text) {
      click(locator);
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
   }

   private void click(By locator) {
      wd.findElement(locator).click();
   }

   public void stop() {
      wd.quit();
   }

   public void gotoRubberDucksPage() {
      click(By.linkText("Rubber Ducks"));
   }
}
