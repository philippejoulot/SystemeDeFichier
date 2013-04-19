package filesys;

public class ExceptionSystemeFichier extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7643154131469600578L;
	public ExceptionSystemeFichier()
	{
		super("Erreur système");
	}
	public ExceptionSystemeFichier(String message, Throwable cause)
	{
		super(message, cause);
	}
	public ExceptionSystemeFichier(String message)
	{
		super(message);
	}
	public ExceptionSystemeFichier(Throwable cause)
	{
		super("Erreur système",cause);
	}
	
}
