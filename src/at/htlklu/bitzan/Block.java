package at.htlklu.bitzan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Block implements Constants{
	private int x;
	private int y;
	private int sizeX;
	private int sizeY;
	private String text;
	private Image texture;
	private int speed;
	private Rectangle hitbox;
	private String path;
	private RandomTexture ts = new RandomTexture();  
	private RandomString rs = new RandomString();
	private Random r = new Random();
	
	public Block() {
		this.path = ts.generate();
		this.y = -600;
		this.sizeY = r.nextInt(MAX_SIZE)+100;
		this.sizeX = sizeY; 
		this.x = r.nextInt(1620-sizeX);
		this.text = rs.generate();
		try {
			this.texture = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println(path);
			e.printStackTrace();
		}
		this.speed = r.nextInt(MAX_SPEED)+1;
		this.hitbox = new Rectangle(this.x,this.y, this.sizeX, this.sizeY);
	}
	public void move(){
		this.y+=this.speed;
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

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Image getTexture() {
		return texture;
	}

	public void setTexture(Image texture) {
		this.texture = texture;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Rectangle getHitbox() {
		return hitbox;
	}

	public void setHitbox(Rectangle hitbox) {
		this.hitbox = hitbox;
	}
	
	public void draw(Graphics g2D)
	{
		g2D.setFont(new Font("Arial", Font.PLAIN, 60));
		g2D.drawImage(this.texture, this.x, this.y, this.sizeY, this.sizeX, null);
		g2D.setColor(Color.WHITE);
		g2D.drawString(this.text, this.x+(this.sizeX/8*3), this.y+(this.sizeY)/8*6);
	}
	
	
}
