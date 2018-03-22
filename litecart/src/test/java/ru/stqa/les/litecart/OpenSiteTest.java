package ru.stqa.les.litecart;

import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class OpenSiteTest extends TestBase{

    @Test
    public void testOpenSite() {
        app.wd.get("http://localhost/litecart/en/");
        app.wd.findElement(By.linkText("Rubber Ducks")).click();
    }

}
