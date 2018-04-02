package ru.stqa.les.litecart.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by a.zelenskaya on 02.04.2018.
 */
public class CountriesTest extends TestBase {

   @Test
   public void testCountries() {

      app.getNavigationHelper().goToAdmin();
      app.getHelperAdmin().CountriesAlphabet();
      app.getHelperAdmin().ZonesAlphabet();


   }
}
