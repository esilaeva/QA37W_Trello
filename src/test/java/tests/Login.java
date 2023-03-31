package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }
    }

    @Test
    public void login1() {
        User user = User.builder().email("emsilaeva@gmail.com").password("sL34@kG2buD").build();

        app.getUser().initLogin();
        app.getUser().pause(2000);
        app.getUser().fillINLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(2000);

        Assert.assertTrue(app.getUser().isLogged());

    }
}
