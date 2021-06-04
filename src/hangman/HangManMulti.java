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

public class HangManMulti extends JFrame {
		public static final int WINDOW_WIDTH  = 1200;
		public static final int WINDOW_HEIGHT = 900;
		
		private String show="";
		private String wrong="   Wrong: ";
		private int total=0;
		
		private JTextField jf;
		private JLabel label;
		private JLabel Wronglabel;
		
		private int player=6;
		private int move=100;
		
		private JTextField player1;
		private int score[]=new int[player];
		private int check=0;
		private int len=0;
		
		private JLabel[] texts=new JLabel[player-1];
		private String answer="";
		private char[] user=new char[30];
		private int [] path=new int[30];
		private int mode;
		
		public static final String srcPath="src";
		public static final String packageName="teamproject";
		
		public HangManMulti(String answer,int player,int mode) {
			super("multiHangMan");
			this.answer=answer;
			this.player=player;
			this.mode=mode;
			setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setBackground(Color.white);
			setLayout(null);
			setLocationRelativeTo(null);
			
			JPanel playerPanel=new JPanel();
			playerPanel.setBackground(Color.white);
			playerPanel.setLayout(new GridLayout(player-1,1,10,10));
			JPanel[] players=new JPanel[player-1];
			
			String currentProjPath="";
			try {
				currentProjPath=new File(".").getCanonicalPath();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			String moodCheckFileName="fire6.gif";//이미지
			String duckImgIconFilePath= currentProjPath+"/"+srcPath+"/"+packageName+"/"+moodCheckFileName;
			ImageIcon duckIcon=new ImageIcon(duckImgIconFilePath);
			
			JLabel duckLabel=new JLabel();
			duckLabel.setIcon(duckIcon);
			duckLabel.setBounds(100,400,200,200);
			duckLabel.setBackground(new Color(255,0,0,0));
			add(duckLabel);
			
			if(player>=2) {//player수 만큼 panel 추가
				players[0]=new JPanel();
				players[0].setBackground(new Color(255,247,242));
				texts[0]=new JLabel("점수: "+score[0]);
				texts[0].setFont(new Font("DX국민시대",Font.BOLD,20));
				texts[0].setForeground(new Color(247,99,12));
				players[0].add(texts[0]);
				playerPanel.add(players[0]);
			}
			if(player>=3) {
				players[1]=new JPanel();
				players[1].setBackground(new Color(255,247,242));
				texts[1]=new JLabel("점수: "+score[1]);
				texts[1].setFont(new Font("DX국민시대",Font.BOLD,20));
				texts[1].setForeground(new Color(247,99,12));
				players[1].add(texts[1]);
				playerPanel.add(players[1]);
			}
			if(player>=4) {
				players[2]=new JPanel();
				players[2].setBackground(new Color(255,247,242));
				texts[2]=new JLabel("점수: "+score[2]);
				texts[2].setFont(new Font("DX국민시대",Font.BOLD,20));
				texts[2].setForeground(new Color(247,99,12));
				players[2].add(texts[2]);
				playerPanel.add(players[2]);
			}
			if(player>=5) {
				players[3]=new JPanel();
				players[3].setBackground(new Color(255,247,242));
				texts[3]=new JLabel("점수: "+score[3]);
				texts[3].setFont(new Font("DX국민시대",Font.BOLD,20));
				texts[3].setForeground(new Color(247,99,12));
				players[3].add(texts[3]);
				playerPanel.add(players[3]);
			}
			if(player>=6) {
				players[4]=new JPanel();
				players[4].setBackground(new Color(255,247,242));
				texts[4]=new JLabel("점수: "+score[4]);
				texts[4].setForeground(new Color(247,99,12));
				texts[4].setFont(new Font("DX국민시대",Font.BOLD,20));
				players[4].add(texts[4]);
				playerPanel.add(players[4]);
			}
			playerPanel.setBounds(600,200,600,500);
			add(playerPanel);
			
			JPanel showPanel=new JPanel();
			showPanel.setLayout(new GridLayout(2,1));
			showPanel.setBackground(Color.white);
			for(int i=0;i<answer.length()*2;i++) {
				if(i%2==0)
					user[i]='_';
				else
					user[i]=' ';
			}
			
			show=String.valueOf(user);
			
			label=new JLabel("   "+show);
			label.setFont(new Font("DX국민시대",Font.BOLD,30));
			label.setForeground(new Color(247,99,12));
			showPanel.add(label);
			
			Wronglabel=new JLabel(wrong);
			Wronglabel.setFont(new Font("DX국민시대",Font.PLAIN,30));
			Wronglabel.setForeground(new Color(247,99,12));
			showPanel.add(Wronglabel);
			
			showPanel.setBounds(600,0,600,190);
			showPanel.setBackground(new Color(255,247,242));
			
			add(showPanel);
			
			JPanel textPanel=new JPanel();
			textPanel.setLayout(new FlowLayout());
			textPanel.setBackground(Color.white);
			
			jf = new JTextField(12);
			jf.setFont(new Font("DX국민시대",Font.BOLD,20));
			jf.setBackground(Color.WHITE);
			textPanel.add(jf);
			
			RoundedButton checkButton=new RoundedButton("확인");
			checkButton.addActionListener(new checkAction());
			checkButton.setFont(new Font("DX국민시대",Font.BOLD,20));
			checkButton.setBackColor(new Color(255,247,242));
			checkButton.setTextColor(new Color(247,99,12));
			
			textPanel.add(checkButton);
			textPanel.setBounds(400,700,300,100);
			
			add(textPanel);
		}
	
		public void paint(Graphics g) {//핵맨 그리기
			
			super.paint(g);
			
			g.drawLine(move+50, move+50, move+150, move+50);
			g.drawLine(move+100, move+50, move+100, move+100);//줄
			
			if(check>=1) {
				g.drawOval(move+75, move+100, 50, 50);//얼굴
			}
			if(check>=2) {
				g.drawLine(move+100, move+150, move+100, move+250);//몸통
			}
			if(check>=3) {
				g.drawLine(move+100, move+200, move+50, move+175);//팔
			}
			if(check>=4) {
				g.drawLine(move+100,move+ 200, move+150, move+175);//팔
			}
			if(check>=5) {
				g.drawLine(move+100, move+250, move+50, move+300);//다리
			}
			if(check>=6) {
				g.drawLine(move+100, move+250, move+150, move+300);
			}
			if(mode == 7) {
				if(check>=7) { 
					g.drawLine(move+85, move+120, move+95, move+120);//눈
					g.drawLine(move+105, move+120, move+115, move+120);//눈
					g.drawArc(move+95, move+125, 10, 5, 180, 180);//입
				}
			}else {
				if(check>=7) { 
					g.drawLine(move+85, move+120, move+95, move+120);//눈
				}
				if(check>=8) {
					g.drawLine(move+105, move+120, move+115, move+120);//눈
				}
				if(check>=9) {
					g.drawArc(move+95, move+125, 10, 5, 180, 180);//입
				}
			}
			
		}
		private class checkAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				String tmp=jf.getText();
				int cnt=0;
				if(tmp.equals("")) {//없을 경우 type error
					JOptionPane.showMessageDialog(null, "type error.", "Error",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					for(int i=0;i<answer.length()*2;i++) {
						if(i%2==0 && tmp.charAt(0)==answer.charAt(i/2) && path[i]==1) {//같은 char 나올 경우
							JOptionPane.showMessageDialog(null, "same char", "Error",JOptionPane.INFORMATION_MESSAGE);
							break;
						}
						else if(i%2==0 && path[i]==0 && tmp.charAt(0)==answer.charAt(i/2)){//알파벳이 같은 경우
							int temp=total%(player-1);
							score[temp]+=20;
							texts[temp].setText("점수: "+score[temp]);
							user[i]=tmp.charAt(0);
							path[i]=1;
							show=String.valueOf(user);
							label.setText("   "+show);
							len++;
							cnt=1;
						}
					}
					if(len==answer.length()) {//다 찾은 경우
						int[] max=new int[10];
						int idx=0,i=0;
						String st="";
						for(i=0;i<player-1;i++) {
							if(i!=0 && score[i]==score[max[idx]]) {
								idx++;
								max[idx]=i;
							}
							else if(score[i]>=score[max[idx]]) {
								idx=0;
								max[idx]=i;
							}
						}
						st+="player"+(max[0]+2)+" ";
						for(i=1;i<=idx;i++) {
							System.out.println(score[max[0]]+" "+score[max[i]]);
							if(score[max[0]]!=score[max[i]]) {
								break;
							}
							else {
								st+="& player "+(max[i]+2)+" ";
							}
						}
						JOptionPane.showMessageDialog(null, st+" win.", "Success",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						//게임 첫화면으로
					}
					if(cnt==0) {
						wrong+=tmp;
						Wronglabel.setText(wrong);
						if(check==mode) {//다 찾지 못한 경우
							JOptionPane.showMessageDialog(null, "player 1 win.", "Success",JOptionPane.INFORMATION_MESSAGE);
							dispose();
							//게임 첫화면으로
						}
						check++;
						repaint();
					}
				}
				total++;
				jf.setText("");
			}
		}
	}


