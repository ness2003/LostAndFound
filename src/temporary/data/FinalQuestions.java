package temporary.data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import datalayer.data.FinalQuestion;
import datalayer.data.Finding;

public class FinalQuestions {
	public static List<FinalQuestion> finalQuestionsList = new ArrayList<FinalQuestion>();

	static {
		initializeFinalQuestions();
	}

	private static void initializeFinalQuestions() {
		finalQuestionsList.add(new FinalQuestion(1, 1, "Какого цвета?", "Желтая", "Синяя", "Красная"));
		finalQuestionsList.add(new FinalQuestion(2, 1, "Из какого материала?", "Медь", "Золото", "Сталь"));
		finalQuestionsList.add(new FinalQuestion(3, 1, "Кто на монете изображен?", "Я", "Не я", "И не яdgdfrergegggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"));
	}
	
	public static int getFindingIdForQuestionId(int questionId) {
	        for (FinalQuestion question : finalQuestionsList) {
	        	if (question.getId()==questionId) {
	        		return question.getFindingId();
	        	}
	        }
			return questionId;
		
	}
	
	  public static List<FinalQuestion> getQuestionsForFinding(int findingId) {
	        List<FinalQuestion> questionsForFinding = new ArrayList<>();
	        for (FinalQuestion question : finalQuestionsList) {
	            if (question.getFindingId() == findingId) {
	                questionsForFinding.add(question);
	            }
	        }
	        return questionsForFinding;
	    }

}
