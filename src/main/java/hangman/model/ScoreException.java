package hangman.model;
public class ScoreException extends Exception {
	public static final String INTENTO_NEGATIVO = "El numero de intententos, ya sea correcto o incorrecto, debe ser mayor a 0.";
    public ScoreException(String message) {
        super(message);
    }
}