package temporary.data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
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
		finalQuestionsList.add(new FinalQuestion(3, 1, "Кто на монете изображен?", "Петр 1", "Иван 2", "Григорий 1"));
		finalQuestionsList.add(new FinalQuestion(1, 2, "Это вопрос 1?", "Желтая", "Синяя", "Красная"));
		finalQuestionsList.add(new FinalQuestion(2, 2, "Это вопрос 2?", "Медь", "Золото", "Сталь"));
		finalQuestionsList.add(new FinalQuestion(3, 2, "Это вопрос 3?", "Петр 1", "Иван 2", "Григорий 1"));

	}

	public static int getFindingIdForQuestionId(int questionId) {
		for (FinalQuestion question : finalQuestionsList) {
			if (question.getId() == questionId) {
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

	public static List<QuestionAnswer> getQuestionsByFinding(int findingId) {
		QuestionAnswer questionAnswer;
		List<QuestionAnswer> questionsForFinding = new ArrayList<>();
		for (FinalQuestion question : finalQuestionsList) {
			if (question.getFindingId() == findingId) {
				questionAnswer = new QuestionAnswer(question.getQuestion());
				questionAnswer.addAnswer(question.getRightAnswer(), true);
				questionAnswer.addAnswer(question.getAlternativeAnswer1(), false);
				questionAnswer.addAnswer(question.getAlternativeAnswer2(), false);

				questionsForFinding.add(questionAnswer);
			}
		}
		FinalQuestions.shuffleAnswers(questionsForFinding);
		return questionsForFinding;
	}

	public static void shuffleAnswers(List<QuestionAnswer> quizQuestions) {
		for (QuestionAnswer question : quizQuestions) {
			List<QuestionAnswer.Answer> answers = question.getAnswers();
			Collections.shuffle(answers);
		}
	}

}
