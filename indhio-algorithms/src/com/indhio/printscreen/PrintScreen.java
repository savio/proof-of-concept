package com.indhio.printscreen;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class PrintScreen {

	public static void main(String[] args) {
		try {
			new PrintScreen().takeAPrint();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	public void takeAPrint() throws Exception {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// Definindo a dimensão que quer capturar
		// pode ser definido o tamanho que desejar
		Dimension screenSize = toolkit.getScreenSize();
		Rectangle screenRect = new Rectangle(screenSize);
		// criando o print screen
		Robot robot = new Robot();
		BufferedImage screenCapturedImage = robot.createScreenCapture(screenRect);

		// depois disso é só procurar a imagem no local indicado abaixo, no meu caso em:
		// /Users/rodrigogomes/printScreen.png
		// Aqui você pode alterar o formato da imagem para, por exemplo, JPG
		// É só mudar o “png” para “jpg” e pronto
		ImageIO.write(screenCapturedImage, "png", new File("/Users/indhio/printScreen.png"));

	}

}
