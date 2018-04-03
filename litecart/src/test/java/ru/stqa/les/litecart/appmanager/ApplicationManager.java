package ru.stqa.les.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by a.zelenskaya on 22.03.2018.
 */
public class ApplicationManager {

   WebDriver wd;

   private SessionHelper sessionHelper;
   private NavigationHelper navigationHelper;
   private String browser;
   private HelperAdmin helperAdmin;
   private HelperStore helperStore;
   private UserHelper userHelper;

   public ApplicationManager(String browser) { this.browser = browser;}


   public void init() {

      if (Objects.equals(browser, BrowserType.FIREFOX)) {
         wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Users/a.zelenskaya/Documents/Mozilla Firefox/firefox.exe"));
         //wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Program Files/Firefox Nightly/firefox.exe"));
      } else if (Objects.equals(browser, BrowserType.CHROME)) {
         wd = new ChromeDriver();
      } else if (Objects.equals(browser, BrowserType.IE)) {
         wd = new InternetExplorerDriver();
      }

     // wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

      navigationHelper = new NavigationHelper(wd);
      sessionHelper = new SessionHelper(wd);
      helperAdmin = new HelperAdmin(wd);
      helperStore = new HelperStore(wd);
      userHelper = new UserHelper(wd);

   }



   public void stop() {
      wd.quit();
   }

   public NavigationHelper getNavigationHelper() { return navigationHelper; }
   public SessionHelper getSessionHelper() { return sessionHelper; }
   public HelperAdmin getHelperAdmin(){return helperAdmin;}
   public HelperStore getHelperStore(){return helperStore;}
   public UserHelper getUserHelper(){return userHelper;}

}
