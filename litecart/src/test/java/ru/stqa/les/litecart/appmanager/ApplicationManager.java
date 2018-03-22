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
      wd.get("http://localhost/litecart/en/");
   }

   public void stop() {
      wd.quit();
   }

   public void gotoRubberDucksPage() {
      wd.findElement(By.linkText("Rubber Ducks")).click();
   }
}
