package ru.stqa.les.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
   String resultZone, mainWindow;
   WebElement prodUnit;
   List<WebElement> prodList, stickerList, countrLinks, links;



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
      }
   }


   public void createNewProduct() {

      generalNewProduct("2018-01-01", "2018-03-20");
      informationNewProduct();
      priceNewProduct();
      click(By.cssSelector("button[name='save']"));
   }

   private void priceNewProduct() {
      click(By.linkText("Prices"));
      pause(2000);
      fillInput("input[name='purchase_price']", "100");
      fillSelect("select[name='purchase_price_currency_code']", "US Dollars");
      fillInput("input[name='prices[USD]']", "100");
   }

   private void informationNewProduct() {

      click(By.linkText("Information"));
      pause(2000);
      fillSelect("select[name='manufacturer_id']", "ACME Corp.");
      fillInput("input[name='short_description[en]']", "DuckDuckDuck Lumen.");
      fillTextarea("textarea[name='description[en]']");
   }

   public void generalNewProduct(String date_from, String date_to) {

      click(By.cssSelector("label input[value='1']"));
      fillInput("input[name='name[en]']","Duck Lumen");
      fillInput("input[name='code']", "lr001");
      putCheckbox("input[name='categories[]'][data-name='Root']");
      fillSelect("select[name='default_category_id']", "Root");
      putCheckbox("input[name='product_groups[]'][value='1-2']");
      fillInput("input[name='quantity']", "10");
      fillSelect("select[name='quantity_unit_id']", "pcs");
      fillSelect("select[name='delivery_status_id']", "3-5 days");
      fillSelect("select[name='sold_out_status_id']", "Sold out");
      attachFile("input[name='new_images[]']", "img\\duck_test.png");
      // заполняем даты
      type(By.cssSelector("input[name='date_valid_from']"), date_from);
      type(By.cssSelector("input[name='date_valid_to']"), date_to);

   }

   public void fillInput(String locator, String text) {
      WebElement element = wd.findElement(By.cssSelector(locator));
      element.clear();
      element.sendKeys(text);
   }

   public void putCheckbox(String locator) {
      WebElement checkbox = wd.findElement(By.cssSelector(locator));
      if (checkbox.isSelected()) {
         return;
      } else {
         checkbox.click();
      }
   }

   public void fillSelect(String locator, String selectedItem) {
      WebElement selectElement = wd.findElement(By.cssSelector(locator));
      Select select = new Select(selectElement);
      //List options = select.getOptions();
      select.selectByVisibleText(selectedItem);
   }

   public void attachFile(String locaror, String fileName) {
      File file = new File(fileName);
      if (file.exists()) {
         wd.findElement(By.cssSelector(locaror)).sendKeys(file.getAbsolutePath());
         System.out.println("Файл " + file.getAbsolutePath() + " прикреплен");
      } else {
         System.out.println("Файл " + file.getAbsolutePath() + " не существует");
      }

   }
   public void pause(Integer milliseconds) {
      try {
         TimeUnit.MILLISECONDS.sleep(milliseconds);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   public void fillTextarea(String locator) {
      WebElement element = wd.findElement(By.cssSelector(locator));
      element.clear();
      String text = "Here can be your the text.";
      element.sendKeys(text);

   }

   public void addNewCountriesClick() {
      click(By.cssSelector("a.button"));
   }

   public void tabsListClick() {

      List<WebElement> links = wd.findElements(By.cssSelector("i[class='fa fa-external-link']"));
      String mainWindow = wd.getWindowHandle();

      for (int i = 0; i < links.size(); i++) {

         Set<String> oldWindows = wd.getWindowHandles();


         links.get(i).click();


         String newWindow = (new WebDriverWait(wd, 30))
                 .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                              Set<String> newWindowsSet = driver.getWindowHandles();
                              newWindowsSet.removeAll(oldWindows);
                              return newWindowsSet.size() > 0 ?
                                      newWindowsSet.iterator().next() : null;
                           }
                        }
                 );


         wd.switchTo().window(newWindow);
         wd.close();

         wd.switchTo().window(mainWindow);
      }
   }

   public void checkTheLog() {

      openAllFolders();

      List<WebElement> links = wd.findElements(By.cssSelector("tr.row img ~a"));

      ArrayList<String> textLinks = new ArrayList<>();

      getTextContentFromLinks(links, textLinks);


      for (int i = 0; i < textLinks.size(); i++) {
         click(By.linkText(textLinks.get(i)));
         wd.navigate().back();


         List<LogEntry> logs = wd.manage().logs().get("browser").getAll();
         if (logs.size() > 0) {
            System.out.println("Если нажать на ссылку " + textLinks.get(i)
                    + " в логе браузера появляется сообщение:");
            System.out.println(logs);
         }
      }
   }

   public void openAllFolders() {
      List<WebElement> closedFolders;
      // находим закрытые папки на странице
      closedFolders = wd.findElements(By.cssSelector("i[class='fa fa-folder']"));
      if (closedFolders.size() > 0) {
         do {
            click(By.cssSelector("i[class='fa fa-folder'] ~ a"));
            closedFolders = wd.findElements(By.cssSelector("i[class='fa fa-folder']"));
         } while (closedFolders.size() != 0);
      }
   }

   public void getTextContentFromLinks(List<WebElement> links, ArrayList textLinks) {
      for (int i = 0; i < links.size(); i++) {
         String a = links.get(i).getAttribute("textContent");
         textLinks.add(a);
      }

   }


}
