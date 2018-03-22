package ru.stqa.les.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by a.zelenskaya on 22.03.2018.
 */
public class NavigationHelper extends HelperBase {

   public NavigationHelper(WebDriver wd) {super(wd); }

   public void gotoRubberDucksPage() {
      click(By.linkText("Rubber Ducks"));
   }
}
