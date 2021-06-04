package javaQuiz;

import java.awt.image.BufferedImage;

public class TheoryDataClass {
	private int quizNum;				// ���� ��ȣ
	private int solvedCheck;			// �� ������ Ǯ������
	private BufferedImage solvedImg;	// ���� or ���� img
	
	private String explanation;			// ���� ����
	private String question;			// ���� ����
	private String answer;				// ����
	
	private String uesrAnswer;			// ����� ���
	
	public TheoryDataClass(){
		this.quizNum = 0;
		this.solvedCheck = -1;
		this.solvedImg = null;
		this.explanation = "";
		this.question = "";
		this.answer = "";
		this.uesrAnswer = "";
	}
	
	public TheoryDataClass(TheoryDataClass data){
		this.quizNum = data.quizNum;
		this.solvedCheck = data.solvedCheck;
		this.solvedImg = data.solvedImg;
		this.explanation = data.explanation;
		this.question = data.question;
		this.answer = data.answer;
		this.uesrAnswer = data.uesrAnswer;
	}
	
	public TheoryDataClass(String explanation, String question, String answer){
		this.explanation = explanation;
		this.question = question;
		this.answer = answer;
	}
	
	public void setQuizNum(int num) {
		this.quizNum = num;
	}
	
	public void setSolvedImg(BufferedImage img) {
		this.solvedImg = img;
	}
	
	public void setSolvedCheck(int num) {
		this.solvedCheck = num;
	}
	
	public void setExplanation(String str) {
		this.explanation = str;
	}
	
	public void setQuestion(String str) {
		this.question = str;
	}
	
	public void setAnswer(String str) {
		this.answer = str;
	}
	
	public void setUesrAnswer(String str) {
		this.uesrAnswer = str;
	}
	
	public int getQuizNum() {
		return this.quizNum;
	}
	
	public int getSolvedCheck() {
		return this.solvedCheck;
	}
	
	public BufferedImage getSolvedImg() {
		return this.solvedImg;
	}
	
	public String getExplanation() {
		return this.explanation;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
	public String getUesrAnswer() {
		return this.uesrAnswer;
	}
	
	public String toString() {
	    return ("����: "+explanation+"\n"
	    		+"����: "+question+"\n"
	    		+"����: "+answer);
	    
	}
}
