package javaQuiz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gamemain.BouncingBall;
import gamemain.RoundJTextField;
import gamemain.RoundedButton;

public class Login extends JFrame implements ActionListener{
	public static final int WINDOW_WIDTH  = 1200;
	public static final int WINDOW_HEIGHT = 900;
	public static final int SMALL_WIDTH = 600;
	public static final int SMALL_HEIGHT = 400;
	
	private Font titleFont = new Font("DX국민시대", Font.BOLD, 60);
	private Font textFont = new Font("DX국민시대", Font.BOLD, 30);
	
	
	private String id="";
	private RoundJTextField login;
	
	public static void main(String[] args) {
		Login l=new Login();
		l.setVisible(true);
	}
	
	public Login(){
		super("login");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//가운데 정렬
	    Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation(res.width / 2 - WINDOW_WIDTH / 2, res.height / 2 - WINDOW_HEIGHT / 2);
		getContentPane().setBackground(new Color(255,0,0,0));
		setLayout(null);
		
		JPanel back = null;
		back = new BouncingBall();
		back.setLayout(null);
		back.setBackground(Color.CYAN);
		add(back);
		back.setBounds(0, 0, 1200, 900);
		
		JLabel beforestart=new JLabel("Please enter your ID");
		beforestart.setFont(titleFont);
		beforestart.setForeground(Color.BLACK);
		beforestart.setBounds(0,200,1200,200);
		beforestart.setHorizontalAlignment(JLabel.CENTER);

		back.add(beforestart);
		
		JPanel answerPanel=new JPanel();
		login=new RoundJTextField(12);
		login.setFont(textFont);
		login.addActionListener(this);
		answerPanel.add(login);
		answerPanel.setBackground(new Color(255,0,0,0));
		
		RoundedButton ok=new RoundedButton("확인");
		ok.setFont(textFont);
		ok.setBackColor(new Color(255,247,242));
		ok.setTextColor(new Color(247,99,12));
		ok.addActionListener(this);
		answerPanel.add(ok);
		answerPanel.setBounds(280,450,600,100);
		back.add(answerPanel);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String m=e.getActionCommand();
		if(m.equals("확인")) {
			id = login.getText();
			if(id.equals("")) {	//아이디가 null값이라면 경고문 띄우기
				JOptionPane.showMessageDialog(this, 
						"ID cannot be null.", 
						"Submission Error", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JavaSelectType javaGame = new JavaSelectType(id);
				javaGame.setVisible(true);
				dispose();
				
			}

		}
		
	}
}
