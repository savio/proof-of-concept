package com.indhio.expressaoregular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressaoRegular {
	
	public static void main(String[] args) {
		String letra = "C";
		Pattern pattern = Pattern.compile("[A|E|I|O|U|C]");
		Matcher matcher = pattern.matcher(letra);
		String l = null;
		while(matcher.find()) {
			l = matcher.group();
		}
		System.out.println(l);
	}

}
