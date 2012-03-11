package com.indhio.ajax;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.indhio.email.EnviarEmailSSL;
import com.indhio.freemarker.AjaxTools;

public class SendEmailAjax {
	
	private static org.apache.log4j.Logger log = Logger.getLogger(SendEmailAjax.class);
	
	public void test() {
		HashMap<String, Object> root = new HashMap<String, Object>();
    root.put("message", "Hello World!");
    WebContext webContext = WebContextFactory.get();
    String template = AjaxTools.gerarTemplateAjax(webContext, root, "test.ftl");
    log.info(template);
	}

	public void sendEmail(String email, String assunto, String conteudo) throws Exception {
		try {
			HashMap<String, Object> dados = new HashMap<String, Object>();
			dados.put("email", email);
			dados.put("assunto", assunto);
			dados.put("conteudo", conteudo);

			WebContext webContext = WebContextFactory.get();
			String template = AjaxTools.gerarTemplateAjax(webContext, dados, "test.ftl");

			/**
			 * Enviar email SSL (Google)
			 */
			EnviarEmailSSL.getInstance().enviar(email, assunto, template);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}