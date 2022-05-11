import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddTasks {
    private WebDriver driver;
    public static TasksPage tasksPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        tasksPage = new TasksPage(driver);
    }
    @Test
    public void checkTasksAdd() {
        tasksPage.openPage("https://todomvc.com/examples/kotlin-react/");
        tasksPage.addTask("make a test plan");
        tasksPage.addTask("write autotests");
        Assert.assertEquals("2", tasksPage.getTasksCount());
    }
    @After
    public void finish() {
        driver.quit();
    }
}
