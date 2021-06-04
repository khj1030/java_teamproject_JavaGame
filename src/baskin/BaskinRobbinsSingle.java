package baskin;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Window;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gamemain.RoundedButton;
//import yellow.errorWindowSetCnt;

public class BaskinRobbinsSingle extends JFrame implements ActionListener {
	String colorBomb = "";
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 900;
	BufferedImage img = null;
	private JPanel greenPanel;
	private JTextField SingleMessage, SingleUserNum;
	private JLabel FinalNumLabel, SetNumLabel, SetSingleCntLabel;
	private String NumCalling, theNumber;
	private static int finalNum, RandomComputerNumber;
	private int strlen, num = 0, prev = 0;
	int tmp[] = new int[4];
	Container contentPane = getContentPane();

	public static final String packageName="baskin";
	public static final String srcPath="src";
	
	private String currentPath;
		
	public BaskinRobbinsSingle() {
		setTitle("BaskinRobbins Single");
		setLocationRelativeTo(null);                                                   // ȭ�� ��� ����
		setBackground(Color.WHITE);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		String currentProjPath="";
		try {
			currentProjPath=new File(".").getCanonicalPath();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		currentPath= currentProjPath+"/"+srcPath+"/"+packageName+"/";

		
		try {
			img = ImageIO.read(new File(currentPath+"greenBomb.png"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "�̹��� �ҷ����� ����");
			System.exit(0);
		}
		
		// ���� ���� Label
		FinalNumLabel = new JLabel("THE NUMBER >> ");                                  // ����ڰ� ������ key���� ��Ÿ���� ��
		FinalNumLabel.setBounds(450, 20, 500, 40);
		FinalNumLabel.setFont(new Font("DX���νô�",Font.BOLD,30));

		SetNumLabel = new JLabel();                                                    // ����ڿ��� key�� ������ �˷��ִ� ��
		SetNumLabel.setText("31 �̻� 50 ������ ���ڸ� �����ϼ���");
		SetNumLabel.setBounds(30, 70, 600, 40);
		SetNumLabel.setFont(new Font("DX���νô�",Font.BOLD,25));

		SingleMessage = new JTextField(15);                                            // ����ڿ��� key���� �Է¹޴� â
		SingleMessage.setBounds(60, 120, 250, 40);

		RoundedButton SingleStart = new RoundedButton("START");                        // key�� �Է� ��ư
		SingleStart.addActionListener(this);
		SingleStart.setFont(new Font("DX���νô�", Font.BOLD,20));
		SingleStart.setBounds(315, 120, 90, 40);
		SingleStart.setBackColor(new Color(255, 247, 242));
		SingleStart.setTextColor(new Color(247, 99, 12));
		
		
		// ���� �Է�
		SetSingleCntLabel = new JLabel();                                              // ����ڿ��� �Է� ������ ���� ������ �˷��ִ� ��
		SetSingleCntLabel.setText("1 ~ 3�� �� �� ���� ������ �Է����� �������ּ���");
		SetSingleCntLabel.setBounds(560, 70, 600, 50);
		SetSingleCntLabel.setFont(new Font("DX���νô�",Font.BOLD,25));

		SingleUserNum = new JTextField(15);                                            // ����ڿ��� ������ų ���� ������ �Է¹޴� â
		SingleUserNum.setBounds(660, 120, 250, 40);

		RoundedButton SingleEnter = new RoundedButton("ENTER");                        // ������ �Է� ��ư
		SingleEnter.addActionListener(this);
		SingleEnter.setBounds(920, 120, 90, 40);
		SingleEnter.setFont(new Font("DX���νô�", Font.BOLD,20));
		SingleEnter.setBackColor(new Color(255, 247, 242));
		SingleEnter.setTextColor(new Color(247, 99, 12));

		// �гο� �߰�
		greenPanel = new JPanel();
		greenPanel.setLayout(null);
		greenPanel.setSize(WIDTH, HEIGHT);
		greenPanel.repaint();
		greenPanel.add(FinalNumLabel);
		greenPanel.add(SetNumLabel);
		greenPanel.add(SingleMessage);
		greenPanel.add(SingleStart);
		greenPanel.add(SetSingleCntLabel);
		greenPanel.add(SingleUserNum);
		greenPanel.add(SingleEnter);
		greenPanel.setBackground(Color.WHITE);
		
		// ���� â
		setResizable(false);
		setLayout(null);
		contentPane.add(greenPanel);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(new Font("DX���νô�", Font.BOLD, 30));
		g.drawString("PREV: " + Integer.toString(prev), 510, 500);                     // ���� �� ���
		g.setFont(new Font("DX���νô�", Font.BOLD, 70));
		g.drawString(Integer.toString(num), 570, 620);                                 // ���� �� ���
		g.drawImage(img, 380, 250, this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCmd = e.getActionCommand();
		if (actionCmd.equals("START")) {
			finalNum = Integer.parseInt(SingleMessage.getText());
			if (31 <= finalNum && finalNum <= 50) {
				theNumber = Integer.toString(finalNum);
				FinalNumLabel.setText("THE NUMBER >> " + theNumber);
				
			} else {
				new errorWindowSetNum();                                               // ������ ����� ���� â �߻�
			}
		} else if (actionCmd.equals("ENTER")) {                                        // key���� 3���� ������ ���� ��踦 �������� ��� ��ź�� ���� ����
			if (num <= (double)finalNum / 3) {
				colorBomb = "green";
			}else if (num < (double)finalNum / 3*2  &&num > (double)finalNum / 3) {
				colorBomb = "yellow";
			}else if (num >= (double)finalNum / 3*2) {
				colorBomb = "red";
			}
			                                                                           // �־��� ������ ����� ���� â �߻�
			if(colorBomb.equals("green")) {
				NumCalling = SingleUserNum.getText();
				strlen = Integer.parseInt(NumCalling);
				if (1 <= strlen && strlen <= 3) {
					// ����� ����� ���
					prev = num;
					num += strlen;
					repaint();
					
					// ��ǻ�� ���
					RandomComputerNumber = (int) (Math.random() * 3 + 1);
					prev = num;
					num += RandomComputerNumber;					
					repaint();
				}
				else
					new errorWindowSetCnt();
			
			} else if(colorBomb.equals("yellow")) {
				try {
					img = ImageIO.read(new File(currentPath+"yellowBomb.png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				repaint();
				NumCalling = SingleUserNum.getText();
				strlen = Integer.parseInt(NumCalling);
				if (1 <= strlen && strlen <= 3) {
					// ����� ����� ���
					prev = num;
					num += strlen;
					repaint();
					// ��ǻ�� ���
					RandomComputerNumber = (int) (Math.random() * 3 + 1);
					prev = num;
					num += RandomComputerNumber;	
					repaint();
				}
				else
					new errorWindowSetCnt();
			} else if (colorBomb.equals("red")) {
				try {
					img = ImageIO.read(new File(currentPath+"redBomb.png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				repaint();
				NumCalling = SingleUserNum.getText();
				strlen = Integer.parseInt(NumCalling);
				if (1 <= strlen && strlen <= 3) {
					// ����� ����� ���
					prev = num;
					num += strlen;
					repaint();
					if (num > finalNum - 1) {
						JOptionPane.showMessageDialog(null, "COMPUTER WIN!!");
						dispose();
					}

					// ��ǻ�� ���
					RandomComputerNumber = (int) (Math.random() * 3 + 1);
					if (num == finalNum - 1) {
						JOptionPane.showMessageDialog(null, "USER WIN!!");
						dispose();
					} else if (num == finalNum - 2) {
						prev = num;
						num += 1;
						repaint();
					} else if (num == finalNum - 3) {
						prev = num;
						num += 2;
					} else if (num == finalNum - 4) {
						prev = num;
						num += 3;
					}
					else {
						prev = num;
						num += RandomComputerNumber;
					}
					repaint();
				}
				else
					new errorWindowSetCnt();
			}
		}
		else {
			SingleMessage.setText("Unexpected Error.");
		}
	}
	
	public static int getFinalNum() {
		return finalNum;
	}

	class errorWindowSetNum extends JFrame {
		errorWindowSetNum() {
			JOptionPane.showMessageDialog(this, "Please enter the number more than 31 and less than 50.", "input error",
					JOptionPane.ERROR_MESSAGE);
			setSize(300, 100);
		}
	}

	class errorWindowSetCnt extends JFrame {
		errorWindowSetCnt() {
			JOptionPane.showMessageDialog(this, "Please enter the number more than 1 and less than 3.", "input error",
					JOptionPane.ERROR_MESSAGE);
			setSize(300, 100);
		}
	}

	class errorWindowSetPeople extends JFrame {
		errorWindowSetPeople() {
			JOptionPane.showMessageDialog(this, "Please enter the player more than 2 and less than 4.", "input error",
					JOptionPane.ERROR_MESSAGE);
			setSize(300, 100);
		}
	}
}