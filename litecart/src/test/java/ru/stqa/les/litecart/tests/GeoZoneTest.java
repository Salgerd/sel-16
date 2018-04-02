package ru.stqa.les.litecart.tests;

import org.testng.annotations.Test;

/**
 * Created by a.zelenskaya on 02.04.2018.
 */
public class GeoZoneTest extends TestBase {

   @Test
   public void testCountries() {

      app.getNavigationHelper().goToAdmin();
      app.getHelperAdmin().GeoZonesAlphabet();


   }
}
