package less_50_Explicit_Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


// implicitlyWait - это ожидание, которое используется при каждом поиске элемента если его не удается найти
// explicitWait - ожидание, которое используется один раз для проверки какого-нибудь условия, например нужно дождаться появления какой-нибудь надписи

public class MainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\seleniumWebDrivers\\geckoDrivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://account.mail.ru/signup?from=main&rf=auth.mail.ru");

        // Создаем элемент ожидания
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        // Задаем условие для ожидания загрузки заголовка
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Регистрация')]")));
        // Щелкаем на выпадающий список
        driver.findElement(By.xpath("//div[@class='b-date__month']")).click();
        // Дожидаемся разворачивания списка
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Март']")));
        // Кликаем на элемент списка
        driver.findElement(By.xpath("//span[text()='Март']")).click();
        // Дожидаемся исчезновения списка
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"birthdate_46\"]/div[2]/div[2]/div/div[1]/div/div[2]")));
        driver.quit();
    }
}


