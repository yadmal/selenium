package less_64_67_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.id("login_field");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//input[@type='submit']");
    private By title = By.xpath("//div[@class='auth-form-header p-0']/h1");
    private By error = By.xpath("//div[@class='flash flash-full flash-error']/div[@class='container']");
    private By creatAccountLink = By.xpath("//a[text()='Create an account']");

    public LoginPage typeLogin(String login){
        driver.findElement(loginField).sendKeys(login);
        return this;
    }

    public LoginPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage loginWithInvalidCreds(String login, String password){
        this.typeLogin(login);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String getHeaderText(){
        return driver.findElement(title).getText();
    }

    public String getErrorText(){
        return driver.findElement(error).getText();
    }

    public SignUpPage createAccount(){
        driver.findElement(creatAccountLink).click();
        return new SignUpPage(driver);
    }
}
