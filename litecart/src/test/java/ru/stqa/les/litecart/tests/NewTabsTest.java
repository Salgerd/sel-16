package ru.stqa.les.litecart.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Created by a.zelenskaya on 10.04.2018.
 */
public class NewTabsTest extends TestBase{

   @Test
   public void testNewTabsOpen() {

      app.getNavigationHelper().goToAdmin();
      app.getSessionHelper().loginAdmin("admin", "admin");
      app.getNavigationHelper().goToCountries();
      app.getHelperAdmin().addNewCountriesClick();
      app.getHelperAdmin().tabsListClick();


   }

}
