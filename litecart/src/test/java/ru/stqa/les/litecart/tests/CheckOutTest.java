package ru.stqa.les.litecart.tests;


import org.testng.annotations.Test;

/**
 * Created by a.zelenskaya on 09.04.2018.
 */
public class CheckOutTest extends TestBase {


   @Test
   public void testCheckOut() {


      for (int i = 0; i < 3; i++) {  //добавляем 3 продукта в корзину

            app.getNavigationHelper().goToSite();
            app.getUserHelper().addCartProduct();

      }

      app.getNavigationHelper().goToSite();

      app.getUserHelper().deleteCartItem(); //удаляем 3 продукта из корзины

      app.getNavigationHelper().goToSite();

   }

}
