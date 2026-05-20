package Testler;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
    @FindBy(xpath = "//span[@class='price actual-price']")
    public List<WebElement> prices;

    // sevgi
    @FindBy(linkText = "Computers")
    public WebElement Computers;
    @FindBy(linkText = "Notebooks")
    public WebElement Notebooks;
    @FindBy(css = "input[value='Add to cart']")
    public WebElement addToCart;
    @FindBy(css = "div[class='product-item']>div>a")
    public WebElement laptop;
    @FindBy(xpath = "//*[@id='bar-notification']/p/a")
    public WebElement addToCartDogrulama;
    @FindBy(xpath = "//*[@id='topcartlink']/a/span[1]")
    public WebElement shoppingCartButonu;
    @FindBy(xpath = "//table[@class='cart']//td[@class='product']//a[contains(text(), '14.1-inch Laptop')]")
    public WebElement shoppingCartDogrulama;
    @FindBy(id = "termsofservice")
    public WebElement checkBox;
    @FindBy(id = "checkout")
    public WebElement checkOut;
    @FindBy(xpath = " //input[@value='Checkout as Guest']")
    public WebElement guestButton;
    @FindBy(id = "BillingNewAddress_FirstName")
    public WebElement billingAdresFirstName;
    @FindBy(id = "BillingNewAddress_LastName")
    public WebElement billingAdresLastName;
    @FindBy(id = "BillingNewAddress_Email")
    public WebElement billingAdresEmail;
    @FindBy(id = "BillingNewAddress_CountryId")
    public WebElement billingAdressSelectCountry;
    @FindBy(id = "BillingNewAddress_City")
    public WebElement billingAdresCity;
    @FindBy(id = "BillingNewAddress_Address1")
    public WebElement billingAdress;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    public WebElement billingAdressPostalCode;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    public WebElement billingAdressPhoneNumber;
    @FindBy(xpath = "//*[@id='billing-buttons-container']/input")
    public WebElement billingContainer;
    @FindBy(xpath = " //*[@id='shipping-buttons-container']/input")
    public WebElement shippingContainer;
    @FindBy(id = "shippingoption_0")
    public WebElement shippingOption;
    @FindBy(xpath = " //*[@id='shipping-method-buttons-container']/input")
    public WebElement shippingMethodContainer;
    @FindBy(id = "paymentmethod_1")
    public WebElement paymentMethod;
    @FindBy(xpath = " //*[@id='payment-method-buttons-container']/input")
    public WebElement paymentMethodContainer;
    @FindBy(xpath = " //*[@id='payment-info-buttons-container']/input")
    public WebElement infoContainer;
    @FindBy(xpath = "  //*[@id='confirm-order-buttons-container']/input")
    public WebElement confirmOrder;
    @FindBy(css = "div[class='title']>strong")
    public WebElement ekranYazi;

    // Buraks elements
    @FindBy(css = "div[class='item-box']:nth-child(1) img")
    public WebElement book1;
    @FindBy(xpath = "//input[@value='Add to compare list']")
    public WebElement addToCompareList;
    @FindBy(css = "div[class='item-box']:nth-child(2) img")
    public WebElement book2;
    @FindBy(css = "[class='overview']>td+td")
    public List<WebElement> listItems;


}
