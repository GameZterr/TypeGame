package GameStates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class GameState {
	public abstract void update();
	
	public abstract void draw(Graphics g2D);
	
	public abstract void keyPressed(KeyEvent key);
	
	public abstract void mouseEvent(MouseEvent e);

}
