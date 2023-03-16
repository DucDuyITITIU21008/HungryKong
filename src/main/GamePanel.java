package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	
	final int originalTileSize = 16;
	final int scale = 3 ;
	
	final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	//Set player's default position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	//This is GamePanel
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
public void startgameThread() {
	gameThread = new Thread(this);
	gameThread.start();
}
	@Override
	public void run() { 
		while(gameThread != null){
			update();
			repaint();
		}
	}
			
		public void update (){
			
		}
		public void paintComponent(Graphic g){
			super.paintComponent(g);
			
			Graphics2D g2 = (Graphics2D)g;
			
			g2.setcolor(Color.white);
			
			g2.fillRect(playerX,playerY,tileSize,tileSize);
			
			g2.dispose();
		}

}
