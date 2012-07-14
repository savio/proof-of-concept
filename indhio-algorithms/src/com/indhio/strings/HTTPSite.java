package com.indhio.strings;

public class HTTPSite {
	
	public static void main(String[] args) {
		
		
		//String url = "fdp.aifoS02%ed02%odnuM02%O/8570924091/moc.erahs-ysae.www//:ptth";
		//String url = "6XJR3VCL=d?/moc.daolpuagem.www//:ptth";
		// String url = "d93bl8f43/selif/tp/moc.seliftisoped//:ptth";
		// String url = "7689427/elif/moc.ognodab.www//:ptth";
		String url = "lmth.1775869/moc.erahs-ysae.51w//:ptth";
		System.out.println(url);
		
		char [] letras = new char[url.length()];
		for (int i = 0; i < url.length(); i++) {
			letras[i] = url.charAt(i);
		}
		
		for (int i = 1; i <= url.length(); i++) {
			System.out.print(letras[url.length() - i]);
		}
		
	}

}
