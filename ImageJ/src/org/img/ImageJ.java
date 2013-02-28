package org.img;

import java.awt.Canvas;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;

import javax.swing.ImageIcon;

public class ImageJ {
	private Image imagen;
	private int alto;
	private int ancho;
	private BufferedImage imagenBuff;
	private int[] pixeles;

	/**
	 * CONSTRUCTORES
	 */

	public ImageJ() {
		setImagen(Toolkit.getDefaultToolkit().getImage("imagen.jpg"));
		initMediaTracker();
		obtenerPixeles();
	}

	public ImageJ(String url) {
		setImagen(Toolkit.getDefaultToolkit().getImage(url));
		initMediaTracker();
		obtenerPixeles();
	}

	private void obtenerPixeles() {
		int iniAncho = getAncho();
		int iniAlto = getAlto();
		int[] pix = new int[iniAncho * iniAlto];
		try {
			new PixelGrabber(getImagen(), 0, 0, iniAncho, iniAlto, pix, 0,
					iniAncho).grabPixels();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setPixeles(pix);
	}

	private void initMediaTracker() {
		MediaTracker tracker = new MediaTracker(new Canvas());
		tracker.addImage(getImagen(), 1);
		try {
			if (!tracker.waitForID(1, 10000)) {
				System.out.println("Error en la carga de la imagen");
				System.exit(1);
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		setAlto(getImagen().getHeight(null));
		setAncho(getImagen().getWidth(null));
		Coversion C = new Coversion();
		setImagenBuff(C.toBufferedImage(getImagen()));
	}

	/*
	 * SETERS AND GETERS
	 */

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public BufferedImage getImagenBuff() {
		return imagenBuff;
	}

	public void setImagenBuff(BufferedImage imagenBuff) {
		this.imagenBuff = imagenBuff;
	}

	public void setPixeles(int[] pixeles) {
		this.pixeles = pixeles;
	}

	public int[] getPixeles() {

		return this.pixeles;
	}

	public class Coversion {

		BufferedImage toBufferedImage(Image image) {
			if (image instanceof BufferedImage) {
				return ((BufferedImage) image);
			} else {
				image = new ImageIcon(image).getImage();
				BufferedImage bufferedImage = new BufferedImage(
						image.getWidth(null), image.getHeight(null),
						BufferedImage.TYPE_4BYTE_ABGR);
				return (bufferedImage);
			}
		}
	}
	

}
