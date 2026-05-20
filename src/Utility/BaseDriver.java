package Utility;

import Testler.Elements;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait bekle;

    @BeforeClass
    public void Setup() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);              // şifre yöneticisi kapalı
        prefs.put("profile.password_manager_enabled", false);        // kayıt popup kapalı
        prefs.put("profile.password_manager_leak_detection", false); // "şifren sızdı değiştir" uyarısı kapalı

        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 30 sn mühlet: sayfayı yükleme mühleti
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // 5 sn mühlet: elementi bulma mühleti
        bekle = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://demowebshop.tricentis.com/");
    }

    public void LoginOl() {

        Elements elements = new Elements();
        elements.login.click();
        elements.email.sendKeys("testkullanici1@gmail.com");
        elements.password.sendKeys("123123");
        elements.loginButton.click();
    }

    public void LogOut() {

        Elements elements = new Elements();
        elements.logout.click();
    }

    public void EkranGoruntusuAl() throws IOException {
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy_hh-mm");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File hafizadakiEkranGoruntusu = ts.getScreenshotAs(OutputType.FILE);
        String path = "ekranGoruntuleri/Screenshot_" + dt.format(format) + ".jpg";
        FileUtils.copyFile(hafizadakiEkranGoruntusu, new File(path));
    }

    @AfterClass
    public void TearDown() {
        MyFunc.bekle(3);
        driver.quit();
    }
}
