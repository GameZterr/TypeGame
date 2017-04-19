package at.htlklu.bitzan;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Button {
	private int x;
	private int y;
	private int width;
	private int height;
	private String path;
	private Image texture;

	public Button(String path, int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.width = 142;
		this.height = 48;
		try {
			this.texture = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println(path);
			e.printStackTrace();
		}
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Image getTexture() {
		return texture;
	}
	public void setTexture(Image texture) {
		this.texture = texture;
	}

}
