package org.img;

public class UtilProcesamientoGris {
	
	public static int[] contraste(int[][] matriz) {
		int[] contraste = new int[255];
		final int _x = matriz.length;
		final int _y = matriz[0].length;
		for (int i = 0; i < _x; i++) {
			for (int j = 0; j < _y; j++) {
				contraste[matriz[i][j]]++;
			}
		}
		return contraste;
	}
}
