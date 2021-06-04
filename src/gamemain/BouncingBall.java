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
	private static final int BOX_WIDTH = 1200; // 전체 폭
	private static final int BOX_HEIGHT = 900; // 전체 높이
	
	private float ballRadius0 = 110; // 공의 반지름
	private float ballX0 = ballRadius0 + 300; // 공의 초기 X위치
	private float ballY0 = ballRadius0 + 500; // 공의 초기 Y위치
	
	private float ballRadius1 = 150; // 공의 반지름
	private float ballX1 = ballRadius1 + 120; // 공의 초기 X위치
	private float ballY1 = ballRadius1 + 300; // 공의 초기 Y위치
	
	private float ballRadius2 = 130; // 공의 반지름
	private float ballX2 = ballRadius2 + 0; // 공의 초기 X위치
	private float ballY2 = ballRadius2 + 200; // 공의 초기 Y위치
	
	private float ballRadius3 = 170; // 공의 반지름
	private float ballX3 = ballRadius3 + 1000; // 공의 초기 X위치
	private float ballY3 = ballRadius3 + 200; // 공의 초기 Y위치
	
	private float ballRadius4 = 150; // 공의 반지름
	private float ballX4 = ballRadius4 + 500; // 공의 초기 X위치
	private float ballY4 = ballRadius4 + 100; // 공의 초기 Y위치
	
	private float ballSpeedX0 = 10; // 공의 X속도
	private float ballSpeedY0 = 10; // 공의 Y속도

	private float ballSpeedX1 = 10; // 공의 X속도
	private float ballSpeedY1 = 10; // 공의 Y속도
	
	private float ballSpeedX2 = 10; // 공의 X속도
	private float ballSpeedY2 = 10; // 공의 Y속도
	
	private float ballSpeedX3 = 10; // 공의 X속도
	private float ballSpeedY3 = 10; // 공의 Y속도
	
	private float ballSpeedX4 = 10; // 공의 X속도
	private float ballSpeedY4 = 10; // 공의 Y속도

	public BouncingBall() {
		this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT)); // 사이즈 지정
	
		class MyThread extends Thread {
			public void run() { // 수행하여야 하는 작업을 적어줌
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
						Thread.sleep(10); // 공의 속도 조절
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
						Thread.sleep(10); // 공의 속도 조절
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
						Thread.sleep(10); // 공의 속도 조절
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
						Thread.sleep(10); // 공의 속도 조절
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
						Thread.sleep(10); // 공의 속도 조절
					} catch (InterruptedException ex) {
						 
					}
					
				}
			}
		}
		
		Thread t = new MyThread(); // 스레드 객체 생성
		t.start(); // 스레드 시작
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.white); // 배경색
		g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT); // 직사각형
		
		
		g.setColor(new Color(239, 255,156)); // 공색
		g.fillOval((int) (ballX0 - ballRadius0), (int) (ballY0 - ballRadius0),
		(int) (2 * ballRadius0), (int) (2 * ballRadius0)); // 원
		
		
		g.setColor(new Color(255,240,240)); // 공색
		g.fillOval((int) (ballX1 - ballRadius1), (int) (ballY1 - ballRadius1),
		(int) (2 * ballRadius1), (int) (2 * ballRadius1)); // 원
		
		//
		
		g.setColor(new Color(255,140,140)); // 공색
		g.fillOval((int) (ballX2 - ballRadius2), (int) (ballY2 - ballRadius2),
		(int) (2 * ballRadius2), (int) (2 * ballRadius2)); // 원
		
		g.setColor(new Color(100,200,10)); // 공색
		g.fillOval((int) (ballX3 - ballRadius3), (int) (ballY3 - ballRadius3),
		(int) (2 * ballRadius3), (int) (2 * ballRadius3)); // 원
		
		g.setColor(new Color(192, 236, 255)); // 공색
		g.fillOval((int) (ballX4 - ballRadius4), (int) (ballY4 - ballRadius4),
		(int) (2 * ballRadius4), (int) (2 * ballRadius4)); // 원
	
	}
 
}
