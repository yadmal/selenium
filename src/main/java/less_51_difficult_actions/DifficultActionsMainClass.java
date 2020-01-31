package less_51_difficult_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DifficultActionsMainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\seleniumWebDrivers\\geckoDrivers\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\seleniumWebDrivers\\geckoDrivers\\chromedriver_79.0.3945.36.exe");
        WebDriver chromeDriver = new ChromeDriver();
//        chromeDriver.manage().window().maximize();

        chromeDriver.get("https://www.ebay.com/");
        WebElement search = chromeDriver.findElement(By.xpath("//input[@id='gh-ac']"));
        WebElement element = chromeDriver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
        Actions actions = new Actions(chromeDriver);
        //Наведение на элемент
        actions.moveToElement(element).build().perform();
        //Перетаскивание элемента 1
        actions.dragAndDrop(element, search).build().perform();
        //Перетаскивание элемента 2
        actions.clickAndHold(element).moveToElement(search).release().build().perform();
        //Перетаскивание элемента 3
        Action action = actions.clickAndHold(element).moveToElement(search).release().build();
        action.perform();
        actions.contextClick(element).perform();
        actions.doubleClick(search).perform();



//        chromeDriver.quit();
    }
}
