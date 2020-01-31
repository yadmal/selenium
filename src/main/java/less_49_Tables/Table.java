package less_49_Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    private WebElement tableElement;
    private WebDriver driver;

    public Table(WebElement tableElement, WebDriver driver) {
        this.tableElement = tableElement;
        this.driver = driver;
    }

    // Получаем список строк
    public List<WebElement> getRows() {
        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr"));
        rows.remove(0); // удаляем заголовки таблицы
        return rows;
    }

    //Выделяем лишь заголовки
    public List<WebElement> getHeaders() {
        WebElement headersRow = tableElement.findElement(By.xpath(".//tr[1]")); //строка
        List<WebElement> headersColumns = headersRow.findElements(By.xpath(".//th"));//ячейки
        return headersColumns;
    }

    // Разобьем полученные строки на ячейки
    public List<List<WebElement>> getRowsWithColumns() {
        List<WebElement> rows = this.getRows(); //разбиваем на строки
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();//для ячеек
        for (WebElement row : rows) {
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));//каждую строку на ячейки
            rowsWithColumns.add(rowWithColumns); //массив ячеек по строкам (двумерный массив)
        }
        return rowsWithColumns;
    }


    public String getValueFromCell(int row, int column) {
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        WebElement cell = rowsWithColumns.get(row - 1).get(column - 1); //поиск по "двумерному" массиву ячеек
        return cell.getText();
    }

    // Получение значения ячейки по имени заголовка и номеру строки.
    // Суть заключается в том, что мы хотим получать значения ячеек указывая название столбца, в котором они находятся.
    // Для этого нам нужно перейти из представления, когда таблицу описывают при помощи List<List<>>,
    // т.е. своеобразным "двумерным массивом" на основе списков, к представлению, когда каждая чейка будет
    // хранить данные и название столбца, к которому она относится. Чтобы одновременно хранить два вида данных
    // в одной ячейке в данном примере для представления строки будет использована HashMap, затем каждая строка,
    // представленная таким HashMap будет записана в List. Таким образом мы вновь получим двумерный массив,
    // ячейки которого хранят дополнительную информацию о том, в столбце с каким названием они находятся
    public List<Map<String, WebElement>> getRowsWithColumnsByHeader(){
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        List<WebElement> headerColumns = getHeaders();
        // одна строка, разбитая на столбцы по заголовку
        Map<String, WebElement> rowByHeader;
        // список строк, разбитых на заголовки
        List<Map<String, WebElement>> rowsWithColumnsByHeader = new ArrayList<Map<String, WebElement>>();

        // Пробегаемся по всем строкам
        for (List<WebElement> row : rowsWithColumns){
            //готовим для текущей строки HashMap
            rowByHeader = new HashMap<String, WebElement>();
            //Проход по строке
            for (int i = 0; i < headerColumns.size(); i++){
                // для каждой ячейки определяем заголовок столбца, в котором она находится
                String header = headerColumns.get(i).getText();
                System.out.println(header);
                // берем ячейку
                WebElement cell = row.get(i);
                System.out.println(cell);
                // Записываем в HashMap заголовок столбца и ячейку
                rowByHeader.put(header, cell);
            }
            rowsWithColumnsByHeader.add(rowByHeader);
        }
        return rowsWithColumnsByHeader;
    }

    //Для работы с предыдущим методом создадим дополнительный метод,
    // который будет принимать в качестве параметров номер строки и название столбца
    public String getValueFromCell(int row, String columnTitle) {
        List<Map<String, WebElement>> rowsWithColumnsByHeader = getRowsWithColumnsByHeader();
        return rowsWithColumnsByHeader.get(row-1).get(columnTitle).getText();
    }
}


