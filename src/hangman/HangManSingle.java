package hangman;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gamemain.RoundJTextField;
import gamemain.RoundedButton;

public class HangManSingle extends JFrame {
	public static final int WINDOW_WIDTH  = 1200;
	public static final int WINDOW_HEIGHT = 900;
	String show="";
	String wrong="   Wrong: ";
	JTextField jf;
	JLabel label;
	int move=100;
	JLabel Wronglabel;
	int check=0;
	int len=0;
	String answer="";
	char[] user=new char[30];
	int [] path=new int[30];
	int mode;
	public static final String srcPath="src";
	public static final String packageName="hangman";
	
	public HangManSingle(int mode,String answer) {
		super("HangMan");
		this.mode=mode;
		this.answer=answer;
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JPanel showPanel=new JPanel();
		showPanel.setLayout(new GridLayout(2,1));
		showPanel.setBackground(Color.black);
		for(int i=0;i<answer.length()*2;i++) {
			if(i%2==0)
				user[i]='_';
			else
				user[i]=' ';
		}
		
		String currentProjPath="";
		try {
			currentProjPath=new File(".").getCanonicalPath();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		String moodCheckFileName="fire6.gif";//�̹���
		String duckImgIconFilePath= currentProjPath+"/"+srcPath+"/"+packageName+"/"+moodCheckFileName;
		ImageIcon duckIcon=new ImageIcon(duckImgIconFilePath);
		JLabel duckLabel=new JLabel();
		duckLabel.setIcon(duckIcon);
		duckLabel.setBounds(100,400,200,200);
		duckLabel.setBackground(new Color(255,0,0,0));
		add(duckLabel);
		setLocationRelativeTo(null);
		show=String.valueOf(user);
		label=new JLabel("   "+show);
		label.setFont(new Font("DX���νô�",Font.BOLD,30));
		label.setForeground(new Color(247,99,12));
		showPanel.add(label);
		Wronglabel=new JLabel(wrong);
		Wronglabel.setFont(new Font("DX���νô�",Font.PLAIN,30));
		Wronglabel.setForeground(new Color(247,99,12));
		showPanel.add(Wronglabel);
		showPanel.setBounds(600,200,550,300);
		showPanel.setBackground(new Color(255,247,242));
		add(showPanel);
		
		JPanel textPanel=new JPanel();
		textPanel.setLayout(new FlowLayout());
		textPanel.setBackground(Color.white);
		jf=new JTextField(12);
		jf.setFont(new Font("DX���νô�",Font.BOLD,20));
		jf.setBackground(Color.WHITE);
		textPanel.add(jf);
		RoundedButton checkButton=new RoundedButton("Ȯ��");
		checkButton.setFont(new Font("DX���νô�",Font.BOLD,20));
		checkButton.setBackColor(new Color(255,247,242));
		checkButton.setTextColor(new Color(247,99,12));
		checkButton.addActionListener(new checkAction());
		textPanel.add(checkButton);
		textPanel.setBackground(new Color(255,0,0,0));
		textPanel.setBounds(400,700,300,100);
		add(textPanel);
	}
	
	public void paint(Graphics g) {//�ٸ� �׸���
		
		super.paint(g);
		
		g.drawLine(move+50, move+50, move+150, move+50);
		g.drawLine(move+100, move+50, move+100, move+100);//��
		
		if(check>=1) {
			g.drawOval(move+75, move+100, 50, 50);//��
		}
		if(check>=2) {
			g.drawLine(move+100, move+150, move+100, move+250);//����
		}
		if(check>=3) {
			g.drawLine(move+100, move+200, move+50, move+175);//��
		}
		if(check>=4) {
			g.drawLine(move+100,move+ 200, move+150, move+175);//��
		}
		if(check>=5) {
			g.drawLine(move+100, move+250, move+50, move+300);//�ٸ�
		}
		if(check>=6) {
			g.drawLine(move+100, move+250, move+150, move+300);
		}
		if(mode == 7) {
			if(check>=7) { 
				g.drawLine(move+85, move+120, move+95, move+120);//��
				g.drawLine(move+105, move+120, move+115, move+120);//��
				g.drawArc(move+95, move+125, 10, 5, 180, 180);//��
			}
		}else {
			if(check>=7) { 
				g.drawLine(move+85, move+120, move+95, move+120);//��
			}
			if(check>=8) {
				g.drawLine(move+105, move+120, move+115, move+120);//��
			}
			if(check>=9) {
				g.drawArc(move+95, move+125, 10, 5, 180, 180);//��
			}
		}
		
		
	}
	
	private class checkAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String tmp=jf.getText();
			int cnt=0;
			if(tmp.equals("")) {//�ƹ� �͵� ���� ��� type error
				JOptionPane.showMessageDialog(null, "type error.", "Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				for(int i=0;i<answer.length()*2;i++) {
					if(i%2==0 && tmp.charAt(0)==answer.charAt(i/2) && path[i]==1) {//���� ���ĺ��� ģ ���
						JOptionPane.showMessageDialog(null, "same char", "Error",JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					else if(i%2==0 && path[i]==0 && tmp.charAt(0)==answer.charAt(i/2)){//���� ���
						user[i]=tmp.charAt(0);
						show=String.valueOf(user);
						path[i]=1;
						label.setText("   "+show);
						len++;
						cnt=1;
					}
				}
				if(len==answer.length()) {//�ܾ ã�� ���
					JOptionPane.showMessageDialog(null, "you win.", "Success",JOptionPane.INFORMATION_MESSAGE);
					dispose();
					//���� ùȭ������
				}
				if(cnt==0) {
					wrong+=tmp;
					Wronglabel.setText(wrong);
					if(check==mode) {//�ܾ �� ��ã�� ���
						JOptionPane.showMessageDialog(null, "Game over.you lose.", "Failure",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						//���� ùȭ������
					}
					check++;
					repaint();
				}
			}
			jf.setText("");
		}
	}
}


