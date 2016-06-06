package br.com.joaolima.testeselenium.basetest;

import org.openqa.selenium.WebDriver;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public abstract class BasePage {

	private WebDriver driver;
	private static final long THIRTY = 30L;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		waitForPageToLoad();
	}
	
	protected WebDriver getDriver(){
		return this.driver;
	}

	protected void waitForPageToLoad() {
		new WaitForPageToLoad().apply(driver, new String[] { String.valueOf(THIRTY * 1000) });
	}
}