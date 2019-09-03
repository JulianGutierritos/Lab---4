package hangman.model;
public class BonusScore implements GameScore{
	/**
	@pre correctCount > 0 , incorrectCount > 0
	@pos Retorna un entero
	@param int correctCount, int incorrectCount
	@throws claculateScoreException
	*/
	public int calculateScore(int correctCount, int incorrectCount) throws ScoreException{
		if ((correctCount < 0) || (incorrectCount < 0)){
				throw new ScoreException(ScoreException.INTENTO_NEGATIVO);
		}
		int res = 0;
		int correctas = correctCount * 10;
		int incorrectas = incorrectCount * 5;
		res += correctas - incorrectas;
		if (res < 0){
			res = 0;
		}
		return res;
	}
}