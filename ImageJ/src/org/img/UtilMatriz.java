package org.img;

public class UtilMatriz {

	public static int[][] getMatriz(int alto, int ancho, int vector[]) {
		System.out.println(alto);
		int[][] nMatriz = new int[alto][ancho];
		for (int i = 0; i < alto; i++)
			for (int j = 0; j < ancho; j++)
				nMatriz[i][j] = vector[i * ancho + j];
		//System.out.println(nMatriz[100][100]);
		return nMatriz;
	}

	public static int[] getVector(int[][] matriz) {
		int x = matriz.length;
		int y = matriz[0].length;
		int[] vector = new int[x * y];
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++)
				vector[i * y + j] = matriz[i][j];
		return vector;
	}

}
