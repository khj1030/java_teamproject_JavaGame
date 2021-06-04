package baskin;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gamemain.BouncingBall;
import gamemain.CircleButton;
import gamemain.GameStart;
import gamemain.RoundedButton;


public class BaskinRobbins extends JFrame implements ActionListener {
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 900;
	public static final int BUTTON_WIDTH = 200;
	public static final int BUTTON_HEIGHT = 100;
	
	private Font btnFont = new Font("DX국민시대", Font.BOLD, 28);
	private Font btnFont2 = new Font("DX국민시대", Font.BOLD, 20);

	CardLayout card;
	Panel startPage = new Panel();
	Panel selectGamePage = new Panel();
	String answer="";
	int mode=0;
	int player=0;
	JTextField player1;
	
	public static void main(String[] args) {
		BaskinRobbins iconGui = new BaskinRobbins();
		iconGui.setVisible(true);
	}
	
	public BaskinRobbins() {
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		card= new CardLayout(0, 0);
		setLayout(card);
		
		JPanel back = null;
		back = new BouncingBall();
		back.setLayout(null);
		back.setBackground(Color.WHITE);
		back.setBounds(0, 0, 1200, 900);
		back.setLayout(new BorderLayout());

		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(255,0,0,0));
		topPanel.setLayout(new BorderLayout());
		
		CircleButton homeBtn = new CircleButton("HOME");
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
		
		JLabel BaskinRobbins=new JLabel("BaskinRobbins Game");
		BaskinRobbins.setBackground(Color.white);
		BaskinRobbins.setBounds(0,300,1200,70);
		BaskinRobbins.setFont(new Font("DX국민시대",Font.BOLD,70));
		BaskinRobbins.setHorizontalAlignment(JLabel.CENTER);
		BaskinRobbins.setForeground(new Color(247,99,12));
		back.add(BaskinRobbins);

		RoundedButton SingleBtn = new RoundedButton("SINGLE MODE");
		SingleBtn.setBackColor(new Color(255,247,242));
		SingleBtn.setTextColor(new Color(247,99,12));
		SingleBtn.setFont(btnFont);
		SingleBtn.setPreferredSize(new Dimension(200,100));
		SingleBtn.addActionListener(this);
		startDetailPanel.add(SingleBtn);
		
		RoundedButton MultiBtn = new RoundedButton("MULTI MODE");
		MultiBtn.setBackColor(new Color(255,247,242));
		MultiBtn.setTextColor(new Color(247,99,12));
		MultiBtn.setFont(btnFont);
		MultiBtn.setPreferredSize(new Dimension(200,100));
		MultiBtn.addActionListener(this);
		startDetailPanel.add(MultiBtn);
		
		startPanel.add(startDetailPanel);
		startPanel.setPreferredSize(new Dimension(200,300));

		back.add(startPanel, BorderLayout.SOUTH);

		startPage.add(back);
		
		add(startPage);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCmd = e.getActionCommand();
		
		if(actionCmd.equals("SINGLE MODE")) {                                        // 싱글 모드 선택 버튼
			BaskinRobbinsSingle game = new BaskinRobbinsSingle();
			game.setVisible(true);

		} else if(actionCmd.equals("MULTI MODE")) {                                  // 멀티 모드 선택 버튼
			BaskinRobbinsMulti game = new BaskinRobbinsMulti();
			game.setVisible(true);
		} else if(actionCmd.equals("HOME")) {                                        // 홈으로 돌아가는 버튼
			GameStart game =new GameStart();
			game.setVisible(true);
			dispose();
		}
	}
}
