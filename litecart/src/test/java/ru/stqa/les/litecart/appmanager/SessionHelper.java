package ru.stqa.les.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.les.litecart.model.UserData;

/**
 * Created by a.zelenskaya on 22.03.2018.
 */
public class SessionHelper extends HelperBase {


   private WebDriverWait wait;

   public SessionHelper(WebDriver wd) {

      super(wd);
   }

   public void loginAdmin(String user, String password) {

      type(By.name("username"), user);
      type(By.name("password"), password);
      click(By.name("login"));
   }

   public void loginUser(String email, String password) {

      wd.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
      wd.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
      click(By.cssSelector("button[name='login']"));
      wait = new WebDriverWait(wd,10);
   }


   public void logout() {

      wait = new WebDriverWait(wd,10);
      click(By.cssSelector("[href*=logout]"));

   }

}
