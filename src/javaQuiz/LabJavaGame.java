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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gamemain.CircleButton;
import gamemain.RoundJTextField;
import gamemain.RoundedButton;
//import javaQuiz.TheoryJavaGame.ConfirmWindow;
import javaQuiz.TheoryJavaGame.threadClass;

public class LabJavaGame extends JFrame implements ActionListener {
	// Define the rest of constants for ScrollBarDemo.
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 900;
	public static final int SMALL_WIDTH = 600;
	public static final int SMALL_HEIGHT = 400;
	
	private int count = 0;
	private int iter = 0;
	private int numTrue = 0;
	
	public static final String packageName="javaQuiz";
	public static final String srcPath="src";

	private String currentPath;
	private String currentPath2;
	
	private Font textFont = new Font("DX���νô�", Font.BOLD, 30);
	private Font textFont2 = new Font("DX���νô�", Font.BOLD, 28);
	private Font textFont3 = new Font("DX���νô�", Font.BOLD, 20);
	private Font quizFont = new Font("DX���νô�", Font.BOLD, 20);
	private Font btnFont = new Font("DX���νô�", Font.BOLD, 30);
	private Font btnFont2 = new Font("DX���νô�", Font.BOLD, 20);
	
	private BufferedImage pic;
	
	private String answerImgFile = "answer_check.png";				//���� Image
	private String wrongAnswerImgFile = "wrong_answer_check.png";	//���� Image
	
	private RoundJTextField inputEdit, inputAnswer;
	
	private String topUserAnswer = "";					//����� ���1
	private String bottomUserAnswer = "";				//����� ���2
	
	private Student user = new Student();				//������ ����� ���� ����
	private LabResult userResult = new LabResult(); 	//����� ���� file�� ���
	
	private boolean check = false; 						//���̵� ���� ����
	
	private ArrayList<LabDataClass> quizList = new ArrayList<LabDataClass>();
	private ArrayList<Panel> panelList = new ArrayList<Panel>();
	private ArrayList<JTextField> topTextFieldList= new ArrayList<JTextField>();
	private ArrayList<JTextField> bottomTextFieldList = new ArrayList<JTextField>();

	CardLayout card;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LabJavaGame gui = new LabJavaGame("test");
		gui.setVisible(true);
	}

	public LabJavaGame(String idtemp) {
		super("Scroll Bars Demo");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		
		card= new CardLayout(0, 0);
		setLayout(card);
		
		String fileName = "lab.txt";
		Scanner inputStream = null;
		
		String currentProjPath="";
		try {
			currentProjPath=new File(".").getCanonicalPath();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		currentPath= currentProjPath+"/"+srcPath+"/";
		currentPath2= currentProjPath+"/"+srcPath+"/"+packageName+"/";
		
		userResult.fileInput();
		if(!userResult.ts.isEmpty()) {
			for(Student usertemp : userResult.ts) {
				if(usertemp.getId().equals(idtemp)) { //���̵� �̹� ����
					
					user = new Student(usertemp); //user�� ���
					userResult.ts.remove(usertemp);
					
					check = true; //���̵� ����
					break;
				}
			}
		}
		
		try {
			inputStream = new Scanner(new InputStreamReader(new FileInputStream(currentPath+fileName),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			
		} catch (FileNotFoundException e) {
			
		}
		
		if(!check) { //���̵� �������� �ʴ� ����
			user.setId(idtemp); //user�� ���̵� ����
		}
		
		while(inputStream.hasNext()) {
			LabDataClass quiz = new LabDataClass();
			
			ArrayList<String> questions = new ArrayList<String>();
			
			quiz.setQuizNum(++count);
			quiz.setExplanation(inputStream.nextLine());
			while(true) {
				String questionLine = inputStream.nextLine();
				if(questionLine.equals("#")) break;
				else questions.add(questionLine);
			}
			quiz.setTopAnswer(inputStream.nextLine());
			quiz.setBottomAnswer(inputStream.nextLine());
			
			quiz.setQuestion(questions);
			
			/**********************************************************/
			
			/* ��ü�� ���δ� Panel */
			Panel newPanel = new Panel();
			newPanel.setLayout(new GridLayout(1,2));
			
			/* Quiz Panel (LeftPanel) */
			JPanel quizPanel = new JPanel();
			quizPanel.setBackground(Color.WHITE);
			quizPanel.setLayout(new BorderLayout());
			
			JPanel temp = new JPanel();
			temp.setBackground(new Color(255,0,0,0));
			temp.setPreferredSize(new Dimension(200,220));
			quizPanel.add(temp, BorderLayout.NORTH);
			
			JPanel templeft = new JPanel();
			templeft.setBackground(Color.WHITE);
			templeft.setPreferredSize(new Dimension(70,150));
			quizPanel.add(templeft, BorderLayout.WEST);
					
			JPanel questionBox = new JPanel();
			questionBox.setBackground(Color.WHITE);
			questionBox.setLayout(new BorderLayout());
			
			JTextArea question = new JTextArea();
			JScrollPane scrollPane = new JScrollPane(question);
			scrollPane.setBorder(BorderFactory.createEmptyBorder());
			
			scrollPane.setBounds(10, 35, 250, 525);
			scrollPane.setBackground(new Color(1, 0, 0, 0));
			scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
			scrollPane.getViewport().setBorder(null);
			scrollPane.setViewportBorder(null);
			scrollPane.setBorder(null);
			
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			for(int i=0; i<quiz.getQuestion().size(); i++) {
				question.append(quiz.getQuestion().get(i)+"\n");
			}
			question.setFont(quizFont);
			question.setEditable(false);
			question.setLineWrap(true);

			questionBox.add(scrollPane, BorderLayout.CENTER);
			quizPanel.add(questionBox, BorderLayout.CENTER);
			
			JPanel temp1 = new JPanel();
			temp1.setBackground(Color.WHITE);
			temp1.setPreferredSize(new Dimension(200,220));
			quizPanel.add(temp1, BorderLayout.SOUTH);
			
			newPanel.add(quizPanel);
			
			/* QuizText Panel (RigthPanel) */
			JPanel RightPanel = new JPanel();
			RightPanel.setLayout(new BorderLayout());
			RightPanel.setBackground(new Color(255,0,0,0));
			
			JPanel temp2 = new JPanel();
			temp2.setBackground(Color.WHITE);
			temp2.setPreferredSize(new Dimension(200,150));		
			RightPanel.add(temp2, BorderLayout.NORTH);
			
			JPanel temp3 = new JPanel();
			temp3.setBackground(Color.WHITE);
			temp3.setLayout(new BorderLayout());
			
			//���� ���� �� ���� �Է� �г�
			JPanel textPanel = new JPanel();
			textPanel.setBackground(Color.WHITE);
			textPanel.setLayout(new GridLayout(3,1));
			
			JPanel imgPanel = new ChangeImagePanel();
			imgPanel.setBackground(Color.WHITE);
			imgPanel.setLayout(new BorderLayout());
			
			/* ���� ������ ȭ�鿡 ���̰� �ϴ� �ڵ� */
			int start;
			int index = 0;
			int charIdx = 0;
			int totalLen =  quiz.getExplanation().length();
			int length = 20;
			String explanationSTR = quiz.getExplanation() ;
			String[] explan = new String[5];

			while(true) {
				explan[index] = "";
				if(totalLen > length) {
					length = length;
				}
				else {
					length = totalLen;
				}
				for(start=charIdx; start<charIdx+length; start++) {
					explan[index] += explanationSTR.charAt(start);
				}
				charIdx = start;
				totalLen -= length;
				index++;
				if(totalLen <= 0) {
					break;
				}
			}

			String finalText = "<html>"+Integer.toString(quiz.getQuizNum())+". ";
			for(int i=0; i<index; i++) {
				finalText += explan[i];
				if(i != explan.length-1) {
					finalText += "<br/>";
				}
				else {
					finalText += "</html>";
				}
			}

			JLabel explanation = new JLabel(finalText);
			explanation.setFont(textFont2);
			explanation.setHorizontalAlignment(JLabel.CENTER);
			
			imgPanel.add(explanation);

			textPanel.add(imgPanel);
			
			//Ʋ�� �κ� �Է�
			JPanel inputEditPanel = new JPanel();
			inputEditPanel.setBackground(new Color(255,0,0,0));
			
			JLabel editLabel = new JLabel("Ʋ�� �ڵ�");
			editLabel.setFont(textFont3);
			
			inputEditPanel.add(editLabel);
			
			inputEdit = new RoundJTextField(30);
			inputEdit.setFont(quizFont);
			inputEdit.setHorizontalAlignment(JLabel.CENTER);
			
			inputEditPanel.add(inputEdit);
			textPanel.add(inputEditPanel);

			topTextFieldList.add(inputEdit);
			
			//���� �Է�
			JPanel inputAnswerPanel = new JPanel();
			inputAnswerPanel.setBackground(Color.WHITE);
			
			JLabel answerLabel = new JLabel("���� �ڵ�");
			answerLabel.setFont(textFont3);
			
			
			inputAnswerPanel.add(answerLabel);
			
			inputAnswer = new RoundJTextField(30);
			inputAnswer.setFont(quizFont);
			inputAnswer.setHorizontalAlignment(JLabel.CENTER);
			
			inputAnswerPanel.add(inputAnswer);
			textPanel.add(inputAnswerPanel);
			
			bottomTextFieldList.add(inputAnswer);
			
			
			RightPanel.add(textPanel);
			
			newPanel.add(RightPanel, BorderLayout.CENTER);
		
			
			/* Button Panel */
			JPanel btnPanel = new JPanel();
			btnPanel.setBackground(Color.WHITE);
			
			JPanel btnDetailPanel = new JPanel();
			btnDetailPanel.setBackground(Color.WHITE);

			btnDetailPanel.setLayout(new GridLayout(1,2, 100, 100));
			
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
			startBtn.setPreferredSize(new Dimension(200,80));
			btnDetailPanel.add(startBtn);
			
			btnPanel.add(btnDetailPanel);
			btnPanel.setPreferredSize(new Dimension(200,300));
			
			RightPanel.add(btnPanel, BorderLayout.SOUTH);
			
			/*****************/
		
			CircleButton exitBtn = new CircleButton("EXIT");
			exitBtn.setBackColor(new Color(255,247,242));
			exitBtn.setTextColor(new Color(247,99,12));
			exitBtn.setFont(btnFont2);
			exitBtn.addActionListener(this);
			temp3.setPreferredSize(new Dimension(0,80));
			temp3.add(exitBtn, BorderLayout.EAST);
			
			RightPanel.add(temp3, BorderLayout.NORTH);
			
			newPanel.add(RightPanel);
			
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
		if(actionCmd.equals("NEXT")) {
			threadClass th = new threadClass(); 			//���� ������ �Ѿ
			th.start();

		} else if(actionCmd.equals("BACK")) {				//���� ������ ���ư�
			if(iter > 0) {
				panelList.get(iter).setVisible(false);
				panelList.get(--iter).setVisible(true);
				pic = quizList.get(iter).getSolvedImg();	//������ ä�� Image�� �ٽ� ������
				panelList.get(iter).repaint();
			}
		}else if(actionCmd.equals("EXIT")) {
			ConfirmWindow checkers = new ConfirmWindow();	//�߰��� ������ ���
			checkers.setVisible(true);

			dispose();
		}
	}
	
	class threadClass extends Thread {
		public void run() {
			
			if(quizList.get(iter).getSolvedCheck() == -1) { //������ �� Ǯ�� ����
				topUserAnswer = topTextFieldList.get(iter).getText();
				bottomUserAnswer = bottomTextFieldList.get(iter).getText();
				quizList.get(iter).setTopUserAnswer(topUserAnswer);
				quizList.get(iter).setBottomUserAnswer(bottomUserAnswer);
				
				
				if(topUserAnswer.equalsIgnoreCase(quizList.get(iter).getTopAnswer())
						&& bottomUserAnswer.equalsIgnoreCase(quizList.get(iter).getBottomAnswer())) {
					// ������ ��
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
				}else { // ������ ��
					quizList.get(iter).setSolvedCheck(0);
					
					try {
						quizList.get(iter).setSolvedImg(ImageIO.read(new File(currentPath2+ wrongAnswerImgFile)));
					} catch (IOException e1) {

					}
					pic = quizList.get(iter).getSolvedImg();
					panelList.get(iter).repaint(); 
				}
			} else { //������ Ǯ�� ���� (���� or ����)
				if(!topTextFieldList.get(iter).getText().equalsIgnoreCase(quizList.get(iter).getTopUserAnswer())
						|| !bottomTextFieldList.get(iter).getText().equalsIgnoreCase(quizList.get(iter).getBottomUserAnswer())) {
					//������ Ǯ�� ���� ������(�̹� ä���� �Ǿ��� ���� ������), ��� ���� �Ұ�
					JOptionPane.showMessageDialog(new LabJavaGame(user.getId()), 
							"You cannot modify it.", 
							"Submission Error", 
							JOptionPane.INFORMATION_MESSAGE);
					topTextFieldList.get(iter).setText(quizList.get(iter).getTopUserAnswer());
					bottomTextFieldList.get(iter).setText(quizList.get(iter).getBottomUserAnswer());
				}
				pic = quizList.get(iter).getSolvedImg();
				panelList.get(iter).repaint();
			}
			
			try {
				Thread.sleep(1500); //ä�� ��� �����ְ� ��ٸ���
			} catch (InterruptedException e) {

			}
			
			pic = null;
			if(iter < panelList.size()-1) {
				panelList.get(iter).setVisible(false);
				panelList.get(++iter).setVisible(true);
			}else {				
				EndingWindow endGame = new EndingWindow();
				endGame.setVisible(true);
				dispose();
			}
			
		}
	}
	
	class ChangeImagePanel extends JPanel {	//�г��� (re)paint�� ����ϴ� ���� class
        public ChangeImagePanel() {

        }
       
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(pic, 0, 10, this);        
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
						implements ActionListener{	//���� Ǯ�� ���� ������ ���� ��, ���� ���� �˷��ִ� class
		public ConfirmWindow() {
			setSize(SMALL_WIDTH, SMALL_HEIGHT);
			setLocationRelativeTo(null);
			getContentPane().setBackground(new Color(255,247,242));
			setLayout(new BorderLayout());
			
			String strNextLine = "<html>Leave the game. <br/> Your score is " + numTrue +" / "+ quizList.size() + "</html>";
			
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

				GuiResult result = new GuiResult("Lab");
				result.setVisible(true);
				
				dispose();
			}else
				System.out.println("Unexpected Error"
						+ " in Confirm Window");
		}
		
	} // end of ConfirmWindow
	
    
	private class EndingWindow extends JFrame 
						implements ActionListener{	// ���� ������ �ѱ�ٰ� ������ ������ ���, �����ִ� ȭ��
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
				
				GuiResult result = new GuiResult("Lab");
				result.setVisible(true);
				dispose();
				
			}else
				System.out.println("Unexpected Error"
						+ " in Confirm Window");
		}
		
	} // end of EndingWindow

}