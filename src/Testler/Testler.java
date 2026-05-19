package Testler;

import Utility.BaseDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Testler extends BaseDriver {

    @Test(priority = 1)   //Tuğçe
    public void RegisterTesti() throws IOException {
        Elements elements = new Elements();
        elements.register.click();
        elements.gender.click();
        elements.firstName.sendKeys("Test");
        elements.lastName.sendKeys("Kullanıcısı");
        elements.email.sendKeys("testkullanici1@gmail.com");
        elements.password.sendKeys("123123");
        elements.confirmPassword.sendKeys("123123");
        elements.registerButton.click();
        Assert.assertTrue(elements.result.getText().equals("Your registration completed"), "HATA");
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy_hh-mm");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File hafizadakiEkranGoruntusu = ts.getScreenshotAs(OutputType.FILE);
        String path = "ekranGoruntuleri/Screenshot_" + dt.format(format) + ".jpg";
        FileUtils.copyFile(hafizadakiEkranGoruntusu, new File(path));
    }

    @Test(priority = 2)  //Tuğçe
    public void NegatifRegisterTesti() throws IOException {
        Elements elements = new Elements();
        elements.register.click();
        elements.gender.click();
        elements.firstName.sendKeys("Test");
        elements.lastName.sendKeys("Kullanıcısı");
        elements.email.sendKeys("testkullanici1@gmail.com");
        elements.password.sendKeys("123123");
        elements.confirmPassword.sendKeys("123123");
        elements.registerButton.click();
        Assert.assertTrue(elements.failRegisterMesage.getText().equals("The specified email already exists"), "HATA");
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy_hh-mm");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File hafizadakiEkranGoruntusu = ts.getScreenshotAs(OutputType.FILE);
        String path = "ekranGoruntuleri/Screenshot_" + dt.format(format) + ".jpg";
        FileUtils.copyFile(hafizadakiEkranGoruntusu, new File(path));
    }

    @Test(priority = 3)  //Tuğçe
    public void LoginTesti() {
        Elements elements = new Elements();
        elements.login.click();
        elements.email.sendKeys("testkullanici1@gmail.com");
        elements.password.sendKeys("123123");
        elements.loginButton.click();
        Assert.assertTrue(elements.logout.getText().equals("Log out"), "Hatalı login");

    }

    @Test(priority = 4)    //yiğithan
    public void NegatifLoginTesti() {
        Elements elements = new Elements();
        elements.login.click();
        elements.email.sendKeys("test@gmail.com");
        elements.password.sendKeys("123123");
        elements.loginButton.click();
        Assert.assertTrue(elements.negativeLoginMessage.getText().equals("Login was unsuccessful. Please correct the errors and try again."), "Hatalı login");

    }

    @Test(priority = 5)       //Sevgi
    public void OrderTest() throws IOException {
        // 1-siteye git
        // extends ile gidildi.

        // 2-login ol
        Elements elements = new Elements();
        elements.login.click();
        elements.email.sendKeys("testkullanicisi@gmail.com");
        elements.password.sendKeys("123456");
        elements.loginButton.click();

        //  3-Computers-> Notebooks menüsüne git
        elements.Computers.click();
        elements.Notebooks.click();

        // 4-"14.1-inch Laptop" ürününe tıkla
        elements.laptop.click();

        // 5- Add to cart butonuna tıklayın
        elements.addToCart.click();

        // 6- "Add to cart" sepette olduğunu doğrula
        Assert.assertTrue(elements.addToCartDogrulama.isDisplayed(), "Ürün sepete eklenmedi!");

        // 7-"Shopping cart" butonuna tıkla
        elements.shoppingCartButonu.click();

        // 8- "Shopping cart" sepette olduğunu doğrula
        Assert.assertTrue(elements.shoppingCartDogrulama.isDisplayed(), "Ürün sepette bulunamadı!");

        // 9- Checkbox u işaretle
        elements.checkBox.click();

        // 10- Checkout butonuna tıkla
        elements.checkOut.click();
        elements.guestButton.click();

        // 11- Billing adres formu doldur
        elements.billingAdresFirstName.sendKeys("test");
        elements.billingAdresLastName.sendKeys("kullnacisi");
        elements.billingAdresEmail.sendKeys("testkullanicisi@gmail.com");
        Select countryDropdown = new Select(elements.billingAdressSelectCountry);  // Select Country
        countryDropdown.selectByVisibleText("Turkey");
        elements.billingAdresCity.sendKeys("Ankara");
        elements.billingAdress.sendKeys("Ankara mah");
        elements.billingAdressPostalCode.sendKeys("01000");
        elements.billingAdressPhoneNumber.sendKeys("55555555");

        // 12- Continue-> Shipping Method-> Payment Method-> Confirm Order
        bekle.until(ExpectedConditions.elementToBeClickable(elements.billingContainer)).click();
//      elements.pickUpBox.click();
        elements.shippingContainer.click();
        elements.shippingOption.click();
        bekle.until(ExpectedConditions.elementToBeClickable(elements.shippingMethodContainer)).click();
//      elements.paymentMethod.click();
//      bekle.until(ExpectedConditions.elementToBeClickable(elements.paymentMethod)).click();
        bekle.until(ExpectedConditions.elementToBeClickable(elements.paymentMethodContainer)).click();
        elements.infoContainer.click();
        elements.confirmOrder.click();

        // 13- "Your order has been placed! mesajını doğrula
        bekle.until(ExpectedConditions.urlContains("completed"));
        Assert.assertEquals(elements.ekranYazi.getText(),
                "Your order has been successfully processed!", "Oluşan Mesajlar Eşleşmiyor");

        // 14- screenshot al
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy_hh-mm");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File hafizadakiEkranGoruntusu = ts.getScreenshotAs(OutputType.FILE);
        String path = "ekranGoruntuleri/Screenshot_" + dt.format(format) + ".jpg";
        FileUtils.copyFile(hafizadakiEkranGoruntusu, new File(path));


    }




    @Test(priority = 6)      //Tuğçe
    public void UrunFiltreVeSiralama() {
        Elements elements = new Elements();
        LoginTesti();
        elements.books.click();
        Select sort = new Select(elements.sortBy);
        sort.selectByVisibleText("Price: Low to High");  //3 5 8 7

        ArrayList<Double> sirali = new ArrayList<>();
        for (WebElement p : elements.prices) {
            sirali.add(Double.parseDouble(p.getText()));
        }
        Collections.sort(sirali); // 3,5,7,8

        for (int i = 0; i < elements.prices.size(); i++) {
            Assert.assertTrue(Double.parseDouble(elements.prices.get(i).getText()) == sirali.get(i), "HATA");
        }
    }


    @Test(priority = 7)   //Burak
    public void urunKarşılaştırma() {

      //  Senaryo:

      //  1. "Books" kategorisine gidin
        //  2. İki farklı ürün için "Add to compare list" butonuna tıklayın
        //  3. "Compare products list" sayfasına gidin
        //  4. Eklenen iki ürünün listede göründüğünü doğrulayın

    }

    @Test(priority = 8)    //Zeynep
    public void WislistTest(){

     //  Senaryo:
     //  1. Login olun
     //  2. "Apparel & Shoes" kategorisine gidin
     //  3. Bir ürünü "Add to wishlist" ile ekleyin
     //  4. "Wishlist" sayfasına gidin
     //  5. Ürünün wishlist'te göründüğünü doğrulayın

    }





}
