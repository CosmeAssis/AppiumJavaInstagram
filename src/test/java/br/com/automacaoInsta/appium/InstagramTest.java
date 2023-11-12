package br.com.automacaoInsta.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class InstagramTest {

    DriverFactory driverFactory = new DriverFactory();

    @Test
    public void realizarLogin() throws MalformedURLException, InterruptedException {

        driverFactory.setCapabilities("Android", "CosmeMobile", "emulator-5554", "uiautomator2",
                "com.instagram.android", ".activity.MainTabActivity");
        driverFactory.setDriver();
        WebDriverWait wait = new WebDriverWait(driverFactory.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"Instagram from Meta\"]\n")));
        MobileElement fieldLogin = driverFactory.getDriver().findElement(By.xpath("//android.view.View[@content-desc=\"Nome de usuário, email ou número de celular\"]"));
        fieldLogin.click();
        driverFactory.getDriver().getKeyboard().sendKeys("estudoautomacao.2023@gmail.com");
        MobileElement fiedPassword = driverFactory.getDriver().findElement(By.xpath("//android.view.View[@content-desc=\"Senha\"]\n"));
        fiedPassword.click();
        driverFactory.getDriver().getKeyboard().sendKeys("automacao@1751!?");
        MobileElement buttonEntrar = driverFactory.getDriver().findElement(By.xpath("//android.widget.Button[@content-desc=\"Entrar\"]\n"));
        buttonEntrar.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("\t//android.view.View[@content-desc=\"Salvar suas informações de login?\"]")));
        MobileElement buttonAgoraNao = driverFactory.getDriver().findElement(By.xpath("//android.widget.Button[@content-desc=\"Agora não\"]\n"));
        buttonAgoraNao.click();
        By buttonSearch = By.xpath("//android.widget.FrameLayout[@content-desc=\"Pesquisar e explorar\"]/android.widget.ImageView\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSearch));
        driverFactory.getDriver().findElement(buttonSearch).click();
        By screenSearch = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(screenSearch));
        By fieldSearch = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.EditText\n");
        driverFactory.getDriver().findElement(fieldSearch).click();
        String nomePesquisado = "bybiancaneves";
        driverFactory.getDriver().getKeyboard().sendKeys(nomePesquisado);
        String nomeFull = "Bianca Neves";
        By searchResult = By.xpath("//android.widget.TextView[contains(@text, '" + nomeFull + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));
//       System.out.println(searchResult);
       MobileElement result = driverFactory.getDriver().findElement(searchResult);
       result.click();
//        MobileElement instaBianca = driverFactory.getDriver().findElementByAccessibilityId("9cb83e93-1d71-43f5-a1ee-050e96fa81bb");
//        instaBianca.click();
        By buttonMensagem = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.Button[2]/android.widget.FrameLayout\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonMensagem));
        MobileElement clickButtonMensagem = driverFactory.getDriver().findElement(buttonMensagem);
        clickButtonMensagem.click();
        By fieldMensagem = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldMensagem));
        MobileElement sendMensagem = driverFactory.getDriver().findElement(fieldMensagem);
        sendMensagem.click();
        driverFactory.getDriver().getKeyboard().sendKeys("BOA NOITE, TESTE DEU CERTO :)");
        By buttonEnviar = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button\n");
        driverFactory.getDriver().findElement(buttonEnviar).click();
        //driverFactory.getDriver().quit();
    }
}
