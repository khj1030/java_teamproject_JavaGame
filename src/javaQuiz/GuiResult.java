package javaQuiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gamemain.GameStart;
import gamemain.RoundedButton;


public class GuiResult extends JFrame implements ActionListener{ // 자바 게임 결과 출력
	public static final int WINDOW_WIDTH  = 1200;
	public static final int WINDOW_HEIGHT = 900;

	private int idx = 1;
	
	private Font textFont = new Font("DX국민시대", Font.BOLD, 30);

	Iterator it; 	//TreeSet 순회
	
	public static void main(String[] args){
		GuiResult gr=new GuiResult("Theory");
		gr.setVisible(true);
	}
	GuiResult(String Gametype){
		super("result");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBackground(Color.white);
		String st="<html>";
		if(Gametype.equals("Theory")) {
			TheoryResult result = new TheoryResult();
			it = result.ts.iterator();
		}else if(Gametype.equals("Lab")) {
			LabResult result = new LabResult();
			it = result.ts.iterator();
		}
	
		
		while(it.hasNext()) {
			if(idx > 10) { //Top 10만 순위 출력
				break;
			}
			Student t = (Student)it.next();
			st += Integer.toString(idx) + "등) "+t+"<br/>";
			idx++;
			
		}
		st+="</html>";
		JPanel showPanel=new JPanel();
		showPanel.setLayout(null);
		showPanel.setBackground(Color.WHITE);
		JLabel title = new JLabel(Gametype.toUpperCase()+" GAME RESULT");
		title.setFont(new Font("DX국민시대",Font.BOLD,40));
		title.setForeground(new Color(247,99,12)); 
		title.setBounds(270,20,500,100);
		title.setHorizontalAlignment(JLabel.CENTER);

		JLabel explan=new JLabel("<TOP 10>");
		explan.setFont(new Font("DX국민시대",Font.BOLD,40));
		explan.setForeground(new Color(247,99,12)); 
		explan.setBounds(350,20,300,250);
		explan.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel text=new JLabel(st);
		text.setFont(new Font("DX국민시대",Font.BOLD,30));
		text.setBounds(200,30,500,530);
		showPanel.add(title);
		showPanel.add(explan);
		showPanel.add(text);
		showPanel.setBounds(100,50,1000,660);
		add(showPanel);
		
		RoundedButton checkButton=new RoundedButton("확인");
		checkButton.setFont(textFont);
		checkButton.setBackColor(new Color(255,247,242));
		checkButton.setTextColor(new Color(247,99,12));
		checkButton.addActionListener(this);
		checkButton.setBounds(550,740,150,80);
		add(checkButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String m=e.getActionCommand();
		if(m.equals("확인")) {
			JavaStartGame game = new JavaStartGame();
			game.setVisible(true);
			dispose();
		}
	}
}
