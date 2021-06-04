package javaQuiz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

//import HW10.Account;
//import WindowListenerDemo.ConfirmWindow;
import gamemain.CircleButton;
import gamemain.RoundJTextField;
import gamemain.RoundedButton;

public class TheoryJavaGame extends JFrame implements ActionListener {
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 900;
	public static final int SMALL_WIDTH = 600;
	public static final int SMALL_HEIGHT = 400;
	
	private int count = 0;
	private int iter = 0;
	private int index;
	private int numTrue = 0;
	
	private BufferedImage pic;
	
	private String answerImgFile = "answer_check.png";				//���� Image
	private String wrongAnswerImgFile = "wrong_answer_check.png";	//���� Image
	
	private String userAnswer = "";									//����� ���
	
	private Student user = new Student();							//������ ����� ���� ����
	private TheoryResult userResult = new TheoryResult();			//����� ���� file�� ���

	private boolean check = false;									//���̵� ���� ����
	
	public static final String packageName="javaQuiz";
	public static final String srcPath="src";
	
	private String currentPath;
	private String currentPath2;
	
	private Font textFont = new Font("DX���νô�", Font.BOLD, 30);
	private Font btnFont = new Font("DX���νô�", Font.BOLD, 30);
	private Font btnFont2 = new Font("DX���νô�", Font.BOLD, 20);
		
	private ArrayList<TheoryDataClass> quizList = new ArrayList<TheoryDataClass>();
	private ArrayList<Panel> panelList = new ArrayList<Panel>();
	private ArrayList<JTextField> textFieldList = new ArrayList<JTextField>();
	
	CardLayout card;
	
	String userFileName = "userList.txt"; 
	String fileName = "theory.txt";
	
	File fileObj = null;
	
	Scanner userinputStream = null;
	Scanner inputStream = null;
	PrintWriter outputStream = null;
	
	public static void main(String[] args) {
//		TheoryJavaGame java = new TheoryJavaGame("..");
//		java.setVisible(true);
	}
	
	public TheoryJavaGame(String idtemp) {
		// Implement
		super("Java Game");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		card= new CardLayout(0, 0);
		setLayout(card);
		
		String currentProjPath="";
		try {
			currentProjPath=new File(".").getCanonicalPath();
		}catch(IOException e) {
			e.printStackTrace();
		}
		currentPath= currentProjPath+"/"+srcPath+"/";
		currentPath2= currentProjPath+"/"+srcPath+"/"+packageName+"/";
		
		
		fileObj = new File(currentPath+userFileName);
		
		if(!userResult.ts.isEmpty()) { //���̵� ������
			for(Student usertemp : userResult.ts) {
				if(usertemp.getId().equals(idtemp)) {
					
					user = new Student(usertemp);	//������ ���
						
					userResult.ts.remove(usertemp);
					
					check = true; //���̵� ����
					break;
				}
			}
		}
		
		if(!check) { //���̵� ���� ���
			user.setId(idtemp);
		}
		
		try {
			inputStream = new Scanner(new InputStreamReader(new FileInputStream(currentPath+fileName),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			
		} catch (FileNotFoundException e) {

		}
		
		while(inputStream.hasNext()) {
			
			TheoryDataClass quiz = new TheoryDataClass();
			quiz.setQuizNum(++count);
			quiz.setExplanation(inputStream.nextLine());
			quiz.setQuestion(inputStream.nextLine());
			quiz.setAnswer(inputStream.nextLine());
			
			/* ��ü�� ���δ� Panel */
			Panel newPanel = new Panel();
			newPanel.setLayout(new BorderLayout());
			
			/* QuizText Panel */
			JPanel temp = new JPanel();
			temp.setBackground(Color.WHITE);
			temp.setLayout(new BorderLayout());
			
			/* ���� �� �Է¶� Panel */
			JPanel textPanel = new JPanel();
			textPanel.setBackground(Color.WHITE);
			textPanel.setLayout(new BorderLayout());
			
			/* ���� Panel */
			JPanel imgPanel = new ChangeImagePanel();
			imgPanel.setLayout(new GridLayout(2,1));
			imgPanel.setBackground(Color.WHITE);
			
			JLabel explanation = new JLabel();
			explanation.setText(Integer.toString(quiz.getQuizNum())+". "+quiz.getExplanation());
			explanation.setFont(textFont);
			explanation.setHorizontalAlignment(JLabel.CENTER);
			
			imgPanel.add(explanation);
						
			JPanel questionBox = new JPanel();
			questionBox.setLayout(new BorderLayout());
			
			JTextPane question = new JTextPane();
			question.setBackground(Color.WHITE);
			question.setText(quiz.getQuestion());
			question.setFont(textFont);
			question.setEditable(false);
			StyledDocument document = question.getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			document.setParagraphAttributes(0, document.getLength(), center, false);
			
			questionBox.add(question, BorderLayout.CENTER);
			
			imgPanel.add(question); 
		
			textPanel.add(imgPanel, BorderLayout.CENTER);
			
			/* ��� �Է� Panel */
			JPanel inputPanel = new JPanel();
			inputPanel.setBackground(Color.WHITE);
			
			RoundJTextField input = new RoundJTextField(15);
			input.setFont(textFont);
			input.setHorizontalAlignment(JLabel.CENTER);
			
			textFieldList.add(input);
			inputPanel.setPreferredSize(new Dimension(200,100));
			inputPanel.add(input);
			
			textPanel.add(inputPanel, BorderLayout.SOUTH);
			
			newPanel.add(textPanel, BorderLayout.CENTER);
			
			/* Button Panel */
			JPanel btnPanel = new JPanel();
			btnPanel.setBackground(Color.WHITE);
			
			JPanel btnDetailPanel = new JPanel();
			btnDetailPanel.setBackground(Color.WHITE);

			btnDetailPanel.setLayout(new GridLayout(1,2, 200, 100));
			
			RoundedButton backBtn = new RoundedButton("BACK");
			backBtn.setBackColor(new Color(255,247,242));
			backBtn.setTextColor(new Color(247,99,12));
			backBtn.setFont(btnFont);
			backBtn.addActionListener(this);
			backBtn.setPreferredSize(new Dimension(200,80));
			btnDetailPanel.add(backBtn);
			
			RoundedButton startBtn = new RoundedButton("NEXT");
			startBtn.setBackColor(new Color(255,247,242));
			startBtn.setTextColor(new Color(247,99,12));
			startBtn.setFont(btnFont);
			startBtn.addActionListener(this);
			startBtn.setPreferredSize(new Dimension(200,100));
			btnDetailPanel.add(startBtn);
			
			JPanel btnBottomPanel = new JPanel();
			btnBottomPanel.setBackground(Color.WHITE);
			
			CircleButton exitBtn = new CircleButton("EXIT");
			exitBtn.setBackColor(new Color(255,247,242));
			exitBtn.setTextColor(new Color(247,99,12));
			exitBtn.setFont(btnFont2);
			exitBtn.addActionListener(this);
			
			temp.setPreferredSize(new Dimension(0,80));
			temp.add(exitBtn, BorderLayout.EAST);
			
			newPanel.add(temp, BorderLayout.NORTH);

			btnPanel.add(btnDetailPanel);
			btnPanel.setPreferredSize(new Dimension(200,300));
			
			newPanel.add(btnPanel, BorderLayout.SOUTH);
			
			/* List�� ���� */
			panelList.add(newPanel);
			quizList.add(quiz);
		}
		
		user.setProblem(count);

		for(int i=0; i<panelList.size(); i++) {
			if(i!=0) {
				panelList.get(i).setVisible(false);
			}
			add(panelList.get(i));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCmd = e.getActionCommand();
		
		if(actionCmd.equals("NEXT")) {						//���� ������ �Ѿ	
			threadClass th = new threadClass();
			th.start();
		} else if(actionCmd.equals("BACK")) {				// �� ������ ���ư�
			if(iter > 0) {
				panelList.get(iter).setVisible(false);
				panelList.get(--iter).setVisible(true);
				pic = quizList.get(iter).getSolvedImg();	//������ ä�� Image�� �ٽ� ������
				panelList.get(iter).repaint();
			}
		}else if(actionCmd.equals("EXIT")) {				//�߰��� ������ ���
			ConfirmWindow checkers = new ConfirmWindow();
			checkers.setVisible(true);
			
			dispose();

		}
    	
	}
	
	class threadClass extends Thread {
    	public void run() {
    		
    		if(quizList.get(iter).getSolvedCheck() == -1) { //������ �� Ǯ�� ����
				userAnswer = textFieldList.get(iter).getText();
				quizList.get(iter).setUesrAnswer(userAnswer);
				
				if(userAnswer.equalsIgnoreCase(quizList.get(iter).getAnswer())) { // ������ ��
					if(quizList.get(iter).getSolvedCheck() != 1) {
						quizList.get(iter).setSolvedCheck(1);
						numTrue++;
						try {
							quizList.get(iter).setSolvedImg(ImageIO.read(new File(currentPath2+ answerImgFile)));
						} catch (IOException e1) {

						}
					}
					pic = quizList.get(iter).getSolvedImg();
					panelList.get(iter).repaint();
				} else { // ������ ��
					quizList.get(iter).setSolvedCheck(0);
						
					try {
						quizList.get(iter).setSolvedImg(ImageIO.read(new File(currentPath2+ wrongAnswerImgFile)));
					} catch (IOException e1) {

					}
					pic = quizList.get(iter).getSolvedImg();
					panelList.get(iter).repaint(); 
				}
			}else { //������ Ǯ�� ���� (���� or ����)
				
				if(!textFieldList.get(iter).getText().equalsIgnoreCase(quizList.get(iter).getUesrAnswer())) {
					//������ Ǯ�� ���� ������(�̹� ä���� �Ǿ��� ���� ������), ��� ���� �Ұ�
					JOptionPane.showMessageDialog(new TheoryJavaGame(user.getId()), 
							"You cannot modify it.", 
							"Submission Error", 
							JOptionPane.INFORMATION_MESSAGE);
					textFieldList.get(iter).setText(quizList.get(iter).getUesrAnswer());
				}
				pic = quizList.get(iter).getSolvedImg();
				panelList.get(iter).repaint();
			}
    		
			try {
				Thread.sleep(1000); //ä�� ��� �����ְ� ��ٸ���
			} catch (InterruptedException e) {

			}
			
			pic = null;
			if(iter < panelList.size()-1) {
				panelList.get(iter).setVisible(false);
				panelList.get(++iter).setVisible(true);
			} else {
				EndingWindow endGame = new EndingWindow();
				endGame.setVisible(true);
				dispose();
			}
    	}
    }
	
    class ChangeImagePanel extends JPanel {
        public ChangeImagePanel() {
        	
        }
       
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(pic, 140, 50, this); 
        }
       
        @Override
        public Dimension getPreferredSize() {
            if (pic == null) {
                return new Dimension(500, 300);
            } else {
                return new Dimension(pic.getWidth(), pic.getHeight());
            }
        }

    }
 
	private class ConfirmWindow extends JFrame 
						implements ActionListener{ //���� Ǯ�� ���� ������ ���� ��, ���� ���� �˷��ִ� class
		public ConfirmWindow() {
			setSize(SMALL_WIDTH, SMALL_HEIGHT);
			setLocationRelativeTo(null);
			getContentPane().setBackground(new Color(255,247,242));
			setLayout(new BorderLayout());
			
			String strNextLine = "<html>Leave the game. <br/> Your score is " + numTrue + " / "+ quizList.size() +"</html>";

			JLabel confirmLabel = new JLabel(strNextLine);
			confirmLabel.setFont(textFont);
			add(confirmLabel, BorderLayout.CENTER);
			
			JPanel btnPanel = new JPanel();
			btnPanel.setBackground(new Color(247,99,12));
			btnPanel.setLayout(new GridLayout(1,2));
			
			JButton exitBtn = new JButton("OK");
			exitBtn.addActionListener(this);
			exitBtn.setPreferredSize(new Dimension(100,50));
			btnPanel.add(exitBtn);

			add(btnPanel, BorderLayout.SOUTH);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCmd = e.getActionCommand();
			if(actionCmd.equals("OK")) {	// ����� ���� ����� ���� ȭ������ ����
				user.setSuccess(numTrue);
				userResult.ts.add(user);	
				userResult.fileOutput();

				GuiResult result = new GuiResult("Theory");
				result.setVisible(true);

				dispose();
			}else
				System.out.println("Unexpected Error"
						+ " in Confirm Window");
		}
	} // end of ConfirmWindow	
	
    
	private class EndingWindow extends JFrame 
						implements ActionListener{ // ���� ������ �ѱ�ٰ� ������ ������ ���, �����ִ� ȭ��
		public EndingWindow() {
			setSize(SMALL_WIDTH, SMALL_HEIGHT);
			setLocationRelativeTo(null);
			getContentPane().setBackground(new Color(255,247,242));
			setLayout(new BorderLayout());
			
			String strNextLine = "<html>The game is over. <br/> Your score is " + numTrue + " / "+ quizList.size() +"</html>";
			
			JLabel confirmLabel = new JLabel(strNextLine);
			confirmLabel.setFont(textFont);
			add(confirmLabel, BorderLayout.CENTER);
			
			JPanel btnPanel = new JPanel();
			btnPanel.setBackground(new Color(247,99,12));
			btnPanel.setLayout(new GridLayout());
			
			JButton exitBtn = new JButton("OK");
			exitBtn.addActionListener(this);
			exitBtn.setPreferredSize(new Dimension(100,50));
			btnPanel.add(exitBtn);
			
			add(btnPanel, BorderLayout.SOUTH);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCmd = e.getActionCommand();
			if(actionCmd.equals("OK")) { // ����� ���� ����� ���� ȭ������ ����
				user.setSuccess(numTrue);
				userResult.ts.add(user);
				userResult.fileOutput();

				GuiResult result = new GuiResult("Theory");
				result.setVisible(true);

				dispose();
			}else
				System.out.println("Unexpected Error"
						+ " in Confirm Window");
		}
		
	} // end of EndingWindow
	
}
