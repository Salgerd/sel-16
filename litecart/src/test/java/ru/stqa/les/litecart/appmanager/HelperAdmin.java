package ru.stqa.les.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by a.zelenskaya on 02.04.2018.
 */
public class HelperAdmin extends HelperBase {


   public HelperAdmin(WebDriver wd) {
      super(wd);
   }

   int menuCol, submenuCol;
   int prodCol, stickerCol;
   WebElement prodUnit;
   List<WebElement> prodList, stickerList;

   private WebDriverWait wait;


   public void clickleftmenu() {

      wait = new WebDriverWait(wd, 10);
      wait.until(titleIs("My Store"));

      List<WebElement> menuPoints = wd.findElements(By.id("app-"));
      List<WebElement> submenuPoints;
      WebElement menuPoint, submenuPoint;
      menuCol = menuPoints.size(); //сохранение количества пунктов меню

      for (int i = 0; i < menuCol; i++) {
         menuPoints = wd.findElements(By.id("app-"));
         menuPoint = menuPoints.get(i);
         wait = new WebDriverWait(wd, 10);
         menuPoint.click();

         menuPoints = wd.findElements(By.id("app-"));
         menuPoint = menuPoints.get(i); //выбор пункта меню
         submenuPoints = menuPoint.findElements(By.cssSelector("[id^=doc-]"));
         submenuCol = submenuPoints.size(); // сохранение количества пунктов подменю

         if (submenuCol > 0) {
            for (int j = 0; j < submenuCol; j++) {
               menuPoints = wd.findElements(By.id("app-"));
               menuPoint = menuPoints.get(i); //выбор пункта меню
               submenuPoints = menuPoint.findElements(By.cssSelector("[id^=doc-]"));
               submenuPoint = submenuPoints.get(j); //выбор пункта подменю
               submenuPoint.click();
               wd.findElement(By.cssSelector("h1")); //проверка наличия заголовка
            }
         } else {
            wd.findElement(By.cssSelector("h1")); //проверка наличия заголовка
         }

      }
   }


   public void CheckStiker(){

      wait = new WebDriverWait(wd,10);

      prodList = wd.findElements(By.id("li.product"));
      prodCol = prodList.size();

      for (int i = 0; i < prodCol; i++) {

         prodList = wd.findElements(By.id("li.product"));
         prodUnit = prodList.get(i);

         stickerList = wd.findElements(By.cssSelector("li.product .sticker"));
         stickerCol = stickerList.size();
         Assert.assertTrue(stickerCol == 1);
      }
   }



}
