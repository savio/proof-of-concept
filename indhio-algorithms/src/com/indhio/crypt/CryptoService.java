package com.indhio.crypt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public final class CryptoService {
	private static CryptoService _object;
	static {
		try {
			_object = new CryptoService();
		} catch (CryptoServiceException e) {
			e.printStackTrace();
		}
	}
	private static final char[] KEYS = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '?' };
	private Cipher cipher;

	private CryptoService() throws CryptoServiceException {
		try {
			cipher = Cipher.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new CryptoServiceException(e);
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			throw new CryptoServiceException(e);
		}
	}

	synchronized public static CryptoService getInstance() throws CryptoServiceException {
		if (_object == null)
			return new CryptoService();

		return _object;
	}

	synchronized public byte[] encriypt(String text, String senha) throws EncryptionException {
		byte[] retValue;

		try {
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(senha.getBytes(), "DES"));
			retValue = new BASE64Encoder().encode(cipher.doFinal(text.getBytes("UTF-8"))).getBytes();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			throw new EncryptionException(e);
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
			throw new EncryptionException(e);
		} catch (BadPaddingException e) {
			e.printStackTrace();
			throw new EncryptionException(e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new EncryptionException(e);
			// } catch (KeyGeneratorException e) {
			// e.printStackTrace();
			// throw new EncryptionException(e);
		}

		return retValue;
	}

	synchronized public byte[] decrypt(String key, String text) throws DecryptionException {
		byte retValue[] = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "DES"));
			retValue = cipher.doFinal(new BASE64Decoder().decodeBuffer(text));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			throw new DecryptionException(e);
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
			throw new DecryptionException(e);
		} catch (BadPaddingException e) {
			e.printStackTrace();
			throw new DecryptionException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new DecryptionException(e);
		}
		return retValue;
	}

	synchronized private byte[] getKey() throws KeyGeneratorException {
		StringBuffer buffer = new StringBuffer();
		byte[] retValue = null;

		Random r = new Random();
		int length = KEYS.length - 1;
		for (int i = 0; i < 8; i += 2) {
			buffer.append(KEYS[r.nextInt(length)]);
			buffer.append(KEYS[r.nextInt(length)]);
		}

		try {
			retValue = buffer.toString().getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new KeyGeneratorException(e);
		}

		return retValue;
	}

	public static void main(String[] args) throws CryptoServiceException, EncryptionException, DecryptionException {
		try {
			CryptoService cs = CryptoService.getInstance();

			// Data;Nro_Usuarios;Prova_conceito(0-nao, 1-Sim);tipoIntegracao(0 - Somente Channel; 1 Somente Operacoes; 2 - Channel e Operacoes);Nro_licencas;Nro_clientes
			// String textoCifrado = new String(cs.encriypt("10/05/2009;999;0;2;1;999", "jxp00015"));
			// String textoCifrado = new String(cs.encriypt("2;operacao.do?action=direcionar&key=3&destino=ticketAcompanhar&chave=178&origem=home", "jchannel"));
			// System.out.println(" Texto cifrado  : " + textoCifrado);
			// System.out.println(" Texto decifrado  : " + new String(cs.decrypt("jxp00015", textoCifrado)));

			String textoCifrado = "";
			System.out.println(" Texto decifrado  : " + new String(cs.decrypt("jxp00015", textoCifrado)));
			System.out.println(" Texto decifrado  : " + new String(cs.decrypt("jxp00015", textoCifrado)));

			// 31/12/2010;20;0;0;1
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String inversao() {

		String url = "fdp.aifoS02%ed02%odnuM02%O/8570924091/moc.erahs-ysae.www//:ptth";
		System.out.println(url);

		char[] letras = new char[url.length()];
		for (int i = 0; i < url.length(); i++) {
			letras[i] = url.charAt(i);
		}

		for (int i = 1; i <= url.length(); i++) {
			System.out.print(letras[url.length() - i]);
		}
		return null;

	}

}
