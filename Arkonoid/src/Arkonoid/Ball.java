package Arkonoid;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ball extends JLabel {
	public Ball(int ballposX,int ballposY, int ball_label_Size) {
		ImageIcon blah=new ImageIcon(getClass().getResource("odev_top2.png"));
		
		setBounds(ballposX, ballposY, ball_label_Size, ball_label_Size);
		setIcon(blah);
	}
}
