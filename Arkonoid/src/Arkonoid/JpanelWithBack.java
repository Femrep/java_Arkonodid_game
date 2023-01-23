package Arkonoid;

import java.awt.Graphics;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JpanelWithBack extends JPanel {
	protected Image backgroundImg;
	private ImageIcon myback;
	public JpanelWithBack(String fileName){
		try {
		myback=new ImageIcon(getClass().getResource(fileName));
		backgroundImg = myback.getImage();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(backgroundImg, 0, 0, null);
	}
	}
