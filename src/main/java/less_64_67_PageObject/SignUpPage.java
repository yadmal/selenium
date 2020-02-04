package less_64_67_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By title = By.xpath("/html/body/div[4]/main/div/div[1]");
    private By userNameField = By.id("user_login");
    private By emailField = By.id("user_email");
    private By passwordField = By.id("user_password");
    private By signupButton = By.id("signup_button");

    public SignUpPage typeUserName(String username){
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String username, String email, String password){
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signupButton).click();
        return new SignUpPage(driver);
    }

    public String getHeaderText(){
        return driver.findElement(title).getText();
    }
}
