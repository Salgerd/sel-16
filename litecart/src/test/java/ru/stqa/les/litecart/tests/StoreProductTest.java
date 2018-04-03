package ru.stqa.les.litecart.tests;

import org.testng.annotations.Test;
import ru.stqa.les.litecart.appmanager.HelperStore;

/**
 * Created by a.zelenskaya on 02.04.2018.
 */
public class StoreProductTest extends TestBase {



   @Test
   public void testStoreProduct() {

      HelperStore.ProductData dataFromMainPage = new HelperStore.ProductData();
      HelperStore.ProductData dataFromProductPage = new HelperStore.ProductData();


      app.getNavigationHelper().goToSite();
      dataFromMainPage = app.getHelperStore().makeProductFormCurrentPage(
              "#box-campaigns div.name",
              "#box-campaigns div.price-wrapper .regular-price",
              "#box-campaigns div.price-wrapper .campaign-price");


      app.getNavigationHelper().goToProductPage();
      dataFromProductPage = app.getHelperStore().makeProductFormCurrentPage(
              "#box-product h1",
              ".information .regular-price",
              ".information .campaign-price");


      app.getHelperStore().compareProductData(dataFromMainPage, dataFromProductPage);


   }

}
