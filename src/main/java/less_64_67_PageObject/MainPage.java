package less_64_PageObject_MainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signIn = By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']");
    private By signUpButton = By.xpath("//a[@class='HeaderMenu-link d-inline-block no-underline border border-gray-dark rounded-1 px-2 py-1']");
    private By signUpFormButton = By.xpath("//button[@class='btn-mktg btn-primary-mktg btn-large-mktg f4 btn-block my-3']");
    private By userNameField = By.id("user[login]");
    private By emailField = By.id("user[email]");
    private By passwordField = By.id("user[password]");

    public LoginPage clickSignIn(){
        driver.findElement(signIn).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton(){
        driver.findElement(signIn).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton(){
        driver.findElement(signIn).click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String username){
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public MainPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public MainPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage register(String userName, String email, String password){
        this.typeUserName(userName);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }
}
