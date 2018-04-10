package ru.stqa.les.litecart.tests;


import org.testng.annotations.Test;



/**
 * Created by a.zelenskaya on 10.04.2018.
 */
public class LogsTest extends TestBase {

   @Test
   public void testLogs() {

      app.getNavigationHelper().goToAdmin();
      app.getSessionHelper().loginAdmin("admin", "admin");

      app.getNavigationHelper().goToCatalog();

      app.getHelperAdmin().checkTheLog();

   }
}
