package ru.stqa.les.litecart.tests;

import org.testng.annotations.Test;
import ru.stqa.les.litecart.model.UserData;

/**
 * Created by a.zelenskaya on 03.04.2018.
 */
public class NewUserAccountTest extends TestBase {

   String email;

   @Test
   public void testNewUserAccount() {

      app.getNavigationHelper().goToSite();

      app.getNavigationHelper().goToNewAccount();

      app.getUserHelper().createNewUser(
              new UserData(
                      "Ivan",
                      "Ivanov",
                      "Address",
                      "12345",
                      "Moscow",
                      email,
                      "+71234567890",
                      "password",
                      "password"));

      app.getUserHelper().assertAutoriz();

      app.getSessionHelper().logout();

      app.getUserHelper().assertLogout();

      app.getSessionHelper().loginUser(UserData.email, "password");

      app.getSessionHelper().logout();

   }






}
