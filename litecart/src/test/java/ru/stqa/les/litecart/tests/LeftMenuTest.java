package ru.stqa.les.litecart.tests;

import org.testng.annotations.Test;

public class LeftMenuTest extends TestBase{


    @Test
    public void testLeftMenu() {

        app.getSessionHelper().login("admin", "admin");
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoAppearence();
        app.getNavigationHelper().gotoAppearenceTemplate();
        app.getNavigationHelper().gotoAppearenceLogotype();
        app.getNavigationHelper().gotoCatalog();
        app.getNavigationHelper().gotoCatalogProductGroups();
        app.getNavigationHelper().gotoCatalogOptionGroups();
        app.getNavigationHelper().gotoCatalogManufacturers();
        app.getNavigationHelper().gotoCatalogSuppliers();
        app.getNavigationHelper().gotoCatalogDeliveryStatuses();
        app.getNavigationHelper().gotoCatalogSoldOutStatuses();
        app.getNavigationHelper().gotoCatalogQuantityUnits();
        app.getNavigationHelper().gotoCatalogCSVImportExport();
        app.getNavigationHelper().gotoCountries();
        app.getNavigationHelper().gotoCurrencies();
        app.getNavigationHelper().gotoCustomers();
        app.getNavigationHelper().gotoCustomersCSVImportExport();
        app.getNavigationHelper().gotoCustomersNewsletter();
        app.getNavigationHelper().gotoGeoZones();
        app.getNavigationHelper().gotoLanguages();
        app.getNavigationHelper().gotoLanguagesStorageEncoding();
        app.getNavigationHelper().gotoModules();
        app.getNavigationHelper().gotoModulesBackgroundJobs();
        app.getNavigationHelper().gotoModulesCustomer();
        app.getNavigationHelper().gotoModulesShipping();
        app.getNavigationHelper().gotoModulesPayment();
        app.getNavigationHelper().gotoModulesOrderTotal();
        app.getNavigationHelper().gotoModulesOrderSuccess();
        app.getNavigationHelper().gotoModulesOrderAction();
        app.getNavigationHelper().gotoOrders();
        app.getNavigationHelper().gotoOrdersOrderStatuses();
        app.getNavigationHelper().gotoPages();
        app.getNavigationHelper().gotoReports();
        app.getNavigationHelper().gotoReportsMonthlySales();
        app.getNavigationHelper().gotoReportsMostSoldProducts();
        app.getNavigationHelper().gotoReportsMostShoppingCustomers();
        app.getNavigationHelper().gotoSettings();
        app.getNavigationHelper().gotoSettingsStoreInfo();
        app.getNavigationHelper().gotoSettingsDefaults();
        app.getNavigationHelper().gotoSettingsGeneral();
        app.getNavigationHelper().gotoSettingsListings();
        app.getNavigationHelper().gotoSettingsImages();
        app.getNavigationHelper().gotoSettingsCheckout();
        app.getNavigationHelper().gotoSettingsAdvanced();
        app.getNavigationHelper().gotoSettingsSecurity();
        app.getNavigationHelper().gotoSlides();
        app.getNavigationHelper().gotoTax();
        app.getNavigationHelper().gotoTaxClasses();
        app.getNavigationHelper().gotoTaxRates();
        app.getNavigationHelper().gotoTranslations();
        app.getNavigationHelper().gotoTranslationsSearchTranslations();
        app.getNavigationHelper().gotoTranslationsScanFiles();
        app.getNavigationHelper().gotoTranslationsCSVImportExport();
        app.getNavigationHelper().gotoUsers();
        app.getNavigationHelper().gotovQmods();


    }
    
}
