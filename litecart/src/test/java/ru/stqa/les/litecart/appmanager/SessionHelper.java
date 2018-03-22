package ru.stqa.les.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by a.zelenskaya on 22.03.2018.
 */
public class SessionHelper extends HelperBase {

   public SessionHelper(WebDriver wd) {

      super(wd);
   }

   public void login(String user, String password) {
      type(By.name("username"), user);
      type(By.name("password"), password);
      click(By.name("login"));
   }
}
