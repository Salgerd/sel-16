package ru.stqa.les.litecart.model;

import java.util.Date;

/**
 * Created by a.zelenskaya on 03.04.2018.
 */
public class UserData {

   private final String firstname;
   private final String lastname;
   private final String address1;
   private final String postcode;
   private final String city;
   private final String phone;
   private final String password;
   private final String confirmed_password;
   public static String email;

   public UserData(String firstname, String lastname, String address1, String postcode, String city, String email, String phone, String password, String confirmed_password) {

      this.firstname = firstname;
      this.lastname = lastname;
      this.address1 = address1;
      this.postcode = postcode;
      this.city = city;
      this.email = generateUniqueNumber() + "@gmail.com";
      this.phone = phone;
      this.password = password;
      this.confirmed_password = confirmed_password;
   }



  /* public void GenerateEmail() {

      email = generateUniqueNumber() + "@gmail.com";
      //System.out.println(email);
   }*/

   public String generateUniqueNumber(){
      Date date = new Date();
      long millis = date.getTime();
      return String.valueOf(millis);

   }

   public String getFirstname() {
      return firstname;
   }

   public String getLastname() {
      return lastname;
   }

   public String getAddress1() {
      return address1;
   }

   public String getPostcode() {
      return postcode;
   }

   public String getCity() {return city; }

   public String getEmail() {return email; }

   public String getPhone() {return phone; }

   public String getPassword() {return password; }

   public String getConfirmed_password() {return confirmed_password; }

}

