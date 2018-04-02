package ru.stqa.les.litecart.tests;

import org.testng.annotations.Test;

/**
 * Created by a.zelenskaya on 02.04.2018.
 */
public class StikersTest extends TestBase{

   @Test
   public void testStikers() {

      app.getNavigationHelper().goToSite();
      app.getHelperAdmin().CheckStiker();


   }
}
