import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage {
    public WebDriver driver;
    public TasksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@placeholder='What needs to be done?']")
    private WebElement taskInput;

    @FindBy(xpath = "//strong")
    private WebElement tasksCount;

    public void openPage(String url) {
        driver.get(url);
    }
    public void addTask(String task) {
        taskInput.sendKeys(task);
        taskInput.sendKeys(Keys.ENTER);
    }

    public String getTasksCount() {
        return tasksCount.getText();
    }

    public void moveToTask(String taskName) {
        String pattern = String.format("//*[text()='%s']", taskName);
        WebElement task = driver.findElement(By.xpath(pattern));
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(task).build().perform();
    }

    public void removeTask(Integer taskIndex) {
        WebElement destroyButton = driver.findElements(By.xpath("//button[@class='destroy']")).get(taskIndex);
        destroyButton.click();
    }
}
