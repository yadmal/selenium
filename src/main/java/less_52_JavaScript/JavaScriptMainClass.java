package less_52_JavaScript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptMainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\seleniumWebDrivers\\geckoDrivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumWebDrivers\\chromeDrivers\\chromedriver_79.0.3945.36.exe");
        WebDriver chromeDriver = new ChromeDriver();

        JavascriptExecutor jse = (JavascriptExecutor)chromeDriver;

        chromeDriver.get("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");

        jse.executeScript("window.scrollBy(0, 1000)", "");
        jse.executeScript("window.scrollBy(0, -1000)", "");
        jse.executeScript("alert('Hello world');");
    }
}
