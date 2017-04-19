package at.htlklu.bitzan;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	private int x;
	private int y;
	private int width;
	private int height;
	private String path;
	private Image texture;
	private Rectangle screen;

	public Background(String path) {
		super();
		this.x = 0;
		this.y = 0;
		this.width = 1920;
		this.height = 1080;
		this.screen = new Rectangle(this.x, this.y, this.width, this.height);
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
	public Rectangle getScreen()
	{
		return this.screen;
	}
	
	

}

