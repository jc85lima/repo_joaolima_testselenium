package br.com.joaolima.testeselenium.basetest;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTests {

	private static final long THIRTY = 30L;
	protected FirefoxDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(THIRTY, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}

	protected <T> T getDataProvider(Class<T> classDataProvider) {
		String pathDataProvider = getPathDataProviderParameter();
		if (StringUtils.isBlank(pathDataProvider)) {
			throw new NullPointerException(
					"Configure corretamente o path do DataProvider na anotação TestParams da classe de testes.");
		}
		return new BaseDataProvider().getDataProvider(pathDataProvider, classDataProvider);
	}

	private String getPathDataProviderParameter() {
		String pathDataProvider = null;
		if (this.getClass().isAnnotationPresent(TestParams.class)) {
			pathDataProvider = this.getClass().getAnnotation(TestParams.class).dataProvider();
		}
		return pathDataProvider;
	}
}
