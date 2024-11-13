package exceptions;

public class MannagginaException extends Exception
{
	public MannagginaException(){}

	public MannagginaException(String message)
	{
		super(message);//richiama il costruttore del supertipo
	}
}
