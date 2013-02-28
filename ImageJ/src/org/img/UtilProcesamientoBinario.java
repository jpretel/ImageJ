package org.img;

public class UtilProcesamientoBinario {
	// Dilatación
	public static boolean[][] dilatacion(boolean[][] matriz,
			final boolean[][] mascara) {
		final int x = matriz.length;
		final int y = matriz[0].length;
		boolean[][] dilatado = new boolean[x][y];
		int _x = mascara.length;
		int _y = mascara[0].length;
		int m_x = (_x % 2 == 0) ? _x / 2 : _x / 2 + 1;
		int m_y = (_y % 2 == 0) ? _y / 2 : _y / 2 + 1;

		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {
				if ((i < m_x || i > x - (_x - m_x))
						|| (j < m_y || j >= y - (_y - m_y))) {
					dilatado[i][j] = matriz[i][j];
				} else {
					boolean aux = false;
					for (int k = m_x - _x; k < m_x; k++)
						for (int l = m_y - _y; l < m_y; l++) {
							if (mascara[k + m_x - 1][l + m_y - 1]) {
								aux = aux || matriz[i + k][j + l];
							}
						}
					dilatado[i][j] = aux;
				}
			}
		return dilatado;
	}

	// EROCION
	public static boolean[][] erocion(boolean[][] matriz,
			final boolean[][] mascara) {
		final int x = matriz.length;
		final int y = matriz[0].length;
		boolean[][] dilatado = new boolean[x][y];
		int _x = mascara.length;
		int _y = mascara[0].length;
		int m_x = (_x % 2 == 0) ? _x / 2 : _x / 2 + 1;
		int m_y = (_y % 2 == 0) ? _y / 2 : _y / 2 + 1;

		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {
				if ((i < m_x || i > x - (_x - m_x))
						|| (j < m_y || j >= y - (_y - m_y))) {
					dilatado[i][j] = matriz[i][j];
				} else {
					boolean aux = true;
					for (int k = m_x - _x; k < m_x; k++)
						for (int l = m_y - _y; l < m_y; l++) {
							if (mascara[k + m_x - 1][l + m_y - 1]) {
								aux = aux && matriz[i + k][j + l];
							}
						}
					dilatado[i][j] = aux;
				}
			}
		return dilatado;
	}

	public static boolean[][] ZhangSuen(boolean[][] matriz) {
		final int x = matriz.length;
		final int y = matriz[0].length;
		boolean[][] esqueleto = new boolean[x][y];
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {
				if (i < 1 || i == x - 1 || j < 1 || j == y - 1 || !matriz[i][j]) {
					matriz[i][j] = false;
				} else {
					/*
					 * FASE 1
					 */
					int band = 0;
					int cont = 0;
					for (int k = -1; k <= 1; k++)
						for (int l = -1; l <= 1; l++) {
							if (matriz[i + k][j + l])
								cont++;
						}
					cont--;

					if (cont >= 2 && cont <= 6)
						band++;

					if (!matriz[i - 1][j] || !matriz[i][j + 1]
							|| !matriz[i + 1][j])
						band++;

					if (!matriz[i][j + 1] || !matriz[i + 1][j]
							|| !matriz[i][j - 1])
						band++;

					cont = 0;
					if (!matriz[i - 1][j] && matriz[i - 1][j + 1])
						cont++;

					if (!matriz[i - 1][j + 1] && matriz[i][j + 1])
						cont++;

					if (!matriz[i][j + 1] && matriz[i + 1][j + 1])
						cont++;

					if (!matriz[i + 1][j + 1] && matriz[i + 1][j])
						cont++;

					if (!matriz[i + 1][j] && matriz[i + 1][j - 1])
						cont++;

					if (!matriz[i + 1][j - 1] && matriz[i][j - 1])
						cont++;

					if (!matriz[i][j - 1] && matriz[i - 1][j - 1])
						cont++;

					if (!matriz[i - 1][j - 1] && matriz[i - 1][j])
						cont++;
					if (cont == 1)
						band++;

					esqueleto[i][j] = !(band == 4);

				}
			}

		matriz = esqueleto;
		esqueleto = new boolean[x][y];
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {
				if (i < 1 || i == x - 1 || j < 1 || j == y - 1 || !matriz[i][j]) {
					matriz[i][j] = false;
				} else {
					/*
					 * FASE 2
					 */
					int band = 0;
					int cont = 0;
					for (int k = -1; k <= 1; k++)
						for (int l = -1; l <= 1; l++) {
							if (matriz[i + k][j + l])
								cont++;
						}
					cont--;

					if (cont >= 2 && cont <= 6)
						band++;

					if (!matriz[i][j - 1] || !matriz[i - 1][j]
							|| !matriz[i][j + 1])
						band++;

					if (!matriz[i + 1][j] || !matriz[i][j - 1]
							|| !matriz[i - 1][j])
						band++;

					cont = 0;
					if (!matriz[i - 1][j] && matriz[i - 1][j + 1])
						cont++;

					if (!matriz[i - 1][j + 1] && matriz[i][j + 1])
						cont++;

					if (!matriz[i][j + 1] && matriz[i + 1][j + 1])
						cont++;

					if (!matriz[i + 1][j + 1] && matriz[i + 1][j])
						cont++;

					if (!matriz[i + 1][j] && matriz[i + 1][j - 1])
						cont++;

					if (!matriz[i + 1][j - 1] && matriz[i][j - 1])
						cont++;

					if (!matriz[i][j - 1] && matriz[i - 1][j - 1])
						cont++;

					if (!matriz[i - 1][j - 1] && matriz[i - 1][j])
						cont++;
					if (cont == 1)
						band++;

					esqueleto[i][j] = !(band == 4);

				}
			}
		return esqueleto;
	}

	public static void extraccionMinucias(boolean[][] m) {

		final int x = m.length;
		final int y = m[0].length;

		for (int i = 1; i < x -1; i++)
			for (int j = 1; j < y -1; j++) {
				int [] dif = new int[8];
				dif[0] = Math.abs(bToBin(m[i][j+1]) - bToBin(m[i-1][j+1])); //1_2
				dif[1] = Math.abs(bToBin(m[i-1][j+1]) - bToBin(m[i-1][j])); //2_3
				dif[2] = Math.abs(bToBin(m[i-1][j]) - bToBin(m[i-1][j-1])); //3_4
				dif[3] = Math.abs(bToBin(m[i-1][j-1]) - bToBin(m[i][j-1])); //4_5
				dif[4] = Math.abs(bToBin(m[i][j-1]) - bToBin(m[i+1][j-1])); //5_6
				dif[5] = Math.abs(bToBin(m[i+1][j-1]) - bToBin(m[i+1][j])); //6_7
				dif[6] = Math.abs(bToBin(m[i+1][j]) - bToBin(m[i+1][j+1])); //7_8
				dif[7] = Math.abs(bToBin(m[i+1][j+1]) - bToBin(m[i][j+1])); //8_9
				
				int sum = 0;
				for (int k = 0; k < dif.length ; k++ ){
					sum += dif[i];
				}
				
				
			}

	}

	public static int bToBin(boolean b) {
		return (b) ? 1 : 0;
	}
}
