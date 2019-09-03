package hangman.model;
public class PowerBonusScore implements GameScore{
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
		int correctas = 0;
		if (correctCount > 0){
			correctas = (int) Math.pow(5, correctCount);
		}
		int incorrectas = incorrectCount * 8;
		res += correctas - incorrectas;
		if (res < 0){
			res = 0;
		}
		if (res >500){
			res = 500;
		}
		return res;
	}
}