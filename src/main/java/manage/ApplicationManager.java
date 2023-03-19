package manage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ApplicationManager {
    WebDriver wd;

    UserHelper user;

    public void init(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        wd = new ChromeDriver(options);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //wd=new ChromeDriver();
        wd.navigate().to("https://trello.com/");

        user = new UserHelper(wd);
    }

    public UserHelper getUser() {
        return user;
    }

    public void quit(){
        wd.close();
        wd.quit();
    }
}
