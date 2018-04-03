package ru.stqa.les.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by a.zelenskaya on 22.03.2018.
 */
public class NavigationHelper extends HelperBase {

   private WebDriverWait wait;

   public NavigationHelper(WebDriver wd) {super(wd); }

   public void gotoRubberDucksPage() {
      click(By.linkText("Rubber Ducks"));
   }

   public void goToSite(){ wd.get("http://localhost/litecart/en/");
   }

   public void goToAdmin(){
      wd.get("http://localhost/litecart/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
   }

   public void goToProductPage() {click(By.cssSelector("#box-campaigns img"));   }

   public void goToNewAccount() {
      click(By.linkText("New customers click here"));
      wait = new WebDriverWait(wd,10);
   }

   public  void goToAddNewProduct() {
      click(By.linkText("Add New Product"));
   }

   public  void goToCatalog() {
      click(By.linkText("Catalog"));
   }


   public void goToDuckLumen() {
      click(By.linkText("Duck Lumen"));
   }
}
