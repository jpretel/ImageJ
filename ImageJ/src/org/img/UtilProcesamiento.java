package org.img;

public class UtilProcesamiento {

	public static int[][] AGris(int[][] matriz) {
		/*
		 * Rojo:30% Verde:59% Azul:11%
		 */
		int x = matriz.length;
		int y = matriz[0].length;
		int gris[][] = new int[x][y];
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {
				int pixel = matriz[i][j];
				int rojo = UtilPixel.getR(pixel);
				int verde = UtilPixel.getG(pixel);
				int azul = UtilPixel.getB(pixel);
				int pixGris = (int) (rojo * .3) + (int) (verde * .59) + (int) (azul * .11);
				gris[i][j] = UtilPixel.getPixel(pixGris, pixGris, pixGris);
			}
		return gris;
	}
	
	public static int[][] ColorAGris(int[][] matriz) {
		/*
		 * Rojo:30% Verde:59% Azul:11%
		 */
		int x = matriz.length;
		int y = matriz[0].length;
		int gris[][] = new int[x][y];
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {
				int pixel = matriz[i][j];
				int rojo = UtilPixel.getR(pixel);
				int verde = UtilPixel.getG(pixel);
				int azul = UtilPixel.getB(pixel);
				int pixGris = (int) (rojo * .3) + (int) (verde * .59) + (int) (azul * .11);
				gris[i][j] = pixGris;
			}
		return gris;
	}
	
	public static boolean[][] AByNBin (int[][] matriz, float umbral){
		if (umbral > 1.0)
			umbral = 1.0F;
		if (umbral < 0)
			umbral = 0.0F;
		int x = matriz.length;
		int y = matriz[0].length;
		boolean bn[][] = new boolean[x][y];
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {
				int pixel = matriz[i][j];
				int rojo = UtilPixel.getR(pixel);
				int verde = UtilPixel.getG(pixel);
				int azul = UtilPixel.getB(pixel);
				if (rojo == verde && verde == azul) {
					bn[i][j]  =  !(rojo >= umbral * 255); // NEGRO = 0 = F, BLANCO = 255 = T
				} else {
					return null;
				}

			}
		return bn;
		
	}
	public static int[][] AByN(int[][] matriz, float umbral) {

		if (umbral > 1.0)
			umbral = 1.0F;
		if (umbral < 0)
			umbral = 0.0F;

		int x = matriz.length;
		int y = matriz[0].length;
		int bn[][] = new int[x][y];
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {
				int pixel = matriz[i][j];
				int rojo = UtilPixel.getR(pixel);
				int verde = UtilPixel.getG(pixel);
				int azul = UtilPixel.getB(pixel);
				if (rojo == verde && verde == azul) {
					int nPixel = (rojo >= umbral * 255) ? 255 : 0;
					bn[i][j] = UtilPixel.getPixel(nPixel, nPixel, nPixel);
				} else {

				}

			}
		return bn;
	}
	
	public static int[][] mascaraConvolucion (int [][]matriz, double[][] mascara){
		final int _x = matriz.length;
		final int _y = matriz[0].length;
		int[][] nMatriz = new int[_x][_y];
		int _long = (mascara.length-1)/2;
		for(int i=0; i< _x;i++){
            for(int j=0; j< _y;j++){
                if((i-_long>=0&&i+_long< _x)&&(j-_long>=0&&j+_long<_y)){
                    double sumX=0;
                    for(int k = i-_long;k<=i+_long;k++)
                        for(int l = j-_long;l<=j+_long;l++){
                            int x = k-i+_long;
                            int y = l-j+_long;
                            int rojo = UtilPixel.getR(matriz[k][l]);
                            sumX=sumX+rojo*mascara[x][y];
                        }
                    final int nPixel =(int) Math.round(Math.abs(sumX));
                    nMatriz[i][j] = UtilPixel.getPixel(nPixel, nPixel, nPixel);
                }
            }
        }
		return nMatriz;
	}
	
	public static int[][] BooleanAPixel (boolean [][] matriz) {
		final int x = matriz.length;
		final int y = matriz[0].length;
		int[][] pixeles = new int[x][y];
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {
				pixeles[i][j] = (matriz[i][j])? UtilPixel.getPixel(0, 0, 0) : UtilPixel.getPixel(255,255,255);
			}
		return pixeles;
	}
}
