package manage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ApplicationManager {
    WebDriver wd;

    UserHelper user;
    BoardHelper board;
    ListHelper list;
    CardHelper card;

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        wd = new ChromeDriver(options);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //wd= new ChromeDriver();
        wd.navigate().to("https://trello.com/");

        user = new UserHelper(wd);
        board = new BoardHelper(wd);
        list = new ListHelper(wd);
        card = new CardHelper(wd);
        user.login("emsilaeva@gmail.com", "sL34@kG2buD");
    }

    public UserHelper getUser() {
        return user;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public ListHelper getList() {
        return list;
    }

    public CardHelper getCard() {
        return card;
    }

    public String getUrl(){
        return wd.getCurrentUrl();
    }

    public void quit() {
        wd.close();
        wd.quit();
    }


}