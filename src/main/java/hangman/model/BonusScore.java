package hangman.model;
public class BonusScore implements GameScore{
	/**
	@pre correctCount > 0 , incorrectCount > 0
	@pos Retorna un entero
	@param int correctCount, int incorrectCount
	@throws claculateScoreException
	*/
	public int calculateScore(int correctCount, int incorrectCount){
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