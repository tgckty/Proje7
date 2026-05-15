package Testler;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {
    public Elements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(linkText = "Register")
    public WebElement register;
    @FindBy(id = "gender-female")
    public WebElement gender;
    @FindBy(id = "FirstName")
    public WebElement firstName;
    @FindBy(id = "LastName")
    public WebElement lastName;
    @FindBy(id = "Email")
    public WebElement email;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassword;
    @FindBy(id = "register-button")
    public WebElement registerButton;
    @FindBy(xpath = "//div[@class='result']")
    public WebElement result;
    @FindBy(xpath = "//div[@class='validation-summary-errors']")
    public WebElement failRegisterMesage;
    @FindBy(linkText = "Log in")
    public WebElement login;
    @FindBy(css = "input[class='button-1 login-button']")
    public WebElement loginButton;
    @FindBy(linkText = "Log out")
    public WebElement logout;
    @FindBy(xpath = "//form/div[1]/div/span")
    public WebElement negativeLoginMessage;
    @FindBy(linkText = "Books")
    public WebElement books;
    @FindBy(id = "products-orderby")
    public WebElement sortBy;


}
