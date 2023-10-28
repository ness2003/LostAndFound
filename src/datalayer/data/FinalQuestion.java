package datalayer.data;

import java.sql.Date;

public class FinalQuestion {
	
	private int id;
	private int findingId;
	private String question;
	private String rightAnswer;
	private String alternativeAnswer1;
	private String alternativeAnswer2;
	public FinalQuestion(int id, int findingId, String question, String rightAnswer, String alternativeAnswer1,
			String alternativeAnswer2) {
		this.id = id;
		this.findingId = findingId;
		this.question = question;
		this.rightAnswer = rightAnswer;
		this.alternativeAnswer1 = alternativeAnswer1;
		this.alternativeAnswer2 = alternativeAnswer2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFindingId() {
		return findingId;
	}
	public void setFindingId(int findingId) {
		this.findingId = findingId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	public String getAlternativeAnswer1() {
		return alternativeAnswer1;
	}
	public void setAlternativeAnswer1(String alternativeAnswer1) {
		this.alternativeAnswer1 = alternativeAnswer1;
	}
	public String getAlternativeAnswer2() {
		return alternativeAnswer2;
	}
	public void setAlternativeAnswer2(String alternativeAnswer2) {
		this.alternativeAnswer2 = alternativeAnswer2;
	}
}
