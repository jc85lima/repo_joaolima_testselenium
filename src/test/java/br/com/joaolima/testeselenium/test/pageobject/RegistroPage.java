package br.com.joaolima.testeselenium.test.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.joaolima.testeselenium.basetest.BasePage;

public class RegistroPage extends BasePage {

	By byInputFirstName = By.id("name_3_firstname");
	By byInputLastName = By.id("name_3_lastname");
	By byCheckboxGroupHobby = By.xpath("//div[./label[text()='Hobby']]");
	By byInputPhoneNumber = By.id("phone_9");
	By byInputUsername = By.id("username");
	By byInputEmail = By.id("email_1");
	By byInputPassword = By.id("password_2");
	By byInputConfirmPassword = By.id("confirm_password_password_2");
	By bySubmitFormulario = By.name("pie_submit");
	By bySystemMessageError = By.className("piereg_login_error");
	
	
	public RegistroPage(WebDriver driver) {
		super(driver);
	}

	public void preencherFirstName(String firstName) {
		getDriver().findElement(byInputFirstName).sendKeys(firstName);
	}

	public void preencherLastName(String lastName) {
		getDriver().findElement(byInputLastName).sendKeys(lastName);
	}

	public void selecionarHobby(String hobby) {
		By byListCheckbox = By.xpath(".//input[@type='checkbox']");
		List<WebElement> listCheckbox = getDriver().findElement(byCheckboxGroupHobby).findElements(byListCheckbox);
		for (WebElement checkbox : listCheckbox) {
			if (hobby.equalsIgnoreCase(checkbox.getAttribute("value"))) {
				if (!checkbox.isSelected()) {
					checkbox.click();
				}
			}else{
				if (checkbox.isSelected()) {
					checkbox.click();
				}
			}
		}
	}

	public void preencherPhoneNumber(String phoneNumber) {
		getDriver().findElement(byInputPhoneNumber).sendKeys(phoneNumber);		
	}

	public void preencherUsername(String username) {
		getDriver().findElement(byInputUsername).sendKeys(username);
	}

	public void preencherEmail(String email) {
		getDriver().findElement(byInputEmail).sendKeys(email);		
	}

	public void preencherPassword(String password) {
		getDriver().findElement(byInputPassword).sendKeys(password);		
	}

	public void preencherConfirmPassword(String password) {
		getDriver().findElement(byInputConfirmPassword).sendKeys(password);		
	}

	public void clicarBotaoSubmitFormularioRegistro() {
		getDriver().findElement(bySubmitFormulario).click();		
	}

	public String getMensagemSistemaErro() {
		return getDriver().findElement(bySystemMessageError).getText();
	}

}
