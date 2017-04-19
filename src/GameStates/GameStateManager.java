package GameStates;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Stack;

public class GameStateManager 
{
	private Stack<GameState> gameStates;
	
	public GameStateManager()
	{
		gameStates = new Stack<>();
	}
	
	public void update()
	{
		
	}
	
	public void draw()
	{
		
	}
	
	public void mousePressed(MouseEvent e)
	{
		
	}
	
	public void keyPressed(KeyEvent key)
	{
		
	}
	
	public void push(GameState s)
	{
		this.gameStates.push(s);
	}
	
	public void pop()
	{
		this.gameStates.pop();
	}
	

}
