package javaQuiz;

import java.io.Serializable;

public class Student implements Serializable,Comparable<Student>{
	private String id;		// ���̵�
	private int success;	// ���� ���� ��
	private int problem;	// �� ���� ��
	
	public Student() {
		id = "";
		success = 0;
		problem = 0;
	}
	
	public Student(Student stu) {
		this.id = stu.id;
		this.success = stu.success;
		this.problem = stu.problem;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	public void setSuccess(int success) {
		this.success=success;
	}
	public void setProblem(int problem) {
		this.problem=problem;
	}
	public String getId() {
		return id;
	}
	public int getSuccess() {
		return success;
	}
	public int getProblem() {
		return problem;
	}
	public String print() {
		return id+" "+success+" "+problem;
	}
	public String getScore() {
		return Integer.toString((int)((double)success/problem*100));
	}
	public String toString() {
		return id+":\t"+(int)((double)success/problem*100)+"��";
	}
	@Override
	public int compareTo(Student o) {
		if((double)success/problem>(double)o.success/o.problem) {
			return -1;
		}
		else if((double)success/problem == (double)o.success/o.problem) {
			return 0;
		}
		else {
			return 1;
		}
	}
}
