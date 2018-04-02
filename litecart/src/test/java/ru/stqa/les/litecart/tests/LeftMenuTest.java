package ru.stqa.les.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class LeftMenuTest extends TestBase{


    @Test
    public void testLeftMenu() {

        app.getSessionHelper().login("admin", "admin");
        app.getHelperAdmin().clickleftmenu();


    }



}
