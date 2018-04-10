package ru.stqa.les.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by a.zelenskaya on 22.03.2018.
 */
public class HelperBase {

   protected WebDriver wd;

   public HelperBase(WebDriver wd) {
      this.wd = wd;
   }

   protected void type(By locator, String text) {
      click(locator);
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
   }

   protected void click(By locator) {
      wd.findElement(locator).click();
   }

   public static boolean isAlertPresent(FirefoxDriver wd) {
      try {
         wd.switchTo().alert();
         return true;
      } catch (NoAlertPresentException e) {
         return false;
      }
   }

   protected boolean isElementPresent(By locator) {
      try {
         wd.findElement(locator);
         return true;
      } catch (NoSuchElementException ex) {
         return false;
      }
   }

}
