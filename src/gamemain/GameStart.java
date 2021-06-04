package gamemain;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import baskin.BaskinRobbins;
import hangman.HangMan;
import javaQuiz.JavaStartGame;

public class GameStart extends JFrame implements ActionListener {
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 900;
	public static final int BUTTON_WIDTH = 200;
	public static final int BUTTON_HEIGHT = 100;
	
	private String dir = "C:\\Users\\±èÇöÁö\\eclipse-workspace\\teamproject\\src\\gamemain\\";
	private String ImgFile = "prof_yksuh.jpg";
	JPanel imgTemp = new JPanel();
	
	JPanel page1;
	
	private Font btnFont = new Font("DX±¹¹Î½Ã´ë", Font.BOLD, 30);
	private Font titleFont = new Font("DX±¹¹Î½Ã´ë", Font.BOLD, 70);

	private ArrayList<Panel> panelList = new ArrayList<Panel>();
	
	BufferedImage img = null;
	
	CardLayout card;
	Panel startPage = new Panel();
	Panel selectGamePage = new Panel();
	
	public static void main(String[] args) {
		GameStart iconGui = new GameStart();
		iconGui.setVisible(true);
	}
	
	public GameStart() {
		// Implement
		super("Team Project - Game");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		
		try {
			img = ImageIO.read(new File(dir+ImgFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		card= new CardLayout(0, 0);
		setLayout(card);
		
		JPanel back = null;
		back = new BouncingBall();
		back.setLayout(null);
		back.setBackground(Color.WHITE);
		//add(back);
		back.setBounds(0, 0, 1200, 900);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBackground(new Color(255,0,0,0));
//		titlePanel.setLayout(null);
//		titlePanel.setPreferredSize(new Dimension(200,180));
		
		JPanel temp2 = new JPanel();
		
		
		JLabel title = new JLabel("LET'S PLAY THE GAME");
		title.setFont(titleFont);
		title.setForeground(new Color(247,99,12));
		title.setHorizontalAlignment(JLabel.CENTER);
//		title.setPreferredSize(new Dimension(200,580));
		titlePanel.add(temp2);
		titlePanel.add(title);
		
		
		JPanel startPanel = new JPanel();
		startPanel.setBackground(new Color(255,0,0,0));
		
		JPanel startDetailPanel = new JPanel();
		startDetailPanel.setBackground(new Color(255,0,0,0));
		startDetailPanel.setLayout(new GridLayout(1,2, 200, 100));
		
		RoundedButton startBtn = new RoundedButton("START");
		startBtn.setBackColor(new Color(255,247,242));
		startBtn.setTextColor(new Color(247,99,12));
		startBtn.setFont(btnFont);
		startBtn.setPreferredSize(new Dimension(200,80));
		startBtn.addActionListener(this);
		
		
		RoundedButton exitBtn = new RoundedButton("EXIT");
		exitBtn.setBackColor(new Color(255,247,242));
		exitBtn.setTextColor(new Color(247,99,12));
		exitBtn.setFont(btnFont);
		exitBtn.setPreferredSize(new Dimension(200,80));
		exitBtn.addActionListener(this);
		
		startDetailPanel.add(exitBtn);
		startDetailPanel.add(startBtn);
		
		startPanel.add(startDetailPanel);
		startPanel.setPreferredSize(new Dimension(200,300));

		back.setLayout(new BorderLayout());
		

		back.add(titlePanel, BorderLayout.CENTER);
		
		back.add(startPanel, BorderLayout.SOUTH);

		startPage.add(back);
		
		add(startPage);
		
		/********************************************/
		
		JPanel back2 = null;
		back2 = new BouncingBall();
		back2.setLayout(null);
		back2.setBackground(new Color(255,0,0,0));
		//add(back2);
		back2.setBounds(0, 0, 1200, 900);

		JPanel gamePanel = new JPanel();
		gamePanel.setBackground(new Color(255,0,0,0));
		gamePanel.setLayout(new GridLayout(1, 2));

		JPanel temp = new JPanel();
		temp.setLayout(new BorderLayout());
		temp.setBackground(new Color(255,0,0,0));
		
		JPanel temp_label = new JPanel();
		temp.setPreferredSize(new Dimension(200,100));
		temp.add(temp_label, BorderLayout.SOUTH);
		
		JLabel label = new JLabel(new ImageIcon(dir+ImgFile));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBounds(100, 520, 120, 540);

		temp.add(label);  // default center section
//		temp.setBackground(new Color(255,0,0,0));
//		gamePanel.setPreferredSize(new Dimension(200,300));
//		temp.setBounds(0, 500, 600, 200);
//		temp.setBackground(Color.BLUE);
		
		
		/*****************************/
//		imgTemp.addMouseListener(new MyMouseListener());
//		gamePanel.add(imgTemp);
		/*****************************/

		gamePanel.add(temp);
		
		JPanel gameDetailPanel = new JPanel();
		gameDetailPanel.setBackground(new Color(255,0,0,0));
		gameDetailPanel.setLayout(new GridLayout(5,1, 200, 100));
		
		JPanel tempBtn1 = new JPanel();
		tempBtn1.setBackground(new Color(255,0,0,0));
		gameDetailPanel.add(tempBtn1);

		RoundedButton hangmanBtn = new RoundedButton("HANGMAN");
		hangmanBtn.setBackColor(new Color(255,247,242));
		hangmanBtn.setTextColor(new Color(247,99,12));
		hangmanBtn.setFont(btnFont);
//		hangmanBtn.setBounds(800, 200, 600, 100);
		hangmanBtn.addActionListener(this);
		hangmanBtn.setSize(600, 100);
		gameDetailPanel.add(hangmanBtn);
		
		
		RoundedButton baskinBtn = new RoundedButton("BASKIN ROBBINS");
		baskinBtn.setBackColor(new Color(255,247,242));
		baskinBtn.setTextColor(new Color(247,99,12));
		baskinBtn.setFont(btnFont);
//		baskinBtn.setBounds(700, 400, 270, 100);
		baskinBtn.addActionListener(this);
		gameDetailPanel.add(baskinBtn);
		
		RoundedButton javaBtn = new RoundedButton("JAVA GAME");
		javaBtn.setBackColor(new Color(255,247,242));
		javaBtn.setTextColor(new Color(247,99,12));
		javaBtn.setFont(btnFont);
		javaBtn.addActionListener(this);
		gameDetailPanel.add(javaBtn);
		
		JPanel tempBtn2 = new JPanel();
		tempBtn2.setBackground(new Color(255,0,0,0));
		gameDetailPanel.add(tempBtn2);

		gamePanel.add(gameDetailPanel);
		gamePanel.setPreferredSize(new Dimension(200,300));
		//gamePanel.setBackground(Color.BLACK);
		back2.setLayout(new GridLayout());
		back2.add(gamePanel);

		selectGamePage.add(back2);
		
		add(selectGamePage);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, 380, 250, this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCmd = e.getActionCommand();
		
		if(actionCmd.equals("START")) {
			startPage.setVisible(false);
			selectGamePage.setVisible(true);

		} else if(actionCmd.equals("EXIT")) {
			System.exit(0);
		} else if(actionCmd.equals("HANGMAN")) {
			HangMan hangmanGame = new HangMan();
			hangmanGame.setVisible(true);
			dispose();
		}else if(actionCmd.equals("BASKIN ROBBINS")) {
			BaskinRobbins baskinGame = new BaskinRobbins();
			baskinGame.setVisible(true);
			dispose();
		}else if(actionCmd.equals("JAVA GAME")) {
			JavaStartGame javaGame = new JavaStartGame();
			javaGame.setVisible(true);
			dispose();
		}
	}

}
