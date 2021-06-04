package javaQuiz;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class LabDataClass { //실습 문제 Data
	private int quizNum;				// 문제 번호
	private int solvedCheck;			// 이 문제를 풀었는지
	private BufferedImage solvedImg;	// 정답 or 오답 img
	
	private String explanation;			// 문제 설명
	private ArrayList<String> question = new ArrayList<String>(); //문제 내용
	private String topAnswer;			// 정답1
	private String bottomAnswer;		// 정답2
	
	private String topUserAnswer;		// 사용자 답안1
	private String bottomUserAnswer;	// 사용자 답안2
		
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
	    return ("설명: "+explanation+"\n"
	    		+"문제: "+question+"\n"
	    		+"정답: "+bottomAnswer);
	    
	}
}
