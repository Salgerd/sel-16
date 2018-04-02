package ru.stqa.les.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
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
   String resultZone;
   WebElement prodUnit;
   List<WebElement> prodList, stickerList;
   List<WebElement> countrLinks;


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

   public void CountriesAlphabet() {

      List<WebElement> countrLinks = wd.findElements(By.cssSelector(".dataTable td:nth-child(5) a"));
      ArrayList<String> countrName = new ArrayList<>();
      getAttributeFromArray(countrLinks, countrName,"textContent");
      String result = isAlphabeticalOrder(countrName);
      System.out.println("Страны в " + result + " порядке");
   }

   public void ZonesAlphabet() {

      List<WebElement> countriesZone = wd.findElements(By.cssSelector("tr.row td:nth-child(6)"));
      ArrayList<String> linksZone = new ArrayList<>();
      saveCountryLinkWhichHasZones(countriesZone,countrLinks,linksZone);
      zoneCheck(linksZone, ".dataTable td:nth-child(3) input");
   }

   public void GeoZonesAlphabet() {

      wd.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
      List<WebElement> geoZone = wd.findElements(By.cssSelector("tr.row td:nth-child(3) a"));
      ArrayList<String> geoZoneLinks = new ArrayList<>();
      getAttributeFromArray(geoZone, geoZoneLinks, "href");
      zoneCheck(geoZoneLinks, ".dataTable td:nth-child(3) [selected]");
   }

   private String isAlphabeticalOrder(ArrayList<String> arrayNotSorted) {         //проверка на алфавитный порядок

      ArrayList<String> arraySorted = arrayNotSorted;
      Collections.sort(arraySorted);

      if (arraySorted.equals(arrayNotSorted)) {
         return "алфавитном";
      } else {
         return "не алфавитном";
      }
   }

   private void getAttributeFromArray(List<WebElement> webElementsArray, ArrayList<String> attributeArray, String attribute) { //массив с названиями стран

      for (int i = 0; i < webElementsArray.size(); i++) {
         String a = webElementsArray.get(i).getAttribute(attribute);
         attributeArray.add(a);
      }
   }


   public void saveCountryLinkWhichHasZones(List<WebElement> countriesZone,
                                            List<WebElement> countrLinks,
                                            ArrayList<String> linksZone){
      for (int i = 0; i < countriesZone.size(); i++) {
         String a = countriesZone.get(i).getAttribute("textContent");
         int number = Integer.parseInt(a);
         if (number != 0) {
            String link = countrLinks.get(i).getAttribute("href");
            linksZone.add(link);
         }
      }
   }

   public void zoneCheck(ArrayList<String> linksZone, String locator) {
      for (int i=0; i<linksZone.size(); i++){
         wd.get(linksZone.get(i));
         List<WebElement> zoneName = wd.findElements(By.cssSelector(locator));
         ArrayList<String> zoneNameTextContent = new ArrayList<>(); // создаем новый массив
         getAttributeFromArray(zoneName,zoneNameTextContent,"textContent"); // заполняем массив названиями зон
         String resultZone = isAlphabeticalOrder(zoneNameTextContent); // проверяем на алфавитный порядок
       //  System.out.println("На странице " + linksZone.get(i) + " зоны расположены " + resultZone);
      }
   }



}
