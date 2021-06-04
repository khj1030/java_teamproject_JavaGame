package javaQuiz;

import java.awt.image.BufferedImage;

public class TheoryDataClass {
	private int quizNum;				// 문제 번호
	private int solvedCheck;			// 이 문제를 풀었는지
	private BufferedImage solvedImg;	// 정답 or 오답 img
	
	private String explanation;			// 문제 설명
	private String question;			// 문제 내용
	private String answer;				// 정답
	
	private String uesrAnswer;			// 사용자 답안
	
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
	    return ("설명: "+explanation+"\n"
	    		+"문제: "+question+"\n"
	    		+"정답: "+answer);
	    
	}
}
