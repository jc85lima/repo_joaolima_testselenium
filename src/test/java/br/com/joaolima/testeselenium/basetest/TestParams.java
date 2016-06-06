package br.com.joaolima.testeselenium.basetest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface TestParams {

	/**
     * <p>Defina o path do arquivo de dataProvider do Fluxo.<p>
     * <p>Considere o path a partir do diretório <i>src/test/resouces</i></p>
     */
	String dataProvider() default "";
}
