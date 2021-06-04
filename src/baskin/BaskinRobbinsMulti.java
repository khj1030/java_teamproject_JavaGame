package baskin;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gamemain.RoundedButton;

public class BaskinRobbinsMulti extends JFrame implements ActionListener {
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 900;
	BufferedImage img = null;
	private JPanel greenPanel;
	private JTextField MultiMessage, MultiUserNum;
	private static String theNumber;
	private static int  ComputerSetNumber;
	private JLabel SetNumPeopleLabel, SetMultiCntLabel, FinalPlayerLabel, SetNumComputerLabel;
	private String UserInputNumber, colorBomb = "";
	private int finalTurn, turn = 0, prev = 0;
	private int strlen, num = 0;
	int tmp[] = new int[4];
	Container contentPane = getContentPane();
	
	public static final String packageName="baskin";
	public static final String srcPath="src";
	
	private String currentPath;
		
	public BaskinRobbinsMulti() {
		setTitle("BaskinRobbins Multi");
		setBackground(Color.WHITE);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);                                                                              // ȭ�� ��� ����                              
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
		
		// ��Ƽ��忡�� ��ǻ�Ͱ� ������ ��
		ComputerSetNumber = (int) (Math.random() * 21 + 31);                                                      // ��ǻ�Ϳ� ���� �߻��ϴ� ����
		SetNumComputerLabel = new JLabel();
		SetNumComputerLabel.setText("THE NUMBER >> " + Integer.toString(ComputerSetNumber));
		SetNumComputerLabel.setBounds(450, 20, 500, 40);
		SetNumComputerLabel.setFont(new Font("DX���νô�",Font.BOLD,30));

		// �÷��̾� �� �Է�
		SetNumPeopleLabel = new JLabel();                                                                         // ���� �ο��� ���� ��
		SetNumPeopleLabel.setText("�� ���� �÷��̾ �����ϳ���?");
		SetNumPeopleLabel.setBounds(30, 70, 600, 40);
		SetNumPeopleLabel.setFont(new Font("DX���νô�",Font.BOLD,25));

		MultiMessage = new JTextField();                                                                          // ���� �ο��� �Է¹޴� â
		MultiMessage.setBounds(60, 120, 250, 40);

		RoundedButton MultiStart = new RoundedButton("START");                                                    // ���� �ο��� �Է¹޴� ��ư
		MultiStart.addActionListener(this);
		MultiStart.setFont(new Font("DX���νô�", Font.BOLD,20));
		MultiStart.setBounds(315, 120, 90, 40);
		MultiStart.setBackColor(new Color(255, 247, 242));
		MultiStart.setTextColor(new Color(247, 99, 12));
		
		FinalPlayerLabel = new JLabel();                                                                          // ���� �ο��� �˷��ִ� ��
		FinalPlayerLabel.setFont(new Font("DX���νô�",Font.BOLD,25));
		FinalPlayerLabel.setBounds(30, 180, 500, 40);

		// �����Է�
		SetMultiCntLabel = new JLabel();                                                                          // ����ڿ��� �� ���� ������ �Է��Ұ����� ����� ��
		SetMultiCntLabel.setText("1 ~ 3�� �� �� ���� ������ �Է����� �������ּ���");
		SetMultiCntLabel.setBounds(560, 70, 600, 50);
		SetMultiCntLabel.setFont(new Font("DX���νô�",Font.BOLD,25));

		MultiUserNum = new JTextField();                                                                          // ����ڿ��� ������ �Է¹޴� â
		MultiUserNum.setBounds(660, 120, 250, 40);

		RoundedButton MultiEnter = new RoundedButton("ENTER");                                                    // ����ڿ��� ������ �Է¹޴� ��ư
		MultiEnter.addActionListener(this);
		MultiEnter.setBounds(920, 120, 90, 40);
		MultiEnter.setFont(new Font("DX���νô�", Font.BOLD,20));
		MultiEnter.setBackColor(new Color(255, 247, 242));
		MultiEnter.setTextColor(new Color(247, 99, 12));

		// �гο� �߰�
		greenPanel = new JPanel();
		greenPanel.setSize(WIDTH, HEIGHT);
		greenPanel.setLayout(null);
		greenPanel.repaint();
		greenPanel.add(SetNumComputerLabel);
		greenPanel.add(SetNumPeopleLabel);
		greenPanel.add(FinalPlayerLabel);
		greenPanel.add(MultiMessage);
		greenPanel.add(MultiStart);
		greenPanel.add(SetMultiCntLabel);
		greenPanel.add(MultiUserNum);
		greenPanel.add(MultiEnter);
		greenPanel.setBackground(Color.WHITE);
		
		// ���� â
		setResizable(false);
		setLayout(null);
		contentPane.add(greenPanel);
	}
	
	public void main(String[] args) {
		BaskinRobbinsMulti screen = new BaskinRobbinsMulti();
		screen.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(new Font("DX���νô�", Font.BOLD, 30));
		g.drawString("USER " + turn + ": " + Integer.toString(prev), 510, 500);                                   // ���� ������ �Է��� ���� ���
		g.setFont(new Font("DX���νô�", Font.BOLD, 70));
		g.drawString(Integer.toString(num), 570, 620);                                                            // ���� ������ �Է��� ���� ���
		g.drawImage(img, 380, 250, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCmd = e.getActionCommand();
		if (actionCmd.equals("START")) {                                  
			finalTurn = Integer.parseInt(MultiMessage.getText());
			if (2 <= finalTurn && finalTurn <= 4) {
				theNumber = Integer.toString(finalTurn) + " PLAYERS PLAY THE GAME!!";
				FinalPlayerLabel.setText(theNumber);
			} else {
				new errorWindowSetPeople();
			}
		} else if (actionCmd.equals("ENTER")) {
			// ����� �Է� �� ���
			UserInputNumber = MultiUserNum.getText();
			strlen = Integer.parseInt(UserInputNumber);
			if (1 <= strlen && strlen <= 3) {
				if (prev == 0) {
					num += strlen;
					prev = num;
				}
				else {
					prev = num;
					num += strlen;
				}
				
				if (num <= (double)ComputerSetNumber / 3)
					colorBomb = "green";
				else if ((double)ComputerSetNumber / 3 <= num && num < (double)ComputerSetNumber / 3 * 2)
					colorBomb = "yellow";
				else if (num >= (double)ComputerSetNumber / 3 * 2)
					colorBomb = "red";

				if (num >= ComputerSetNumber) {
					repaint();
					JOptionPane.showMessageDialog(null, "USER " + turn + " LOSE!!");
					dispose();
				}
				else {
					if (colorBomb.equals("green")) {
						repaint();
					}else if (colorBomb.equals("yellow")) {
						try {
							img = ImageIO.read(new File(currentPath+"yellowBomb.png"));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						repaint();
					}else {
						try {
							img = ImageIO.read(new File(currentPath+"redBomb.png"));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						repaint();
					}
				}
				
				if (turn == finalTurn)                                                           // ������ ������ �Է��ϸ� �ٽ� ����1�� �� �Է�
					turn = 1;
				else
					turn++;
			} else {
				new errorWindowSetCnt();                                                         // ������ ����� ���� â �߻�
			}
		}
	}
	
	public static int getCompNum() {
		return ComputerSetNumber;
	}
	
	public static String getUserNum() {
		return theNumber;
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