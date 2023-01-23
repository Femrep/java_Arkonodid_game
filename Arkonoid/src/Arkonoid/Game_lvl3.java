package Arkonoid;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.time.LocalDateTime;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game_lvl3  extends JFrame implements KeyListener, ActionListener,MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel backGround ;
	boolean play= false; 

	private JPanel player_Left=new JPanel();
	private JPanel player_Mid=new JPanel();
	private JPanel player_Right=new JPanel();
	
	private int level_score=0; 
	
	private JLabel lvl=new JLabel("Level :3");
	private JLabel Score=new JLabel("Score: 0");
	private JLabel live_label=new JLabel("Lives: 3");
	/*private JLabel Lives=new JLabel("Lives: 3");
	private JLabel Level=new JLabel("Level 1");*/
	
	
	
	private	Bricks brick0=new Bricks_lvl2(60, 50);
	private	Bricks brick1=new Bricks_lvl1(60, 80);
	private	Bricks brick2=new Bricks_lvl3(140, 50);
	private	Bricks brick3=new Bricks_lvl1(140, 80);
	private	Bricks brick4=new Bricks_lvl2(220, 50);
	private	Bricks brick5=new Bricks_lvl3(220, 80);
	private	Bricks brick6=new Bricks_lvl1(300, 50);
	private	Bricks brick7=new Bricks_lvl3(300, 80);
	private	Bricks brick8=new Bricks_lvl2(380, 50);
	private	Bricks brick9=new Bricks_lvl1(380, 80);
	private	Bricks brick10=new Bricks_lvl3(460, 50);
	
	
	private int brick_counter=2;
	Timer timer;
	private int delay=8;
	int lives=3;
	
	
	int playerX= 310;
	int playerY= 600;
	int playerX_right_corner=playerX+150;
	
	// variables of ball
	private int ballposX=360;
	private int ballposY=540;
	private int ballYdir=+2;
	private int left_ballYdir=-3;
	private int right_ballYdir=-3;
	private int ballxdir=+1;
	//private int midxdir=0;
	private int left_ballxdir=+3;
	private int right_ballxdir=+3;
	private int ball_label_Size=20;
	private Ball ball=new Ball(ballposX, ballposY, ball_label_Size);
	
	
	
	
	public Game_lvl3() {
		//create game frame
		setLayout(null);
		setBounds(0, 0, 600, 800);
		addKeyListener(this);
		
		backGround=new JpanelWithBack("Spaceinexamle.jpg");
		backGround.setLayout(null);
		backGround.setBounds(0, 0, 600, 800);
		//backGround.setBackground(Color.yellow);
		paint();
		Score.setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);
		addMouseMotionListener(this);
		setResizable(false);
		setFocusable(true);
		
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		
		
	}
	public Game_lvl3(int sc) {
		//create game frame
		setLayout(null);
		setBounds(0, 0, 600, 800);
		addKeyListener(this);
		this.level_score=sc;
		backGround=new JpanelWithBack("Spaceinexamle.jpg");
		backGround.setLayout(null);
		backGround.setBounds(0, 0, 600, 800);
		//backGround.setBackground(Color.yellow);
		paint();
		Score.setText("Score: "+level_score);
		Score.setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(null);
		setResizable(false);
		setFocusable(true);
		
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		
		
	}
	
	


	public void paint() {
		
		
		
		
		
		//score set
		Score.setBounds(0,0,300,20);
		
		lvl.setForeground(Color.WHITE);
		lvl.setBounds(250,0,300,20);
		live_label.setForeground(Color.WHITE);
		live_label.setBounds(500,0,300,20);
		
		//player_Left=new JLabel(" ");
		
		// player 
		player_Left.setBounds(playerX, playerY, 50, 20);
		player_Left.setOpaque(true);
		player_Left.setBackground(Color.PINK);
		backGround.add(player_Left);
		
	
		
		
		player_Mid.setBounds(playerX+50, playerY, 50, 20);
		player_Mid.setOpaque(true);
		player_Mid.setBackground(Color.GREEN);
		backGround.add(player_Mid);
		
		//player_Right=new JLabel(" ");
		player_Right.setBounds(playerX+100, playerY, 50, 20);
		player_Right.setOpaque(true);
		player_Right.setBackground(Color.RED);
		backGround.add(player_Right);

		// ball sets
		
		backGround.add(ball);
		
		
		//bricks set
		
		
		backGround.add(brick0);
		backGround.add(brick1);
		backGround.add(brick2);
		backGround.add(brick3);
		
		backGround.add(brick4);
		backGround.add(brick5);
		backGround.add(brick6);
		backGround.add(brick7);
		backGround.add(brick8);
		backGround.add(brick9);
		backGround.add(brick10);
		
		backGround.add(Score);
		backGround.add(lvl);
		backGround.add(live_label);
		add(backGround);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(play) {
			if(lives>0) {
			
			/*Rectangle pL=new Rectangle(playerX,550,33,8);
			Rectangle pM=new Rectangle(player_Mid.getLocation().x,550,33,8);*/
			//Rectangle pR=new Rectangle(player_Right.getLocation().x,550,33,8);
			/*Rectangle Br0=new Rectangle(brick0.getLocation().x, brick0.getLocation().y, 33, 8);
			Rectangle Br1=new Rectangle(brick1.getLocation().x, brick1.getLocation().y, 33, 8);
			Rectangle Br2=new Rectangle(brick2.getLocation().x, brick2.getLocation().y, 33, 8);
			Rectangle Br3=new Rectangle(brick3.getLocation().x, brick3.getLocation().y, 33, 8);*/
			/*if(new Rectangle(ballposX,ballposY,20,20).intersects(pL)) {
				ballYdir= -(left_ballYdir);
				ballxdir= left_ballxdir;
				
				
			}
			
			if(new Rectangle(ballposX,ballposY,20,20).intersects(pM)) {
				ballYdir= -ballYdir;
				
			}*/
			/*if(new Rectangle(ballposX,ballposY,22,22).intersects(pR)) {
				ballYdir= -(right_ballYdir);
				if(ballxdir<0) {
					ballxdir= +ballxdir;
				}
				else {
					ballxdir= -ballxdir;
				}
				
			}*/
			// paddle intersection with ball
				if(ball.getBounds().intersects(player_Left.getBounds()) ) {
					ballYdir= (3);
					ballxdir= left_ballxdir;
					
					}
				
				
				
				
				if(ball.getBounds().intersects(player_Mid.getBounds()) ) {
					ballYdir= 2;
					
				}
				
				
				if(ball.getBounds().intersects(player_Right.getBounds()) ) {
					ballYdir= (3);
					ballxdir= -right_ballxdir;
					
					
					
					
				}
			
			
			
		
			
		
			
			// ball move code
			ballposX-=ballxdir;
			ballposY-=ballYdir;
			ball.setLocation(ballposX, ballposY);
			
			if(ballposX<=0) {
				ballxdir= -ballxdir;
			}
			if (ballposY<=40) {
				right_ballYdir= -right_ballYdir;
				left_ballYdir= -left_ballYdir;
				ballYdir= -ballYdir;
			}
			if(ballposX>560) {
				ballxdir= -ballxdir;
			}
			/*if(brick0.getBackground().equals(Color.RED)) {
				brick0.setBackground(Color.BLUE);
				
				backGround.setVisible(false);
				backGround.setVisible(true);
				
				level_score+=40;
				Score.setText("Score: "+level_score);
				}
			if(brick0.getBackground().equals(Color.YELLOW)) {
				brick0.setBackground(Color.RED);
				
				backGround.setVisible(false);
				backGround.setVisible(true);
				
				level_score+=50;
				Score.setText("Score: "+level_score);
			
				}*/
			// brick intersection with ball
			if(ball.getBounds().intersects(brick0.getBounds()) ) {
				if((ball.getLocation().y<=brick0.getLocation().y+20||ball.getLocation().y+20>=brick0.getLocation().y)) {
					ballYdir= -ballYdir;
					if(brick0.getBackground().equals(Color.YELLOW)) {
						
						brick0.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
						
						}
					else if(brick0.getBackground().equals(Color.RED)) {
						brick0.setBackground(Color.BLUE);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
					
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
				
					else {
						brick0.setVisible(false);
						
						backGround.remove(brick0);
						brick0.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}
					}
				if(ball.getLocation().x+20<=brick0.getLocation().x||ball.getLocation().x>=brick0.getLocation().x+70) {
					ballxdir= -ballxdir;
					if(brick0.getBackground().equals(Color.YELLOW)) {
						brick0.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
					
						}
					else if(brick0.getBackground().equals(Color.RED)) {
						brick0.setBackground(Color.BLUE);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick0.setVisible(false);
						backGround.remove(brick0);
						brick0.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}
					
				}
				
				
				//ballxdir= -ballxdir;
				
			}
			
			if(ball.getBounds().intersects(brick1.getBounds()) ) {
				if((ball.getLocation().y<=brick1.getLocation().y+20||ball.getLocation().y+20>=brick1.getLocation().y)) {
					ballYdir= -ballYdir;
					if(brick1.getBackground().equals(Color.YELLOW)) {
						brick1.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
						
						}
				
					else if(brick1.getBackground().equals(Color.RED)) {
						brick1.setBackground(Color.BLUE);
					
						backGround.setVisible(false);
						backGround.setVisible(true);
					
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick1.setVisible(false);
						backGround.remove(brick1);
						brick1.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}
				}
				if(ball.getLocation().x+20<=brick1.getLocation().x||ball.getLocation().x>=brick1.getLocation().x+70) {
					ballxdir= -ballxdir;

					if(brick1.getBackground().equals(Color.YELLOW)) {
						brick1.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
					
						}
					else if(brick1.getBackground().equals(Color.RED)) {

						brick1.setBackground(Color.BLUE);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick1.setVisible(false);
						backGround.remove(brick1);
						brick1.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}
					
				}
				
				
				//ballxdir= -ballxdir;
				
			}
				
			
			if(ball.getBounds().intersects(brick2.getBounds()) ) {
				if((ball.getLocation().y<=brick2.getLocation().y+20||ball.getLocation().y+20>=brick2.getLocation().y)) {
					ballYdir= -ballYdir;
					if(brick2.getBackground().equals(Color.YELLOW)) {
						brick2.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
						
						}
				
					else if(brick2.getBackground().equals(Color.RED)) {
						brick2.setBackground(Color.BLUE);
					
						backGround.setVisible(false);
						backGround.setVisible(true);
					
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick2.setVisible(false);
						backGround.remove(brick2);
						brick2.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}}
				else if(ball.getLocation().x+20<=brick2.getLocation().x||ball.getLocation().x>=brick2.getLocation().x+70) {
					ballxdir= -ballxdir;
					if(brick2.getBackground().equals(Color.YELLOW)) {
						brick2.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
					
						}
					else if(brick2.getBackground().equals(Color.RED)) {
						brick2.setBackground(Color.BLUE);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick2.setVisible(false);
						backGround.remove(brick2);
						brick2.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}
					
				
				}
				
				//ballxdir= -ballxdir;
				
			}
			if(ball.getBounds().intersects(brick3.getBounds()) ) {
				if((ball.getLocation().y<=brick3.getLocation().y+20||ball.getLocation().y+20>=brick3.getLocation().y)) {
					ballYdir= -ballYdir;
					if(brick3.getBackground().equals(Color.YELLOW)) {
						brick3.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
						
						}
					else if(brick3.getBackground().equals(Color.RED)) {
						brick3.setBackground(Color.BLUE);
					
						backGround.setVisible(false);
						backGround.setVisible(true);
					
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick3.setVisible(false);
						backGround.remove(brick3);
						brick3.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}
					}
				else if(ball.getLocation().x+20<=brick3.getLocation().x||ball.getLocation().x>=brick3.getLocation().x+70) {
					ballxdir= -ballxdir;
					if(brick3.getBackground().equals(Color.YELLOW)) {
						brick3.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
					
						}
					else if(brick3.getBackground().equals(Color.RED)) {
						brick3.setBackground(Color.BLUE);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick3.setVisible(false);
						backGround.remove(brick3);
						brick3.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}
				
				
				}
				
				//ballxdir= -ballxdir;
				
			}
			if(ball.getBounds().intersects(brick4.getBounds()) ) {
				if((ball.getLocation().y<=brick4.getLocation().y+20||ball.getLocation().y+20>=brick4.getLocation().y)) {
					ballYdir= -ballYdir;
					if(brick4.getBackground().equals(Color.YELLOW)) {
						brick4.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
						
						}
				
					else if(brick4.getBackground().equals(Color.RED)) {
						brick4.setBackground(Color.BLUE);
					
						backGround.setVisible(false);
						backGround.setVisible(true);
					
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick4.setVisible(false);
						backGround.remove(brick4);
						brick4.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}}
				else if(ball.getLocation().x+20<=brick4.getLocation().x||ball.getLocation().x>=brick4.getLocation().x+70) {
					ballxdir= -ballxdir;
					if(brick4.getBackground().equals(Color.YELLOW)) {
						brick4.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
					
						}
					else if(brick4.getBackground().equals(Color.RED)) {
						brick4.setBackground(Color.BLUE);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
				
					else {
						brick4.setVisible(false);
						backGround.remove(brick4);
						brick4.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}
					
				}
				
				
				//ballxdir= -ballxdir;
				
			}
			if(ball.getBounds().intersects(brick5.getBounds()) ) {
				if((ball.getLocation().y<=brick5.getLocation().y+20||ball.getLocation().y+20>=brick5.getLocation().y)) {
					ballYdir= -ballYdir;
					if(brick5.getBackground().equals(Color.YELLOW)) {
						brick5.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
						
						}
				
					else if(brick5.getBackground().equals(Color.RED)) {
						brick5.setBackground(Color.BLUE);
					
						backGround.setVisible(false);
						backGround.setVisible(true);
					
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick5.setVisible(false);
						backGround.remove(brick5);
						brick5.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}}
				else if(ball.getLocation().x+20<=brick5.getLocation().x||ball.getLocation().x>=brick5.getLocation().x+70) {
					ballxdir= -ballxdir;
					if(brick5.getBackground().equals(Color.YELLOW)) {
						brick5.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
					
						}
					else if(brick5.getBackground().equals(Color.RED)) {
						brick5.setBackground(Color.BLUE);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick5.setVisible(false);
						backGround.remove(brick5);
						brick5.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}
					
				
				}
				
				//ballxdir= -ballxdir;
				
			}
			if(ball.getBounds().intersects(brick6.getBounds()) ) {
				if((ball.getLocation().y<=brick6.getLocation().y+20||ball.getLocation().y+20>=brick6.getLocation().y)) {
					ballYdir= -ballYdir;
					if(brick6.getBackground().equals(Color.YELLOW)) {
						brick6.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
						
						}
				
					else if(brick6.getBackground().equals(Color.RED)) {
						brick6.setBackground(Color.BLUE);
					
						backGround.setVisible(false);
						backGround.setVisible(true);
					
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
				
					else {
						brick6.setVisible(false);
						backGround.remove(brick6);
						brick6.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}}
				else if(ball.getLocation().x+20<=brick6.getLocation().x||ball.getLocation().x>=brick6.getLocation().x+70) {
					ballxdir= -ballxdir;
					if(brick6.getBackground().equals(Color.YELLOW)) {
						brick6.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
					
						}
					else if(brick6.getBackground().equals(Color.RED)) {
						brick6.setBackground(Color.BLUE);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick6.setVisible(false);
						backGround.remove(brick6);
						brick6.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}
					
				}
				
				
				//ballxdir= -ballxdir;
				
			}
			if(ball.getBounds().intersects(brick7.getBounds()) ) {
				if((ball.getLocation().y<=brick7.getLocation().y+20||ball.getLocation().y+20>=brick7.getLocation().y)) {
					ballYdir= -ballYdir;
					if(brick7.getBackground().equals(Color.YELLOW)) {
						brick7.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
						
						}
				
					else if(brick7.getBackground().equals(Color.RED)) {
						brick7.setBackground(Color.BLUE);
					
						backGround.setVisible(false);
						backGround.setVisible(true);
					
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick7.setVisible(false);
						backGround.remove(brick7);
						brick7.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}}
				else if(ball.getLocation().x+20<=brick7.getLocation().x||ball.getLocation().x>=brick7.getLocation().x+70) {
					ballxdir= -ballxdir;
					if(brick7.getBackground().equals(Color.YELLOW)) {
						brick7.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
					
						}
					else if(brick7.getBackground().equals(Color.RED)) {
						brick7.setBackground(Color.BLUE);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick7.setVisible(false);
						backGround.remove(brick7);
						brick7.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}
					
				
				}
				
				//ballxdir= -ballxdir;
				
			}
			if(ball.getBounds().intersects(brick8.getBounds()) ) {
				if((ball.getLocation().y<=brick8.getLocation().y+20||ball.getLocation().y+20>=brick8.getLocation().y)) {
					ballYdir= -ballYdir;
					if(brick8.getBackground().equals(Color.YELLOW)) {
						brick8.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
						
						}
					else if(brick8.getBackground().equals(Color.RED)) {
						brick8.setBackground(Color.BLUE);
					
						backGround.setVisible(false);
						backGround.setVisible(true);
					
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick8.setVisible(false);
						backGround.remove(brick8);
						brick8.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}}
				else if(ball.getLocation().x+20<=brick8.getLocation().x||ball.getLocation().x>=brick8.getLocation().x+70) {
					ballxdir= -ballxdir;
					if(brick8.getBackground().equals(Color.YELLOW)) {
						brick8.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
					
						}
					else if(brick8.getBackground().equals(Color.RED)) {
						brick8.setBackground(Color.BLUE);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
				
					else {
						brick8.setVisible(false);
						backGround.remove(brick8);
						brick8.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}
					
				}
				
				
				//ballxdir= -ballxdir;
				
			}
			if(ball.getBounds().intersects(brick9.getBounds()) ) {
				if((ball.getLocation().y<=brick9.getLocation().y+20||ball.getLocation().y+20>=brick9.getLocation().y)) {
					ballYdir= -ballYdir;
					if(brick9.getBackground().equals(Color.YELLOW)) {
						brick9.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
						
						}
					else if(brick9.getBackground().equals(Color.RED)) {
						brick9.setBackground(Color.BLUE);
					
						backGround.setVisible(false);
						backGround.setVisible(true);
					
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
				
					else {
						brick9.setVisible(false);
						backGround.remove(brick9);
						brick9.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}}
				else if(ball.getLocation().x+20<=brick9.getLocation().x||ball.getLocation().x>=brick9.getLocation().x+70) {
					ballxdir= -ballxdir;
					if(brick9.getBackground().equals(Color.YELLOW)) {
						brick9.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
					
						}
					else if(brick9.getBackground().equals(Color.RED)) {
						brick9.setBackground(Color.BLUE);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick9.setVisible(false);
						backGround.remove(brick9);
						brick9.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}
					
				}
				
				
				//ballxdir= -ballxdir;
				
			}
			if(ball.getBounds().intersects(brick10.getBounds()) ) {
				if((ball.getLocation().y<=brick10.getLocation().y+20||ball.getLocation().y+20>=brick10.getLocation().y)) {
					ballYdir= -ballYdir;
				
					if(brick10.getBackground().equals(Color.YELLOW)) {
						brick10.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
						
						}
					else if(brick10.getBackground().equals(Color.RED)) {
						brick10.setBackground(Color.BLUE);
					
						backGround.setVisible(false);
						backGround.setVisible(true);
					
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick10.setVisible(false);
						backGround.remove(brick10);
						brick10.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}
					}
				else if(ball.getLocation().x+20<=brick10.getLocation().x||ball.getLocation().x>=brick10.getLocation().x+70) {
					ballxdir= -ballxdir;
					if(brick10.getBackground().equals(Color.YELLOW)) {
						brick10.setBackground(Color.RED);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=50;
						Score.setText("Score: "+level_score);
					
						}
					else if(brick10.getBackground().equals(Color.RED)) {
						brick10.setBackground(Color.BLUE);
						
						backGround.setVisible(false);
						backGround.setVisible(true);
						
						level_score+=40;
						Score.setText("Score: "+level_score);
						}
					
					else {
						brick10.setVisible(false);
						backGround.remove(brick10);
						brick10.setBounds(0, 0, 0, 0);
						backGround.setVisible(false);
						backGround.setVisible(true);
						level_score+=30;
						Score.setText("Score: "+level_score);
						brick_counter--;
					}
					
				}
				
				
				//ballxdir= -ballxdir;
				
			}
			if (ballposY>700) {
				lives--;
				if(lives==0) {
					play=false;
					LocalDateTime date=LocalDateTime.now();
					String Name= JOptionPane.showInputDialog(this,"Score :"+level_score+"\n Player name");
					new Score_Write(Name+" "+level_score+" "+date);
					timer.stop();
					setVisible(false);
					GUI inter= new GUI();
					inter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					inter.setSize(640,480);
					inter.setVisible(true);
					inter.set_UP_Button_Listeners();
				}
				else {
					
					ballposX= 120;
					ballposY=350;
						
					/*ballposX-=ballxdir;
					ballposY-=ballYdir;*/
					
				}
				live_label.setText("Lives: "+lives);
				
			}
			if(brick_counter==0) {
				play=false;
				String Name= JOptionPane.showInputDialog("Score :"+level_score+"\n Player name");
				new Score_Write(Name+" "+level_score);
				timer.stop();
				setVisible(false);
				GUI inter= new GUI();
				inter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				inter.setSize(640,480);
				inter.setVisible(true);
				inter.set_UP_Button_Listeners();
				
				
			}
			
			
		}
			}
		//repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			
			
				if(playerX>=430) {
					(playerX)=430;
					
					
					
				}
				else {
					moveRight();
					
				}
			
		}
		if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			
			
				if(playerX<=10) {
					playerX=10;

				}
				else {
					moveLeft();
					
				}
			
		}
		if(e.isControlDown()&& e.getKeyCode() ==KeyEvent.VK_Q) {
			play=false;
			JOptionPane.showMessageDialog(null,"Game over:\n your score="+level_score);
			System.exit(0);
			
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			timer.start();
			
		}
	}




	public void moveRight() {
		play=true;
		playerX+=10;
		//playerX_right_corner+=19;
		player_Left.setLocation(playerX, playerY);
		player_Mid.setLocation(playerX+50, playerY);
		player_Right.setLocation(playerX+100, playerY);
	}
	public void moveLeft() {
		play=true;
		playerX-=10;
		//playerX_right_corner-=19;
		player_Left.setLocation(playerX, playerY);
		player_Mid.setLocation(playerX+50, playerY);
		player_Right.setLocation(playerX+100, playerY);
		
	}
	public boolean get_playable() {
		return play;
	}
	/*public int getlvl() {
		return lvl;
	}
	public int getscore() {
		return score;
	}
	public int getlives() {
		return lives;
	}*/

	@Override
	public void mouseDragged(MouseEvent e) {
		
		

	}




	@Override
	public void mouseMoved(MouseEvent e) {
		if(playerX>=430) {
			(playerX)=425;
			
			
			
		}
		
		else if(playerX<=9) {
			playerX=15;

		}
		
		else {
			playerX=e.getX()-75;
			player_Left.setLocation(playerX, playerY);
			player_Mid.setLocation(playerX+50, playerY);
			player_Right.setLocation(playerX+100, playerY);
			play=true;
			timer.start();
		}
		
		
	}


	
	

}
