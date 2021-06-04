package hangman;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gamemain.BouncingBall;
import gamemain.CircleButton;
import gamemain.GameStart;
import gamemain.RoundJTextField;
import gamemain.RoundedButton;


public class HangMan extends JFrame implements ActionListener {
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 900;
	public static final int BUTTON_WIDTH = 200;
	public static final int BUTTON_HEIGHT = 100;
	
	public static final String srcPath="src";
	public static final String packageName="hangman";
	
	private Font btnFont = new Font("DX국민시대", Font.BOLD, 30);
	private Font btnFont2 = new Font("DX국민시대", Font.BOLD, 20);

	CardLayout card;
	Panel startPage = new Panel();
	Panel selectGamePage = new Panel();
	String answer="";
	int mode=0;
	int player=0;
	JTextField player1;
	
	public static void main(String[] args) {
		HangMan iconGui = new HangMan();
		iconGui.setVisible(true);
	}
	
	public HangMan() {
		super("Team Project - Game");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		card= new CardLayout(0, 0);
		setLayout(card);
		
		JPanel back = null;
		back = new BouncingBall();//배경
		back.setLayout(null);
		back.setBackground(Color.WHITE);
		back.setBounds(0, 0, 1200, 900);
		back.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(255,0,0,0));
		topPanel.setLayout(new BorderLayout());
		
		CircleButton homeBtn = new CircleButton("HOME");//홈버튼
		homeBtn.setBackColor(new Color(255,247,242));
		homeBtn.setTextColor(new Color(247,99,12));
		homeBtn.setFont(btnFont2);
		homeBtn.addActionListener(this);
		homeBtn.setPreferredSize(new Dimension(80,80));
		
		topPanel.setPreferredSize(new Dimension(0,80));
		topPanel.add(homeBtn, BorderLayout.EAST);

		back.add(topPanel, BorderLayout.NORTH);

		JPanel startPanel = new JPanel();
		startPanel.setBackground(new Color(255,0,0,0));
		
		JPanel startDetailPanel = new JPanel();
		startDetailPanel.setBackground(new Color(255,0,0,0));
		startDetailPanel.setLayout(new GridLayout(1,2, 200, 100));
		
		JLabel hangman=new JLabel("HangMan");//제목
		hangman.setBackground(Color.white);
		hangman.setBounds(0,250,1200,100);
		hangman.setHorizontalAlignment(JLabel.CENTER);
		hangman.setFont(new Font("DX국민시대",Font.BOLD,70));
		hangman.setForeground(new Color(247,99,12));
		back.add(hangman);

		RoundedButton startBtn = new RoundedButton("single mode");//single mode
		startBtn.setBackColor(new Color(255,247,242));
		startBtn.setTextColor(new Color(247,99,12));
		startBtn.setFont(btnFont);
		startBtn.setPreferredSize(new Dimension(200,100));
		startBtn.addActionListener(this);
		startDetailPanel.add(startBtn);
		
		RoundedButton exitBtn = new RoundedButton("multi mode");//multi mode
		exitBtn.setBackColor(new Color(255,247,242));
		exitBtn.setTextColor(new Color(247,99,12));
		exitBtn.setFont(btnFont);
		exitBtn.setPreferredSize(new Dimension(200,100));
		exitBtn.addActionListener(this);
		startDetailPanel.add(exitBtn);
		
		
		startPanel.add(startDetailPanel);
		startPanel.setPreferredSize(new Dimension(200,300));

		
		back.add(startPanel, BorderLayout.SOUTH);

		startPage.add(back);
		
		add(startPage);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCmd = e.getActionCommand();
		
		if(actionCmd.equals("single mode")) {
			Choosemode c=new Choosemode();
			c.setVisible(true);


		} else if(actionCmd.equals("multi mode")) {
			Choosemode1 c=new Choosemode1();
			c.setVisible(true);

		} else if(actionCmd.equals("HOME")) {
			GameStart game =new GameStart();
			game.setVisible(true);
			dispose();
		}
	}
	private class Choosemode extends JFrame implements ActionListener{//single mode에서 mode 선택
		Choosemode(){
			setSize(400,300);
			setBackground(Color.white);
			setLocationRelativeTo(null);
			JPanel modePanel=new JPanel();
			modePanel.setBackground(Color.white);
			modePanel.setLayout(new GridLayout(1,2,10,10));
			RoundedButton normal=new RoundedButton("normal mode");
			normal.setFont(new Font("DX국민시대",Font.BOLD,27));
			normal.setBackColor(new Color(255,247,242));
			normal.setTextColor(new Color(247,99,12));
			normal.addActionListener(this);
			modePanel.add(normal);
			RoundedButton hard=new RoundedButton("hard mode");
			hard.setFont(new Font("DX국민시대",Font.BOLD,27));
			hard.addActionListener(this);
			hard.setBackColor(new Color(255,247,242));
			hard.setTextColor(new Color(247,99,12));
			modePanel.add(hard);
			add(modePanel,BorderLayout.CENTER);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String m=e.getActionCommand();
			if(m.equals("normal mode")) {
				mode=9;
				dispose();
			}
			else if(m.equals("hard mode")) {
				mode=7;
				dispose();
			}
			Chooselevel cl=new Chooselevel();
			cl.setVisible(true);
		}
	}
	private class Chooselevel extends JFrame implements ActionListener{//single mode에서 level 선택
		Chooselevel(){
			setSize(400,300);
			setBackground(Color.white);
			setLocationRelativeTo(null);
			JPanel modePanel=new JPanel();
			modePanel.setBackground(Color.white);
			modePanel.setLayout(new GridLayout(1,3,10,10));
			RoundedButton one=new RoundedButton("1 level");
			one.setFont(new Font("DX국민시대",Font.BOLD,20));
			one.setBackColor(new Color(255,247,242));
			one.setTextColor(new Color(247,99,12));
			one.addActionListener(this);
			modePanel.add(one);
			RoundedButton two=new RoundedButton("2 level");
			two.setFont(new Font("DX국민시대",Font.BOLD,20));
			two.setBackColor(new Color(255,247,242));
			two.setTextColor(new Color(247,99,12));
			two.addActionListener(this);
			modePanel.add(two);
			RoundedButton three=new RoundedButton("3 level");
			three.setFont(new Font("DX국민시대",Font.BOLD,20));
			three.addActionListener(this);
			three.setBackColor(new Color(255,247,242));
			three.setTextColor(new Color(247,99,12));
			modePanel.add(three);
			add(modePanel,BorderLayout.CENTER);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String m=e.getActionCommand();
			ArrayList<String> word=new ArrayList<String>();
			String currentProjPath="";
			try {
				currentProjPath=new File(".").getCanonicalPath();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
			if(m.equals("1 level")) {
				try {
					ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(currentProjPath+"/"+srcPath+"/"+packageName+"/"+"level1_word.dat"));
					
					word=(ArrayList)inputStream.readObject();
			
					inputStream.close();
				}catch(FileNotFoundException ex) {
					ex.printStackTrace();
				}catch(ClassNotFoundException ex) {
					System.err.println("Problem with file input.");
				}catch(IOException ex) {
					System.err.println("Problem with file input.");
				}
				int i=0;
				
				int random=(int)(Math.random()*word.size());
				answer=word.get(random);
				dispose();
			}
			else if(m.equals("2 level")) {
				try {
					ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(currentProjPath+"/"+srcPath+"/"+packageName+"/"+"level2_word.dat"));
					
					word=(ArrayList)inputStream.readObject();
			
					inputStream.close();
				}catch(FileNotFoundException ex) {
					ex.printStackTrace();
				}catch(ClassNotFoundException ex) {
					System.err.println("Problem with file input.");
				}catch(IOException ex) {
					System.err.println("Problem with file input.");
				}
				int i=0;
				
				int random=(int)(Math.random()*word.size());
				answer=word.get(random);
				System.out.println(answer);
			}
			else if(m.equals("3 level")) {
				try {
					ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(currentProjPath+"/"+srcPath+"/"+packageName+"/"+"level3_word.dat"));
					
					word=(ArrayList)inputStream.readObject();
			
					inputStream.close();
				}catch(FileNotFoundException ex) {
					ex.printStackTrace();
				}catch(ClassNotFoundException ex) {
					System.err.println("Problem with file input.");
				}catch(IOException ex) {
					System.err.println("Problem with file input.");
				}
				int i=0;
				
				int random=(int)(Math.random()*word.size());
				answer=word.get(random);
			}
			HangManSingle drawing = new HangManSingle(mode,answer);
			drawing.setVisible(true);
			dispose();
		}
	}
	private class Choosemode1 extends JFrame implements ActionListener{//multi mode에서 mode 선택
		Choosemode1(){
			setSize(400,300);
			setBackground(Color.white);
			setLocationRelativeTo(null);
			JPanel modePanel=new JPanel();
			modePanel.setBackground(Color.white);
			modePanel.setLayout(new GridLayout(1,2,10,10));
			RoundedButton normal=new RoundedButton("normal mode");
			normal.addActionListener(this);
			normal.setFont(new Font("DX국민시대",Font.BOLD,20));
			normal.setBackColor(new Color(255,247,242));
			normal.setTextColor(new Color(247,99,12));
			modePanel.add(normal);
			RoundedButton hard=new RoundedButton("hard mode");
			hard.addActionListener(this);
			hard.setFont(new Font("DX국민시대",Font.BOLD,20));
			hard.setBackColor(new Color(255,247,242));
			hard.setTextColor(new Color(247,99,12));
			modePanel.add(hard);
			add(modePanel,BorderLayout.CENTER);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String m=e.getActionCommand();
			if(m.equals("normal mode")) {
				mode=9;
				dispose();
			}
			else if(m.equals("hard mode")) {
				mode=7;
				dispose();
			}
			Choosemem cm=new Choosemem();
			cm.setVisible(true);
		}
		
	}
	private class Choosemem extends JFrame implements ActionListener{//multi mode에서 level 선택
		Choosemem(){
			setSize(400,300);
			setBackground(Color.white);
			setLocationRelativeTo(null);
			JPanel modePanel=new JPanel();
			modePanel.setBackground(Color.white);
			modePanel.setLayout(new GridLayout(1,5,10,10));
			RoundedButton two=new RoundedButton("2");
			two.addActionListener(this);
			two.setFont(new Font("DX국민시대",Font.BOLD,20));
			two.setBackColor(new Color(255,247,242));
			two.setTextColor(new Color(247,99,12));
			modePanel.add(two);
			RoundedButton three=new RoundedButton("3");
			three.addActionListener(this);
			three.setFont(new Font("DX국민시대",Font.BOLD,20));
			three.setBackColor(new Color(255,247,242));
			three.setTextColor(new Color(247,99,12));
			modePanel.add(three);
			RoundedButton four=new RoundedButton("4");
			four.setFont(new Font("DX국민시대",Font.BOLD,20));
			four.setBackColor(new Color(255,247,242));
			four.setTextColor(new Color(247,99,12));
			four.addActionListener(this);
			modePanel.add(four);
			RoundedButton five=new RoundedButton("5");
			five.addActionListener(this);
			five.setFont(new Font("DX국민시대",Font.BOLD,20));
			five.setBackColor(new Color(255,247,242));
			five.setTextColor(new Color(247,99,12));
			modePanel.add(five);
			RoundedButton six=new RoundedButton("6");
			six.addActionListener(this);
			six.setFont(new Font("DX국민시대",Font.BOLD,20));
			six.setBackColor(new Color(255,247,242));
			six.setTextColor(new Color(247,99,12));
			modePanel.add(six);
			add(modePanel,BorderLayout.CENTER);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String m=e.getActionCommand();
			if(m.equals("2")) {
				player=2;
				dispose();
			}
			else if(m.equals("3")) {
				player=3;
				dispose();
			}
			else if(m.equals("4")) {
				player=4;
				dispose();
			}
			else if(m.equals("5")) {
				player=5;
				dispose();
			}
			else if(m.equals("6")) {
				player=6;
				dispose();
			}
			writeanswer cl=new writeanswer();
			cl.setVisible(true);
		}
		
	}
	private class writeanswer extends JFrame implements ActionListener{//multi mode에서 player1이 답 입력
		writeanswer(){
			setSize(400,300);
			setBackground(Color.white);
			setLayout(new GridLayout(2,1));
			
			JLabel beforestart=new JLabel("    player 1 write a answer.");
			beforestart.setFont(new Font("DX국민시대",Font.BOLD,20));
			beforestart.setForeground(new Color(247,99,12));
			beforestart.setOpaque(true); 
			beforestart.setBackground(Color.white);
			add(beforestart);
			setLocationRelativeTo(null);
			JPanel answerPanel=new JPanel();
			player1=new RoundJTextField(12);
			player1.addActionListener(this);
			answerPanel.add(player1);
			RoundedButton ok=new RoundedButton("확인");
			ok.setBackColor(new Color(255,247,242));
			ok.setTextColor(new Color(247,99,12));
			ok.setFont(btnFont2);
			answerPanel.setBackground(Color.white);
			ok.addActionListener(this);
			answerPanel.add(ok);
			add(answerPanel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String m=e.getActionCommand();
			if(m.equals("확인")) {
				answer=player1.getText();
				
				HangManMulti drawing = new HangManMulti(answer,player,mode);
				drawing.setVisible(true);
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "type error.", "Error",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}
}
