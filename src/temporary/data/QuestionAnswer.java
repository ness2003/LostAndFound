package temporary.data;

import java.util.ArrayList;
import java.util.List;

public class QuestionAnswer {
	
	 private String question;
	    private List<Answer> answers;

	    public QuestionAnswer(String question) {
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
