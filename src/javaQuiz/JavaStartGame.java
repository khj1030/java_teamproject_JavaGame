package javaQuiz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gamemain.BouncingBall;
import gamemain.GameStart;
import gamemain.RoundedButton;

public class JavaStartGame extends JFrame implements ActionListener {
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 900;
	public static final int BUTTON_WIDTH = 200;
	public static final int BUTTON_HEIGHT = 100;
		
	private Font titleFont = new Font("DX국민시대", Font.BOLD, 70);
	private Font btnFont = new Font("DX국민시대", Font.BOLD, 30);
		
	Panel startPage = new Panel();

	CardLayout card;
	
	public static void main(String[] args) {
		JavaStartGame java = new JavaStartGame();
		java.setVisible(true);
	}
	
	public JavaStartGame() { //자바 게임 시작 화면
		super("Java Game");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		
		card= new CardLayout(0, 0);
		setLayout(card);
		
		JPanel back = null;
		back = new BouncingBall();
		back.setLayout(new BorderLayout());
		back.setBackground(Color.WHITE);

		back.setBounds(0, 0, 1200, 900);
		
		JPanel temp = new JPanel();
		temp.setBackground(new Color(255,0,0,0));
		temp.setPreferredSize(new Dimension(200,200));
		back.add(temp, BorderLayout.NORTH);
		
		JPanel textPanel = new JPanel();
		textPanel.setBackground(new Color(255,0,0,0));
		textPanel.setLayout(new GridLayout(3,1));
		
		JLabel title = new JLabel("Solving the Wrong Java Problem");
		title.setFont(titleFont);
		title.setForeground(new Color(247,99,12));
		title.setHorizontalAlignment(JLabel.CENTER);
		textPanel.add(title);
		
		back.add(textPanel, BorderLayout.CENTER);

		JPanel btnPanel = new JPanel();
		btnPanel.setBackground(new Color(255,0,0,0));
		
		JPanel btnDetailPanel = new JPanel();
		btnDetailPanel.setBackground(new Color(255,0,0,0));

		btnDetailPanel.setLayout(new GridLayout(1,2, 200, 100));
		
		RoundedButton exitBtn = new RoundedButton("BACK");
		exitBtn.setBackColor(new Color(255,247,242));
		exitBtn.setTextColor(new Color(247,99,12));
		exitBtn.setFont(btnFont);
		exitBtn.addActionListener(this);
		exitBtn.setPreferredSize(new Dimension(200,80));
		btnDetailPanel.add(exitBtn);
		
		
		RoundedButton startBtn = new RoundedButton("START");
		startBtn.setBackColor(new Color(255,247,242));
		startBtn.setTextColor(new Color(247,99,12));
		startBtn.setFont(btnFont);
		startBtn.addActionListener(this);
		startBtn.setPreferredSize(new Dimension(200,100));
		btnDetailPanel.add(startBtn);
		
		
		btnPanel.add(btnDetailPanel);
		btnPanel.setPreferredSize(new Dimension(200,300));
		
		back.add(btnPanel, BorderLayout.SOUTH);
		
		add(back);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCmd = e.getActionCommand();
		
		if(actionCmd.equals("START")) {
			  Login frame2 = new Login();		//게임 시작 시, Login 화면으로
              frame2.setVisible(true);
              dispose();
		} else if(actionCmd.equals("BACK")) {
			GameStart game = new GameStart();	//게임 시작 하지 않을 시, Game의 가장 첫 화면으로
			game.setVisible(true);
			dispose();
		}
	}
}
