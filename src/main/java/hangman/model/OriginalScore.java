package hangman.model;

public class OriginalScore implements GameScore{
	/**
	@pre correctCount > 0 , incorrectCount > 0
	@pos Retorna un entero
	@param int correctCount, int incorrectCount
	@throws claculateScoreException
	*/
	public int calculateScore(int correctCount, int incorrectCount){
		int res = 100;
		int incorrectas = incorrectCount * 10;
		res += -incorrectas;
		return res;
	}
}