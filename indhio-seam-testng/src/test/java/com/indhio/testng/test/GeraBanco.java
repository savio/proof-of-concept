package com.indhio.testng.test;

import javax.persistence.Persistence;


public class GeraBanco {

	public static void main(String[] args) throws Exception {
		Persistence.createEntityManagerFactory("IndhioTestNGPU");
	}
	
}
