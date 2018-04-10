package ru.stqa.les.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.stqa.les.litecart.model.UserData;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by a.zelenskaya on 03.04.2018.
 */
public class UserHelper extends HelperBase {

   private WebDriverWait wait;
   String testString;
   List<WebElement> prodList;
   WebElement  prodTable;


   public UserHelper(WebDriver wd) {
      super(wd);
   }



   public void fillNewUserForm(UserData userData) {

      type(By.cssSelector("input[name='firstname']"), userData.getFirstname());
      type(By.cssSelector("input[name='lastname']"), userData.getLastname());
      type(By.cssSelector("input[name='address1']"), userData.getAddress1());
      type(By.cssSelector("input[name='postcode']"), userData.getPostcode());
      type(By.cssSelector("input[name='city"), userData.getCity());
    // wait = new WebDriverWait(wd,10);
      fillSelect("select[name='country_code']", "United States");
      wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      fillSelect("select[name='zone_code']", "California");
    //  wd.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
      type (By.cssSelector("input[name='email']"), userData.getEmail());
      type(By.cssSelector("input[name='phone']"), userData.getPhone());
      type(By.cssSelector("input[name='password']"), userData.getPassword());
      type(By.cssSelector("input[name='confirmed_password']"), userData.getConfirmed_password());


   }

   public void createNewUser(UserData date) {


      fillNewUserForm(date);
      submitForm();

   }

   public void fillSelect(String locator, String selectedItem){
      WebElement selectElement = wd.findElement(By.cssSelector(locator));
      Select select = new Select(selectElement);
      //List options = select.getOptions();
      select.selectByVisibleText(selectedItem);
   }


   public void submitForm() {

      click(By.cssSelector("button[name='create_account']"));

   }



   public void assertAutoriz() {

      testString = wd.findElement(By.cssSelector("[id=box-account] .title")).getText();
      Assert.assertTrue(testString.compareTo("Account")==0);
   }

   public void assertLogout() {

      testString = wd.findElement(By.cssSelector("[id=box-account-login] .title")).getText();
      Assert.assertTrue(testString.compareTo("Login")==0);

   }


   public void addCartProduct() {

      wd.findElement(By.cssSelector("div.image-wrapper img")).click();

      // текущее количество товаров в корзине
      int currentQuantity = getIntFromTextContent(By.cssSelector("div#cart .quantity"));

      boolean size = isElementPresent("select[name='options[Size]']");
      if (size) {
         WebElement selectElement = wd.findElement(By.cssSelector("select[name='options[Size]'"));
         Select select = new Select(selectElement);
         select.selectByVisibleText("Small");
      }

      wd.findElement(By.cssSelector("button[name='add_cart_product']")).click();

      (new WebDriverWait(wd, 5)).until(ExpectedConditions
              .textToBePresentInElement(By.cssSelector("div#cart .quantity"),
                      Integer.toString(currentQuantity + 1)));
   }

   private int getIntFromTextContent(By locator) {

      String text = wd.findElement(locator)
              .getAttribute("textContent");
      return Integer.parseInt(text);

   }

   public boolean isElementPresent(String locator) {
      try {
         wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
         boolean result = wd.findElements(By.cssSelector(locator)).size() > 0;
         return result;
      } finally {
         wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      }
   }

   public void deleteCartItem() {

      wd.findElement(By.id("cart")).click();
      wait = new WebDriverWait(wd, 10);
      wait.until(titleContains("Checkout"));

      for(int n = 1; n <= 3; n++) {
         prodTable = wait.until(presenceOfElementLocated(By.id("order_confirmation-wrapper")));

         prodList = wd.findElements(By.cssSelector("li.shortcut"));
         if(prodList.size()>0) {  prodList.get(0).click(); }

         wd.findElement(By.name("remove_cart_item")).click();
         wait = new WebDriverWait(wd, 10);
         wait.until(stalenessOf(prodTable));
      }
   }


}

