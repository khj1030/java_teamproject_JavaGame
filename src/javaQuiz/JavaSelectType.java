package javaQuiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gamemain.RoundedButton;

public class JavaSelectType extends JFrame implements ActionListener {
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 900;
	public static final int SMALL_WIDTH = 600;
	public static final int SMALL_HEIGHT = 400;
		
	private Font textFont = new Font("DX국민시대", Font.BOLD, 60);
	private Font textFont2 = new Font("DX국민시대", Font.BOLD, 30);

	private Font btnFont = new Font("DX국민시대", Font.BOLD, 30);
	
	private JTextField input;
	
	private String GameType;		// 이론 or 실습 선택
	
	private Student user = new Student();	
	private LabResult labUserResult = new LabResult();
	private TheoryResult theoryUserResult = new TheoryResult();
	
	private boolean check = false;	//아이디 존재 여부

	private String id;				// 사용자 아이디 
	
	public static void main(String[] args) {
//		JavaSelectType java = new JavaSelectType();
//		java.setVisible(true);
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public JavaSelectType(String idtemp) {
		// Implement
		super("Java Game");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		
		this.id = idtemp;		
		
		JPanel temp = new JPanel();
		temp.setBackground(Color.WHITE);
		temp.setPreferredSize(new Dimension(200,200));
		add(temp, BorderLayout.NORTH);
		
		JPanel textPanel = new JPanel();
		textPanel.setBackground(Color.WHITE);
		textPanel.setLayout(new GridLayout(3,1));
		
		JLabel title = new JLabel("Please Select a Game Type");
		title.setFont(textFont);
		title.setHorizontalAlignment(JLabel.CENTER);
		textPanel.add(title);
		
		JLabel option = new JLabel("(Lab / Theory)");
		option.setFont(textFont);
		option.setHorizontalAlignment(JLabel.CENTER);
		textPanel.add(option);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(Color.WHITE);
		
		input = new JTextField(15);
		input.setFont(textFont);
		input.setHorizontalAlignment(JLabel.CENTER);
		
		inputPanel.add(input);
		textPanel.add(inputPanel);
		
		add(textPanel, BorderLayout.CENTER);

		
		JPanel btnPanel = new JPanel();
		btnPanel.setBackground(Color.WHITE);
		
		JPanel btnDetailPanel = new JPanel();
		btnDetailPanel.setBackground(Color.WHITE);

		btnDetailPanel.setLayout(new GridLayout(1,2, 200, 100));
		
		RoundedButton exitBtn = new RoundedButton("BACK");
		exitBtn.setBackColor(new Color(255,247,242));
		exitBtn.setTextColor(new Color(247,99,12));
		exitBtn.setFont(btnFont);
		exitBtn.addActionListener(this);
		exitBtn.setPreferredSize(new Dimension(200,80));
		btnDetailPanel.add(exitBtn);
		
		RoundedButton startBtn = new RoundedButton("NEXT");
		startBtn.setBackColor(new Color(255,247,242));
		startBtn.setTextColor(new Color(247,99,12));
		startBtn.setFont(btnFont);
		startBtn.addActionListener(this);
		startBtn.setPreferredSize(new Dimension(200,100));
		btnDetailPanel.add(startBtn);
		
		btnPanel.add(btnDetailPanel);
		btnPanel.setPreferredSize(new Dimension(200,300));
		
		add(btnPanel, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCmd = e.getActionCommand();
		if(actionCmd.equals("NEXT")) {
			if(input.getText().equalsIgnoreCase("Theory")) {
				GameType = "Theory";
				
				if(!theoryUserResult.ts.isEmpty()) { //아이디가 있으면
					for(Student usertemp : theoryUserResult.ts) {
						if(usertemp.getId().equals(id)) {
							
							user = new Student(usertemp); //유저에 담기
							
							RevisitWindow revisit = new RevisitWindow();
							revisit.setVisible(true);
							
							check = true; //아이디 존재
							dispose();
							
							break;
						}
					}
				}
				
				if(!check) { //아이디가 없는 상태
					TheoryJavaGame javaGame = new TheoryJavaGame(id);
					javaGame.setVisible(true);
					dispose();
				}
				
			} else if(input.getText().equalsIgnoreCase("Lab")) {
				GameType = "Lab";
				
				if(!labUserResult.ts.isEmpty()) { //아이디가 있으면
					for(Student usertemp : labUserResult.ts) {
						if(usertemp.getId().equals(id)) {
							
							user = new Student(usertemp); //유저에 담기
							
							RevisitWindow revisit = new RevisitWindow();
							revisit.setVisible(true);
														
							check = true; //아이디 존재
							dispose();
							
							break;
						}
					}
				}
				
				if(!check) { //아이디가 없는 경우
					LabJavaGame javaGame = new LabJavaGame(id);
					javaGame.setVisible(true);
					dispose();
				}
			}
			
		} else if(actionCmd.equals("BACK")) { //로그인 페이지로 돌아가기
			Login log = new Login();
			log.setVisible(true);
			dispose();
		}
	}
    
	private class RevisitWindow extends JFrame 
						implements ActionListener{
		//아이디가 이미 있는 경우, 재게임 여부 선택 화면
		public RevisitWindow() {
			setSize(SMALL_WIDTH, SMALL_HEIGHT);
			setLocationRelativeTo(null);
			getContentPane().setBackground(new Color(255,247,242));
			setLayout(new BorderLayout());
			
			String strNextLine = "<html>Your ID is recorded. <br/> " + user.getSuccess() + " / "+ user.getProblem() +"<br/>Would you like to replay? </html>";

			JLabel confirmLabel = new JLabel(strNextLine);
			confirmLabel.setFont(textFont2);
			add(confirmLabel, BorderLayout.CENTER);
			
			JPanel btnPanel = new JPanel();
			btnPanel.setBackground(new Color(247,99,12));
			btnPanel.setLayout(new GridLayout());
			
			JButton exitBtn = new JButton("Yes");
			exitBtn.addActionListener(this);
			exitBtn.setPreferredSize(new Dimension(100,50));
			btnPanel.add(exitBtn);
			
			JButton cancelBtn = new JButton("No");
			cancelBtn.addActionListener(this);
			cancelBtn.setPreferredSize(new Dimension(100,50));

			btnPanel.add(cancelBtn);
			
			add(btnPanel, BorderLayout.SOUTH);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String actionCmd = e.getActionCommand();
			if(actionCmd.equals("Yes")) { //재게임 하겠다
				
				if(GameType.equalsIgnoreCase("Theory")) { //이론 게임 선택 
					TheoryJavaGame theoryjava = new TheoryJavaGame(user.getId());
					theoryjava.setVisible(true);
				}else if(GameType.equalsIgnoreCase("Lab")) { //실습 게임 선택 
					LabJavaGame labjava = new LabJavaGame(user.getId());
					labjava.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(new TheoryJavaGame(user.getId()), 
							"Please enter it correctly.", 
							"Submission Error", 
							JOptionPane.INFORMATION_MESSAGE);
				}
				dispose();

			}else if(actionCmd.equals("No")) { //재게임 하지 않겠다
				Login log = new Login(); //로그인 페이지로 돌아가기
				log.setVisible(true);
				dispose();
			}else
				System.out.println("Unexpected Error"
						+ " in Confirm Window");
		}
		
	} // end of RevisitWindow
	
}
