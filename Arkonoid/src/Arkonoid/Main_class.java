package Arkonoid;


import javax.swing.JFrame;

public class Main_class {

	public static void main(String[] args) {
		GUI inter= new GUI();
		inter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inter.setSize(640,480);
		inter.setVisible(true);
		inter.set_UP_Button_Listeners();

	}

}
 