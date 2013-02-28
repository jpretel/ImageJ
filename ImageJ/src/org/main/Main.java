package org.main;
import java.awt.Image;
import java.awt.image.BufferedImage;

import org.img.ImageJ;
import org.img.UtilImagen;
import org.img.UtilMatriz;
import org.img.UtilProcesamiento;
import org.img.UtilProcesamientoBinario;

public class Main {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		double[][] mascara = { { 1 / 9.0, 1 / 9.0, 1 / 9.0 },
				{ 1 / 9.0, 1 / 9.0, 1 / 9.0 }, { 1 / 9.0, 1 / 9.0, 1 / 9.0 } };
		

		String urls2 = "h1.png";
		ImageJ im = new ImageJ(urls2);
		long a = System.currentTimeMillis();
		String url = "h0.png";

		int[][] m_ = UtilProcesamiento.AGris(UtilMatriz.getMatriz(im.getAlto(),
				im.getAncho(), im.getPixeles()));

		int[][] suvisado = UtilProcesamiento.mascaraConvolucion(m_, mascara);
		
		//int[] 
		
		//int[] contraste = UtilProcesamientoGris.contraste(suvisado);
		
		//for(int i = 0; i<contraste.length ; i++)
		//	System.out.println(contraste[i]);
		
		boolean[][] dilMasc = { { true, true, true } };

		boolean[][] bin = UtilProcesamiento.AByNBin(suvisado, 0.6F);

		boolean[][] dil = UtilProcesamientoBinario.dilatacion(bin, dilMasc);

		//boolean[][] zs = new ZhangSuen(bin).iniciar();

		boolean[][] zs = UtilProcesamientoBinario.ZhangSuen(dil);


		for (int i = 0; i < 60; i++) {
			zs = UtilProcesamientoBinario.ZhangSuen(zs);
		}

		/*for (int i = 0; i < 20; i++) {
			for (int j = 0; j < zs[0].length; j++) {
				System.out.print(bin[i][j] + "\t");
			}
			System.out.println();
		}*/

		// int[][] m = UtilProcesamiento.AByN(suvisado, 0.6F);

		// int[] p = UtilMatriz.getVector(m);

		// int[][] mat = UtilProcesamiento.BooleanAPixel(dil);

		int[][] mat = UtilProcesamiento.BooleanAPixel(zs);

		int[] p = UtilMatriz.getVector(mat);

		Image img = UtilImagen.crearImagen(im.getAlto(), im.getAncho(), p);

		BufferedImage bi = UtilImagen.imageToBufferedImage(img);
		UtilImagen.grabarImagen(url, bi);
		long b = System.currentTimeMillis();

		System.out.println("Tiempo de ejecución: " + (b - a)
				+ " milisegundos aprox.");
		System.out.println("Alto: " + im.getAlto() + ", Ancho: "
				+ im.getAncho());

	}
}

class bandera {
	private int x;

	public bandera() {
		x = 0;
	}

	public void set(int x) {
		this.x = x;
	}

	public int get() {
		return x;
	}
}
