package Main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import CelestialBodies.Planet;
import CelestialBodies.Star;

public class ProgramExecution extends JPanel {
	private static final long serialVersionUID = 4285965111539342910L;
	final static int DELAY = 50; 

	Panel panel;
	Planet[] planetsList = new Planet[8];
	Star sun;

	double size = 1;
	double panX = 1;
	double panY = 1;
	boolean isApplicationPaused = false;

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double screenWidth = screenSize.getWidth();
	double screenHeight = screenSize.getHeight();
	Image backgroundImage;

	public ProgramExecution()
	{
		panel = new Panel();
		panel.setPreferredSize(new Dimension((int)screenWidth, (int)screenHeight));
		add(panel);

		setBackground(Color.BLACK);
		try {
			backgroundImage = ImageIO.read(new File("resources/background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		sun = new Star(600, 400, .1, 0, 1000, 30, Color.ORANGE, 0,"Sun");

		planetsList[0] = new Planet(600, 450, -4.7, 0, 9, 8, Color.GRAY, 1000,"Mercury");
		planetsList[1] = new Planet(752, 400, 0, 2.5, 900, 12, new Color(207,153,52), 1000,"Venus");
		planetsList[2] = new Planet(600, 150, 1.8, 0, 900, 11, Color.BLUE, 2000,"Earth");
		planetsList[3] = new Planet(650, -50, 1.2, 0, 900, 7, Color.RED, 2000, "Mars");
		planetsList[4] = new Planet(600, -100, 1.2, 0, 900, 20, new Color(255,140,0), 2000, "Jupiter");
		planetsList[5] = new Planet(600, -150, 1.2, 0, 900, 15, new Color(112,128,144), 2000,"Saturn");
		planetsList[6] = new Planet(600, -175, 1.2, 0, 900, 15, new Color(196,233,238), 2000,"Uranus");
		planetsList[7] = new Planet(0, 400, 0, -1.2, 900, 13, new Color(66, 98, 243), 2000,"Neptune");

		Thread thread =  new Thread() {

			@Override
			public void run() {
				mainLoop();
			}
		}; 

		thread.start();
	}

	private void mainLoop() {

		while (true) {
			if (!isApplicationPaused)
			{
				for(int i = 0; i < planetsList.length; i++)
				{
					planetsList[i].update(sun.getXPosition(),sun.getYPosition(),sun.getMass());
				}
			}
			repaint();

			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException ex) { }
		}
	}
	class Panel extends JPanel implements MouseWheelListener, KeyListener {
		private static final long serialVersionUID = -6214071575528104463L;

		public Panel() {

			setFocusable(true);
			requestFocus();
			addMouseWheelListener(this);
			addKeyListener(this);
		}


		public void paintComponent(Graphics g) {

			g.drawImage(backgroundImage,0,0,null);
			String legend = "The Solar System";
			g.setFont(new Font("Arial", Font.PLAIN, 26));
			g.setColor(Color.WHITE);
			g.drawString(legend,950,60);

			sun.draw(g, size, panX, panY);
			sun.drawSunshine(g, size, panX, panY);
			sun.displayText(g, size, panX, panY);

			for(Planet planet : planetsList) {
				planet.draw(g,size, panX, panY);
				planet.displayText(g,size, panX, panY);
			}
		}

		@Override
		public void keyPressed(KeyEvent e) { 

			if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)
				panY += 25;

			if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)
				panY -= 25;

			if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
				panX -= 25;

			if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
				panX += 25;

			if(e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				isApplicationPaused = !isApplicationPaused;
			}
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			{
				System.exit(0);
			}

		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			int notches = e.getWheelRotation();
			if (notches < 0) {
				size += .1;
				//panX-= 25;
				//panY-=25;
			} else {
				size -= .1;
				//panX+= 25;
				//panY+=25;
			}	       
		}


		@Override
		public void keyReleased(KeyEvent arg0) {

		}


		@Override
		public void keyTyped(KeyEvent arg0) {

		}

	}

}