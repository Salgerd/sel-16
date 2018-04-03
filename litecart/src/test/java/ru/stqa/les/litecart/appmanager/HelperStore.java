package ru.stqa.les.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by a.zelenskaya on 02.04.2018.
 */
public class HelperStore extends HelperBase {

   public static class ProductData {
      public String name;
      public String regularPrice;
      public String campaignPrice;
      boolean isCrossedRegularPrice;
      boolean isGrayColorRegularPrice;
      boolean isBoldСampaignPrice;
      boolean isRedColorСampaignPrice;
      boolean isTextSizeСampaignPriceBigger;
   }

   public HelperStore(WebDriver wd) {
      super(wd);
   }



   public int[] getRGB(String color) {


      int[] rgb = new int[3];

      int bracketOpen = color.indexOf('(');
      int bracketClose = color.indexOf(')');

      color = color.substring(bracketOpen + 1, bracketClose);

      int comma1 = color.indexOf(',');
      String element = color.substring(0, comma1);
      rgb[0] = Integer.parseInt(element);
      color = color.substring(comma1 + 2, color.length());


      int comma2 = color.indexOf(',');
      element = color.substring(0, comma2);
      rgb[1] = Integer.parseInt(element);
      color = color.substring(comma2 + 2, color.length());

      int comma3 = color.indexOf(',');
      if (comma3 != -1) {
         element = color.substring(0, comma3);
         rgb[2] = Integer.parseInt(element);
      } else {
         element = color;
         rgb[2] = Integer.parseInt(element);
      }

      return rgb;
   }

   public double getTextSize(String textSize) {

      String cut = textSize.substring(0, textSize.length() - 2);
      double size = Double.parseDouble(cut);
      return size;
   }

   public ProductData makeProductFormCurrentPage(String nameSelector,
                                                 String regularPriceSelector,
                                                 String campaignPriceSelector) {


      ProductData productData = new ProductData();

      productData.name = wd.findElement(By.cssSelector(nameSelector))
              .getAttribute("textContent");
      productData.regularPrice = wd.findElement(By.cssSelector(regularPriceSelector))
              .getAttribute("textContent");
      productData.campaignPrice = wd.findElement(By.cssSelector(campaignPriceSelector))
              .getAttribute("textContent");


      String textDecorationLineRP = wd.findElement(By.cssSelector(regularPriceSelector))
              .getCssValue("text-decoration-line");
      if (textDecorationLineRP.equals("line-through")) {
         productData.isCrossedRegularPrice = true;
      } else {
         productData.isCrossedRegularPrice = false;
      }


      String textColorRegularPrice = wd.findElement(By.cssSelector(regularPriceSelector))
              .getCssValue("color");
      int[] textColorRP = getRGB(textColorRegularPrice);
      if (textColorRP[0] == textColorRP[1] && textColorRP[0] == textColorRP[2]) {
         productData.isGrayColorRegularPrice = true;
      } else {
         productData.isGrayColorRegularPrice = false;
      }


      String textDecorationСP = wd.findElement(By.cssSelector(campaignPriceSelector))
              .getCssValue("font-weight");
      int textDecoration = Integer.parseInt(textDecorationСP);
      if (textDecoration >= 700) {
         productData.isBoldСampaignPrice = true;
      } else {
         productData.isBoldСampaignPrice = false;
      }


      String textColorСampaignPrice = wd.findElement(By.cssSelector(campaignPriceSelector))
              .getCssValue("color");
      int[] textColorCP = getRGB(textColorСampaignPrice);
      if (textColorCP[1] == 0 && textColorCP[2] == 0) {
         productData.isRedColorСampaignPrice = true;
      } else {
         productData.isRedColorСampaignPrice = false;
      }

      String textSizeRegularPrice = wd.findElement(By.cssSelector(regularPriceSelector))
              .getCssValue("font-size");
      String textSizeСampaignPrice = wd.findElement(By.cssSelector(campaignPriceSelector))
              .getCssValue("font-size");

      double textSizeRP = getTextSize(textSizeRegularPrice);
      double textSizeCP = getTextSize(textSizeСampaignPrice);
      if (textSizeCP > textSizeRP) {
         productData.isTextSizeСampaignPriceBigger = true;
      } else {
         productData.isTextSizeСampaignPriceBigger = false;
      }

      return productData;
   }


   public void compareProductData(ProductData mainPage, ProductData productPage) {
      // Выводим результат сравнения на консоль
      System.out.println("На главной странице и на странице товара:");
      System.out.println(compareStringData(mainPage.name, productPage.name)
              + " название товара");
      System.out.println(compareStringData(mainPage.regularPrice, productPage.regularPrice)
              + " обычная цена");
      System.out.println(compareStringData(mainPage.campaignPrice, productPage.campaignPrice)
              + " акционная цена");
      System.out.println(compareBooleanData(mainPage.isCrossedRegularPrice, productPage.isCrossedRegularPrice)
              + " стиль обычной цены - зачеркнутый");
      System.out.println(compareBooleanData(mainPage.isGrayColorRegularPrice, productPage.isGrayColorRegularPrice)
              + " цвет текста обычной цены - серый");
      System.out.println(compareBooleanData(mainPage.isBoldСampaignPrice, productPage.isBoldСampaignPrice)
              + " стиль акционной цены - полужирный");
      System.out.println(compareBooleanData(mainPage.isRedColorСampaignPrice, productPage.isRedColorСampaignPrice)
              + " цвет текста акционной цены - красный");
      System.out.println(compareBooleanData(mainPage.isTextSizeСampaignPriceBigger, productPage.isTextSizeСampaignPriceBigger)
              + " шрифт текста цен: акционная цена крупнее, чем обычная");
   }

   public String compareStringData(String mainPage, String productPage) {
      if (mainPage.equals(productPage)) {
         return "совпадает";
      } else {
         return "не совпадает";
      }
   }

   public String compareBooleanData(boolean mainPage, boolean productPage) {
      if (mainPage == productPage) {
         return "совпадает";
      } else {
         return "не совпадает";
      }
   }
}
