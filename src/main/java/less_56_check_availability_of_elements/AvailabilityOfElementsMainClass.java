package less_56_check_availability_of_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AvailabilityOfElementsMainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumWebDrivers\\chromeDrivers\\chromedriver_79.0.3945.36.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.oracle.com/technetwork/java/javase/downloads/2133151");
        WebElement radioButtonAccept = driver.findElement(By.xpath("//input[@name='agreementjdk-8u241-oth-JPR'][1]"));
        WebElement noDisplayed = driver.findElement(By.xpath("//*[@class='u02tlink']"));
        WebElement isDisplayed = driver.findElement(By.xpath("//*[@id=\"XMLLeftNav\"]/ul/li[9]/a/div"));

        // активна ли кнопка
        System.out.println(radioButtonAccept.isEnabled());
        // отображается ли пункт меню
        System.out.println(noDisplayed.isDisplayed());
        // отображается ли элемент страницы
        System.out.println(isDisplayed.isDisplayed());

        // нажата ли радиокнопка
        if(!radioButtonAccept.isSelected()){
            radioButtonAccept.click();
        }

        driver.quit();
    }
}
