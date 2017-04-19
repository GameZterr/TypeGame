package at.htlklu.bitzan;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.Timer;

import GameStates.GameStateManager;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
	
	public GameStateManager gsm;
	

	//Timer
	public Timer timer = new Timer(10, this);
	
	//StartScreen
	public boolean drawStart = true;
	
	//Difficulty
	//0 = Start, 1 = Easy, 2 = Medium, 3 = Hard
	public boolean drawDifficulty = false;
	public int saveDif = 0;
	
	//Health
	public int health = 0;
	public int healthAnimation = 0;
	
	//Sidebar
	public Image sidebar;
	
	//Mouse
	public int mouseX, mouseY;
	
	//Default Settings
	public boolean drawCoords = false;
	
	//Blocks
	Block block1 = new Block();
	public ArrayList<Block> blocks = new ArrayList<Block>();
	public int blockSpawnCounter = 0;
	
	//Explosions
	Explosion explosion = new Explosion();
	public ArrayList<Explosion> explosions = new ArrayList<Explosion>();
	
	
	//Buttons
	public Button bSOff_s = new Button("res/button_start_off_1.png", 1700, 90);
	public Button bEOff_s = new Button("res/button_exit_off_1.png", 1700, 148);
	public Button bSOn_s = new Button("res/button_start_on_1.png", 1700, 90);
	public Button bEOn_s = new Button("res/button_exit_on_1.png", 1700, 148);
	
	public Button bSOff_b = new Button("res/button_start_off_2.png", 685, 380);
	public Button bSOn_b = new Button("res/button_start_on_2.png", 685, 380);
	public Button bHOff_b = new Button("res/button_help_off_2.png", 685, 528);
	public Button bHOn_b = new Button("res/button_help_on_2.png", 685, 528);
	public Button bEOff_b = new Button("res/button_exit_off_2.png", 685, 676);
	public Button bEOn_b = new Button("res/button_exit_on_2.png", 685, 676);
	
	public Button bEaOff_b = new Button("res/button_easy_off_2.png", 40, 528);
	public Button bEaOn_b = new Button("res/button_easy_on_2.png", 40, 528);
	public Button bMeOff_b = new Button("res/button_medium_off_2.png", 705, 528);
	public Button bMeOn_b = new Button("res/button_medium_on_2.png", 705, 528);
	public Button bHaOff_b = new Button("res/button_hard_off_2.png", 1370, 528);
	public Button bHaOn_b = new Button("res/button_hard_on_2.png", 1370, 528);
	
	public Button bEaDis_b = new Button("res/button_easy_dis_2.png", 40, 528);
	public Button bMeDis_b = new Button("res/button_medium_dis_2.png", 705, 528);
	public Button bHaDis_b = new Button("res/button_hard_dis_2.png", 1370, 528);
	
	public Button bExOff_b = new Button("res/button_extreme_off_2.png", 705, 820);
	public Button bExOn_b = new Button("res/button_extreme_on_2.png", 705, 820);
	
	public Button bROff_b = new Button("res/button_retry_off_2.png", 685, 528);
	public Button bROn_b = new Button("res/button_retry_on_2.png", 685, 528);
	
	//Time
	public int timeSec = 0;
	public int timeMil = 0;
	
	//Score 
	public int score = 0;
	public int score1 = 0;
	public int score2 = 0;
	public int score3 = 0;
	public int score4 = 0;
	
	//Background
	public Background background1_1 = new Background("res/background_3_1.png");
	public Background background1_2 = new Background("res/background_3_2.png");
	public Background background1_3 = new Background("res/background_3_2.png");
	public Background background2 = new Background("res/background_1.png");
	public Background background3 = new Background("res/background_2.png");
	public Background background4 = new Background("res/background_4.png");
	public Background background5 = new Background("res/background_5.png");
	
	//Damage Screen
	public boolean damageScreen = false;
	public int damageScreenCounter=0;
	
	//Game Over
	public boolean drawGameOver = false;
	
	//Help
	public boolean drawHelp = false;
	
	//Save Highscore
	public int highscore1 = 0;
	public int highscore2 = 0;
	public int highscore3 = 0;
	public int highscore4 = 0;
	public boolean gelesen = true;
	public String content;
	public int savescore = 1;
	
	//Enable Modi
	public boolean easyEnabled = true;
	public boolean mediumEnabled = true;
	public boolean hardEnabled = true;
	public boolean extremeEnabled = false;
	
	//Pause
	public boolean pause = false;
	
	
	public GamePanel(){
		background1_3.setX(-1920);
		sidebar = loadImage("res/sidebar_2.png");
		this.addKeyListener(this);
		this.setFocusable(true);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		blocks.add(block1);
		explosions.add(explosion);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if(RandomString.difficulty==0){
			drawBackground(g2, background1_1);
			drawBackground(g2, background1_2);
			drawBackground(g2, background1_3);
		}
		if(RandomString.difficulty==3){
			drawBackground(g2, background3);
		}
		if(RandomString.difficulty==2){
			drawBackground(g2, background4);
		}
		if(RandomString.difficulty==1){
			drawBackground(g2, background2);
		}
		if(RandomString.difficulty==4){
			drawBackground(g2, background5);
		}
		
		if(drawStart){
			g2.drawImage(loadImage("res/title.png"), -35, 0, null);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.PLAIN, 12));
			g.drawString("Created by Michael Bitzan", 10, 1058);
			g.drawString("3BHEL (2016/17)", 10, 1070);
			if(drawCoords){
				g.setColor(Color.WHITE);
				g.setFont(new Font("Arial", Font.PLAIN, 60));
				g.drawString("x= "+mouseX, 100, 100);
				g.drawString("y= "+mouseY, 100, 200);
			}
			if(mouseX>=685&&mouseX<=1194&&mouseY>=380&&mouseY<=508){
				drawButton(g,bSOn_b);
			} else {
			drawButton(g,bSOff_b);
			}
			if(mouseX>=685&&mouseX<=1194&&mouseY>=528&&mouseY<=656){
				drawButton(g,bHOn_b);
			} else {
			drawButton(g,bHOff_b);
			}
			if(mouseX>=685&&mouseX<=1194&&mouseY>=676&&mouseY<=804){
				drawButton(g,bEOn_b);
			} else {
			drawButton(g,bEOff_b);
			}
		} 
		if(drawDifficulty){
			g.setFont(new Font("Arial", Font.PLAIN, 45));
			try {
				if(easyEnabled){
				if(mouseX>=40&&mouseX<=552&&mouseY>=528&&mouseY<=656){
					g.setColor(new Color(0, 228, 39));
				} else {
				g.setColor(new Color(220, 94, 0));
				}
				drawHighscore(g, readHighscore("saves/highscore1.txt"), 80, 480);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(mediumEnabled){
				if(mouseX>=705&&mouseX<=1217&&mouseY>=528&&mouseY<=656){
					g.setColor(new Color(0, 228, 39));
				} else {
					g.setColor(new Color(220, 94, 0));
				}
				drawHighscore(g, readHighscore("saves/highscore2.txt"), 740, 480);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(hardEnabled){
				if(mouseX>=1370&&mouseX<=1882&&mouseY>=528&&mouseY<=656){
					g.setColor(new Color(0, 228, 39));
				} else {
					g.setColor(new Color(220, 94, 0));
				}
				drawHighscore(g, readHighscore("saves/highscore3.txt"), 1410, 480);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(extremeEnabled){
				if(mouseX>=705&&mouseX<=1217&&mouseY>=820&&mouseY<=948){
					g.setColor(new Color(0, 228, 39));
				} else {
				g.setColor(new Color(220, 94, 0));
				}
				drawHighscore(g, readHighscore("saves/highscore4.txt"), 745, 780);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(drawCoords){
				g.setColor(Color.WHITE);
				g.setFont(new Font("Arial", Font.PLAIN, 60));
				g.drawString("x= "+mouseX, 100, 100);
				g.drawString("y= "+mouseY, 100, 200);
			}
			if(easyEnabled){
			if(mouseX>=40&&mouseX<=552&&mouseY>=528&&mouseY<=656){
				drawButton(g,bEaOn_b);
			} else {
			drawButton(g,bEaOff_b);
			}
			} else {
			drawButton(g,bEaDis_b);
			}
			if(mediumEnabled){
			if(mouseX>=705&&mouseX<=1217&&mouseY>=528&&mouseY<=656){
				drawButton(g,bMeOn_b);
			} else {
			drawButton(g,bMeOff_b);
			}
			} else {
				drawButton(g,bMeDis_b);
			}
			if(hardEnabled){
			if(mouseX>=1370&&mouseX<=1882&&mouseY>=528&&mouseY<=656){
				drawButton(g,bHaOn_b);
			} else {
			drawButton(g,bHaOff_b);
			}
			} else {
				drawButton(g,bHaDis_b);
			}
			if(extremeEnabled){
			if(mouseX>=705&&mouseX<=1217&&mouseY>=820&&mouseY<=948){
				drawButton(g,bExOn_b);
			} else {
			drawButton(g,bExOff_b);
			}
			}
		}
			
		if(!drawStart&&!drawDifficulty&&!drawHelp)  {
			
		drawSidebar(g);
		
		for(int i = 0; i<explosions.size();i++){
			drawExplosion(g, explosions.get(i));
		}
		
		for(int i = 0; i<blocks.size();i++)
		{	
			if(blocks.get(i).getHitbox().intersects(background1.getScreen()))
			{
				drawBlock(g, blocks.get(i));				
			}
		}
		
		drawHealth(g);
		
		if(mouseX>=1700&&mouseX<=1842&&mouseY>=90&&mouseY<=138){
			drawButton(g,bSOn_s);
		} else {
		drawButton(g,bSOff_s);
		}
		if(mouseX>=1700&&mouseX<=1842&&mouseY>=148&&mouseY<=196){
			drawButton(g,bEOn_s);
		} else {
		drawButton(g,bEOff_s);
		}
		
		//DrawTime
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		if(timeSec<10){
		g.drawString("0"+timeSec+":"+timeMil, 1710, 500);
		} else{
			g.drawString(timeSec+":"+timeMil, 1710, 500);
		}
		
		//DrawScore
		g2.setFont(new Font("Arial", Font.PLAIN, 45));
		if(score<100){
		g2.drawString(""+score, 1747, 322);
		} 
		if(score>=100){
		g2.drawString(""+score, 1730, 322);
		}
		
		//Draw DamageScreen
		drawDamage(g2);
		
		//Draw GameOver Screen
		if(drawGameOver){
			g2.drawImage(loadImage("res/gameOver.png"), -35, 0, null);
			if(mouseX>=685&&mouseX<=1194&&mouseY>=380&&mouseY<=508){
				drawButton(g,bSOn_b);
			} else {
			drawButton(g,bSOff_b);
			}
			if(mouseX>=685&&mouseX<=1194&&mouseY>=528&&mouseY<=656){
				drawButton(g,bROn_b);
			} else {
			drawButton(g,bROff_b);
			}
			if(mouseX>=685&&mouseX<=1194&&mouseY>=676&&mouseY<=804){
				drawButton(g,bEOn_b);
			} else {
			drawButton(g,bEOff_b);
			}
		}
		}
		//DrawPause
		if(pause){
			drawPauseScreen(g2);
		}
		if(drawHelp){
			g2.drawImage(loadImage("res/help.png"), 0, 0, null);
			if(mouseX>=1700&&mouseX<=1842&&mouseY>=90&&mouseY<=138){
				drawButton(g,bSOn_s);
			} else {
			drawButton(g,bSOff_s);
			}
			if(mouseX>=1700&&mouseX<=1842&&mouseY>=148&&mouseY<=196){
				drawButton(g,bEOn_s);
			} else {
			drawButton(g,bEOff_s);
			}
		}
	}
	
	//Draw Explosions
	public void drawExplosion(Graphics g, Explosion p){
		g.drawImage(p.getExplosionTexture(), p.getExplosionX(), p.getExplosionY(), p.getWidth(), p.getHeight(), null);
	}
	
	//Draw Backgrounds
	public void drawBackground(Graphics g, Background b){
		g.drawImage(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight(), null);
	}
	
	//Draw Healthbar
	public void drawHealth(Graphics g){
		g.setColor(new Color(68,176,59));
		g.setFont(new Font("Arial", Font.PLAIN, 27));
		if(100-(healthAnimation/4)==100){
		g.drawString(""+(100-(healthAnimation/4))+"%", 1788 , 812);
		} else{
			g.drawString(""+(100-(healthAnimation/4))+"%", 1796 , 812);
		}
		g.fillRect(1720, 600+healthAnimation, 50, 400-healthAnimation);
	}
	
	//Draw Sidebars
	public void drawSidebar(Graphics g){
		g.drawImage(sidebar, 1620, 0, null);
	}
	
	//Draw Buttons
	public void drawButton(Graphics g, Button b){
		g.drawImage(b.getTexture(), b.getX(), b.getY(), null);
	}
	
	//Draw Bloodscreen
	public void drawDamage(Graphics g){
		if(damageScreen&&!drawGameOver){
	    Composite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .4f);
	    ((Graphics2D) g).setComposite(c);
	    g.setColor(Color.RED);
	    g.fillRect(0, 0, 1920, 1080);
	    if(damageScreenCounter==5){
	    damageScreen = false;
	    damageScreenCounter=0;
	    }
		}
	}
	
	//Draw Highscore in Difficulty
	public void drawHighscore(Graphics g, int points, int x, int y){
		g.drawString("Current Highscore: "+points, x, y);
	}
	
	//DrawPause
	public void drawPauseScreen(Graphics g){
		    Composite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .6f);
		    ((Graphics2D) g).setComposite(c);
		    g.setColor(Color.GRAY);
		    g.fillRect(0, 0, 1920, 1080);
		    g.setColor(Color.RED);
		    g.fillRect(840, 350, 35, 180);
		    g.fillRect(900, 350, 35, 180);
	}
	
	
	//Timer
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(drawStart||drawDifficulty){
		background1_2.setX(background1_2.getX()+1);
		background1_3.setX(background1_3.getX()+1);
		if(background1_2.getX()==1920){
			background1_2.setX(0);
			background1_3.setX(-1920);
			}
		}
		if(!drawStart&&!drawDifficulty&&!drawHelp){
			timeMil+=1;
			if(damageScreen){
				damageScreenCounter++;
			}
			if(timeMil>=100){
				timeMil=0;
				timeSec++;
				blockSpawnCounter++;
			}
			if(blockSpawnCounter>=10){
				blockSpawnCounter=0;
				Block block = new Block();
				blocks.add(block);	
			}
			for(int i = 0; i<blocks.size();i++){
				blocks.get(i).move();
				if(blocks.get(i).getY()>1080){
					blocks.set(i, new Block());
					healthAnimation+=50;
					damageScreen=true;
					play("sounds/hurt.wav");
					if(100-(healthAnimation/4)<0){
					gameOver();
					}
				}
			}
		}
		
		repaint();
		pause=false;
	}

	@Override
	public void keyPressed(KeyEvent key) {
		if(!drawStart&&!drawGameOver&&!drawDifficulty&&!drawHelp){
		switch(key.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			if(timer.isRunning()){
			pause = true;
			timer.stop();
			repaint();
			} else {
				timer.start();
			}
			break;
		default:
			break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//Keylistener
	@Override
	public void keyTyped(KeyEvent key) {
		if(!drawStart&&!drawDifficulty&&!drawGameOver&&!pause&&!drawHelp){
//		if(key.getKeyChar()=='A'){
//			Block block = new Block();
//			blocks.add(block);
//		}
		char pressed = key.getKeyChar();
		String tester = ""+pressed;
		for(int i = 0; i<blocks.size();i++){
			if(tester.equals(blocks.get(i).getText())&&blocks.get(i).getY()>=0-blocks.get(i).getSizeY()){
				Explosion explosion = new Explosion();
				explosions.get(i).explode(blocks.get(i).getX(), blocks.get(i).getY(), blocks.get(i).getSizeX(), blocks.get(i).getSizeY());
				explosions.add(explosion);
				blocks.set(i, new Block());
				play("sounds/explosion.wav");
				score++;
				break;
			}
			if(pause){
				break;
			}
			if(i+1==blocks.size()){
				healthAnimation+=7;
				play("sounds/hurt.wav");
				damageScreen=true;
				if(100-(healthAnimation/4)<0){
				gameOver();	
				}
			}
		}
		}
		
	}
	
	//Set the Game to "GameOver"
	public void gameOver(){
		drawGameOver = true;
		repaint();
		if(RandomString.difficulty==1){
			score1=score;
		try {
			updateHighscore("saves/highscore1.txt", score1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(RandomString.difficulty==2){
			score2=score;
		try {
			updateHighscore("saves/highscore2.txt", score2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(RandomString.difficulty==3){
			score3=score;
		try {
			updateHighscore("saves/highscore3.txt", score3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(RandomString.difficulty==4){
			score4=score;
		try {
			updateHighscore("saves/highscore4.txt", score4);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		healthAnimation=400;
		timer.stop();
		//reset();
	}
	
	//Resets the Game
	public void reset(){
		blocks.clear();
		block1 = new Block();
		blocks.add(block1);
		explosions.clear();
		explosion = new Explosion();
		explosions.add(explosion);
		timeMil = 0;
		timeSec = 0;
		healthAnimation = 0;
		score = 0;
		damageScreen = false;
		damageScreenCounter=0;
		RandomString.difficulty=0;
		timer.start();
		drawGameOver=false;
	}
	
	//Load Sounds in the Game
	public Image loadImage(String fileName) {
		Image image = null;
		try{
			image = ImageIO.read(new File(fileName));
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
	return image;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX= e.getX();
		mouseY= e.getY();
		repaint();
		
	}
	
	public static void play(String filename)
	{
	    try
	    {
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(new File(filename)));
	        clip.start();
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
	}
	public void updateHighscore(String path, int points) throws IOException{
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(path, true));
			int highscore = readHighscore(path);
			if(points>highscore){
			writer = new PrintWriter(path);
			writer.print(points);
			writer.flush();
		}
		}
			catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int readHighscore(String path) throws IOException{
		FileReader fr;
		try {
			fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			PrintWriter writer = new PrintWriter(new FileWriter(path, true));
			content = new String(Files.readAllBytes(Paths.get(path)));
			if(Integer.parseInt(content)>150){
				extremeEnabled=true;
			}
			return Integer.parseInt(content);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getButton()==MouseEvent.BUTTON1&&event.getClickCount()==1){
		}
		if(!drawStart&&!drawDifficulty){
		if(mouseX>=1700&&mouseX<=1842&&mouseY>=90&&mouseY<=138){
			if(!drawStart&&!drawDifficulty&&!drawHelp){
				play("sounds/button.wav");
			drawStart=true;
			reset();
			}
			if(drawHelp){
				play("sounds/button.wav");
				drawHelp=false;
				drawStart = true;
			}
		}
		if(mouseX>=1700&&mouseX<=1842&&mouseY>=148&&mouseY<=196){
			play("sounds/button.wav");
			System.exit(0);
		}
		}
		if(mouseX>=685&&mouseX<=1194&&mouseY>=676&&mouseY<=804){
			if(drawStart||drawGameOver){
				play("sounds/button.wav");
			System.exit(0);
			}
		}
		
		if(mouseX>=685&&mouseX<=1194&&mouseY>=528&&mouseY<=656){
			if(drawGameOver){
				play("sounds/button.wav");
				saveDif = RandomString.difficulty;
				reset();
				RandomString.difficulty = saveDif;
			}
			if(drawStart){
				play("sounds/button.wav");
				drawStart=false;
				drawHelp=true;
			}
		} 
		if(mouseX>=685&&mouseX<=1194&&mouseY>=380&&mouseY<=508){
			if(drawStart){
				play("sounds/button.wav");
			drawStart=false;
			drawDifficulty=true;
			} else if(drawGameOver){
				play("sounds/button.wav");
				drawStart=true;
				reset();
			}
		}
		if(drawDifficulty){
		if(mouseX>=40&&mouseX<=552&&mouseY>=528&&mouseY<=656&&easyEnabled){
			play("sounds/button.wav");
			play("sounds/gameStart.wav");
			drawDifficulty=false;
			RandomString.difficulty=1;
		}
		if(mouseX>=705&&mouseX<=1217&&mouseY>=528&&mouseY<=656&&mediumEnabled){
			play("sounds/button.wav");
			play("sounds/gameStart.wav");
			drawDifficulty=false;
			RandomString.difficulty=2;
			Block block = new Block();
			blocks.add(block);
			Explosion explosion = new Explosion();
			explosions.add(explosion);
		}
		if(mouseX>=1370&&mouseX<=1882&&mouseY>=528&&mouseY<=656&&hardEnabled){
			play("sounds/button.wav");
			play("sounds/gameStart.wav");
			drawDifficulty=false;
			RandomString.difficulty=3;
			Block block = new Block();
			blocks.add(block);
			Block block2 = new Block();
			blocks.add(block2);
			Explosion explosion2 = new Explosion();
			explosions.add(explosion);
			Explosion explosion = new Explosion();
			explosions.add(explosion2);
		}
		if(mouseX>=705&&mouseX<=1217&&mouseY>=820&&mouseY<=948&&extremeEnabled){
			play("sounds/button.wav");
			play("sounds/gameStart.wav");
			drawDifficulty=false;
			RandomString.difficulty=4;
			Block block = new Block();
			blocks.add(block);
			Block block2 = new Block();
			blocks.add(block2);
			Block block3 = new Block();
			blocks.add(block3);
			Block block4 = new Block();
			blocks.add(block4);
			Explosion explosion2 = new Explosion();
			explosions.add(explosion2);
			Explosion explosion = new Explosion();
			explosions.add(explosion);
			Explosion explosion3 = new Explosion();
			explosions.add(explosion3);
			Explosion explosion4 = new Explosion();
			explosions.add(explosion4);
			healthAnimation=200;
		}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		//drawCoords=true;
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		drawCoords=false;
		
	}

}
