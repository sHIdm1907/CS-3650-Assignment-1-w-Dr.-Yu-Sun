package cs3560Assignment1;

//@author: David Maestas
//Date last modified: 9/28/2020
//purpose: class that is used to configure either a single choice or
//	multiple choice question and their respective answers

public class Question {
	private String answerS;
	private String answerM;
	private String singleChoice;
	private String multipleChoice;
	private String a;
	private String b;
	private String c;
	private String d;
	
	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	
	public String getAnswerS() {
		return answerS;
	}

	public void setAnswerS(String answerS) {
		this.answerS = answerS;
	}

	public String getAnswerM() {
		return answerM;
	}

	public void setAnswerM(String answerM) {
		this.answerM = answerM;
	}

	public String getSingleChoice() {
		return singleChoice;
	}

	public void setSingleChoice(String singleChoice) {
		this.singleChoice = singleChoice;
	}

	public String getMultipleChoice() {
		return multipleChoice;
	}

	public void setMultipleChoice(String multipleChoice) {
		this.multipleChoice = multipleChoice;
	}
	
	
	
}
