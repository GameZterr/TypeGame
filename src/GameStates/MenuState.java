package GameStates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import at.htlklu.bitzan.Background;

public class MenuState extends GameState
{
	public static Background background1_1 = new Background("res/background_3_1.png");
	public static Background background1_2 = new Background("res/background_3_2.png");
	public static Background background1_3 = new Background("res/background_3_2.png");

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g2D) {
		g2D.drawImage(background1_1.getTexture(), background1_1.getX(), background1_1.getY(), background1_1.getWidth(), background1_1.getHeight(), null);
		g2D.drawImage(background1_2.getTexture(), background1_2.getX(), background1_2.getY(), background1_2.getWidth(), background1_2.getHeight(), null);
		g2D.drawImage(background1_3.getTexture(), background1_3.getX(), background1_3.getY(), background1_3.getWidth(), background1_3.getHeight(), null);
		
	}

	@Override
	public void keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEvent(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
