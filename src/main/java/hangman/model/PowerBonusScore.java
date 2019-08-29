package hangman.model;
public class PowerBonusScore implements GameScore{
	/**
	@pre correctCount > 0 , incorrectCount > 0
	@pos Retorna un entero
	@param int correctCount, int incorrectCount
	@throws claculateScoreException
	*/
	public int calculateScore(int correctCount, int incorrectCount){
		int res = 0;
		int correctas = (int) Math.pow(5, correctCount);
		int incorrectas = incorrectCount * 8;
		res += correctas - incorrectas;
		return res;
	}
}