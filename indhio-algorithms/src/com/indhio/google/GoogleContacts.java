package com.indhio.google;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class GoogleContacts {

	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("/Users/indhio/Downloads/emails.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader in = new BufferedReader(fileReader);
		String line = in.readLine();
		System.out.println(line);

		HashMap<String, String> map = new HashMap<String, String>();
		StringTokenizer st = new StringTokenizer(line, ",");
		while (st.hasMoreTokens()) {
			String contato = st.nextToken();
			System.out.println(">> " + contato);
			if (contato != null && !contato.trim().equals("") && contato.length() > 0) {
				String key = contato.substring(0, contato.indexOf("<"));
				String value = contato.substring(contato.indexOf("<"), contato.length());
				value = value.replace("<", "").replace(">", "");
				map.put(key, value);
			}
		}

		System.out.println(map);

		for (String email : map.values()) {
			if (email.indexOf("@gmail.") != -1) {
				System.out.print(email);
				System.out.print(",");
			}
		}

	}
}
