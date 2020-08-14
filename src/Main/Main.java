package Main;

import java.awt.Color;
import javax.swing.*;

public class Main extends JPanel {

	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
	         @Override
	         public void run() {
	        	System.out.println("Starting Application...");
	            JFrame viewport = new JFrame("Solar-J - A visual representation of the solar system");
	            viewport.setContentPane(new ProgramExecution());  
	            viewport.setBackground(Color.BLACK);
	            viewport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            viewport.pack();
	            viewport.setLocationRelativeTo(null); 
	            viewport.setVisible(true);            
	         }
	      });

	}

}
