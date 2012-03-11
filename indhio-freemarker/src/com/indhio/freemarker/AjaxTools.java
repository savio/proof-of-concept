package com.indhio.freemarker;

import java.io.StringWriter;
import java.util.HashMap;

import org.directwebremoting.WebContext;

import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import freemarker.template.Template;

public class AjaxTools {

	public static void main(String[] args) throws Exception {
		HashMap<String, Object> dados = new HashMap<String, Object>();
		// dados.put("indicadores", new IndicadorBusiness().getIndicadoresPorPai(14));
		System.out.println(gerarTemplateAjax(null, dados, "t_arvore.html"));
	}

	public static String gerarTemplateAjax(WebContext ctx, HashMap<String, Object> dados, String sTemplate) {
		try {

			Configuration cfg = new Configuration();
			cfg.setServletContextForTemplateLoading(ctx.getServletContext(), "templates");
			cfg.setStrictSyntaxMode(false);
			Template template = cfg.getTemplate(sTemplate);

			SimpleHash sh = new SimpleHash(dados);
			StringWriter sw = new StringWriter();
			template.process(sh, sw);

			String pagina = sw.getBuffer().toString();
			sw.close();

			return (pagina);
		} catch (Exception e) {
			e.printStackTrace();
			return ("");
		}
	}
	
}
