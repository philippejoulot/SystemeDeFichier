package filesys;

/**
 * 
 * @author Pierre Lizet et Philippe Joulot
 *
 */
public class ExceptionSystemeFichier extends Exception {

    /**.
     * Identificateur
     */
	private static final long serialVersionUID = 7643154131469600578L;
	
	/**
	 * 
	 */
	public ExceptionSystemeFichier() {
		super("Erreur système");
	}
	/**
	 * 
	 * @param message
	 *     Message lié à l'exception
	 * @param cause
	 *     Cause liée à l'exception
	 */
	public ExceptionSystemeFichier(String message, Throwable cause) {
		super(message, cause);
	}
	/**
	 * 
	 * @param message
	 *     Message lié à l'exception
	 */
	public ExceptionSystemeFichier(String message) {
		super(message);
	}
	/**
	 * 
	 * @param cause
	 *     Cause liée à l'exception
	 */
	public ExceptionSystemeFichier(Throwable cause) {
		super("Erreur système", cause);
	}
	
}
