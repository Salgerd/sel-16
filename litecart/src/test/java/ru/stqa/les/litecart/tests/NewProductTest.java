package ru.stqa.les.litecart.tests;

import org.testng.annotations.Test;

/**
 * Created by a.zelenskaya on 03.04.2018.
 */
public class NewProductTest extends TestBase {

   @Test
   public void testNewProduct() {

      app.getNavigationHelper().goToAdmin();
      app.getSessionHelper().loginAdmin("admin", "admin");

      app.getNavigationHelper().goToCatalog();
      app.getNavigationHelper().goToAddNewProduct();

      app.getHelperAdmin().createNewProduct();

      app.getNavigationHelper().goToDuckLumen();
   }
}
