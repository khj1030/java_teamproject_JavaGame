	package gamemain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BouncingBall extends JPanel {
	private static final int BOX_WIDTH = 1200; // ��ü ��
	private static final int BOX_HEIGHT = 900; // ��ü ����
	
	private float ballRadius0 = 110; // ���� ������
	private float ballX0 = ballRadius0 + 300; // ���� �ʱ� X��ġ
	private float ballY0 = ballRadius0 + 500; // ���� �ʱ� Y��ġ
	
	private float ballRadius1 = 150; // ���� ������
	private float ballX1 = ballRadius1 + 120; // ���� �ʱ� X��ġ
	private float ballY1 = ballRadius1 + 300; // ���� �ʱ� Y��ġ
	
	private float ballRadius2 = 130; // ���� ������
	private float ballX2 = ballRadius2 + 0; // ���� �ʱ� X��ġ
	private float ballY2 = ballRadius2 + 200; // ���� �ʱ� Y��ġ
	
	private float ballRadius3 = 170; // ���� ������
	private float ballX3 = ballRadius3 + 1000; // ���� �ʱ� X��ġ
	private float ballY3 = ballRadius3 + 200; // ���� �ʱ� Y��ġ
	
	private float ballRadius4 = 150; // ���� ������
	private float ballX4 = ballRadius4 + 500; // ���� �ʱ� X��ġ
	private float ballY4 = ballRadius4 + 100; // ���� �ʱ� Y��ġ
	
	private float ballSpeedX0 = 10; // ���� X�ӵ�
	private float ballSpeedY0 = 10; // ���� Y�ӵ�

	private float ballSpeedX1 = 10; // ���� X�ӵ�
	private float ballSpeedY1 = 10; // ���� Y�ӵ�
	
	private float ballSpeedX2 = 10; // ���� X�ӵ�
	private float ballSpeedY2 = 10; // ���� Y�ӵ�
	
	private float ballSpeedX3 = 10; // ���� X�ӵ�
	private float ballSpeedY3 = 10; // ���� Y�ӵ�
	
	private float ballSpeedX4 = 10; // ���� X�ӵ�
	private float ballSpeedY4 = 10; // ���� Y�ӵ�

	public BouncingBall() {
		this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT)); // ������ ����
	
		class MyThread extends Thread {
			public void run() { // �����Ͽ��� �ϴ� �۾��� ������
				while (true) {
					ballX0 += ballSpeedX0;
					ballY0 -= ballSpeedY0;
					if (ballX0 - ballRadius0 < 0) {
						ballSpeedX0 = -ballSpeedX0;
						ballX0 = ballRadius0;
					} else if (ballX0 + ballRadius0 > BOX_WIDTH) {
						ballSpeedX0 = -ballSpeedX0;
						ballX0 = BOX_WIDTH - ballRadius0;
					}
					if (ballY0 - ballRadius0 < 0) {
						ballSpeedY0 = -ballSpeedY0;
						ballY0 = ballRadius0;
					} else if (ballY0 + ballRadius0 > BOX_HEIGHT) {
						ballSpeedY0 = -ballSpeedY0;
						ballY0 = BOX_HEIGHT - ballRadius0;
					}
					repaint();
					try {
						Thread.sleep(10); // ���� �ӵ� ����
					} catch (InterruptedException ex) {
						 
					}
					//
					ballX1 += ballSpeedX1;
					ballY1 += ballSpeedY1;
					if (ballX1 - ballRadius1 < 0) {
						ballSpeedX1 = -ballSpeedX1;
						ballX1 = ballRadius1;
					} else if (ballX1 + ballRadius1 > BOX_WIDTH) {
						ballSpeedX1 = -ballSpeedX1;
						ballX1 = BOX_WIDTH - ballRadius1;
					}
					if (ballY1 - ballRadius1 < 0) {
						ballSpeedY1 = -ballSpeedY1;
						ballY1 = ballRadius1;
					} else if (ballY1 + ballRadius1 > BOX_HEIGHT) {
						ballSpeedY1 = -ballSpeedY1;
						ballY1 = BOX_HEIGHT - ballRadius1;
					}
					repaint();
					try {
						Thread.sleep(10); // ���� �ӵ� ����
					} catch (InterruptedException ex) {
						 
					}
					//
					ballX2 -= ballSpeedX2;
					ballY2 += ballSpeedY2;
					if (ballX2 - ballRadius2 < 0) {
						ballSpeedX2 = -ballSpeedX2;
						ballX2 = ballRadius2;
					} else if (ballX2 + ballRadius2 > BOX_WIDTH) {
						ballSpeedX2 = -ballSpeedX2;
						ballX2 = BOX_WIDTH - ballRadius2;
					}
					if (ballY2 - ballRadius2 < 0) {
						ballSpeedY2 = -ballSpeedY2;
						ballY2 = ballRadius2;
					} else if (ballY2 + ballRadius2 > BOX_HEIGHT) {
						ballSpeedY2 = -ballSpeedY2;
						ballY2 = BOX_HEIGHT - ballRadius2;
					}
					repaint();
					try {
						Thread.sleep(10); // ���� �ӵ� ����
					} catch (InterruptedException ex) {
						 
					}
					//
					ballX3 -= ballSpeedX3;
					ballY3 -= ballSpeedY3;
					if (ballX3 - ballRadius3 < 0) {
						ballSpeedX3 = -ballSpeedX3;
						ballX3 = ballRadius3;
					} else if (ballX3 + ballRadius3 > BOX_WIDTH) {
						ballSpeedX3 = -ballSpeedX3;
						ballX3 = BOX_WIDTH - ballRadius3;
					}
					if (ballY3 - ballRadius3 < 0) {
						ballSpeedY3 = -ballSpeedY3;
						ballY3 = ballRadius3;
					} else if (ballY3 + ballRadius3 > BOX_HEIGHT) {
						ballSpeedY3 = -ballSpeedY3;
						ballY3 = BOX_HEIGHT - ballRadius3;
					}
					repaint();
					try {
						Thread.sleep(10); // ���� �ӵ� ����
					} catch (InterruptedException ex) {
						 
					}
					//
					ballX4 += ballSpeedX4;
					ballY4 -= ballSpeedY4;
					if (ballX4 - ballRadius4 < 0) {
						ballSpeedX4 = -ballSpeedX4;
						ballX4 = ballRadius3;
					} else if (ballX4 + ballRadius3 > BOX_WIDTH) {
						ballSpeedX4 = -ballSpeedX4;
						ballX4 = BOX_WIDTH - ballRadius3;
					}
					if (ballY4 - ballRadius4 < 0) {
						ballSpeedY4 = -ballSpeedY4;
						ballY4 = ballRadius4;
					} else if (ballY4 + ballRadius3 > BOX_HEIGHT) {
						ballSpeedY4 = -ballSpeedY4;
						ballY4 = BOX_HEIGHT - ballRadius3;
					}
					repaint();
					try {
						Thread.sleep(10); // ���� �ӵ� ����
					} catch (InterruptedException ex) {
						 
					}
					
				}
			}
		}
		
		Thread t = new MyThread(); // ������ ��ü ����
		t.start(); // ������ ����
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.white); // ����
		g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT); // ���簢��
		
		
		g.setColor(new Color(239, 255,156)); // ����
		g.fillOval((int) (ballX0 - ballRadius0), (int) (ballY0 - ballRadius0),
		(int) (2 * ballRadius0), (int) (2 * ballRadius0)); // ��
		
		
		g.setColor(new Color(255,240,240)); // ����
		g.fillOval((int) (ballX1 - ballRadius1), (int) (ballY1 - ballRadius1),
		(int) (2 * ballRadius1), (int) (2 * ballRadius1)); // ��
		
		//
		
		g.setColor(new Color(255,140,140)); // ����
		g.fillOval((int) (ballX2 - ballRadius2), (int) (ballY2 - ballRadius2),
		(int) (2 * ballRadius2), (int) (2 * ballRadius2)); // ��
		
		g.setColor(new Color(100,200,10)); // ����
		g.fillOval((int) (ballX3 - ballRadius3), (int) (ballY3 - ballRadius3),
		(int) (2 * ballRadius3), (int) (2 * ballRadius3)); // ��
		
		g.setColor(new Color(192, 236, 255)); // ����
		g.fillOval((int) (ballX4 - ballRadius4), (int) (ballY4 - ballRadius4),
		(int) (2 * ballRadius4), (int) (2 * ballRadius4)); // ��
	
	}
 
}
