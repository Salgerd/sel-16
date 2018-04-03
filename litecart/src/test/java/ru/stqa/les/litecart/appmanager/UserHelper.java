package ru.stqa.les.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.stqa.les.litecart.model.UserData;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by a.zelenskaya on 03.04.2018.
 */
public class UserHelper extends HelperBase {

   private WebDriverWait wait;
   String testString;
   //String email;

   public UserHelper(WebDriver wd) {
      super(wd);
   }

 /*  public void GenerateEmail() {

      email = generateUniqueNumber() + "@gmail.com";
      //System.out.println(email);
   }*/

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
}
