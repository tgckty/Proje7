package Testler;

import Utility.BaseDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
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

    @Test
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

    @Test
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

    @Test
    public void LoginTesti() {
        Elements elements = new Elements();
        elements.login.click();
        elements.email.sendKeys("testkullanici1@gmail.com");
        elements.password.sendKeys("123123");
        elements.loginButton.click();
        Assert.assertTrue(elements.logout.getText().equals("Log out"), "Hatalı login");

    }

    @Test
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


}
