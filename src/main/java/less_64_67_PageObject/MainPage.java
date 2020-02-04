package less_64_67_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='HeaderMenu-link no-underline mr-3']")
    private WebElement signIn;

    @FindBy(xpath = "//a[@class='HeaderMenu-link d-inline-block no-underline border border-gray-dark rounded-1 px-2 py-1']")
    private WebElement signUpButton;

    @FindBy(xpath = "//button[@class='btn-mktg btn-primary-mktg btn-large-mktg f4 btn-block my-3']")
    private WebElement signUpFormButton;

    @FindBy(id = "user[login]")
    private WebElement userNameField;

    @FindBy(id = "user[email]")
    private WebElement emailField;

    @FindBy(id = "user[password]")
    private WebElement passwordField;



    public SignUpPage clickSignUpButton() {
        signIn.click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton() {
        signIn.click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String username) {
        userNameField.sendKeys(username);
        return this;
    }

    public MainPage typeEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public MainPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public SignUpPage register(String userName, String email, String password) {
        this.typeUserName(userName);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }
}