package at.htlklu.bitzan;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {

	private JPanel contentPane;
	private GamePanel gamePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setAlwaysOnTop(true);
					frame.setResizable(false);
					Toolkit tk = Toolkit.getDefaultToolkit();
					int xSize = ((int) tk.getScreenSize().getWidth());
					int ySize = ((int) tk.getScreenSize().getHeight());
					frame.setSize(xSize,ySize);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		GamePanel gamePanel = new GamePanel();
		contentPane.add(gamePanel, BorderLayout.CENTER);
		gamePanel.timer.start();
		gamePanel.setFont(new Font("Arial", Font.PLAIN, 60));
	}

}
