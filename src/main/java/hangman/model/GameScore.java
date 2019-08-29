package hangman.model;

public interface GameScore{
	/**
	@pre correctCount > 0 , incorrectCount > 0
	@pos Retorna un entero
	@param int correctCount, int incorrectCount
	@throws claculateScoreException
	*/
	public int calculateScore(int correctCount, int incorrectCount);	
}