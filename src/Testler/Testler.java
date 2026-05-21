package Testler;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class Testler extends BaseDriver {

    @Test(priority = 1)   //Tuğçe
    public void RegisterTesti() throws IOException {
        Elements elements = new Elements();
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");
        elements.register.click();
        elements.gender.click();
        elements.firstName.sendKeys("Test");
        elements.lastName.sendKeys("Kullanıcısı");
        elements.email.sendKeys("testkullanici" + dt.format(format) + "@gmail.com");
        elements.password.sendKeys("123123");
        elements.confirmPassword.sendKeys("123123");
        elements.registerButton.click();
        Assert.assertEquals(elements.result.getText(), "Your registration completed", "HATA");
        EkranGoruntusuAl();
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
        Assert.assertEquals(elements.failRegisterMesage.getText(), "The specified email already exists", "HATA");
        EkranGoruntusuAl();
    }

    @Test(priority = 3)  //Tuğçe
    public void LoginTesti() {
        Elements elements = new Elements();
        elements.login.click();
        elements.email.sendKeys("testkullanici1@gmail.com");
        elements.password.sendKeys("123123");
        elements.loginButton.click();
        Assert.assertEquals(elements.logout.getText(), "Log out", "Hatalı login");

    }

    @Test(priority = 4)    //yiğithan
    public void NegatifLoginTesti() {
        Elements elements = new Elements();
        elements.login.click();
        elements.email.sendKeys("test@gmail.com");
        elements.password.sendKeys("123123");
        elements.loginButton.click();
        Assert.assertEquals(elements.negativeLoginMessage.getText(), "Login was unsuccessful. Please correct the errors and try again.", "Hatalı login");

    }

    @Test(priority = 5)       //Sevgi
    public void OrderTest() throws IOException {
        Elements elements = new Elements();
        LoginOl();
        elements.Computers.click();
        elements.Notebooks.click();
        elements.laptop.click();
        elements.addToCart.click();
        Assert.assertTrue(elements.addToCartDogrulama.isDisplayed(), "Ürün sepete eklenmedi!");
        elements.shoppingCartButonu.click();
        Assert.assertTrue(elements.shoppingCartDogrulama.isDisplayed(), "Ürün sepette bulunamadı!");
        elements.checkBox.click();
        elements.checkOut.click();
        Select billingAddressDropdown = new Select(elements.newAddress);
        billingAddressDropdown.selectByVisibleText("New Address");
        // kullanici bilgileri LogiOl(); --> ile dolduruldu
        Select countryDropdown = new Select(elements.billingAdressSelectCountry);
        countryDropdown.selectByVisibleText("Turkey");
        elements.billingAdresCity.sendKeys("Ankara");
        elements.billingAdress.sendKeys("Ankara mah");
        elements.billingAdressPostalCode.sendKeys("01000");
        elements.billingAdressPhoneNumber.sendKeys("55555555");
        bekle.until(ExpectedConditions.elementToBeClickable(elements.billingContainer)).click();
        elements.shippingContainer.click();
        elements.shippingOption.click();
        bekle.until(ExpectedConditions.elementToBeClickable(elements.shippingMethodContainer)).click();
        bekle.until(ExpectedConditions.elementToBeClickable(elements.paymentMethod)).click();
        bekle.until(ExpectedConditions.elementToBeClickable(elements.paymentMethodContainer)).click();
        elements.infoContainer.click();
        elements.confirmOrder.click();
        bekle.until(ExpectedConditions.urlContains("completed"));
        Assert.assertEquals(elements.ekranYazi.getText(),
                "Your order has been successfully processed!", "Oluşan Mesajlar Eşleşmiyor");
        //EkranGoruntusuAl();
    }


    @Test(priority = 6)      //Tuğçe
    public void UrunFiltreVeSiralama() {
        Elements elements = new Elements();
        LoginOl();
        elements.books.click();
        Select sort = new Select(elements.sortBy);
        sort.selectByVisibleText("Price: Low to High");  //3 5 8 7
        ArrayList<Double> sirali = new ArrayList<>();
        for (WebElement p : elements.prices) {
            sirali.add(Double.parseDouble(p.getText()));
        }
        Collections.sort(sirali); // 3,5,7,8
        for (int i = 0; i < elements.prices.size(); i++) {
            Assert.assertEquals(sirali.get(i), Double.parseDouble(elements.prices.get(i).getText()), "HATA");
        }
    }


    @Test(priority = 7)   //Burak
    public void UrunKarsilastirma() {
        Elements elements = new Elements();
        LoginOl();
        //  Senaryo:
        //  1. "Books" kategorisine gidin
        //  2. İki farklı ürün için "Add to compare list" butonuna tıklayın
        //  3. "Compare products list" sayfasına gidin
        //  4. Eklenen iki ürünün listede göründüğünü doğrulayın
    }

    @Test(priority = 8)    //Zeynep
    public void WishlistTest() {
        Elements elements = new Elements();
        LoginOl();
        //  Senaryo:
        //  1. Login olun
        //  2. "Apparel & Shoes" kategorisine gidin
        //  3. Bir ürünü "Add to wishlist" ile ekleyin
        //  4. "Wishlist" sayfasına gidin
        //  5. Ürünün wishlist'te göründüğünü doğrulayın
    }
}
