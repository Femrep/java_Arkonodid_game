package Arkonoid;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class GUI extends JFrame{
	//private JPanel background;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton Options;
	private JButton Scores;
	private JButton Help;
	private JButton About;
	private JButton Exit;
	private JPanel layout;
	private JPanel button_panels;
	private JPanel button_panels2;
	private JButton Back;
	private JButton Back2;
	private JButton lvl1;
	private JButton lvl2;
	private JButton lvl3;
	private JButton new_Game_button;
	private ArrayList<Scoress> players=new ArrayList<Scoress>();
	private JLabel Scor_table_1;
	private JLabel Scor_table_2;
	private JLabel Scor_table_3;
	private JLabel Scor_table_4;
	private JLabel Scor_table_5;
	private JLabel Scor_table_6;
	private JLabel Scor_table_7;
	private JLabel Scor_table_8;
	private JLabel Scor_table_9;
	private JLabel Scor_table_10;
	
	public GUI () {
		//background=new JPanel();
		super("The brick breaker");
		//setLayout(new FlowLayout());
		//setContentPane();
		
		//backJLabel=new JLabel("");
		
		//backJLabel.setIcon(bG);
		panel =new JpanelWithBack("Spaceinexamle.jpg");
		panel.setLayout(new FlowLayout());
		layout=new JPanel(new GridBagLayout());
		button_panels=new JPanel(new GridLayout(6,1,10,5));
		button_panels2=new JPanel(new FlowLayout());
		new_Game_button=new JButton("New Game");
		Options=new JButton("Options");
		Scores=new JButton("Scores");
		Help=new JButton("Help");
		About=new JButton("About");
		Exit=new JButton("Exit");
		Back=new JButton("Back");
		Back2=new JButton("Back");
		lvl3=new JButton("level 3");
		lvl2=new JButton("level 2");
		lvl1=new JButton("level 1");
		new Score_reader(players,"ScoreFile");
		panel.setBorder(new EmptyBorder(2,3,2,3));
		layout.setBorder(new EmptyBorder(5,5,5,5));
		//button_panels2.add(Back);
		
		button_panels2.add(lvl1);
		button_panels2.add(lvl2);
		button_panels2.add(lvl3);
		button_panels.add(new_Game_button);
		button_panels.add(Options);
		button_panels.add(Scores);
		button_panels.add(Help);
		button_panels.add(About);
		button_panels.add(Exit);
		
		
		//layout.add(button_panels);
		panel.add(button_panels);
		//backJLabel.add(panel);
		
		add(panel);
		
	}
	public void create_option() {
		remove(panel);
		panel.remove(button_panels);
		//layout.remove(button_panels);
		//setLayout(new BorderLayout());
		panel.setLayout(new BorderLayout() );
		panel.add(Back, BorderLayout.NORTH);
		add(panel);

	}
	public void create_Score() {
		remove(panel);
		panel.remove(button_panels);
		
		Scoress[] top10=new Scoress[10];
		Collections.sort(players,new Sort_arrlist());
		//String all = new String();
		Iterator<Scoress> Itr= players.iterator();
		int b=0;
		while(Itr.hasNext()) {
			
			Scoress i=(Scoress)Itr.next();
			if(b<9) {
				top10[b]=new Scoress(i.name, i.scor,i.date);
				b++;
			}
			
			
		}
		
		JPanel ground=new JPanel();
		ground.setLayout(new GridLayout(10,1,10,5));
		ground.setBounds(230, 40, 180, 200);
		Back2.setBounds(0,0,640,30);
		if(top10[0]!=null) {Scor_table_1=new JLabel("1) "+top10[0].name+" "+top10[0].scor+" "+top10[0].date);
		ground.add(Scor_table_1);}
		//Scor_table_1=new JLabel("1) "+top10[0].name+" "+top10[0].scor);
		if(top10[1]!=null) {Scor_table_2=new JLabel("2) "+top10[1].name+" "+top10[1].scor+" "+top10[1].date);
		ground.add(Scor_table_2);}
		if(top10[2]!=null) {Scor_table_3=new JLabel("3) "+top10[2].name+" "+top10[2].scor+" "+top10[2].date);
		ground.add(Scor_table_3);}	
		if(top10[3]!=null) {Scor_table_4=new JLabel("4) "+top10[3].name+" "+top10[3].scor+" "+top10[3].date);
		ground.add(Scor_table_4);}
		if(top10[4]!=null) {Scor_table_5=new JLabel("5) "+top10[4].name+" "+top10[4].scor+" "+top10[4].date);
		ground.add(Scor_table_5);}
		if(top10[5]!=null) {Scor_table_6=new JLabel("6) "+top10[5].name+" "+top10[5].scor+" "+top10[5].date);
		ground.add(Scor_table_6);}
		if(top10[6]!=null) {Scor_table_7=new JLabel("7) "+top10[6].name+" "+top10[6].scor+" "+top10[6].date);
		ground.add(Scor_table_7);}
		if(top10[7]!=null) {Scor_table_8=new JLabel("8) "+top10[7].name+" "+top10[7].scor+" "+top10[7].date);
		ground.add(Scor_table_8);}
		if(top10[8]!=null) {Scor_table_9=new JLabel("9) "+top10[8].name+" "+top10[8].scor+" "+top10[8].date);
		ground.add(Scor_table_9);}
		if(top10[9]!=null) {Scor_table_10=new JLabel("10) "+top10[9].name+" "+top10[9].scor+" "+top10[9].date);
		ground.add(Scor_table_10);}
		
		panel.setLayout(null);
		
		
		
	
	
		panel.add(ground);
		panel.add(Back2);
		add(panel);

	}
	
	public void create_game_menu() {
		remove(panel);
		panel.remove(button_panels);
		//layout.remove(button_panels);
		setSize(600, 800);
		setDefaultLookAndFeelDecorated(false);
		
		button_panels2.add(Back);
		//layout.add(button_panels2);
		panel.add(button_panels2);
		add(panel);
		
		
		
	}
	public void recreat_qui() {
		setSize(640,480);
		remove(panel);
		panel.removeAll();
		//layout.removeAll();
		panel.setLayout(new FlowLayout());
		//layout.add(button_panels);
		panel.add(button_panels);
		add(panel);
	}
	public void lvl1_game() {
		
		
		
		panel.setVisible(false);

		Game_lvl1 gm=new Game_lvl1();
		setBounds(0,0,600,800);
		setResizable(false);
		dispose(); 
		
		
		
		gm.setVisible(true);
		/*if(gm.get_playable()==true) {
			setVisible(true);
			panel.setVisible(true);
		}*/
		

		

		
	}
	public void lvl2_game() {
		panel.setVisible(false);
		setVisible(false);
		Game_lvl2 gm2=new Game_lvl2();
		setBounds(0,0,600,800);
		setResizable(false);
		setVisible(false);
		dispose();
		
		
		
		gm2.setVisible(true);
		if(gm2.get_playable()==true) {
			setVisible(true);
			panel.setVisible(true);
		}
		

		
	}
	public void lvl3_game() {
		panel.setVisible(false);
		setVisible(false);
		Game_lvl3 gm3=new Game_lvl3();
		setBounds(0,0,600,800);
		setResizable(false);
		setVisible(false);
		dispose();
		
		
		
		gm3.setVisible(true);
		if(gm3.get_playable()==true) {
			setVisible(true);
			panel.setVisible(true);
		}
		

		
	}
	
	public void set_UP_Button_Listeners() {
		ActionListener buttonListener=new ActionListener() {
		
			
			public void actionPerformed(ActionEvent e) {
				Object a=e.getSource();
				if(a==new_Game_button) {
					panel.setVisible(false);
					
					create_game_menu();
					panel.setVisible(true);
					
				}
				else if(a==Options) {
					panel.setVisible(false);
					create_option();
					panel.setVisible(true);
				}
				else if(a==lvl1) {
					
					lvl1_game();
					
					
				}
				else if(a==lvl2) {
					remove(panel);
					lvl2_game();
					
				}
				else if(a==lvl3) {
					remove(panel);
					lvl3_game();
					
				}
				else if(a== Scores) {
					panel.setVisible(false);
					create_Score();
					panel.setVisible(true);
					//System.out.println("3 button");
				}
				else if(a== Help) {
					JOptionPane.showMessageDialog(null,	"Players should be trying to break all bricks on every level to get scores as high possible and advance to the next level.\n"
							+ "A player should slide the paddle left and right - either by using left right keys on the keyboard or moving the mouse - to bounce back the ball.\n"
							+ "Each level is cleared by breaking all breakable bricks � red bricks should break with one hit, orange with two and black with three.");
				}
				else if(a== About) {
					JOptionPane.showMessageDialog(null,	"Creator: \n\nName: Fahrettin Emre \nSurname: PABUSCU \nSchool Number: 20190702010 \nEmail: fahrettinemre.pabuscu@std.yeditepe.edu.tr");
				}
				else if(a== Back) {
					panel.setVisible(false);
					recreat_qui();
					panel.setVisible(true);
				}
				else if(a== Back2) {
					panel.setVisible(false);
					recreat_qui();
					panel.setVisible(true);
				}
				else if(a== Exit) {
					JOptionPane.showMessageDialog(null,	"Exiting...");
					System.exit(0);
				}
				
			}
		};
		Back2.addActionListener(buttonListener);
		Back.addActionListener(buttonListener);
		lvl1.addActionListener(buttonListener);
		lvl2.addActionListener(buttonListener);
		lvl3.addActionListener(buttonListener);
		new_Game_button.addActionListener(buttonListener);
		Options.addActionListener(buttonListener);
		Scores.addActionListener(buttonListener);
		Help.addActionListener(buttonListener);
		About.addActionListener(buttonListener);
		Exit.addActionListener(buttonListener);
	}

}
