package TestSuites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ConsoleLog {
    @Test
    public void ReadBrowserLogs() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/");
        LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs= entry.getAll();
        for(LogEntry e: logs)
        {
            System.out.println(e);
        }
        for(LogEntry e: logs)
        {
            System.out.println("Message is: " +e.getMessage());
            System.out.println("Level is: " +e.getLevel());
        }
    }
}


