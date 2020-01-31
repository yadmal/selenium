package less_49_Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\seleniumWebDrivers\\geckoDrivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/html/html_tables.asp");
        WebElement tableElement = driver.findElement(By.xpath("//table[@id='customers']"));
        Table table = new Table(tableElement, driver);
        System.out.println("Row 4 cell 2 : " + table.getValueFromCell(4, 2));
        System.out.println("Row 2 column Country : " + table.getValueFromCell(2,"Country"));

        driver.quit();
    }
}
