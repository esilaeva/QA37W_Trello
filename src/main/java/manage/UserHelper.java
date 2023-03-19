package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillINLoginForm(String email, String password) {
        type(By.cssSelector("#user"), email);
        click(By.cssSelector("#login"));
        pause(2000);
        type(By.cssSelector("#password"), password);
    }

    public void submitLogin() {
        click(By.cssSelector("#login-submit"));
    }

    public boolean isLogged() {
        return wd.findElements(By.cssSelector("[data-testid='header-member-menu-button']")).size() > 0;
    }
}
