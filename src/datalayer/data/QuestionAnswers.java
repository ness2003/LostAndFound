package datalayer.data;

import java.util.ArrayList;
import java.util.List;

public class QuestionAnswers {

	private int findingId;
	private String question;
	private List<Answer> answers;
	
	public QuestionAnswers(int findingId, String question) {
		this.setFindingId(findingId);
		this.question = question;
		this.answers = new ArrayList<>();
	}

	public QuestionAnswers(String question) {
		this.question = question;
		this.answers = new ArrayList<>();
	}

	public void addAnswer(String answer, boolean isCorrect) {
		Answer newAnswer = new Answer(answer, isCorrect);
		answers.add(newAnswer);
	}

	public String getQuestion() {
		return question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public int getFindingId() {
		return findingId;
	}

	public void setFindingId(int findingId) {
		this.findingId = findingId;
	}

	public static class Answer {
		private String text;
		private boolean isCorrect;

		public Answer(String text, boolean isCorrect) {
			this.text = text;
			this.isCorrect = isCorrect;
		}

		public String getText() {
			return text;
		}

		public boolean isCorrect() {
			return isCorrect;
		}
	}

}
