package br.com.joaolima.testeselenium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.joaolima.testeselenium.basetest.BaseTests;
import br.com.joaolima.testeselenium.basetest.TestParams;
import br.com.joaolima.testeselenium.test.dataprovider.UsuarioDataProvider;
import br.com.joaolima.testeselenium.test.pageobject.HomePage;
import br.com.joaolima.testeselenium.test.pageobject.RegistroPage;

@TestParams(dataProvider = "CT01_RegistroUsuarioTest.json")
public class CT01_RegistroUsuarioTest extends BaseTests {

	private UsuarioDataProvider data;
	private HomePage homePage;
	private RegistroPage registroPage;

	/*
	 * No caso abaixo o ideal seria ter uma estrutura de testes separada em
	 * passos para poder ter maior reaproveitamento se houvessem mais scripts de
	 * testes.
	 * 
	 * Exemplo: Passo 01 - Acessar HomePage e clicar no Botão de Registro Passo
	 * 02 - Preencher formulário e confirmar registro.
	 * 
	 */

	@Test
	public void registrarUsuarioExistente() {
		data = getDataProvider(UsuarioDataProvider.class);
		driver.get(data.getUrl());
		homePage = new HomePage(driver);
		homePage.clicarBotaoRegistration();

		registroPage = new RegistroPage(driver);
		preencherFormularioRegistro();
		registroPage.clicarBotaoSubmitFormularioRegistro();
		validarMensagemDoSistema();
	}

	private void validarMensagemDoSistema() {
		String mensagemSistemaEsperada = data.getMensagemSistema();
		String mensagemSistemaEncontrada = registroPage.getMensagemSistemaErro();
		Assert.assertEquals("Validar mensagem de sistema após confirmação de registro.", mensagemSistemaEsperada,
				mensagemSistemaEncontrada);
	}

	private void preencherFormularioRegistro() {
		registroPage.preencherFirstName(data.getFirstName());
		registroPage.preencherLastName(data.getLastName());
		registroPage.selecionarHobby(data.getHobby());
		registroPage.preencherPhoneNumber(data.getPhoneNumber());
		registroPage.preencherUsername(data.getUsername());
		registroPage.preencherEmail(data.getEmail());
		registroPage.preencherPassword(data.getPassword());
		registroPage.preencherConfirmPassword(data.getPassword());
	}
}
