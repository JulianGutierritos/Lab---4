package hangman.model;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.fail;
/**
Clases de equivalencia:
OriginalScore:
	1. incorrectas >= 10 , resultado = 0, limites= {9 , 10}.
	2. 0 < incorrectas < 10, 0 < resultado < 100, limites = {0,1,9,10}  
	3. incorrectas = 0, resultado 100 , limites = {-1, 0, 1}
	4. incorrectas < 0, resultado exception, limites = {-1, 0}
BonusScore:
	1. incorrectas (in) >= 2*correctas (co) , resultado = 0, limite = {in = 2*co-1, in = 2*co} 
	2. incorrectas (in) < 2*correctas  (co) , 0 < resultado, limite = {in = 2*co, in = 2*co+1}
	3. incorrectas (in) < 0 , resultado = exception, limite = {in = -1, in = 0}
	4. correctas   (co) < 0 , resultado = exception, limite = {co = -1, co = 0}
PowerBonusScore:
	1. (5^correctas (co)) - (incorrectas (in) * 8) > 500, resultado = 500, limite = {co = 4 in = 16, co = 4 in = 15}
	2.  correctas (co) = 0, resultado = 0, limite = {co = 0 in = 0, co = 2 in = 3, co = 1 in = 1}
	3. (5^correctas (co)) - (incorrectas (in) * 8) < 0, resultado = 0, limite {co = 1 in = 1, co = 0 in = 0}
	4. incorrectas (in) < 0 , resultado = exception, limite = {in = -1, in = 0}
	5. correctas   (co) < 0 , resultado = exception, limite = {co = -1, co = 0}
*/
public class GameScoreTest {
    private GameScore score;
	private int res;
	@Test
    public void validateScore0With10Incorrect() {
        score = new OriginalScore();
		try{
			res = score.calculateScore(100, 10);
		}catch(ScoreException e){fail();}
        Assert.assertEquals(0, res);
    }
	
	@Test
    public void validateScore0With11Incorrect() {
        score = new OriginalScore();
		try{
			res = score.calculateScore(100, 11);
		}catch(ScoreException e) {fail();}
        Assert.assertEquals(0, res);
    }
	
	@Test
    public void validateScore10With9Incorrect() {
        score = new OriginalScore();
		try{	
			res = score.calculateScore(100, 9);
		}catch(ScoreException e) {fail();}
        Assert.assertEquals(10, res);
    }
	
	@Test
    public void validateScore90With1Incorrect() {
        score = new OriginalScore();
		try{
			res = score.calculateScore(100, 1);
		}catch(ScoreException e) {fail();}
        Assert.assertEquals(90, res);
    }
	
	@Test
    public void validateScore100With0Incorrect() {
        score = new OriginalScore();
		try{
			res = score.calculateScore(100, 0);
		}catch(ScoreException e) {fail();}
        Assert.assertEquals(100, res);
    }
	
	@Test
    public void validateExceptionWithNegative1Incorrect(){
        score = new OriginalScore();
		try{
			res = score.calculateScore(100, -1);
		} catch(ScoreException e){
			Assert.assertEquals(e.getMessage(), "El numero de intententos, ya sea correcto o incorrecto, debe ser mayor a 0.");
		}
    }
	
	@Test
    public void validateScore5With1IncorrectAnd1Correct() {
        score = new BonusScore();
		try{
			res = score.calculateScore(1, 1);
        }catch(ScoreException e) {fail();}
		Assert.assertEquals(5, res);
    }
	
	@Test
    public void validateScore0With2IncorrectAnd1Correct() {
        score = new BonusScore();
		try{	
			res = score.calculateScore(1, 2);
		}catch(ScoreException e) {fail();}
        Assert.assertEquals(0, res);
    }
	
	@Test
    public void validateScore0With3IncorrectAnd1Correct() {
        score = new BonusScore();
		try{
			res = score.calculateScore(1, 3);
		}catch(ScoreException e) {fail();}
        Assert.assertEquals(0, res);
    }

	@Test
    public void validateScore0With0IncorrectAnd0Correct() {
        score = new BonusScore();
		try{
			res = score.calculateScore(0, 0);
		}catch(ScoreException e) {fail();}
        Assert.assertEquals(0, res);
    }
	
	@Test
    public void validateExceptionWithNegative1IncorrectBonusScore(){
        score = new BonusScore();
		try{
			res = score.calculateScore(0, -1);
		} catch(ScoreException e){
			Assert.assertEquals(e.getMessage(), "El numero de intententos, ya sea correcto o incorrecto, debe ser mayor a 0.");
		}
    }
	
	@Test
    public void validateExceptionWithNegative1CorrectBonusScore(){
        score = new BonusScore();
		try{
			res = score.calculateScore(-1, 0);
		} catch(ScoreException e){
			Assert.assertEquals(e.getMessage(), "El numero de intententos, ya sea correcto o incorrecto, debe ser mayor a 0.");
		}
    }
	
	@Test
    public void validateScore497With16IncorrectAnd4Correct() {
        score = new PowerBonusScore();
		try{
			res = score.calculateScore(4, 16);
		}catch(ScoreException e) {fail();}
        Assert.assertEquals(497, res);
    }
	
	@Test
    public void validateScore500With15IncorrectAnd4Correct() {
        score = new PowerBonusScore();
		try{	
			res = score.calculateScore(4, 15);
		}catch(ScoreException e) {fail();}
        Assert.assertEquals(500, res);
    }
	
	@Test
    public void validatePowerBonusScore0With0IncorrectAnd0Correct() {
        score = new PowerBonusScore();
		try{
			res = score.calculateScore(0, 0);
		}catch(ScoreException e) {fail();}
        Assert.assertEquals(0, res);
    }
	
	@Test
    public void validateScore1With3IncorrectAnd2Correct() {
        score = new PowerBonusScore();
		try{
			res = score.calculateScore(2, 3);
		}catch(ScoreException e) {fail();}
        Assert.assertEquals(1, res);
    }
	
	@Test
    public void validateScore0With1IncorrectAnd1Correct() {
        score = new PowerBonusScore();
		try{
			res = score.calculateScore(1, 1);
		}catch(ScoreException e) {fail();}
        Assert.assertEquals(0, res);
    }
	
	@Test
    public void validateExceptionWithNegative1IncorrectPowerBonusScore(){
        score = new PowerBonusScore();
		try{
			res = score.calculateScore(0, -1);
		} catch(ScoreException e){
			Assert.assertEquals(e.getMessage(), "El numero de intententos, ya sea correcto o incorrecto, debe ser mayor a 0.");
		}
    }
	
	@Test
    public void validateExceptionWithNegative1CorrectPowerBonusScore(){
        score = new PowerBonusScore();
		try{
			res = score.calculateScore(-1, 0);
		} catch(ScoreException e){
			Assert.assertEquals(e.getMessage(), "El numero de intententos, ya sea correcto o incorrecto, debe ser mayor a 0.");
		}
    }
	
}