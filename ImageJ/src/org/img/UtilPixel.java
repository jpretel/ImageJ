package org.img;

public class UtilPixel {

	public static int getR(int p) {
		return (0xff & (p >> 16));
	}
	public static int getG(int p) {
		return (0xff & (p >> 8));
	}
	public static int getB(int p) {
		return (0xff & (p));
	}

	public static int getPixel(int r, int g, int b) {
		return 0xff000000 | r << 16 | g << 8 | b;
	}
}
