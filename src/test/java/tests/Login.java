package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {
    @Test
    public void login1() {
        app.getUser().initLogin();
        app.getUser().pause(5000);
        app.getUser().fillINLoginForm("emsilaeva@gmail.com", "sL34@kG2buD");
        app.getUser().submitLogin();
        app.getUser().pause(5000);

        Assert.assertTrue(app.getUser().isLogged());


    }
}
