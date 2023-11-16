package datalayer;

import java.util.List;

import datalayer.data.FinalQuestion;

public interface FinalQuestionDAO {
	List<FinalQuestion> getFinalQuestionByFindingsId(int currentFindingId);

	FinalQuestion getFinalQuestionById(int currentQuestionId);

	void refreshFinalQuestion(int findingId, int questionId, String question, String rightAnswer, String alternativeAnswer1,
			String alternativeAnswer2);
}
