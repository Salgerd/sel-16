package ru.stqa.les.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by a.zelenskaya on 22.03.2018.
 */
public class NavigationHelper extends HelperBase {

   public NavigationHelper(WebDriver wd) {super(wd); }

   public void gotoRubberDucksPage() {
      click(By.linkText("Rubber Ducks"));
   }

   public void gotoHomePage() {
      if (! isElementPresent(By.tagName("h1"))) {
         return;
      }

      click(By.xpath("//div[@class='logotype']/a/img"));
   }

   public void gotoAppearence() {

    if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Template")) {
         return;
      }

      click(By.linkText("Appearence"));
   }


   public void gotoAppearenceTemplate() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Template")) {
         return;
      }

      click(By.linkText("Template"));
   }

   public void gotoAppearenceLogotype() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Logotype")) {
         return;
      }

      click(By.linkText("Logotype"));
   }

   public void gotoCatalog() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Catalog")) {
         return;
      }

      click(By.linkText("Catalog"));
   }

   public void gotoCatalogProductGroups() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Product Groups")) {
         return;
      }

      click(By.linkText("Product Groups"));

   }

   public void gotoCatalogOptionGroups() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Option Groups")) {
         return;
      }

      click(By.linkText("Option Groups"));

   }

   public void gotoCatalogManufacturers() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Manufacturers")) {
         return;
      }

      click(By.linkText("Manufacturers"));

   }

   public void gotoCatalogSuppliers() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Suppliers")) {
         return;
      }

      click(By.linkText("Suppliers"));

   }

   public void gotoCatalogDeliveryStatuses() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Delivery Statuses")) {
         return;
      }

      click(By.linkText("Delivery Statuses"));

   }

   public void gotoCatalogSoldOutStatuses() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Sold Out Statuses")) {
         return;
      }

      click(By.linkText("Sold Out Statuses"));

   }

   public void gotoCatalogQuantityUnits() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Quantity Units")) {
         return;
      }

      click(By.linkText("Quantity Units"));

   }

   public void gotoCatalogCSVImportExport() {

      if (isElementPresent(By.tagName("h1"))
              && wd.findElement(By.tagName("h1")).getText().equals("CSV Import/Export")
              && (isElementPresent(By.tagName("h2"))
              && wd.findElement(By.tagName("h2")).getText().equals("Categories"))){
         return;
      }

      click(By.linkText("CSV Import/Export"));

   }

   public void gotoCountries() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Countries")) {
         return;
      }

      click(By.linkText("Countries"));

   }

   public void gotoCurrencies() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Currencies")) {
         return;
      }

      click(By.linkText("Currencies"));

   }

   public void gotoCustomers() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Customers")) {
         return;
      }

      click(By.linkText("Customers"));

   }

   public void gotoCustomersCSVImportExport() {

      if (isElementPresent(By.tagName("h1"))
              && wd.findElement(By.tagName("h1")).getText().equals("CSV Import/Export")) {
         return;
      }

      click(By.linkText("CSV Import/Export"));

   }

   public void gotoCustomersNewsletter() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Newsletter")) {
         return;
      }

      click(By.linkText("Newsletter"));

   }
   public void gotoGeoZones() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Geo Zones")) {
         return;
      }

      click(By.linkText("Geo Zones"));
   }

   public void gotoLanguages() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Languages")) {
         return;
      }

      click(By.linkText("Languages"));

   }

   public void gotoLanguagesStorageEncoding() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Storage Encoding")) {
         return;
      }

      click(By.linkText("Storage Encoding"));

   }

   public void gotoModules() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Job Modules")) {
         return;
      }

      click(By.linkText("Modules"));

   }

   public void gotoModulesBackgroundJobs() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Job Modules")) {
         return;
      }

      click(By.linkText("Background Jobs"));

   }

   public void gotoModulesCustomer() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Customer Modules")) {
         return;

      }

      click(By.linkText("Customer"));

   }

   public void gotoModulesShipping() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Shipping Modules")) {
         return;

      }

      click(By.linkText("Shipping"));

   }

   public void gotoModulesPayment() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Payment Modules")) {
         return;

      }

      click(By.linkText("Payment"));

   }

   public void gotoModulesOrderTotal() {

      if (isElementPresent(By.tagName("h1"))
              && wd.findElement(By.tagName("h1")).getText().equals("Order Total Modules")) {
         return;

      }

      click(By.linkText("Order Total"));

   }

   public void gotoModulesOrderSuccess() {

      if (isElementPresent(By.tagName("h1"))
              && wd.findElement(By.tagName("h1")).getText().equals("Order Success Modules")) {
         return;

      }

      click(By.linkText("Order Success"));

   }

   public void gotoModulesOrderAction() {

      if (isElementPresent(By.tagName("h1"))
              && wd.findElement(By.tagName("h1")).getText().equals("Order Action Modules")) {
         return;

      }

      click(By.linkText("Order Action"));

   }

   public void gotoOrders() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Orders")) {
         return;

      }

      click(By.linkText("Orders"));

   }

   public void gotoOrdersOrderStatuses() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Order Statuses")) {
         return;

      }

      click(By.linkText("Order Statuses"));

   }

   public void gotoPages() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Pages")) {
         return;

      }

      click(By.linkText("Pages"));

   }

   public void gotoReports() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Monthly Sales")) {
         return;

      }

      click(By.linkText("Reports"));

   }

   public void gotoReportsMonthlySales() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Monthly Sales")) {
         return;

      }

      click(By.linkText("Monthly Sales"));

   }

   public void gotoReportsMostSoldProducts() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Most Sold Products")) {
         return;

      }

      click(By.linkText("Most Sold Products"));

   }

   public void gotoReportsMostShoppingCustomers() {

      if (isElementPresent(By.tagName("h1"))
              && wd.findElement(By.tagName("h1")).getText().equals("Most Shopping Customers")) {
         return;

      }

      click(By.linkText("Most Shopping Customers"));

   }

   public void gotoSettings() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Settings")) {
         return;

      }

      click(By.linkText("Settings"));

   }

   public void gotoSettingsStoreInfo() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Settings")) {
         return;

      }

      click(By.linkText("Store Info"));

   }

   public void gotoSettingsDefaults() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Settings")) {
         return;

      }

      click(By.linkText("Defaults"));

   }

   public void gotoSettingsGeneral() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Settings")) {
         return;

      }

      click(By.linkText("General"));

   }

   public void gotoSettingsListings() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Settings")) {
         return;

      }

      click(By.linkText("Listings"));

   }

   public void gotoSettingsImages() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Settings")) {
         return;

      }

      click(By.linkText("Images"));

   }

   public void gotoSettingsCheckout() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Settings")) {
         return;

      }

      click(By.linkText("Checkout"));

   }

   public void gotoSettingsAdvanced() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Settings")) {
         return;

      }

      click(By.linkText("Advanced"));

   }

   public void gotoSettingsSecurity() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Settings")) {
         return;

      }

      click(By.linkText("Security"));

   }

   public void gotoSlides() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Slides")) {
         return;

      }

      click(By.linkText("Slides"));

   }

   public void gotoTax() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Tax Classes")) {
         return;

      }

      click(By.linkText("Tax"));

   }

   public void gotoTaxClasses() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Tax Classes")) {
         return;

      }

      click(By.linkText("Tax Classes"));

   }

   public void gotoTaxRates() {

      if (isElementPresent(By.tagName("h1"))&& wd.findElement(By.tagName("h1")).getText().equals("Tax Rates")) {
         return;

      }

      click(By.linkText("Tax Rates"));

   }

   public void gotoTranslations() {

      if (isElementPresent(By.tagName("h1"))
              && wd.findElement(By.tagName("h1")).getText().equals("Search Translations")) {
         return;

      }

      click(By.linkText("Translations"));

   }

   public void gotoTranslationsSearchTranslations() {

      if (isElementPresent(By.tagName("h1"))
              && wd.findElement(By.tagName("h1")).getText().equals("Search Translations")) {
         return;

      }
      click(By.linkText("Search Translations"));

   }

   public void gotoTranslationsScanFiles() {

      if (isElementPresent(By.tagName("h1"))
              && wd.findElement(By.tagName("h1")).getText().equals("Scan Files For Translations")) {
         return;

      }


      click(By.linkText("Scan Files"));  }

   public void gotoTranslationsCSVImportExport() {

      if (isElementPresent(By.tagName("h1"))
              && wd.findElement(By.tagName("h1")).getText().equals("CSV Import/Export")
              && (isElementPresent(By.tagName("h2"))
              && wd.findElement(By.tagName("h2")).getText().equals("Translations"))){
         return;
      }

      click(By.linkText("CSV Import/Export"));

   }

   public void gotoUsers() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Users")) {
         return;
      }

      click(By.linkText("Users"));
   }

   public void gotovQmods() {

      if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("vQmods")) {
         return;
      }

      click(By.linkText("vQmods"));
   }


}
