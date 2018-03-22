package ru.stqa.les.litecart.tests;

import org.testng.annotations.Test;

public class AdminTest extends TestBase{


    
    @Test
    public void testAdmin() {

        app.getSessionHelper().login("admin", "admin");
    }
    

}
