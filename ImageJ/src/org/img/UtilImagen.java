package org.img;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class UtilImagen {

	public static BufferedImage imageToBufferedImage(Image im) {
		BufferedImage bi = new BufferedImage(im.getWidth(null),
				im.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics bg = bi.getGraphics();
		bg.drawImage(im, 0, 0, null);
		bg.dispose();
		return bi;
	}

	public static Image crearImagen(int alto, int ancho, int[] pixeles) {
		return Toolkit.getDefaultToolkit().createImage(
				new MemoryImageSource(ancho, alto, pixeles, 0, ancho)
			  );
	}
	
	public static void grabarImagen(String ruta, BufferedImage bi) {
		File fichero = new File(ruta);
		String formato = "jpg";

		try {
			
			ImageIO.write(bi, formato, fichero);
			System.out.println("Escribio : " + fichero.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("Error de escritura");
		}
	}

}
