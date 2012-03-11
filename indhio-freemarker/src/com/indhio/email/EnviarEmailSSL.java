package com.indhio.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarEmailSSL {

	private static EnviarEmailSSL instance;

	public static EnviarEmailSSL getInstance() {
		if (instance == null) {
			instance = new EnviarEmailSSL();
		}
		return instance;
	}

	private static final String SSL_SMTP_HOST = "smtp.gmail.com";
	private static final String SSL_SMTP_PORT = "465";
	private static final String SSL_EMAIL_LOGIN = "vinicius@indhio.com";
	private static final String SSL_EMAIL_SENHA = "********";

	public void enviar(String para, String assunto, String mensagem) {
		System.out.println("Enviando e-mail SSL... ");
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", SSL_SMTP_HOST);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", SSL_SMTP_PORT);
			props.put("mail.smtp.socketFactory.port", SSL_SMTP_PORT);
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");
			props.put("mail.mime.charset", "ISO-8859-1");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

				// Aqui o authenticator, poderia ser uma classe separada também:
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(SSL_EMAIL_LOGIN, SSL_EMAIL_SENHA);
				}
			});

			// cria a mensagem
			Message msg = new MimeMessage(session);

			// seta remetente
			InternetAddress addressFrom = new InternetAddress(SSL_EMAIL_LOGIN);
			msg.setFrom(addressFrom);

			// seta todos destinatário (possível envio para mais de uma conta)
			InternetAddress addressTo = new InternetAddress(para);

			msg.setRecipient(Message.RecipientType.TO, addressTo);
			msg.setSubject(assunto);
			msg.setContent(mensagem, "text/html");

			msg.saveChanges();
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("...email SSL enviado com sucesso.");
	}

	public static void main(String[] args) {
		EnviarEmailSSL.getInstance().enviar("indhio@gmail.com", "NewsLetter - Indhio Tecnology", " e aqui vai a minha msgggggggggggggggggg.............................. <br><br>***********M<br><br>############");
	}

}
