package br.com.automacaoInsta.appium.pages;

import br.com.automacaoInsta.appium.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class LoginPage {

   DriverFactory driverFactory = new DriverFactory();

   @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Nome de usuário, email ou número de celular\"]")
   private MobileElement usernameField;

   @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Senha\"]\n")
   private MobileElement passwordField;

   @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Entrar\"]\n")
   private MobileElement loginButton;

   public LoginPage() throws MalformedURLException {
      driverFactory.setDriver();
   }

   public void login(String username,String password){
      usernameField.sendKeys(username);
      passwordField.sendKeys(password);
      loginButton.click();
   }
}
