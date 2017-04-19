package at.htlklu.bitzan;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Explosion {
	private int explosionTimer;
	private boolean explosion = false;
	private Image explosionTexture;
	private int explosionX = 1;
	private int explosionY = 1;
	private int width = 1;
	private int height = 1;
	private static Image[] sprites;
	
	static
	{
		sprites = new Image[11];
		for(int i = 0; i<sprites.length; i++)
		{
			try {
				sprites[i] = ImageIO.read(new File("res/exp1_"+(i+1)+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public Explosion() 
	{
		
	}
	public void explode(int x, int y, int width, int height)
	{
		this.explosionX= x;
		this.explosionY= y;
		this.width = width;
		this.height = height;
		explosion=true;
	}	
	public int getExplosionX() {
		return explosionX;
	}

	public void setExplosionX(int explosionX) {
		this.explosionX = explosionX;
	}

	public int getExplosionY() {
		return this.explosionY;
	}

	public void setExplosionY(int explosionY) {
		this.explosionY = explosionY;
	}
	public Image getExplosionTexture() {
		return explosionTexture;
	}

	public void setExplosionTexture(Image explosionTexture) {
		this.explosionTexture = explosionTexture;
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
	
	public void update() {
		if(explosion){
		explosionTimer++;
		}
		if(explosionTimer==3){
			try {
				this.explosionTexture = ImageIO.read(new File("res/exp1_1.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(explosionTimer==6){
			try {
				this.explosionTexture = ImageIO.read(new File("res/exp1_2.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(explosionTimer==9){
			try {
				this.explosionTexture = ImageIO.read(new File("res/exp1_3.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(explosionTimer==12){
			try {
				this.explosionTexture = ImageIO.read(new File("res/exp1_4.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(explosionTimer==15){
			try {
				this.explosionTexture = ImageIO.read(new File("res/exp1_5.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(explosionTimer==18){
			try {
				this.explosionTexture = ImageIO.read(new File("res/exp1_6.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(explosionTimer==21){
			try {
				this.explosionTexture = ImageIO.read(new File("res/exp1_7.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(explosionTimer==24){
			try {
				this.explosionTexture = ImageIO.read(new File("res/exp1_8.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(explosionTimer==28){
			try {
				this.explosionTexture = ImageIO.read(new File("res/exp1_9.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(explosionTimer==31){
			try {
				this.explosionTexture = ImageIO.read(new File("res/exp1_10.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(explosionTimer==34){
			try {
				this.explosionTexture = ImageIO.read(new File("res/exp1_11.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			explosionTimer=0;
			explosion=false;
		}
	}
	
}
