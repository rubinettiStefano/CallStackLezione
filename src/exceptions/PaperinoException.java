package exceptions;

public class PaperinoException extends RuntimeException
{
	public PaperinoException(){}

	public PaperinoException(String message)
	{
		super(message);//richiama il costruttore del supertipo
	}
}
