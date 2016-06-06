package br.com.joaolima.testeselenium.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.joaolima.testeselenium.basetest.BasePage;

public class HomePage extends BasePage {

	By byBotaoRegistration = By.xpath("//ul[@id='menu-registration']//a[contains(text(),'Registration')]");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clicarBotaoRegistration() {
		getDriver().findElement(byBotaoRegistration).click();
	}

}
