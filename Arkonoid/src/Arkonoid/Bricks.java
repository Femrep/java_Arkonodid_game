package Arkonoid;

import java.awt.Color;

import javax.swing.JLabel;

public abstract class Bricks extends JLabel{
	public Bricks(int posx,int posy) {
		setBounds(posx,posy,70, 20);
		setOpaque(true);
		
	}
}
