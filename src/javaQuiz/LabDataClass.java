package javaQuiz;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class LabDataClass { //�ǽ� ���� Data
	private int quizNum;				// ���� ��ȣ
	private int solvedCheck;			// �� ������ Ǯ������
	private BufferedImage solvedImg;	// ���� or ���� img
	
	private String explanation;			// ���� ����
	private ArrayList<String> question = new ArrayList<String>(); //���� ����
	private String topAnswer;			// ����1
	private String bottomAnswer;		// ����2
	
	private String topUserAnswer;		// ����� ���1
	private String bottomUserAnswer;	// ����� ���2
		
	public LabDataClass(){
		this.quizNum = 0;
		this.solvedCheck = -1;
		this.solvedImg = null;
		this.explanation = "";
		this.topAnswer = "";
		this.bottomAnswer = "";
	}
	
	public LabDataClass(String explanation, ArrayList<String> question, String answer){
		this.explanation = explanation;
		for(int i=0; i<question.size(); i++) {
			this.question.add(question.get(i));
		}
		this.bottomAnswer = answer;
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
	
	public void setQuestion(ArrayList<String> str) {
		for(int i=0; i<str.size(); i++) {
			this.question.add(str.get(i));
		}
	}
	
	public void setTopAnswer(String str) {
		this.topAnswer = str;
	}
	
	public void setBottomAnswer(String str) {
		this.bottomAnswer = str;
	}
	public void setTopUserAnswer(String str) {
		this.topUserAnswer = str;
	}
	
	public void setBottomUserAnswer(String str) {
		this.bottomUserAnswer = str;
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
	
	public ArrayList<String> getQuestion() {
		return this.question;
	}
	
	public String getTopAnswer() {
		return this.topAnswer;
	}
	
	public String getBottomAnswer() {
		return this.bottomAnswer;
	}
	public String getTopUserAnswer() {
		return this.topUserAnswer;
	}
	
	public String getBottomUserAnswer() {
		return this.bottomUserAnswer;
	}
	
	public String toString() {
	    return ("����: "+explanation+"\n"
	    		+"����: "+question+"\n"
	    		+"����: "+bottomAnswer);
	    
	}
}
